/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.dao;



import cadastro.Db.DB;
import cadastro.Db.DbException;
import cadastro.Db.DbMysqlUsuario;
import cadastro.model.entidades.Usuario;
import cadastro.model.interfacs.EntidadeInterfaceDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario implements EntidadeInterfaceDAO<Usuario>  {
    
     private Connection conn;
     
     public DaoUsuario(){
     }
     public DaoUsuario(Connection connection){
         this.conn = connection;
     }
   
    
    @Override
    public void inserir(Usuario obj) {
        PreparedStatement st = null;
        
        try {
           st = conn.prepareStatement(DbMysqlUsuario.SqlInserirUsuario(),
          PreparedStatement.RETURN_GENERATED_KEYS);
           
           st.setInt(1, obj.getIdUsuario());  
           st.setString(2, obj.getLogin());
           st.setString(3, obj.getSenha());       
           
           int LinhasAfetadas = st.executeUpdate(); 
            
            if(LinhasAfetadas > 0 ) {
                ResultSet rs = st.getGeneratedKeys(); 
            if(rs.next()) {
                int id = rs.getInt(1); 
		obj.setIdUsuario(id);
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
{
        }
    }

    @Override
    public void atualizar(Usuario obj) {
      
       PreparedStatement st = null; 
		try {
			st = conn.prepareStatement(DbMysqlUsuario.SqlAtualizarUsuario(),
          PreparedStatement.RETURN_GENERATED_KEYS);
           
                        st.setString(1, obj.getLogin());  
                        st.setString(2, obj.getSenha());
                        st.setInt(3, obj.getIdUsuario());     
                            
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
			st = conn.prepareStatement(DbMysqlUsuario.SqlDeletarUsuario());
			st.setInt(1, id);
			int rows = st.executeUpdate();
			
			if(rows == 0) {
				throw new DbException("Id nao tem no banco de dados , corrija a numeracao");
			}
						
		}
		catch(SQLException e){
			throw new DbException("Usuario não delatada , erro ao deletar");
		}
		finally{
			DB.fecharStatement(st);
		}
    }

    @Override
    public Usuario buscarPorId(Integer id) {
      
                PreparedStatement st = null;
                ResultSet rs = null;
                Usuario usuario = null; 

    try {
                st = conn.prepareStatement(DbMysqlUsuario.SqlBuscarUsuarioID());
                st.setInt(1, id);
                rs = st.executeQuery();
    if (rs.next()) {
                int idUsuario = rs.getInt("idUsuario");
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                
      
               usuario = new Usuario(idUsuario, login, senha);
               
                    
                    }
        
    } catch (SQLException e) {
                throw new DbException(e.getMessage());
    } finally {
                DB.fecharStatement(st);
                DB.fecharResultSet(rs);
    }  
      return usuario; 
    }
    

    @Override
    public List<Usuario> todos() {
    PreparedStatement st = null;
    ResultSet rs = null;
    List<Usuario> list = new ArrayList<Usuario>();
    try {
        st = conn.prepareStatement(DbMysqlUsuario.SqlTodosUsuario());
        rs = st.executeQuery();
        
        while (rs.next()) {
            Usuario usu = new Usuario();
            usu.setIdUsuario(rs.getInt("idUsuario"));
            usu.setLogin(rs.getString("login"));
            usu.setSenha(rs.getString("senha")); 
            
            
            list.add(usu);         
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
    public Usuario buscarPorNome(String nome) {
    PreparedStatement st = null;
    ResultSet rs = null;
    Usuario usu = null;

    try {
        st = conn.prepareStatement(DbMysqlUsuario.SqlBuscarUsuarioNome());
        st.setString(1, "%" + nome + "%");
        rs = st.executeQuery();

        if (rs.next()) {
            usu = new Usuario();
            usu.setIdUsuario(rs.getInt("idUsuario"));
            usu.setLogin(rs.getString("login"));
            usu.setSenha(rs.getString("senha"));
              
        }

        return usu; 
    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.fecharStatement(st);
        DB.fecharResultSet(rs);
      }
    
    }

    @Override
    public List<Usuario> BuscartodosNomes(String nome) {
       PreparedStatement st = null;
       ResultSet rs = null;
        List<Usuario> list = new ArrayList<Usuario>();
    try {
        st = conn.prepareStatement(DbMysqlUsuario.SqlTodosUsuario());
        
       st.setString(1, "%" + nome + "%");
       rs = st.executeQuery();
        
        while (rs.next()) {
            Usuario usu = new Usuario();
            usu.setIdUsuario(rs.getInt("idUsuario"));
            usu.setLogin(rs.getString("login"));
            usu.setSenha(rs.getString("senha"));
            
            list.add(usu);         
        }        
        
        return list;
        
    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.fecharStatement(st);
        DB.fecharResultSet(rs);
    }
    }
    
    
    
}
