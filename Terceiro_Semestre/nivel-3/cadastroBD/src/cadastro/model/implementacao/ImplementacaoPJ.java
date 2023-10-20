/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.implementacao;

import cadastro.Db.DbMysqlPJ;
import cadastro.Db.DB;
import cadastro.Db.DbException;
import cadastro.model.entidades.PessoaJuridica;
import cadastro.model.interfacs.EntidadeInterfaceDAO;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ImplementacaoPJ implements EntidadeInterfaceDAO<PessoaJuridica> {

    private Connection conn;
    
    public ImplementacaoPJ(Connection conn){
        this.conn = conn;
    }
    
    
    @Override
    public void Inserir(PessoaJuridica Obj) {
        PreparedStatement st = null;
        
    try {
            st = conn.prepareStatement(DbMysqlPJ.SqlInserirPj(),
          PreparedStatement.RETURN_GENERATED_KEYS);
            st.setInt(1, Obj.getIdPessoaJuridica());  
            st.setString(2, Obj.getNome());
            st.setString(3, Obj.getLogradouro());
            st.setString(4, Obj.getCidade());
            st.setString(5, Obj.getEstado());
            st.setString(6, Obj.getTelefone());
            st.setString(7, Obj.getEmail());
            st.setInt(8, Obj.getIdUsuarioResponsavel());   
            st.setString(9, Obj.getCnpj());  
                        
            int LinhasAfetadas = st.executeUpdate(); 
            
            if(LinhasAfetadas > 0 ) {
                ResultSet rs = st.getGeneratedKeys(); 
            if(rs.next()) {
                int id = rs.getInt(1); 
		Obj.setIdPessoaJuridica(id);
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
    public void atualizar(PessoaJuridica Obj) {
       		PreparedStatement st = null; 
		try {
			st = conn.prepareStatement(DbMysqlPJ.SqlAtualizar());
                        st.setInt(1, Obj.getIdPessoaJuridica()); 
                        st.setString(2, Obj.getNome());
                        st.setString(3, Obj.getLogradouro());
                        st.setString(4, Obj.getCidade());
                        st.setString(5, Obj.getEstado());
                        st.setString(6, Obj.getTelefone());
                        st.setString(7, Obj.getEmail());
                        st.setInt(8, Obj.getIdUsuarioResponsavel());
                        st.setString(9, Obj.getCnpj());
                       
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
			st = conn.prepareStatement(DbMysqlPJ.SqlDeletar());
			st.setInt(1, id);
			int rows = st.executeUpdate();
			
			if(rows == 0) {
				throw new DbException("Id nao tem no banco de dados , corrija a numeracao");
			}
						
		}
		catch(SQLException e){
			throw new DbException("Pessoa Juridica não delatada , erro ao deletar");
		}
		finally{
			DB.fecharStatement(st);
		}
    }

    @Override
    public PessoaJuridica buscarPorId(Integer id) {
                PreparedStatement st = null;
                ResultSet rs = null;
                PessoaJuridica pessoaJuridica = null; 

    try {
                st = conn.prepareStatement(DbMysqlPJ.SqlBuscarPjId());
                st.setInt(1, id);
                rs = st.executeQuery();
    if (rs.next()) {
                int idPessoaJuridica = rs.getInt("idPessoaJuridica");
                String nome = rs.getString("nome");
                String logradouro = rs.getString("logradouro");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String telefone = rs.getString("telefone");
                String email = rs.getString("Email");
                int idUsuario = rs.getInt("idUsuario");
                String cnpj = rs.getString("cnpj");

      
                pessoaJuridica = new PessoaJuridica(0, nome, logradouro, cidade, estado, telefone, email, 0, cnpj);
                    
                    }
        
    } catch (SQLException e) {
                throw new DbException(e.getMessage());
    } finally {
                DB.fecharStatement(st);
                DB.fecharResultSet(rs);
    }  
      return pessoaJuridica; 
    }


    @Override
    public List<PessoaJuridica> todos() {
    PreparedStatement st = null;
    ResultSet rs = null;
    List<PessoaJuridica> list = new ArrayList<PessoaJuridica>();
    try {
        st = conn.prepareStatement(DbMysqlPJ.SqlTodosPj());
        rs = st.executeQuery();
        
        while (rs.next()) {
            PessoaJuridica pj = new PessoaJuridica();
            pj.setIdPessoaJuridica(rs.getInt("idPessoaJuridica"));
            pj.setNome(rs.getString("nome"));
            pj.setLogradouro(rs.getString("logradouro")); 
            pj.setCidade(rs.getString("cidade"));
            pj.setEstado(rs.getString("estado"));
            pj.setTelefone(rs.getString("telefone"));
            pj.setEmail(rs.getString("Email"));
            pj.setIdUsuarioResponsavel(rs.getInt("idUsuario"));
            pj.setCnpj(rs.getString("cnpj"));
            
            list.add(pj);         
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
    public PessoaJuridica buscarPorNome(String nome) {
    PreparedStatement st = null;
    ResultSet rs = null;
    PessoaJuridica pj = null;

    try {
        st = conn.prepareStatement(DbMysqlPJ.SqlBuscarPjnome());
        st.setString(1, "%" + nome + "%");
        rs = st.executeQuery();

        if (rs.next()) {
            pj = new PessoaJuridica();
            pj.setIdPessoaJuridica(rs.getInt("idPessoaJuridica"));
            pj.setNome(rs.getString("nome"));
           
        }

        return pj; 
    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.fecharStatement(st);
        DB.fecharResultSet(rs);
    }
}

}
    
    
    

    
    

