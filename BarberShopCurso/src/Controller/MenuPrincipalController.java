/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Agenda;
import View.MenuPrincipal;

/**
 *
 * @author alex O controller é o responsável por fazer a navegação para outros
 * menus...
 */
public class MenuPrincipalController {

    private final MenuPrincipal view;

    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
    }

    public void navegarParaAgenda() {
        Agenda agenda = new Agenda();
        agenda.setVisible(true);
    }
}
