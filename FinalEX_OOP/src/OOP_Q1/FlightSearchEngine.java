package OOP_Q1;

import java.util.Set;

public class FlightSearchEngine {
    static Set<Flight> search(SearchStrategy strategy, Set<Flight> flightSet) {
        return strategy.searchFlights(flightSet);
    }
}
