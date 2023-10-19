/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.entidades;

public class PessoaFisica extends Pessoa   {
    
    private int idPessoaFisica;
    private String Cpf;
    
    
    public PessoaFisica(){
    }

    public PessoaFisica(int idPessoaFisica,String nome, String logradouro, String cidade, String estado, String telefone, String email, int idUsuarioResponsavel,   String Cpf) {
        super(nome, logradouro, cidade, estado, telefone, email, idUsuarioResponsavel);
        this.idPessoaFisica = idPessoaFisica;
        this.Cpf = Cpf;
          
    }

    public int getIdPessoaFisica() {
        return idPessoaFisica;
    }

    public void setIdPessoaFisica(int idPessoaFisica) {
        this.idPessoaFisica = idPessoaFisica;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idPessoaFisica;
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
        final PessoaFisica other = (PessoaFisica) obj;
        return this.idPessoaFisica == other.idPessoaFisica;
    }

    @Override
    public String toString() {
    return "PessoaFisica{" +
           "idPessoaFisica=" + getIdPessoaFisica() +
           ", nome='" + getNome() + '\'' +
           ", logradouro='" + getLogradouro() + '\'' +
           ", cidade='" + getCidade() + '\'' +
           ", estado='" + getEstado() + '\'' +
           ", telefone='" + getTelefone() + '\'' +
           ", email='" + getEmail() + '\'' +
           ", idUsuarioResponsavel=" + getIdUsuarioResponsavel() +
           ", cpf='" + getCpf() + '\'' +
           '}';
}
   
   
   
    
}
