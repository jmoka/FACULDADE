/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.Db;


public class DbMysqlPF {
    
    public static String SqlInserirPf() {
		return "INSERT INTO pf "
				+ "(idPessoaFisica, nome, logradouro,cidade, estado, telefone, Email, idUsuario, cpf) "
				+ "VALUES "
				+ "(?,?, ?, ?, ?, ?, ?, ? ,?) ";
	};	
	
	public static String SqlAtualizar () {
		return "UPDATE pj " 
				+ "SET nome = ?, logradouro = ?, cidade = ?, estado = ?, telefone = ?, email=?, idusuario=?, cpf=? "
				+ "WHERE idPessoaFisica = ? ";                        
                        }
	
	public static String SqlDeletar() {
		return "DELETE FROM pessoafisica WHERE idPessoaFisica = ?";
	}
        
        public static String SqlBuscarPfId() {
		return "SELECT * FROM pessoafisica WHERE idPessoaFisica = ? ";
	};
	
	public static String SqlTodosPf () {
		return "SELECT * FROM pessoafisica";
				
	};
        
        
        public static String SqlBuscarPfnome() {
		return "SELECT * FROM pessoafisica WHERE nome LIKE ?";
	};
        
    
}
