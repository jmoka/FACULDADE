/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.Db;


public class DbMysqlUsuario {
    
    public static String SqlInserirUsuario() {
		return "INSERT INTO usuarios "
				+ "(idUsuario, login, senha) "
				+ "VALUES "
				+ "(?,?,?) ";
	};	
	
	public static String SqlAtualizarUsuario () {
        return "UPDATE usuarios " 
           + "SET login = ?, senha = ? "
           + "WHERE idUsuario = ?";  
}
	
	public static String SqlDeletarUsuario() {
		return "DELETE FROM usuarios WHERE idUsuario = ?";
	}
        
        public static String SqlBuscarUsuarioID() {
		return "SELECT * FROM usuarios WHERE idUsuario = ? ";
	};
	
	public static String SqlTodosUsuario () {
		return "SELECT * FROM usuarios";
				
	};
        
        
        public static String SqlBuscarUsuarioNome() {
		return "SELECT * FROM usuarios WHERE nome LIKE ?";
	};
        
    
}
