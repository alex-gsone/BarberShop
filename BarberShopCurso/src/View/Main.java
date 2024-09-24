/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Servico;

/**
 *
 * @author alex
 */
public class Main {
    public static void main(String[] args) {
//        String nome = "Alex";
//        System.out.println(nome);
        
        Servico servico = new Servico(1, "barba", 30);
        System.out.println(servico.getDescricao());
        System.out.println(servico.getValor());
    }
    
}
