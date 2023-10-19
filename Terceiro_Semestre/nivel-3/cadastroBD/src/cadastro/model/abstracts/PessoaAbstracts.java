/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.abstracts;

public abstract class PessoaAbstracts{
    private int idPessoa; 
    private String nome;
    private String logradouro;
    private String cidade;
    private String estado;
    private String telefone;
    private String email;
    private int idUsuarioResponsavel;
    
    public PessoaAbstracts(){
    }
     
    
    public PessoaAbstracts(String nome, String logradouro, String cidade, String estado, String telefone, String email, int idUsuarioResponsavel) {
        this.nome = nome;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.email = email;
        this.idUsuarioResponsavel = idUsuarioResponsavel;
    }

    public int getIdPessoa() {
        return idPessoa;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdUsuarioResponsavel() {
        return idUsuarioResponsavel;
    }

    public void setIdUsuarioResponsavel(int idUsuarioResponsavel) {
        this.idUsuarioResponsavel = idUsuarioResponsavel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idPessoa;
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
        final PessoaAbstracts other = (PessoaAbstracts) obj;
        return this.idPessoa == other.idPessoa;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "idPessoa=" + idPessoa + ", nome=" + nome + ", logradouro=" + logradouro + ", cidade=" + cidade + ", estado=" + estado + ", telefone=" + telefone + ", email=" + email + ", idUsuarioResponsavel=" + idUsuarioResponsavel + '}';
    }
    
    

    
}
