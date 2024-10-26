package tn.esprit.devops_project.services;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockRepository stockRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddProduct() {
        // Given
        Stock stock = new Stock();
        stock.setIdStock(1L);

        Product product = new Product();
        // Remove the setId method if ID is auto-generated
        product.setStock(stock);

        when(stockRepository.findById(1L)).thenReturn(Optional.of(stock));
        when(productRepository.save(product)).thenReturn(product);

        // When
        Product savedProduct = productService.addProduct(product, 1L);

        // Then
        assertThat(savedProduct).isEqualTo(product);
        verify(stockRepository).findById(1L);
        verify(productRepository).save(product);
    }




    @Test
    void testRetrieveAllProducts() {
        // Given
        Product product1 = new Product();
        Product product2 = new Product();
        List<Product> products = Arrays.asList(product1, product2);
        when(productRepository.findAll()).thenReturn(products);

        // When
        List<Product> foundProducts = productService.retreiveAllProduct();

        // Then
        assertThat(foundProducts).hasSize(2).containsExactly(product1, product2);
    }

    @Test
    void testRetrieveProductByCategory() {
        // Given
        Product product1 = new Product();
        Product product2 = new Product();
        product1.setCategory(ProductCategory.ELECTRONICS);
        product2.setCategory(ProductCategory.ELECTRONICS);
        List<Product> products = Arrays.asList(product1, product2);
        when(productRepository.findByCategory(ProductCategory.ELECTRONICS)).thenReturn(products);

        // When
        List<Product> foundProducts = productService.retrieveProductByCategory(ProductCategory.ELECTRONICS);

        // Then
        assertThat(foundProducts).hasSize(2).containsExactly(product1, product2);
    }

    @Test
    void testDeleteProduct() {
        // Given
        Long productId = 1L;

        // When
        productService.deleteProduct(productId);

        // Then
        verify(productRepository).deleteById(productId);
    }

    @Test
    void testRetrieveProductStock() {
        // Given
        Stock stock = new Stock();
        stock.setIdStock(1L);
        Product product1 = new Product();
        Product product2 = new Product();
        when(productRepository.findByStockIdStock(1L)).thenReturn(Arrays.asList(product1, product2));

        // When
        List<Product> foundProducts = productService.retreiveProductStock(1L);

        // Then
        assertThat(foundProducts).hasSize(2).containsExactly(product1, product2);
    }
}
