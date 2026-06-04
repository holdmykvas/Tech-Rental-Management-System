package pj.techrentalsystem.DTOs;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import pj.techrentalsystem.Entities.Rental;
import pj.techrentalsystem.Enums.Role;

import java.util.List;

public class UserDto {

    @Email
    String email;

    String firstName;
    String lastName;

    String password;

    Role role;

    @OneToMany
    List<Rental> rentalList;
}
