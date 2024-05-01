package OOP_Q1;

import java.util.HashSet;
import java.util.Set;

public class SearchByDepartureTime implements SearchStrategy {
    int startTime;  // שעת ההתחלה שהמשתמש הזין

    SearchByDepartureTime(int startTime) {
        this.startTime = startTime;
    }

    public Set<Flight> searchFlights(Set<Flight> flightSet) {
        Set<Flight> result = new HashSet<>();
        for (Flight f : flightSet) {
            // בדיקה ששעת היציאה של הטיסה נמצאת בין השעה שהוזנה על ידי המשתמש ועד 2400
            if (f.getDeparture() >= startTime && f.getDeparture() <= 2400) {
                result.add(f);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No flights departing within the time range you entered.");
        }
        return result;
    }
}
