package view;

import Controller.Cliente;
import ViewAdmin.TelaAdministrar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

public class TelaCadastro extends JFrame {
    private JLabel limg;
    private ImageIcon imagem;
    private JRadioButton rbadm;
    private JTextField tnome,tsenha;
    private JButton bcadastrar;
    public TelaCadastro(String title) throws HeadlessException {
        super(title);
        setSize(895,470);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
        iniciarEventos();
    }
    private void iniciarComponentes() {
        Font font = new Font(Font.SANS_SERIF,Font.BOLD,15);
        imagem = new ImageIcon(getClass().getResource("/imagens/img2.png"));
        limg = new JLabel(imagem);
        tnome = new JTextField();
        tsenha = new JTextField();
        bcadastrar = new JButton();
        bcadastrar.setOpaque(false);
        bcadastrar.setBackground(new Color(0,0,0,0));
        bcadastrar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bcadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tnome.setOpaque(false);
        tnome.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tnome.setFont(font);
        tsenha.setFont(font);
        tsenha.setOpaque(false);
        tsenha.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        rbadm = new JRadioButton("Administracao?");
        rbadm.setFont(font);
        rbadm.setOpaque(false);
        add(rbadm);
        add(tsenha);
        add(tnome);
        add(bcadastrar);
        add(limg);

        bcadastrar.setBounds(647,320,150,35);
        tnome.setBounds(640,160,200,30);
        tsenha.setBounds(640,237,200,30);
        limg.setBounds(0,0,895,442);
        rbadm.setBounds(550,280,140,30);
    }
    private void iniciarEventos() {
        bcadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //cadastra o usuario na matriz
                String nomeProprietario= tnome.getText();
                String senha = tsenha.getText();
                if (!tnome.getText().isEmpty()&&!tsenha.getText().isEmpty()){
                    if (rbadm.isSelected()){
                        TelaBanco3GK.clientes.add(new Cliente(nomeProprietario,senha,0,true));
                        //Tela Administracao
                        TelaBanco3GK tela1 = new TelaBanco3GK("Banco 3GK");
                        tela1.setVisible(true);
                        setVisible(false);
                    }else {
                        Random geradorNumeroConta = new Random();
                        int numeroConta = geradorNumeroConta.nextInt(10001);
                        TelaBanco3GK.clientes.add(new Cliente(nomeProprietario,senha,numeroConta,false));
                        TelaBanco3GK tela1 = new TelaBanco3GK("Banco 3GK");
                        tela1.setVisible(true);
                        setVisible(false);
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"PRENCHA TODOS OS CAMPOS");
                }
            }
        });
    }
}
