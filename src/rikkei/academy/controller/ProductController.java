package rikkei.academy.controller;



import rikkei.academy.model.Product;
import rikkei.academy.service.IProductService;
import rikkei.academy.service.ProductServiceIMPL;

import java.util.List;

public class ProductController {
    IProductService productService = new ProductServiceIMPL();
    public List<Product> getListProduct(){
        return productService.findAll();
    }
    public void addProduct(Product product){
        productService.save(product);
    }

    public Product findById(int id){
        return productService.findById(id);
    }
}
