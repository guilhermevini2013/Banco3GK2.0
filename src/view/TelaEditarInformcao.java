package view;

import Controller.Cliente;
import Controller.Endereco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEditarInformcao extends JFrame {
    private JLabel limg;
    private ImageIcon imagem;
    private JTextField trua,tnumero,tbairro,tcomplemento;
    private JButton bsalvar;
    Cliente cliente;
    public TelaEditarInformcao(String title, Cliente cliente) throws HeadlessException {
        super(title);
        this.cliente=cliente;
        setSize(500,400);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        iniciarComponentes();
        iniciarEventos();
    }

    private void iniciarComponentes() {
        Font font = new Font(Font.SANS_SERIF,Font.BOLD,15);
        imagem = new ImageIcon(getClass().getResource("/imagens/editar2.png"));
        limg = new JLabel(imagem);
        trua = new JTextField(cliente.getEndereco().getRua());
        tbairro = new JTextField(cliente.getEndereco().getBairro());
        tcomplemento=new JTextField(cliente.getEndereco().getComplementos());
        tnumero=new JTextField(cliente.getEndereco().getNumeroRua());
        trua.setFont(font);
        trua.setOpaque(false);
        trua.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tnumero.setFont(font);
        tnumero.setOpaque(false);
        tnumero.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tbairro.setFont(font);
        tbairro.setOpaque(false);
        tbairro.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tcomplemento.setFont(font);
        tcomplemento.setOpaque(false);
        tcomplemento.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bsalvar = new JButton("");
        bsalvar.setOpaque(false);
        bsalvar.setBackground(new Color(0,0,0,0));
        bsalvar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bsalvar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(bsalvar);
        add(tcomplemento);
        add(tbairro);
        add(tnumero);
        add(trua);
        add(limg);

        tnumero.setBounds(115,115,50,30);
        limg.setBounds(0,0,500,400);
        trua.setBounds(120,67,250,30);
        tbairro.setBounds(150,160,220,30);
        tcomplemento.setBounds(250,203,130,30);
        bsalvar.setBounds(125,285,250,50);
    }

    private void iniciarEventos() {
        bsalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // salva o novo endereco do usuario
                Endereco endereco = new Endereco();
                endereco.setRua( trua.getText());
                endereco.setBairro( tbairro.getText());
                endereco.setComplementos(tcomplemento.getText());
                endereco.setNumeroRua(tnumero.getText());
                cliente.setEndereco(endereco);
                setVisible(false);
            }
        });
    }
}
