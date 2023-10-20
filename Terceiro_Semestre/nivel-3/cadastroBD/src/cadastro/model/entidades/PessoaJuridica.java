/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.entidades;

public class PessoaJuridica extends Pessoa   {
    
    private int idPessoaJuridica;
    private String Cnpj;
    
    
    public PessoaJuridica(){
    }

    public PessoaJuridica(int idPessoaJuridica,String nome, String logradouro, String cidade, String estado, String telefone, String email, int idUsuarioResponsavel,   String Cnpj) {
        super(nome, logradouro, cidade, estado, telefone, email, idUsuarioResponsavel);
        this.idPessoaJuridica = idPessoaJuridica;
        this.Cnpj = Cnpj;
          
    }

    public int getIdPessoaJuridica() {
        return idPessoaJuridica;
    }

    public void setIdPessoaJuridica(int idPessoaJuridica) {
        this.idPessoaJuridica = idPessoaJuridica;
    }

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idPessoaJuridica;
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
        final PessoaJuridica other = (PessoaJuridica) obj;
        return this.idPessoaJuridica == other.idPessoaJuridica;
    }

    @Override
    public String toString() {
    return "idPessoaJuridica=" + getIdPessoaJuridica() + ",\n" +
           "nome='" + getNome() + "',\n" +
           "logradouro='" + getLogradouro() + "',\n" +
           "cidade='" + getCidade() + "',\n" +
           "estado='" + getEstado() + "',\n" +
           "telefone='" + getTelefone() + "',\n" +
           "email='" + getEmail() + "',\n" +
           "idUsuarioResponsavel=" + getIdUsuarioResponsavel() + ",\n" +
           "cnpj='" + getCnpj() + "'\n" +
           '}';
}

   
   
   
    
}
