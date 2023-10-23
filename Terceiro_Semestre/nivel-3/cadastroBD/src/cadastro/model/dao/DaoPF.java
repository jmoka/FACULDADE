/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.dao;

import cadastro.model.entidades.PessoaFisica;
import cadastro.Db.DbMysqlPF;
import cadastro.Db.DB;
import cadastro.Db.DbException;
import cadastro.model.interfacs.EntidadeInterfaceDAO;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DaoPF implements EntidadeInterfaceDAO<PessoaFisica> {

    private Connection conn;
    
    public DaoPF(Connection conn){
        this.conn = conn;
    }
    
    
    @Override
    public void Inserir(PessoaFisica Obj) {
        PreparedStatement st = null;
        
    try {
            st = conn.prepareStatement(DbMysqlPF.SqlInserirPf(),
                    PreparedStatement.RETURN_GENERATED_KEYS);
            st.setInt(1, Obj.getIdPessoaFisica());  
            st.setString(2, Obj.getNome());
            st.setString(3, Obj.getLogradouro());
            st.setString(4, Obj.getCidade());
            st.setString(5, Obj.getEstado());
            st.setString(6, Obj.getTelefone());
            st.setString(7, Obj.getEmail());
            st.setInt(8, Obj.getIdUsuarioResponsavel());   
            st.setString(9, Obj.getCpf());  
                        
            int LinhasAfetadas = st.executeUpdate(); 
            
            if(LinhasAfetadas > 0 ) {
                ResultSet rs = st.getGeneratedKeys(); 
            if(rs.next()) {
                int id = rs.getInt(1); 
		Obj.setIdPessoaFisica(id);
		}
                    DB.fecharResultSet(rs); 
				 							
		}else {
                    throw new DbException("Erro !! Nenhuma linha Afetada");
			 }	 	
    }
    catch(SQLException e) {
            throw new DbException(e.getMessage());
		}
    finally {
            DB.fecharStatement(st);
		}
	};

    @Override
    public void atualizar(PessoaFisica Obj) {
       		PreparedStatement st = null; 
		try {
			st = conn.prepareStatement(DbMysqlPF.SqlAtualizar());
                        st.setString(1, Obj.getNome());
                        st.setString(2, Obj.getLogradouro());
                        st.setString(3, Obj.getCidade());
                        st.setString(4, Obj.getEstado());
                        st.setString(5, Obj.getTelefone());
                        st.setString(6, Obj.getEmail());
                        st.setInt(7, Obj.getIdUsuarioResponsavel());
                        st.setString(8, Obj.getCpf());
                        st.setInt(9, Obj.getIdPessoaFisica()); // Esta deve ser a última linha
                            
                        st.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.fecharStatement(st);
		}

	}

    @Override
    public void deletar(Integer id) {
                PreparedStatement st = null;
		try {
			st = conn.prepareStatement(DbMysqlPF.SqlDeletar());
			st.setInt(1, id);
			int rows = st.executeUpdate();
			
			if(rows == 0) {
				throw new DbException("Id nao tem no banco de dados , corrija a numeracao");
			}
	
					
		}
		catch(SQLException e){
			throw new DbException("Pesoa Física não delatada , erro ao deletar");
		}
		finally{
			DB.fecharStatement(st);
		}
    }

    @Override
    public PessoaFisica buscarPorId(Integer id) {
                PreparedStatement st = null;
                ResultSet rs = null;
                PessoaFisica pessoaFisica = null; 

    try {
                st = conn.prepareStatement(DbMysqlPF.SqlBuscarPfId());
                st.setInt(1, id);
                rs = st.executeQuery();
    if (rs.next()) {
                int idPessoaFisica = rs.getInt("idPessoaFisica");
                String nome = rs.getString("nome");
                String logradouro = rs.getString("logradouro");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String telefone = rs.getString("telefone");
                String email = rs.getString("Email");
                int idUsuario = rs.getInt("idUsuario");
                String cpf = rs.getString("cpf");

            
            pessoaFisica = new PessoaFisica(idPessoaFisica, nome, logradouro, cidade, estado, telefone, email, idUsuario, cpf);
        }
        
    } catch (SQLException e) {
                throw new DbException(e.getMessage());
    } finally {
                DB.fecharStatement(st);
                DB.fecharResultSet(rs);
    }  
      return pessoaFisica; 
    }


    @Override
    public List<PessoaFisica> todos() {
    PreparedStatement st = null;
    ResultSet rs = null;
    List<PessoaFisica> list = new ArrayList<PessoaFisica>();
    try {
        st = conn.prepareStatement(DbMysqlPF.SqlTodosPf());
        rs = st.executeQuery();
        
        while (rs.next()) {
            PessoaFisica pf = new PessoaFisica();
            pf.setIdPessoaFisica(rs.getInt("idPessoaFisica"));
            pf.setNome(rs.getString("nome"));
            pf.setLogradouro(rs.getString("logradouro")); 
            pf.setCidade(rs.getString("cidade"));
            pf.setEstado(rs.getString("estado"));
            pf.setTelefone(rs.getString("telefone"));
            pf.setEmail(rs.getString("Email"));
            pf.setIdUsuarioResponsavel(rs.getInt("idUsuario"));
            pf.setCpf(rs.getString("cpf"));
            
            list.add(pf);         
        }        
        
        return list;
        
    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.fecharStatement(st);
        DB.fecharResultSet(rs);
    }
}

    @Override
    public PessoaFisica buscarPorNome(String nome) {
    PreparedStatement st = null;
    ResultSet rs = null;
    PessoaFisica pf = null; 

    try {
        st = conn.prepareStatement(DbMysqlPF.SqlBuscarPfnome());
        st.setString(1, "%" + nome + "%");
        rs = st.executeQuery();

        if (rs.next()) {
            pf = new PessoaFisica();
            pf.setIdPessoaFisica(rs.getInt("idPessoaFisica"));
            pf.setNome(rs.getString("nome"));
           
        }

        return pf; 
    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.fecharStatement(st);
        DB.fecharResultSet(rs);
    }
}

}
    
    
    

    
    

