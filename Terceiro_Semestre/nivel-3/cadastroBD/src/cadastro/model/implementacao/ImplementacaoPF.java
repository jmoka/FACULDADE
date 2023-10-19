/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.implementacao;

import cadastro.model.entidades.PessoaFisica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import cadastro.Db.DbMysqlPF;
import cadastro.Db.DB;
import cadastro.Db.DbException;
import cadastro.model.interfacs.EntidadeInterfaceDAO;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class ImplementacaoPF implements EntidadeInterfaceDAO<PessoaFisica> {

    private Connection conn;
    
    public ImplementacaoPF(Connection conn){
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deletar(Integer idPessoaFisica) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PessoaFisica buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PessoaFisica> todos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PessoaFisica buscarPorNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


     
    }
    

