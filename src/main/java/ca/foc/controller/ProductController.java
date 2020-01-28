package ca.foc.controller;

import ca.foc.domain.Product;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * ******************************************** **
 * ProductController - ca.foc.controller.ProductController
 *
 * @author Christian Garrovillo
 * Information and Communications Technologies
 * Software Development
 * * ********************************************* **
 */

@RestController
public class ProductController {

    public Product addNewProduct(@RequestBody Map<String, String> body) {

        return null;
    }
}
