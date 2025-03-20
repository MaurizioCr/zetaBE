package MaurizioCrispino.Services;
import MaurizioCrispino.Entities.Product;
import MaurizioCrispino.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository prodottoRepository;

    @Autowired
    public ProductService(ProductRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
    }

    public Product createProduct(Product product) {
        return prodottoRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        return prodottoRepository.save(product);
    }

    public void deleteProduct(Long id) {
        prodottoRepository.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return prodottoRepository.findAll();
    }

    public Product getProductById(Long id) {
        return prodottoRepository.findById(id).orElse(null);
    }


}