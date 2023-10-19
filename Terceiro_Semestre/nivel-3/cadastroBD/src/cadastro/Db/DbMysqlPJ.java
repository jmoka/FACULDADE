/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.Db;


public class DbMysqlPJ {
    
    public static String SqlInserirPj() {
		return "INSERT INTO pessoajuridica "
				+ "(nome, logradouro,cidade, estado, telefone, Email, idUsuario, cnpj) "
				+ "VALUES "
				+ "(?, ?, ?, ?, ?, ?, ? , ?) ";
	};	
	
	public static String SqlUpdatePj () {
		return "UPDATE seller " 
				+ "SET nome = ?, logradouro = ?, cidade = ?, estado = ?, telefone = ?, email=?, idusuario=?, cnpj=? "
				+ "WHERE idPessoaJuridica = ? ";                        
                        }
	
	public static String SqlDeleteIdPj () {
		return "DELETE FROM pessoajuridica WHERE idPessoaJuridica = ?";
	}
        
        public static String SqlBuscarPfIdPj() {
		return "SELECT * FROM pessoajuridica WHERE idPessoaJuridica = ? ";
	};
	
	public static String SqlTodosPj () {
		return "SELECT * FROM pessoajuridica";
				
	};
        
        
        public static String SqlBuscarPfnomePj() {
		return "SELECT * FROM pessoajuridica WHERE nome =?";
	};
        
    
}
