package Models;

public abstract class Conta {
    private int agencia = 666;
    private int numero;
    private boolean administrador=false;

    public Conta(int numero, boolean administrador) {
        this.numero = numero;
        this.administrador = administrador;
    }
    public boolean isAdministrador() {
        return administrador;
    }
    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
    public int getAgencia() {
        return agencia;
    }
    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

}
