import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id) {
        Product p = productService.getProductById(id);
        return (p != null) ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.ok("Product added");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Product product) {
        boolean updated = productService.updateProduct(id, product);
        return updated ? ResponseEntity.ok("Product updated") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean removed = productService.deleteProduct(id);
        return removed ? ResponseEntity.ok("Product deleted") : ResponseEntity.notFound().build();
    }
}
