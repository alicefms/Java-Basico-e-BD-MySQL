import java.util.Date;

public class UsedProdutc extends Product {
   private String name;
   private Double price;
   private Date manufactureDate;

    public UsedProdutc(String name, Double price, Date manufactureDate) {
        this.name = name;
        this.price = price;
        this.manufactureDate = manufactureDate;
    }


    @Override
    public String priceTag() {
        return "Produto: " + this.name + '\n' +
                "Preço: " + this.price + '\n' +
                "Data de Fabricação: " + this.manufactureDate + '\n' +
                "PREÇO TOTAL: "+ this.price;
    }
}
