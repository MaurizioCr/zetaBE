package MaurizioCrispino.Services;

import MaurizioCrispino.Entities.Cart;
import MaurizioCrispino.Entities.CartItem;
import MaurizioCrispino.Entities.Product;
import MaurizioCrispino.Repositories.CartItemRepository;
import MaurizioCrispino.Repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class CartItemService {

    @Service
        @Autowired
        private CartItemRepository cartItemsRepository;
        @Autowired
        private CartService cartService;
        @Autowired
        private ProductService productsService;
        @Autowired
        private CartRepository carrelloRepository;


        public void addItemToCart(Long cartId, Long productId) {
            Cart cart = cartService.getCartById(cartId);
            Products products = productsService.getProductById(productId);
            List<OggettoCarrello> oggettoCarrellos = cart.getOggettoCarrellos();
            OggettoCarrello oggettoCarrello = new OggettoCarrello();
            oggettoCarrello.setCart(cart);
            oggettoCarrello.setProducts(products);
            oggettoCarrello.setQuantity(1);
            cart.setTotalPrice(cart.getTotalPrice() + products.getPrice());
            cartService.updateCart(cart);
            if (oggettoCarrellos.contains(oggettoCarrello)) {
                CartItem found = cartItemsRepository.findByCartIdAndProductsId(cartId, productId);
                found.setQuantity(found.getQuantity() + 1);
                cartItemsRepository.save(found);

            } else {
                cartItemsRepository.save(oggettoCarrello);
            }
        }
}
