package OOP_Q1;

import OOP_Q1.Flight;

import java.util.Set;

public interface SearchStrategy {
    public Set<Flight> searchFlights(Set<Flight> flightSet);
}
