/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadastro.model.interfacs;

import java.util.List;

public interface EntidadeInterfaceDAO<T> {
    void inserir(T obj);
    void atualizar(T obj);
    void deletar(Integer id);
    T buscarPorId(Integer id);
    List<T> todos();
    T buscarPorNome(String nome);
    List<T> BuscartodosNomes(String nome);;
}
    

