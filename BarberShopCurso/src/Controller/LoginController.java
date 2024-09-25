/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import View.Login;

/**
 *
 * @author alex
 */
public class LoginController {

    private final Login view;

    public LoginController(Login view) {
        this.view = view;
    }

    public void entrarNoSistema() {
//      Pegar um usuário da view
//      Pesquisar  Usuário no Banco
//      Se o usuário da view tiver o mesmo usuário e senha que o usuário do vindo do banco, direcionar para o menu.
//      Se não mostrar uma mensagem so usuário "Usuário ou senha inválidos".

        String nome = view.getTextUsuario().getText();
        String senha = view.getTextSenha().getText();
        
        Usuario modelo = new Usuario(0, nome, senha);
        

    }

    public void fizTarefa() {
        System.out.println("Busquei algo do banco de dados");

        this.view.exibeMensagem("Executei o fiz tarefa");
    }

}
