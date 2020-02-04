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

//    public Product addNewProduct(@RequestBody Map<String, String> body) {
//        long prod_id = Long.parseLong(body.get("prod_id"));
//        String name = body.get("name");
//        String description = body.get("description");
//        String imgPath = body.get("imgPath");
//        String shelfLife = body.get("shelfLife");
//        // Pairing tips - Probably a JSON Array ?
//        String danger = body.get("danger");
//        // growthRegions
//        String growthPhases = body.get("growthPhases");
//        String scientificName = body.get("scientificName");
//        String history = body.get("history");
//        String cookingUse = body.get("cookingUse");
//        String preservation = body.get("preservation");
//        String funFact = body.get("funFact");
//        String countryOfOrigin = body.get("countryOfOrigin");
//        Product newProduct = new Product(prod_id,name,description,shelfLife,danger,growthPhases,scientificName,history,cookingUse,preservation,funFact,countryOfOrigin);
//
//        // DAO PERSIST New product
//        return null;
//    }
//    public Product addNewProduct(@RequestBody Product newProd) {
//        return newProd;
//    }

//    public Product uploadNewProduct(@RequestBody Map<String, String> body) {
//        //figure out how to parse file and convert to JSON
//        return null;
//    }

//    public Product editProduct(@RequestBody(required = false) Map<String, String> body, @PathVariable String prod_id) {
//        // Product old = dao.getProductFromDatabase
//        String name = body.get("name");
//        String description = body.get("description");
//        String imgPath = body.get("imgPath");
//        String shelfLife = body.get("shelfLife");
//        // Pairing tips - Probably a JSON Array ?
//        String danger = body.get("danger");
//        // growthRegions
//        String growthPhases = body.get("growthPhases");
//        String scientificName = body.get("scientificName");
//        String history = body.get("history");
//        String cookingUse = body.get("cookingUse");
//        String preservation = body.get("preservation");
//        String funFact = body.get("funFact");
//        String countryOfOrigin = body.get("countryOfOrigin");
//        //old.setters
//        return null;
//    }

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
