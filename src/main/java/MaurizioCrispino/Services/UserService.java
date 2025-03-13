package MaurizioCrispino.Services;
import  MaurizioCrispino.Entities.User;
import  MaurizioCrispino.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public User findbyIdAndUpdate(long id, User body) {
        User found = this.findById(id);
        if (body.getCognome() != null && !body.getCognome().isEmpty()) {
            found.setCognome(body.getCognome());
        }
        if (body.getNome() != null && !body.getNome().isEmpty()) {
            found.setNome(body.getNome());
        }
        if (body.getEmail() != null && !body.getEmail().isEmpty()) {
            found.setEmail(body.getEmail());
        }
        if (body.getUsername() != null && !body.getUsername().isEmpty()) {
            found.setUsername(body.getUsername());
        }

        if (body.getAvatar() != null && !body.getAvatar().isEmpty()) {
            found.setAvatar(body.getAvatar());
        }

        // Salva le modifiche nell'utente nel database
        return userRepository.save(found);
    }
}
