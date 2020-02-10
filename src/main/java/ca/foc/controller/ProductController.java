package ca.foc.controller;

import ca.foc.domain.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
@RequestMapping("/products")
public class ProductController {

    @PostMapping
    public Product addNewProduct(@RequestBody Product newProd) {
        //dao.persist newProd
        return null;
    }

    @PutMapping("/{id}")
    public Product editProduct(@RequestBody Product updatedProd, @PathVariable long id) {
        //dao persist
        return null;
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable long id) {
        return null;
    }

    @PostMapping("/search")
    public List<Product> search(@RequestBody Map<String, String> body) {
        if (body.containsKey("product")) {
            //product search support method
        }
        else if (body.containsKey("region")) {
            //region search support method
        }
        else if (body.containsKey("season")) {
            //region search support method
        }

        return null;
    }






    @GetMapping("/products/top")
    public List<Product> getTopTen() {
        //dao get top ten
        return null;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        //dao get all
        return null;
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable long id) {
        //dao get product
        return null;
    }

    @PostMapping("/suggest/{id}")
    public Product suggestion(@RequestBody Map<String, String> body) {
        return null;
    }

    @GetMapping("/suggest")
    public List<Product> viewSuggestions() {
        return null;
    }
}
