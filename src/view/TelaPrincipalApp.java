package view;

import Controller.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import static view.TelaBanco3GK.clientes;

public class TelaPrincipalApp extends JFrame {
    private JLabel limg,lnome,lsaldo,lnumeroConta;
    private ImageIcon imagem;
    private JButton bdepositar,bsacar,btransferir,binformacao,bsair,bjuros,bjuros2;
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
        bjuros = new JButton("calcular juros de % ao mês");
        bjuros2 = new JButton("calcular taxas equivalentes");
        add(bjuros2);
        add(bjuros);
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
        bjuros.setBounds(40,80,200,30);
        bjuros2.setBounds(250,80,200,30);
    }

    private void iniciarEventos() {
        DecimalFormat df = new DecimalFormat("#,##0.00"); // FORMATADOR DE DOUBLE COM 2 CASAS DECIMAIS
        bdepositar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Depositar valor
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
                //sacar saldo
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
                //transfere saldo para outro usuario
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
            //Volta para a tela de cadastro
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
        bjuros.addActionListener(new ActionListener() { //  calcular juros de % ao mês
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double valor = Double.parseDouble(JOptionPane.showInputDialog("DIGITE O VALOR"));
                    int quantidadeMes = Integer.parseInt(JOptionPane.showInputDialog("DIGITE A QUANTIDADE DE MES"));
                    double porcentagem = Double.parseDouble(JOptionPane.showInputDialog("DIGITE A PORCENTAGEM"));
                    JOptionPane.showMessageDialog(null,"O VALOR TOTAL DE TAXA EM "+quantidadeMes+" MES: "+df.format(cliente.getTaxaPorcentagemMes(valor,quantidadeMes,porcentagem))+"R$");
                }catch (Exception a){

                }
            }
        });
        bjuros2.addActionListener(new ActionListener() { //calcular taxas equivalentes
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double taxa = Double.parseDouble(JOptionPane.showInputDialog("DIGITE A TAXA"));
                    int prazo = Integer.parseInt(JOptionPane.showInputDialog("DIGITE O PRAZO"));
                    double prazoDesejavel = Double.parseDouble(JOptionPane.showInputDialog("DIGITE O PRAZO DESEJAVEL"));
                    JOptionPane.showMessageDialog(null,"TAXAS EQUIVALENTES: "+df.format(cliente.getTaxaequivalentes(taxa,prazo,prazoDesejavel))+"%");
                }catch (Exception l){

                }
            }
        });
    }
}