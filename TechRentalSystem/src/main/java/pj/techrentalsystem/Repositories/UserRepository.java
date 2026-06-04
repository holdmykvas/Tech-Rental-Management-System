package pj.techrentalsystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pj.techrentalsystem.Entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
