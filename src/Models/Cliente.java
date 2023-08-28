package Models;

import Interface.CalculaJuros;

import javax.swing.*;
import Exception.SemSaldoException;

public class Cliente extends Conta implements CalculaJuros {
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

    public String getSenha() {
        return senha;
    }
    public double getSaldo(){
        return saldo;
    }
    public void depositaSaldo(double valor){
            this.saldo+=valor;
    }
    public void sacar(double valor) throws SemSaldoException {
        //remove o dinheiro da conta do usuario
        if (valor>=this.saldo&&valor<0){
            throw new SemSaldoException("valor ou saldo incorreto");
        }
        saldo-=valor;
    }

    @Override
    public double getTaxaPorcentagemMes(double valor, int quantidadeMes, double porcentagem) {
        valor = ((porcentagem/100)*valor);
        valor = valor*quantidadeMes;
        return valor;
    }
    @Override
    public double getTaxaequivalentes(double taxa, double prazo, double prazoDesejavel) {
        double taxaEquivalente=(Math.pow((taxa/100)+1,prazoDesejavel/prazo)-1)*100;
        return taxaEquivalente;
    }

    public Cliente(String nomeProprietario, String senha,int numero,boolean administrador) {
        super(numero,administrador);
        this.nomeProprietario = nomeProprietario;
        this.senha = senha;
    }
}
