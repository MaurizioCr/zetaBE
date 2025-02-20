package MaurizioCrispino.Repositories;
import MaurizioCrispino.Entities.CartItem;
import MaurizioCrispino.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUser(User user);
}
