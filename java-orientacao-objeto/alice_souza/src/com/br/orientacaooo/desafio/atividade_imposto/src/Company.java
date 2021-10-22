public class Company extends TaxPayer{
    public int numberOfEmployees;

    public Company(String name, Double anualIncome, int numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double tax() {
        double imposto = 0;
        imposto = getAnualIncome()*0.16;
        if(getNumberOfEmployees()>10){
            imposto = getAnualIncome()*0.14;
        }
        return imposto;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }
}
