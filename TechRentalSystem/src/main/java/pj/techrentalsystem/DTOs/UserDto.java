package pj.techrentalsystem.DTOs;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import pj.techrentalsystem.Entities.Rental;
import pj.techrentalsystem.Enums.Role;

import java.util.List;

public class UserDto {

    private Long id;

    @Email
    private String email;

    private String firstName;
    private String lastName;

    String password;
    private Role role;

    private List<RentalDto> rentals;

    public List<RentalDto> getRentals() {
        return rentals;
    }

    public void setRentals(List<RentalDto> rentals) {
        this.rentals = rentals;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
