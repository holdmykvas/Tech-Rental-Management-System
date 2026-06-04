package pj.techrentalsystem.Services;

import org.springframework.stereotype.Service;
import pj.techrentalsystem.DTOs.RentalDto;
import pj.techrentalsystem.Entities.Rental;
import pj.techrentalsystem.Repositories.RentalRepository;

import java.util.List;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental addRental(RentalDto rentalDto) {
        Rental rental = new Rental();
        //TODO
        return rentalRepository.save(rental);
    }

    public Rental getRentalById(Long id) {
        return rentalRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Rental with this id { " + id + " } is not found!"));
    }
}
