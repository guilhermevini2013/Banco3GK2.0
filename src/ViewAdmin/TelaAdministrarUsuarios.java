package ViewAdmin;

import Controller.Cliente;
import view.TelaBanco3GK;
import view.TelaPrincipalApp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaAdministrarUsuarios extends JFrame {
    private JTable table;
    Object[] titulos = {"Numero","Nome","Senha","Saldo"};
    public TelaAdministrarUsuarios(String title) throws HeadlessException {
        super(title);
        setSize(585,430);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        iniciarComponentes();
        iniciarEventos();
        getContentPane().setBackground(new Color(0,0,0));
    }

    private void iniciarComponentes() {
        String col[] = {"Numero","Nome","Senha","Saldo"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        table = new JTable(tableModel);
        tableModel.addRow(titulos);
        int i=0;
        for (Cliente clientes:TelaBanco3GK.clientes) { // COLOCAR OBJETOS NA TABELA
            if (!clientes.isAdministrador()){
                Object[] data = {TelaBanco3GK.clientes.get(i).getNumero(),TelaBanco3GK.clientes.get(i).getNomeProprietario() , TelaBanco3GK.clientes.get(i).getSenha(), TelaBanco3GK.clientes.get(i).getSaldo()};
                tableModel.addRow(data);

            }
            i++;
        }
        add(table);
        table.setBounds(25,10,500,600);
    }
    private void iniciarEventos() {
    }
}
