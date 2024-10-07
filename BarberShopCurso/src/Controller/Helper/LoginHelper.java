/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.Usuario;
import View.Login;

/**
 *
 * @author alex
 */
public class LoginHelper implements IHelper {

//  primeiramente ele vai precisar ter acesso à view!
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }

    public Usuario obterModelo() {
        String nome = view.getTextUsuario().getText();
        String senha = view.getTextSenha().getText();
        Usuario modelo = new Usuario(0, nome, senha);
        return modelo;
    }

    public void setarModelo(Usuario modelo) {
        String nome = modelo.getNome();
        String senha = modelo.getSenha();

        view.getTextUsuario().setName(nome);
        view.getTextSenha().setName(senha);
    }

    public void limparTela() {
        view.getTextUsuario().setName("");
        view.getTextSenha().setName("");
    }

}
