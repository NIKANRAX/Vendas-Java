package db;

import models.Product;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDb {
	private List<Product> productList = new ArrayList <>();

	public List<Product> getProductList() {
		return productList;
	}
	
	public void addNovoProduct(Product product) {
		productList.add(product);
	}
}
