package pj.techrentalsystem.Services;

import org.springframework.stereotype.Service;
import pj.techrentalsystem.Entities.Equipment;

import java.time.LocalDate;

@Service
public class HelperService {

    public boolean validateDateChronology(LocalDate start,LocalDate end) {
        return end.isAfter(start);
    }

    public boolean checkStockAvailability (Equipment equipment, int requestedQuantity) {
        return equipment.getStockQuantity() >= requestedQuantity;
    }
}
