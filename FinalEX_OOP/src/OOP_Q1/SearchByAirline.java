package OOP_Q1;

import java.util.HashSet;
import java.util.Set;

public class SearchByAirline implements SearchStrategy {
    private String airlineName;

    public SearchByAirline(String airlineName) {
        this.airlineName = airlineName;
    }

    @Override
    public Set<Flight> searchFlights(Set<Flight> flightSet) {
        Set<Flight> result = new HashSet<>();
        for (Flight flight : flightSet) {
            if (isSubsidiaryOrSelf(flight.getAirline(), airlineName)) {
                result.add(flight);
            }
        }
        return result;
    }

    private boolean isSubsidiaryOrSelf(Airline airline, String airlineName) {
        if (airline.getName().equals(airlineName)) {
            return true;  // החברה עצמה
        }
        // בדוק אם יש חברות בת שהן של החברה שחיפשנו
        for (Airline subAirline : getSubAirlines(airlineName)) {
            if (airline.getName().equals(subAirline.getName())) {
                return true;  // חברת בת של החברה שחיפשנו
            }
        }
        return false;
    }

    // פונקציה להשגת כל חברות הבת של חברת התעופה
    private Set<Airline> getSubAirlines(String airlineName) {
        for (Airline mainAirline : Main.airlines) { // 'airlines' זו הרשימה הגלובלית של כל החברות
            if (mainAirline.getName().equals(airlineName)) {
                return mainAirline.getSubAirlines();
            }
        }
        return new HashSet<>(); // אם לא מצאנו חברה, החזר רשימה ריקה
    }


}
