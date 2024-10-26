package tn.esprit.devops_project.controllers;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.services.Iservices.IProductService;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ProductController {

    private static final Logger logger = LogManager.getLogger(ProductController.class);
    private final IProductService productService;

    @PostMapping("/product/{idStock}")
    public Product addProduct(@RequestBody Product product, @PathVariable Long idStock) {
        logger.info("Adding a new product to stock with ID: {}", idStock);
        return productService.addProduct(product, idStock);
    }

    @GetMapping("/product/{id}")
    public Product retrieveProduct(@PathVariable Long id) {
        logger.info("Retrieving product with ID: {}", id);
        return productService.retrieveProduct(id);
    }

    @GetMapping("/product")
    public List<Product> retreiveAllProduct() {
        logger.info("Retrieving all products");
        return productService.retreiveAllProduct();
    }

    @GetMapping("/product/stock/{id}")
    public List<Product> retreiveProductStock(@PathVariable Long id) {
        logger.info("Retrieving products in stock with ID: {}", id);
        return productService.retreiveProductStock(id);
    }

    @GetMapping("/productCategory/{category}")
    public List<Product> retrieveProductByCategory(@PathVariable ProductCategory category) {
        logger.info("Retrieving products by category: {}", category);
        return productService.retrieveProductByCategory(category);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        logger.info("Deleting product with ID: {}", id);
        productService.deleteProduct(id);
    }
}
