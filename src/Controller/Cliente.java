package Controller;

import view.TelaPrincipalApp;

import javax.swing.*;

public class Cliente extends Banco {
    private String cpf;
    private String nomeProprietario;
    private String senha;
    private double saldo;
    private Endereco endereco  = new Endereco();


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cliente(String nomeProprietario, String senha,int numero) {
        this.nomeProprietario = nomeProprietario;
        this.senha = senha;
        setNumero(numero);
    }

    public String getSenha() {
        return senha;
    }
    public double getSaldo(){
        return saldo;
    }
    public void depositaSaldo(double valor){
            this.saldo+=valor;
    }
    public void sacar(double valor){
        if (valor<=this.saldo&&valor>0){
            this.saldo-=valor;
        }else {
            JOptionPane.showMessageDialog(null,"valor incorreto");
        }
    }
}
