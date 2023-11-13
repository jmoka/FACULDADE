/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.dao;

import cadastro.Db.DbMysqlPJ;
import cadastro.Db.DB;
import static cadastro.Db.DB.fecharResultSet;
import static cadastro.Db.DB.fecharStatement;
import cadastro.Db.DbException;
import static cadastro.Db.DbMysqlPJ.SqlAtualizarPj;
import static cadastro.Db.DbMysqlPJ.SqlBuscarPjId;
import static cadastro.Db.DbMysqlPJ.SqlBuscarPjnome;
import static cadastro.Db.DbMysqlPJ.SqlDeletarPj;
import static cadastro.Db.DbMysqlPJ.SqlInserirPj;
import static cadastro.Db.DbMysqlPJ.SqlTodosPj;
import cadastro.model.entidades.PessoaJuridica;
import cadastro.model.interfacs.EntidadeInterfaceDAO;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import java.util.List;


public class DaoPJ implements EntidadeInterfaceDAO<PessoaJuridica> {

    private Connection conn;
    
    public DaoPJ(Connection conn){
        this.conn = conn;
    }
    
    
    @Override
    public void inserir(PessoaJuridica ObjPj) {
        PreparedStatement st = null;
        
    try {
            st = conn.prepareStatement(SqlInserirPj(), RETURN_GENERATED_KEYS);
            st.setInt(1, ObjPj.getIdPessoaJuridica());  
            st.setString(2, ObjPj.getNome());
            st.setString(3, ObjPj.getLogradouro());
            st.setString(4, ObjPj.getCidade());
            st.setString(5, ObjPj.getEstado());
            st.setString(6, ObjPj.getTelefone());
            st.setString(7, ObjPj.getEmail());
            st.setInt(8, ObjPj.getIdUsuarioResponsavel());   
            st.setString(9, ObjPj.getCnpj());  
                        
            int LinhasAfetadas = st.executeUpdate(); 
            
            if(LinhasAfetadas > 0 ) {
                ResultSet rs = st.getGeneratedKeys(); 
            if(rs.next()) {
                int id = rs.getInt(1); 
		ObjPj.setIdPessoaJuridica(id);
		}
                    fecharResultSet(rs); 
				 							
		}else {
                    throw new DbException("Erro !! Nenhuma linha Afetada");
			 }	 	
    }
    catch(SQLException e) {
            throw new DbException(e.getMessage());
		}
    finally {
            fecharStatement(st);
		}
	};

    @Override
    public void atualizar(PessoaJuridica ObjPj) {
       		PreparedStatement st = null; 
		try {
			st = conn.prepareStatement(SqlAtualizarPj());
                        st.setString(1, ObjPj.getNome());
                        st.setString(2, ObjPj.getLogradouro());
                        st.setString(3, ObjPj.getCidade());
                        st.setString(4, ObjPj.getEstado());
                        st.setString(5, ObjPj.getTelefone());
                        st.setString(6, ObjPj.getEmail());
                        st.setInt(7, ObjPj.getIdUsuarioResponsavel());
                        st.setString(8, ObjPj.getCnpj());
                        st.setInt(9, ObjPj.getIdPessoaJuridica()); 
                            
                        st.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			fecharStatement(st);
		}

	}

    @Override
    public void deletar(Integer id) {
                PreparedStatement st = null;
		try {
			st = conn.prepareStatement(SqlDeletarPj());
			st.setInt(1, id);
			int linhaAfetada = st.executeUpdate();
			
			if(linhaAfetada == 0) {
				throw new DbException("Id nao tem no banco de dados , corrija a numeracao");
			}
						
		}
		catch(SQLException e){
			throw new DbException("Pessoa Juridica não delatada , erro ao deletar");
		}
		finally{
			fecharStatement(st);
		}
    }

    @Override
    public PessoaJuridica buscarPorId(Integer id) {
                PreparedStatement st = null;
                ResultSet rs = null;
                PessoaJuridica pessoaJuridica = null; 

    try {
                st = conn.prepareStatement(SqlBuscarPjId());
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

                pessoaJuridica = new PessoaJuridica(idPessoaJuridica, nome, logradouro, cidade, estado, telefone, email, 0, cnpj);
                    
                    }
        
    } catch (SQLException e) {
                throw new DbException(e.getMessage());
    } finally {
                fecharStatement(st);
                fecharResultSet(rs);
    }  
      return pessoaJuridica; 
    }


    @Override
    public List<PessoaJuridica> todos() {
    PreparedStatement st = null;
    ResultSet rs = null;
    List<PessoaJuridica> list = new ArrayList<>();
    try {
        st = conn.prepareStatement(SqlTodosPj());
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
            fecharStatement(st);
            fecharResultSet(rs);
    }
}



    @Override
    public PessoaJuridica buscarPorNome(String nome) {
    PreparedStatement st = null;
    ResultSet rs = null;
    PessoaJuridica pj = null;

    try {
        st = conn.prepareStatement(SqlBuscarPjnome());
        st.setString(1, "%" + nome + "%");
        rs = st.executeQuery();

        if (rs.next()) {
            pj = new PessoaJuridica();
            pj.setIdPessoaJuridica(rs.getInt("idPessoaJuridica"));
            pj.setNome(rs.getString("nome"));
            pj.setLogradouro(rs.getString("logradouro")); 
            pj.setCidade(rs.getString("cidade"));
            pj.setEstado(rs.getString("estado"));
            pj.setTelefone(rs.getString("telefone"));
            pj.setEmail(rs.getString("Email"));
            pj.setIdUsuarioResponsavel(rs.getInt("idUsuario"));
            pj.setCnpj(rs.getString("cnpj"));
           
        }

        return pj; 
    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
            fecharStatement(st);
            fecharResultSet(rs);
    }
}

    @Override
    public List<PessoaJuridica> BuscartodosNomes(String nome) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<PessoaJuridica> list = new ArrayList<>();
    try {
        st = conn.prepareStatement(SqlBuscarPjnome());
        
       st.setString(1, "%" + nome + "%");
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
            fecharStatement(st);
            fecharResultSet(rs);
    }
}

        
    }


    
    
    

    
    

