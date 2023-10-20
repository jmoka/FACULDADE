/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.fabrica;

import cadastro.Db.DB;
import cadastro.model.implementacao.ImplementacaoPF;
import cadastro.model.implementacao.ImplementacaoPJ;
import cadastro.model.interfacs.EntidadeInterfaceDAO;



public class FabricaPessoas {

    public static EntidadeInterfaceDAO  PessoaFisicaFabrica() {
		return new ImplementacaoPF(DB.getConection());
	} 
    
     public static EntidadeInterfaceDAO  PessoaJuridicaFabrica() {
		return new ImplementacaoPJ(DB.getConection());
	} 
	

}



    

