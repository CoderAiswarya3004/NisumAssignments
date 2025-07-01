import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.stream()
                       .filter(p -> p.getId() == id)
                       .findFirst()
                       .orElse(null);
    }
    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean updateProduct(int id, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            Product existing = products.get(i);
            if (existing.getId() == id) {
                updatedProduct.setId(id); 
                products.set(i, updatedProduct);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(int id) {
        return products.removeIf(p -> p.getId() == id);
    }
}
