package top.jota.dao.main.entidades.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import java.util.List;

import top.jota.dao.DB.DB;
import top.jota.dao.DB.Exception.DbException;
import top.jota.dao.DB.sql.UserSql;
import top.jota.dao.main.entidades.Usuario;
import top.jota.dao.main.entidades.interfacs.UserInterfaces;

public class UserServices implements UserInterfaces {

    @Override
    public Integer inserir(String nome, String senha) {
        try (Connection con = DB.getConnection();
             PreparedStatement st = con.prepareStatement(UserSql.sqlInsert(), PreparedStatement.RETURN_GENERATED_KEYS)) {

            st.setString(1, nome);
            st.setString(2, senha);

            int linhasAfetadas = st.executeUpdate();
            return linhasAfetadas;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public String autenticarUsuario(String nome, String senha) {
        try (Connection con = DB.getConnection();
             PreparedStatement st = con.prepareStatement(UserSql.autenticarUsuário())) {

            st.setString(1, nome);
            st.setString(2, senha);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    String nomeUsuario = rs.getString("nome");
                    System.out.println("Usuario autenticado: " + nomeUsuario);
                    return nomeUsuario;
                } else {
                    System.err.println("Usuario nao encontrado");
                }
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

        return null;
    }

    @Override
    public List<Usuario> findAllUser() {
        List<Usuario> list = new ArrayList<>();

        try (Connection con = DB.getConnection();
             PreparedStatement st = con.prepareStatement(UserSql.SqlTodosUser());
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setId(rs.getInt("id_user"));
                usu.setName(rs.getString("nome"));
                usu.setSenha(rs.getString("senha"));
                list.add(usu);
            }

            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void deletar(Integer id) {
        try (Connection con = DB.getConnection();
             PreparedStatement st = con.prepareStatement(UserSql.SqlDeletar())) {

            st.setInt(1, id);
            int linhaAfetada = st.executeUpdate();

            if (linhaAfetada == 0) {
                throw new DbException("Usuário não deletado, erro ao deletar. Id não encontrado no banco de dados.");
            }

        } catch (SQLException e) {
          throw new DbException(e.getMessage());
        }
    }
    
    @Override
public Usuario atualizar(Usuario obj) {
    PreparedStatement st = null;
    try {
        Connection con = DB.getConnection();
        st = con.prepareStatement(UserSql.SqlAtualizar(), RETURN_GENERATED_KEYS);

        st.setString(1, obj.getName());
        st.setString(2, obj.getSenha());
        st.setInt(3, obj.getId()); // Adiciona o ID na cláusula WHERE

        st.executeUpdate();
        return obj; // Retorna o usuário atualizado

    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.fecharStatiment();
    }
}


    @Override
    public Usuario buscarId(Integer id) {
                PreparedStatement st = null;
                ResultSet rs = null;
                Usuario user = null; 

    try {
                Connection con = DB.getConnection();
                st = con.prepareStatement(UserSql.SqlBuscarId());
                st.setInt(1, id);
                rs = st.executeQuery();
    if (rs.next()) {
                int id_user = rs.getInt("id_user");
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");            

            
                user = new Usuario(id, nome, senha);
        }
        
    } catch (SQLException e) {
                throw new DbException(e.getMessage());
    } finally {
                DB.fecharStatiment();
                DB.fecharResultSet();
      return user; 
    }
    }

    
   
}

