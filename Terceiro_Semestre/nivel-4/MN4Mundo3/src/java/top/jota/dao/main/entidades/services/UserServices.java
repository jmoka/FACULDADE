package top.jota.dao.main.entidades.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        try (Connection conm = DB.getConnection();
             PreparedStatement st = conm.prepareStatement(UserSql.sqlInsert(), PreparedStatement.RETURN_GENERATED_KEYS)) {

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
        try (Connection conm = DB.getConnection();
             PreparedStatement st = conm.prepareStatement(UserSql.autenticarUsuário())) {

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

        try (Connection conm = DB.getConnection();
             PreparedStatement st = conm.prepareStatement(UserSql.SqlTodosUser());
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
};
    

    
    
        
 
    
    

    

