package Interface;

public interface CalculaJuros {
    public double getTaxaPorcentagemMes(double valor,int quantidadeMes,double porcentagem);// calcular juros de % ao mês
    public double getTaxaequivalentes(double taxa,double prazo,double prazoDesejavel);//calcular taxas equivalentes
}
