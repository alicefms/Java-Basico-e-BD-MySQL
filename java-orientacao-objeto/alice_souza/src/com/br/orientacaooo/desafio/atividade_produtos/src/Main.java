import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        System.out.println("Quantos produtos deseja cadastrar?");
        int N = scan.nextInt();
        List<Product> listaProdutos = new ArrayList<>();
        for(int i = 0; i<N; i++){
            System.out.println("O produto é importado(1) ou usado(2)?");
            int prod = 0;
            do {
                prod = scan.nextInt();}
            while(prod != 1 && prod !=2);

                System.out.println("digite o nome: ");
                scan.nextLine();
                String nome = scan.nextLine();
                System.out.println("digite o preço: ");
                Double preco = scan.nextDouble();
            if(prod == 1) {
                System.out.println("Digite a taxa alfandegária: ");
                Double taxa = scan.nextDouble();
                Product produto = new ImportedProduct(nome, preco, taxa);
                listaProdutos.add(produto);
            }
            else if (prod == 2){
                System.out.println("digite a data de fabricação(ex.: 31-12-2020): ");
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                scan.nextLine();
                Date data = formato.parse(scan.nextLine());
                Product produto = new UsedProdutc(nome, preco, data);
                listaProdutos.add(produto);
            }
        }
        for (Product p: listaProdutos) {
            System.out.println(p.priceTag());
            System.out.println();

        }
    }
}
