/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;

/**
 *
 * @author alex
 */
public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }

    public void entrarNoSistema() {
//      Pegar um usuário da view
        Usuario usuario = helper.obterModelo();

//      Pesquisar  Usuário no Banco
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);

//      Se o usuário da view tiver o mesmo usuário e senha que o usuário do vindo do banco, direcionar para o menu.
//      Se não mostrar uma mensagem so usuário "Usuário ou senha inválidos".
        if (usuarioAutenticado != null) {

//          navegar para menu principal
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        } else {
            view.exibeMensagem("Usuário ou senha inválidos");
        }
    }

    public void fizTarefa() {
        System.out.println("Busquei algo do banco de dados");

        this.view.exibeMensagem("Executei o fiz tarefa");
    }
}
