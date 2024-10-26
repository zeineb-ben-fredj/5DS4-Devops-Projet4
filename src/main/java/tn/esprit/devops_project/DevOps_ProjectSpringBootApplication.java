package tn.esprit.devops_project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevOps_ProjectSpringBootApplication {

    private static final Logger logger = LogManager.getLogger(DevOps_ProjectSpringBootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DevOps_ProjectSpringBootApplication.class, args);

        // Logging information about ProductController endpoints
        logger.info("ProductController - Available Endpoints:");
        logger.info("POST /product/{idStock} - Add a new product to stock");
        logger.info("GET /product/{id} - Retrieve product by ID");
        logger.info("GET /product - Retrieve all products");
        logger.info("GET /product/stock/{id} - Retrieve products by stock ID");
        logger.info("GET /productCategory/{category} - Retrieve products by category");
        logger.info("DELETE /product/{id} - Delete product by ID");

        logger.info("Application started successfully with ProductController endpoints.");
    }
}
