package top.jota.dao.DB.sql;

public class UserSql {
    
    public static String sqlInsert(){        
        return "INSERT INTO usuarios "
               + "(nome, senha) "
               + "VALUES " // 
               + "(?, ?)";
    }
    
    public static String autenticarUsuário () {
		return "SELECT nome, senha "
                       + "FROM usuarios "
                       + "WHERE " 
                       + "nome = ? " 
                       + "AND senha = ?; ";
	};
    
    public static String SqlTodosUser () {
		return "SELECT * FROM loja1.usuarios";
	};
    
    public static String SqlDeletar() {
		return "DELETE FROM loja1.usuarios WHERE id_user = ?;";
	}
    
}

