import models.Product;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import db.ProdutosDb;
public class Main {

	static ProdutosDb produtosDB = new ProdutosDb();
	
	public static void main(String[] args) throws Exception {
		System.out.println("--- PEDIDO DE VENDAS ----");
		
		int option;
		
		do {
			System.out.println("1 - Cadastrar produto");
			System.out.println("2 - Listar produtos cadastrados");
			System.out.println("0 - Sair ");
			
			Scanner scanner = new Scanner(System.in); 
			
			System.out.print("Qual operação deseja realizar: ");
			option = scanner.nextInt();
			
			process(option);
		}while(option != 0);
	}
	
	public static void process(int option) throws Exception{
		switch (option) {
			case 1 : {
				Scanner scanner = new Scanner(System.in);
				
				System.out.print("Qual a descrição que você deseja dar ao novo produto: ");
				String descricao = scanner.nextLine();
				
				System.out.print("Qual o id você deseja dar ao novo produto: ");
				int id = scanner.nextInt();
				
				System.out.println("Qual o preço: ");
				double preco = scanner.nextDouble(); 
				
				System.out.println("Qual a data de validade: ");
				String dataString = scanner.next();
				
				Date dataValidade = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);
				
				Product novoProduct = new Product(id, descricao, preco, dataValidade);
				
				produtosDB.addNovoProduct(novoProduct);
				
				break;
				
			}
			
			case 2: {
				List <Product> productList = produtosDB.getProductList();
				 
				for(Product product : productList) {
					
					System.out.println("--- ID: " + product.getId());
					System.out.println("--- Descrição: " + product.getDescricao());
					System.out.println("---- Preço:" + product.getPreco());
					System.out.println("---- Data de validade " + product.getDataValidade());
					System.out.println("------------------------------------------------");
				}
				
				break;
			}
		}
	}
}
