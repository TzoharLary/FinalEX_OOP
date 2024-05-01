package OOP_Q1;

import java.util.HashSet;
import java.util.Set;

public class SearchByPrice implements SearchStrategy{
    int maxPrice;
    int minPrice;

    SearchByPrice(int minPrice, int maxPrice){
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public Set<Flight> searchFlights(Set<Flight> flightSet){
        Set<Flight> result = new HashSet<>();
        for(Flight f : flightSet){
            if(f.getPrice() >= minPrice && f.getPrice() <= maxPrice){
                result.add(f);
            }
        }
        if (result.isEmpty()) {
            System.out.println("You don't have any flights at the prices you entered");
        }
        return result;
    }
}
