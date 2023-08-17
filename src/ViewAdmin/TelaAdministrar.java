package ViewAdmin;

import Controller.Cliente;
import view.TelaBanco3GK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAdministrar extends JFrame {
    private JLabel limg;
    private ImageIcon imagem;
    private JButton busuariosSistema,bremoverUsuario;
    Cliente client;

    public TelaAdministrar(String title, Cliente cliente) throws HeadlessException {
        super(title);
        this.client=cliente;
        setSize(585,430);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
        iniciarEventos();
    }
    private void iniciarComponentes() {
        Font font = new Font(Font.SANS_SERIF,Font.BOLD,15);
        imagem = new ImageIcon(getClass().getResource("/imagens/adm.png"));
        limg = new JLabel(imagem);
        busuariosSistema = new JButton("VER USUARIOS DO SISTEMA");
        busuariosSistema.setFont(font);
        bremoverUsuario = new JButton("REMOVER USUARIO");
        bremoverUsuario.setFont(font);
        add(bremoverUsuario);
        add(busuariosSistema);
        add(limg);
        limg.setBounds(0,0,585,415);
        busuariosSistema.setBounds(180,200,250,40);
        bremoverUsuario.setBounds(180,260,250,40);
    }

    private void iniciarEventos() {
        busuariosSistema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAdministrarUsuarios tela1 = new TelaAdministrarUsuarios("TABELA DE USUARIOS");
                tela1.setVisible(true);
            }
        });
        bremoverUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nomeUsuario = JOptionPane.showInputDialog("QUAL O NOME DO USUARIO PARA REMOVER");
                    boolean achou = false;
                    for (Cliente cliente: TelaBanco3GK.clientes) {
                        if (cliente.getNomeProprietario().contains(nomeUsuario)&&!cliente.getNomeProprietario().contains(client.getNomeProprietario())){
                            TelaBanco3GK.clientes.remove(cliente);
                            JOptionPane.showMessageDialog(null,"CLIENTE "+cliente.getNomeProprietario()+" REMOVIDO COM SUCESSO");
                            achou=true;
                            break;
                        }
                    }
                    if (!achou){
                        JOptionPane.showMessageDialog(null,"NOME DE USUARIO INCORRETO");
                    }
                }catch (Exception p){
                }
            }
        });
    }
}
