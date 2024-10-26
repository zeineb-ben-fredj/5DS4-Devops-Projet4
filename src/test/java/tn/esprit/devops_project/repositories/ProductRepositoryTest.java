package tn.esprit.devops_project.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
     void testFindByCategory() {
        // Given
        Product product1 = new Product();
        product1.setCategory(ProductCategory.ELECTRONICS);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setCategory(ProductCategory.ELECTRONICS);
        productRepository.save(product2);

        // When
        List<Product> foundProducts = productRepository.findByCategory(ProductCategory.ELECTRONICS);

        // Then
        assertThat(foundProducts)
                .hasSize(2)
                .extracting("category")
                .containsOnly(ProductCategory.ELECTRONICS);
    }

//    @Test
//     void testFindByStockId() {
//        // Given
//        Stock stock = new Stock();
//        stock.setIdStock(1L); // Ensure the ID is set properly for testing
//        // Save the stock first to ensure it's persisted
//        // Note: You need to have a StockRepository if Stock is an entity and needs to be persisted
//        // stockRepository.save(stock); // Uncomment if you have a StockRepository
//
//        Product product1 = new Product();
//        product1.setStock(stock);
//        productRepository.save(product1);
//
//        Product product2 = new Product();
//        product2.setStock(stock);
//        productRepository.save(product2);
//
//        // When
//        List<Product> foundProducts = productRepository.findByStockIdStock(stock.getIdStock());
//
//        // Then
//        assertThat(foundProducts)
//                .hasSize(2)
//                .extracting("stock.idStock")
//                .containsOnly(stock.getIdStock());
//    }
}
