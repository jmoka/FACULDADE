/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.Db;

import java.sql.Statement;
import java.sql.ResultSet;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB {
    
    public static Connection conn = null;
    
    public static Connection getConection(){
        if(conn == null){
            
            try{
            Properties props = carregarDadosConection();
            String url = props.getProperty("dburl");           
            conn =  DriverManager.getConnection(url, props);  
               
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    };
    
        
    public static void fecharConexao(){
        if(conn!=null){
            try{
                conn.close();
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
    
    private static Properties carregarDadosConection(){
        try(FileInputStream fs  = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch(IOException e){        
         throw new DbException(e.getMessage());
        }
        
    }    
    
    public static void fecharStatement(Statement st) {
	if(st != null) {
            try {
		st.close();
		} 
            catch (SQLException e) {
                	throw new DbException(e.getMessage());
		}
	}
    };
		
	
    public static void fecharResultSet(ResultSet rs) {
	if(rs != null) {
            try {
		rs.close();
            } 
            catch (SQLException e) {
		throw new DbException(e.getMessage());
            }
        }
    };

    
}
