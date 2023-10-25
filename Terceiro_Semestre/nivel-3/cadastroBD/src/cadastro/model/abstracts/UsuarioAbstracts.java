/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.abstracts;

public abstract class UsuarioAbstracts{
    private int idUsuario; 
    private String login;
    private String senha;
    
    
    public UsuarioAbstracts(){
    }

    public UsuarioAbstracts(int idUsuario, String login, String senha) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.senha = senha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioAbstracts other = (UsuarioAbstracts) obj;
        return this.idUsuario == other.idUsuario;
    }

    @Override
    public String toString() {
        return "UsuarioAbstracts{" + "idUsuario=" + idUsuario + ", login=" + login + ", senha=" + senha + '}';
    }

       
}
