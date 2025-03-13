package MaurizioCrispino.Services;

import MaurizioCrispino.Entities.Cart;
import MaurizioCrispino.Entities.User;
import MaurizioCrispino.Exceptions.NotFoundException;
import MaurizioCrispino.Repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {


    @Autowired
    private CartRepository carrelloRepository;


    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return carrelloRepository.save(cart);
    }

    public Cart getCartById(Long cartId) {
        return carrelloRepository.findById(cartId).orElseThrow(() -> new NotFoundException(cartId));
    }

    public void updateCart(Cart cart) {
        carrelloRepository.save(cart);
    }




    }