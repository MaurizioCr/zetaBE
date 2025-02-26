package MaurizioCrispino.Entities;

import MaurizioCrispino.Repositories.UserRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class Cart {

    @Service
    public class UserService {
        @Autowired
        private UserRepository utenteRepository;

        @Autowired
        private Cloudinary cloudinaryUploader;

        private PasswordEncoder bcrypt = new BCryptPasswordEncoder(11);

        public Page<User> getUsers(int page, int size, String orderBy) {
            if (size >= 100) size = 100;
            Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
            return utenteRepository.findAll(pageable);
        }
    }
}
