/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alex
 */
public class AgendaHelper implements IHelper {

    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableAgendamentos().getModel();
        tableModel.setNumRows(0);
//      percorrer a lista preechendo o table model...

        for (Agendamento agendamento : agendamentos) {
//          cada linha da minha tabela é um objeto... 
            tableModel.addRow(new Object[]{
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao()
            });

        }
    }

    public void preencherClientes(ArrayList<Cliente> clientes) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxCliente().getModel();

        for (Cliente cliente : clientes) {
            comboBoxModel.addElement(cliente); // aqui está o truque 
        }
    }

    public void preencherServicos(ArrayList<Servico> servicos) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxServico().getModel();

        for (Servico servico : servicos) {
            comboBoxModel.addElement(servico); // aqui está o truque 
        }
    }

    public Servico obterServico() {
        return (Servico) view.getjComboBoxServico().getSelectedItem();
    }

    public Cliente obterCliente() {
        return (Cliente) view.getjComboBoxCliente().getSelectedItem();
    }

    public void setarValor(float valor) {
        view.getjTextValor().setText(valor + "");
    }

    @Override
    public Object obterModelo() {
//      Vamos obter um modelo, e depois realizar o agendamento:       
//      Agendamento agendamento = new Agendamento(, cliente, servico, 0, date, observacao);

        String idString = view.getjTextId().getText();
        int id = Integer.parseInt(idString);
        Cliente cliente = obterCliente();
        Servico servico = obterServico();
        String stringValor = view.getjTextValor().getText();
        float valor = Float.parseFloat(stringValor);
        String data = view.getjTextData().getText();
        String hora = view.getjTextHora().getText();
        String dataHora = data + " " + hora;
        String observacao = view.getjTextObservacao().getText();

        Agendamento agendamento = new Agendamento(id, cliente, servico, valor, dataHora, observacao);
        return agendamento;
    }

    @Override
    public void limparTela() {
        view.getjTextId().setText("0");
        view.getjTextObservacao().setText("");
        view.getjTextData().setText("");
        view.getjTextHora().setText("");
    }

}
