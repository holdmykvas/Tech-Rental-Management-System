package pj.techrentalsystem.Services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pj.techrentalsystem.DTOs.RentalDto;
import pj.techrentalsystem.Entities.Equipment;
import pj.techrentalsystem.Entities.Rental;
import pj.techrentalsystem.Entities.RentalItem;
import pj.techrentalsystem.Entities.User;
import pj.techrentalsystem.Enums.Status;
import pj.techrentalsystem.Repositories.RentalRepository;
import pj.techrentalsystem.Repositories.UserRepository;

import java.time.LocalDate;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final HelperService helperService;
    private final UserRepository userRepository;

    public RentalService(RentalRepository rentalRepository, HelperService helperService, UserRepository userRepository) {
        this.rentalRepository = rentalRepository;
        this.helperService = helperService;
        this.userRepository = userRepository;
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

    @Transactional
    public Rental processCheckout(Long userId, LocalDate start, LocalDate end, Map<Equipment, Integer> equipmentQuanity) {
        if (helperService.validateDateChronology(start,end)) throw new IllegalArgumentException("End date cannot be earlier that start date!");

        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found!"));

        Rental rental = new Rental();
        rental.setUser(user);
        rental.setStartDate(start);
        rental.setEndDate(end);
        rental.setStatus(Status.ACTIVE);

        for(Map.Entry<Equipment,Integer> entry : equipmentQuanity.entrySet()) {
            Equipment equipment = entry.getKey();
            Integer requestedQuantity = entry.getValue();

            if (!helperService.checkStockAvailability(equipment, requestedQuantity)) {
                throw new IllegalArgumentException("Not enought stock for: " + equipment.getName());
            }

            equipment.setStockQuantity(equipment.getStockQuantity() - requestedQuantity);

            RentalItem rentalItem = new RentalItem();
            rentalItem.setRental(rental);
            rentalItem.setEquipment(equipment);
            rentalItem.setQuantity(requestedQuantity);

            rental.getRentalItemList().add(rentalItem);
        }

        return rentalRepository.save(rental);
    }

    public Rental processReturn(Long rentalId) {
        Rental rental = rentalRepository.findById(rentalId).orElseThrow(() -> new IllegalArgumentException("Rental with id: " + rentalId + " not found!"));

        if (rental.getStatus() == Status.RETURNED) {
            throw new IllegalStateException("This rental has already been returned!");
        }

        rental.setStatus(Status.RETURNED);

        for (RentalItem item : rental.getRentalItemList()) {
            Equipment equipment = item.getEquipment();

            int newQuantity = equipment.getStockQuantity() + item.getQuantity();
            equipment.setStockQuantity(newQuantity);
        }
        return rentalRepository.save(rental);
    }
}
