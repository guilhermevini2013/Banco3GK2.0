package view;

import Controller.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.TelaBanco3GK.clientes;

public class TelaPrincipalApp extends JFrame {
    private JLabel limg,lnome,lsaldo,lnumeroConta;
    private ImageIcon imagem;
    private JButton bdepositar,bsacar,btransferir,binformacao,bsair;
    static Cliente cliente;
    public TelaPrincipalApp(String title, Cliente cliente) throws HeadlessException {
        super(title);
        this.cliente=cliente;
        setSize(500,500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
        iniciarEventos();
        System.out.println(cliente.getNomeProprietario());
    }

    private void iniciarComponentes() {
        imagem = new ImageIcon(getClass().getResource("/imagens/img.png"));
        limg = new JLabel(imagem);
        lnome = new JLabel(cliente.getNomeProprietario());
        lnome.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
        lnome.setForeground(new Color(255,255,255));
        lsaldo = new JLabel(String.valueOf(cliente.getSaldo()));
        lsaldo.setForeground(new Color(255,255,255));
        lsaldo.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
        bdepositar = new JButton("DEPOSITAR");
        bsacar = new JButton("SACAR");
        btransferir = new JButton("TRANSFERIR");
        binformacao = new JButton("EDT.INFORMACAO");
        bsair = new JButton("SAIR");
        lnumeroConta = new JLabel("CONTA: "+cliente.getNumero());
        lnumeroConta.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
        lnumeroConta.setForeground(new Color(255,255,255));
        add(lnumeroConta);
        add(bsair);
        add(binformacao);
        add(btransferir);
        add(bsacar);
        add(bdepositar);
        add(lsaldo);
        add(lnome);
        add(limg);

        lnumeroConta.setBounds(110,420,300,40);
        bdepositar.setBounds(5,20,100,40);
        limg.setBounds(0,0,500,500);
        lnome.setBounds(190,320,200,40);
        lsaldo.setBounds(190,380,100,40);
        bsacar.setBounds(110,20,90,40);
        btransferir.setBounds(210,20,110,40);
        binformacao.setBounds(330,20,150,40);
        bsair.setBounds(375,420,100,40);
    }

    private void iniciarEventos() {
        bdepositar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double valor = Double.parseDouble(JOptionPane.showInputDialog("DIGITE O VALOR $ PARA DEPOSITAR"));
                    if (valor>0){
                        cliente.depositaSaldo(valor);
                        System.out.println(cliente.getSaldo());
                        lsaldo.setText(String.valueOf(cliente.getSaldo()));
                    }else {
                        JOptionPane.showMessageDialog(null,"valor incorreto");
                    }
                }catch (Exception l){
                }
            }
        });
        bsacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double valor = Double.parseDouble(JOptionPane.showInputDialog("DIGITE O VALOR $ PARA SACAR"));
                    if (valor<=cliente.getSaldo()&&valor>0){
                        cliente.sacar(valor);
                        System.out.println(cliente.getSaldo());
                        lsaldo.setText(String.valueOf(cliente.getSaldo()));
                    }else {
                        JOptionPane.showMessageDialog(null,"valor incorreto");
                    }
                }catch (Exception p){
                }
                }

        });
        btransferir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Bug de campos vazios arrumado
                    String numeroDaConta = JOptionPane.showInputDialog("DIGITE O NUMERO DA CONTA ");
                    double valor = Double.parseDouble(JOptionPane.showInputDialog("DIGITE O VALOR $ PARA TRANSFERIR PARA O REMETENTE   "+numeroDaConta));
                    boolean verifica=false;
                for (Cliente remetente:clientes) {
                    if (remetente.getNumero()==Integer.parseInt(numeroDaConta)&&valor>0&&cliente.getNumero()!=Integer.parseInt(numeroDaConta)){
                        cliente.sacar(valor);
                        System.out.println(cliente.getSaldo());
                        lsaldo.setText(String.valueOf(cliente.getSaldo()));
                        remetente.depositaSaldo(valor);
                        System.out.println(remetente.getSaldo());
                        verifica=true;
                    }else {
                        System.out.println("NAO DEU");
                    }
                }
                if (verifica==false){
                    JOptionPane.showMessageDialog(null,"USUARIO NAO ENCONTRADO OU INCORRETO");
                }
                }catch (Exception u) {
                }
            }
        });
        bsair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaBanco3GK tela1 = new TelaBanco3GK("Banco 3GK");
                tela1.setVisible(true);
                setVisible(false);
            }
        });
        binformacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaEditarInformcao tela = new TelaEditarInformcao("EDITAR INF",cliente);
                tela.setVisible(true);
            }
        });
    }
}
