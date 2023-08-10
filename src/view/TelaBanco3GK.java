package view;

import Controller.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaBanco3GK extends JFrame {
    private JLabel limg;
    private JTextField tnome,tsenha;
    private JButton bcadastrar,bentrar;
    private ImageIcon imagem;

     static List<Cliente> clientes = new ArrayList<>();
    public TelaBanco3GK(String title) throws HeadlessException {
        super(title);
        setSize(895,470);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
        iniciarEventos();
    }

    private void iniciarComponentes() {
        Font font = new Font(Font.SANS_SERIF,Font.BOLD,15);
        imagem = new ImageIcon(getClass().getResource("/imagens/img1.png"));
        limg = new JLabel(imagem);
        tnome = new JTextField();
        tnome.setOpaque(false);
        tnome.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tnome.setFont(font);
        tsenha = new JTextField();
        tsenha.setFont(font);
        tsenha.setOpaque(false);
        tsenha.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bcadastrar = new JButton();
        bentrar = new JButton("");
        bcadastrar.setOpaque(false);
        bcadastrar.setBackground(new Color(0,0,0,0));
        bcadastrar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bcadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bentrar.setOpaque(false);
        bentrar.setBackground(new Color(0,0,0,0));
        bentrar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bentrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(tsenha);
        add(tnome);
        add(bentrar);
        add(bcadastrar);
        add(limg);
        bcadastrar.setBounds(667,380,150,35);
        bentrar.setBounds(667,320,150,35);
        tnome.setBounds(640,160,200,30);
        tsenha.setBounds(640,237,200,30);
        limg.setBounds(0,0,895,442);
    }

    private void iniciarEventos() {
        bcadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastro tela1 = new TelaCadastro("Banco3GK-Cadastro");
                tela1.setVisible(true);
                setVisible(false);
            }
        });
        bentrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tnome.getText().isEmpty()&&!tsenha.getText().isEmpty()){
                    String nomeProprietario= tnome.getText();
                    String senha = tsenha.getText();
                    boolean verifica=false;
                    for (Cliente cliente:clientes) {
                        if (cliente.getNomeProprietario().equals(nomeProprietario)&&cliente.getSenha().equals(senha)){
                            System.out.println("ENTROU");
                            verifica=true;
                            TelaPrincipalApp tela1 = new TelaPrincipalApp("Banco 3GK",cliente);
                            tela1.setVisible(true);
                            setVisible(false);
                            break;
                        }
                    }
                    if (verifica==false){
                        JOptionPane.showMessageDialog(null,"USUARIO NAO ENCONTRADO");
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"PREENCHA TODOS OS CAMPOS");
                }
            }
        });
    }
    public static void main(String[] args) {
        TelaBanco3GK tela = new TelaBanco3GK("Banco 3GK");
        tela.setVisible(true);
    }
}
