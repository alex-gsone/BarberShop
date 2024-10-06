/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class AgendaController {

    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }

    public void atualizaTabela() {
        // buscar uma lista com os agendamentos do banco de dados...
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();

        //exibir essa lista na view
        this.helper.preencherTabela(agendamentos);

    }
    
    public void atualizaClientes(){
//      buscar clientes do banco de dados
        ClienteDAO clienteDAO = new ClienteDAO();
        // sempre trabalhando com listas colocamos no plural (clientes)
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        
        
//      exibir clientes no Combobox cliente 
        helper.preencherClientes(clientes);
    }
    
    public void AtualizaServicos(){
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        helper.preencherServicos(servicos);
    }
    
    public void atualizaValor(){
        Servico servico = helper.obterServico();
        
//      o helper seta o valor na tela!
        helper.setarValor(servico.getValor());        
    }
    public void agendar(){
    //buscar objeto agendamento da tela
    //salva objeto no banco de dados
    }
    
}
