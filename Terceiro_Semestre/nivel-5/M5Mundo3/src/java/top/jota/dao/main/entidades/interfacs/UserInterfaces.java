/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package top.jota.dao.main.entidades.interfacs;

import java.util.List;
import top.jota.dao.main.entidades.Usuario;

/**
 *
 * @author jotac
 */
public interface UserInterfaces {
    
    public String autenticarUsuario(String nome, String senha);
    public Integer inserir(String nome, String senha);
    public List<Usuario> findAllUser();
    public void deletar(Integer id);
    public Usuario atualizar (Usuario obj);
    public Usuario buscarId(Integer id);
    
  
    
       
}
