package pj.techrentalsystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pj.techrentalsystem.Entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
