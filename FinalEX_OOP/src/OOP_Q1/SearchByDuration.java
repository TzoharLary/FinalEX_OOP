package OOP_Q1;

import java.util.HashSet;
import java.util.Set;

public class SearchByDuration implements SearchStrategy {
    int maxDuration;

    SearchByDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public Set<Flight> searchFlights(Set<Flight> flightSet) {
        Set<Flight> result = new HashSet<>();
        for (Flight f : flightSet) {
            if (f.getDuration() <= maxDuration) {
                result.add(f);
            }
        }
        if (result.isEmpty()) {
            System.out.println("You don't have any flights within the maximum duration you entered.");
        }
        return result;
    }
}
