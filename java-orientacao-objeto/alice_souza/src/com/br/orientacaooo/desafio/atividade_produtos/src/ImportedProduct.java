public class ImportedProduct extends Product {
    private String name;
    private Double price;
    private Double CustomsFoo;

    public ImportedProduct(String name, Double price, Double customsFoo) {
        this.name = name;
        this.price = price;
        CustomsFoo = customsFoo;
    }


    public Double totalPrice(){
        return this.CustomsFoo + this.price;
    }

    @Override
    public String priceTag() {
        return "Produto: " + this.name + '\n' +
                "Preço: " + this.price + '\n' +
                "Taxa da Alfândega: " + this.CustomsFoo + '\n' +
                "PREÇO TOTAL: "+ this.totalPrice();
    }
}
