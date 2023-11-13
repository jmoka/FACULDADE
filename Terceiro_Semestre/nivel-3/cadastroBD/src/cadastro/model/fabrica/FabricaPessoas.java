/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.fabrica;

import cadastro.Db.DB;
import static cadastro.Db.DB.getConection;
import cadastro.model.dao.DaoPF;
import cadastro.model.dao.DaoPJ;
import cadastro.model.dao.DaoUsuario;

import cadastro.model.interfacs.EntidadeInterfaceDAO;



public class FabricaPessoas {

    public static EntidadeInterfaceDAO  PessoaFisicaFabrica() {
		return new DaoPF(getConection());
	} 
    
    public static EntidadeInterfaceDAO  PessoaJuridicaFabrica() {
		return new DaoPJ(getConection());
	} 
	
     
    public static DaoUsuario UsuarioFabrica(){
            return new DaoUsuario(getConection());
    }

}



    

