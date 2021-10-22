public class FuncionarioTerceirizado extends Funcionario {
    private double despesaAdicional;

    public double getDespesaAdicional() {
        return despesaAdicional;
    }

       public FuncionarioTerceirizado(String nome, int horas, double valorPorHora, double despesaAdicional) {
        super(nome, horas, valorPorHora);
        this.despesaAdicional = despesaAdicional;
    }

    @Override
    public double pagamento(){
       return this.getHoras() *this.getValorPorHora() + this.despesaAdicional*1.1;
    }

    public void setDespesaAdicional(double despesaAdicional) {
        this.despesaAdicional = despesaAdicional;
    }
}



