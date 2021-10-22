public class Individual extends TaxPayer {
    private Double healthExpenditures;

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        double imposto = 0;
        if (getAnualIncome() <20000.00){
            imposto = getAnualIncome()*0.15;
        }else {
            imposto = getAnualIncome()*0.25;
        }
        if (getHealthExpenditures()>0) {
            imposto = imposto -getHealthExpenditures()/2;
        }
        return imposto;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }
}