package model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;

    public Inventory(){
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts(){
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public Product getProductById(int id){
        for(Product product : products){
            if(product.getId() == id)
                return product;
        }
        return null;
    }
}
