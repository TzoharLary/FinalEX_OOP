package OOP_Q1;

import OOP_Q1.Flight;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FlightManager {
    private static Set<Flight> flights = new HashSet<>();

    public static void addFlight(Flight flight) {
        flights.add(flight);
    }
    public static Flight getFlightById(String flightId) {
        for (Flight flight : flights) {
            if (flight.getId().equals(flightId)) {
                return flight;
            }
        }
        return null;
    }

    public static Set<Flight> getAllFlights() {
        return Collections.unmodifiableSet(flights);
    }
}
