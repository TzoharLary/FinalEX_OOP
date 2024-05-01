package OOP_Q1;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Airline {
    Set<Flight> flights = new HashSet<Flight>();
    Set<Airline> subAirlines = new HashSet<Airline>();

    String name;

    public Airline(String name){
        this.name = name;
    }

    public void addFlight(Flight f){
        flights.add(f);
    }

    public void addSubAirline(Airline a){
        subAirlines.add(a);
    }

    public Set<Flight> getFlights(){
        return flights;
    }

    public Set<Airline> getSubAirlines(){
        return subAirlines;
    }

    public String getName(){
        return name;
    }

    public Collection<Flight> getAllFlights(){
        if (subAirlines.isEmpty()){
            return flights;
        }
        Set<Flight> result = new HashSet<Flight>(flights);
        for(Airline a : subAirlines){
            result.addAll(a.getAllFlights());
        }
        return result;
    }
}
