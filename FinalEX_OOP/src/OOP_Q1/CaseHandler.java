package OOP_Q1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.NoSuchElementException;

public class CaseHandler {
    private InputHandler inputHandler;
    private Client c1; // Reference to a OOP_Q1.Client object
    private static boolean continueSearch = true;
    public CaseHandler(InputHandler inputHandler, Client client) {
        this.inputHandler = inputHandler;
        this.c1 = client;  // Initialize client reference

    }



    public void handlePriceCase(Client c1) {
        Set<Flight> allFlights = getAllFlights();
        int minavailable =  findMinimumFlightPrice();
        int maxavailable = findMaximumFlightPrice();
        if (c1.getBalance()<minavailable){
            System.out.println("You don't have enough money for flights");
        }
        System.out.println("The prices of the flights range from " + minavailable + " to - " + maxavailable);
        int[] minmax = new int[2];
        minmax = inputHandler.displayPricePrompt();
        SearchByPrice priceSearch = new SearchByPrice(minmax[0], minmax[1]);
        Set<Flight> filteredFlights = priceSearch.searchFlights(allFlights);
        displayFlights("Flights sorted by price from all airlines:", filteredFlights,1);
        askForNextAction(filteredFlights, c1);
    }


    public void handleAirlineCase(Client c1) {
        List<Airline> airlines = getAllAirlines(); // Assume this retrieves a list of all airlines
        // Check if airlines are available
        if (airlines.isEmpty()) {
            System.out.println("No airlines available.");
            return;
        }
        // Display available airlines
        System.out.println("Available Airlines:");
        for (Airline airline : airlines) {
            System.out.println(airline.getName());
        }
        // Get user input for airline name
        System.out.println("Please enter the name of the airline:");
        String airlineName = inputHandler.getStringInput();
        // Search for flights by airline
        SearchByAirline airlineSearch = new SearchByAirline(airlineName);
        Set<Flight> allFlights = getAllFlights(); // Assuming this retrieves all flights
        Set<Flight> filteredFlights = airlineSearch.searchFlights(allFlights);
        // Display results or error message
        if (filteredFlights.isEmpty()) {
            System.out.println("No flights found for " + airlineName);
        } else {
            displayFlights("Flights available for " + airlineName + ":", filteredFlights,2);
            askForNextAction(filteredFlights, c1);
        }
    }


    public void handleDurationCase(Client c1) {
    Set<Flight> allFlights = getAllFlights();
    // Request from the customer to enter the maximum duration of the flight
    System.out.println("Enter the maximum flight duration in minutes:");
    int maxDuration = inputHandler.getIntInput();
    // Create an instance of OOP_Q1.SearchByDuration with the maximum time duration
    SearchByDuration durationSearch = new SearchByDuration(maxDuration);
    // search for flights according to the maximum duration
    Set<Flight> flightsByDuration = durationSearch.searchFlights(allFlights);
    // Displaying the flights that match the criteria
    displayFlights("Flights within a maximum duration of " + maxDuration + " minutes:", flightsByDuration,3);
    askForNextAction(flightsByDuration, c1);
}

    public void handleDepartureTimeCase(Client c1) {
        System.out.println("Enter departure time (HHMM format):");
        int departureTime = inputHandler.getIntInput();
        SearchByDepartureTime departureSearch = new SearchByDepartureTime(departureTime);
        Set<Flight> flightsByDepartureTime = departureSearch.searchFlights(getAllFlights());
        displayFlights("Flights departing from " + departureTime + " to 2400:", flightsByDepartureTime,4);
        askForNextAction(flightsByDepartureTime, c1);
    }



    private void displayFlights(String message, Set<Flight> flights, int i) {
        System.out.println(message);
        if (i==1){
            for (Flight flight : flights) {
                System.out.println(flight + " - " + flight.getPrice());
            }
        }
        if (i==2){
            for (Flight flight : flights) {
                System.out.println(flight + " - " + flight.getAirlinename());
            }
        }
        if (i==3){
            for (Flight flight : flights) {
                System.out.println(flight + " - " + flight.getDuration() + "minutes");
            }
        }
        if (i==4){
            for (Flight flight : flights) {
                System.out.println(flight + " - " + flight.getDeparture());
            }
        }
    }

    private void askForNextAction(Set<Flight> flights, Client c1) {
        System.out.println("Enter '1' to continue searching, '2' to choose a flight, '3' to manage your flight tracking, '4' to exit:");
        int action = inputHandler.getIntInput();
        if (action == 1) {
            continueSearch = true;
        }
        else{
            continueSearch = false;
        }
        if (action ==2) {
            bookFlight(flights,c1);

        }
        else if (action==3){
            SubOption(flights,c1);
        }
        else if (action==4){
            System.out.println("Exiting application.");
            System.exit(0);
        }
    }

    private void SubOption(Set<Flight> flights, Client c1) {
        System.out.println("Enter '1' to Subscribe to flight updates without booking, \n '2' Unsubscribe from flight updates, \n '3' to see flights you booked");
        int action = inputHandler.getIntInput();
        if (action == 1) {
            c1.observeFlight((ObservableFlight) flights);
        }
        if (action ==2) {
            c1.cancelFlight((ObservableFlight) flights);
        }
        else if (action==3){
            c1.displayObservedFlights();
        }
//        else if (action==4) {
//            c1.observeFlight((OOP_Q1.ObservableFlight) flights);
//        }
//        else if (action==5){
//            System.out.println("Exiting application.");
//            System.exit(0);
//        }
    }


    public  static boolean shouldContinueSearch() {
        return continueSearch;
    }
    private void bookFlight(Set<Flight> flights, Client c1) {
        // print for the client all the available flight after searching.
        System.out.println("Available flights:");
        for (Flight flight : flights) {
            System.out.println(flight.getId());
        }
        // choose the wanted flight.
        System.out.println("Enter the ID of the flight you wish to book:");
        String flightId = inputHandler.getStringInput();
        // search the flightID between the set of the flights that the client received before.
        Flight selectedFlight = flights.stream()
                .filter(f -> f.getId().equals(flightId))
                .findFirst()
                .orElse(null);

        if (selectedFlight != null) {
            c1.bookFlight(selectedFlight);
            c1.displayObservedFlights();

        } else {
            System.out.println("OOP_Q1.Flight ID not found. Please try again.");
        }
    }
        // Mock implementations for methods to retrieve data
    private Set<Flight> getAllFlights() {
        return Main.getAllFlights();
    }
    private Set<Flight> getFlightsFilteredByDuration(int duration) {
        Set<Flight> filteredFlights = new HashSet<>();
        for (Flight flight : getAllFlights()) {
            if (flight.getDuration() == duration) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }

    private Set<Flight> getFlightsFilteredByDepartureTime(int departureTime) {
        Set<Flight> filteredFlights = new HashSet<>();
        for (Flight flight : getAllFlights()) {
            if (flight.getDeparture() == departureTime) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }

    private Airline findAirlineByName(String name, List<Airline> airlines) {
        for (Airline airline : airlines) {
            if (name.equals(airline.getName())){
                return airline;
            }
        }
        System.out.println("Invalid name of airline.");
        System.out.println("Please enter again the name of the airline that you want between the available airlines");

        return null;
    }



    private List<Airline> getAllAirlines() {
        // This method should fetch all airlines. Below is a placeholder implementation.
        // Return a list of all airlines you have in your system.
        return List.of(
                new Airline("ELAL"),
                new Airline("Globalia Corporación Empresarial"),
                new Airline("Air Europa"),
                new Airline("K.L.M"),
                new Airline("International Airlines Group"),
                new Airline("Aer Lingus"),
                new Airline("IBERIA EXPRES"),
                new Airline("SUNDOR"),
                new Airline("Delta Air Lines"),
                new Airline("Aeromexico"),
                new Airline("Virgin Atlantic")
        );
    }

    // Method to find the minimum available price among all flights
    public int findMinimumFlightPrice() {
        Set<Flight> allFlights = getAllFlights();

        // Using the Stream API to find the minimum price efficiently
        return allFlights.stream()
                .mapToInt(Flight::getPrice) // Transform OOP_Q1.Flight objects to their price values
                .min()                      // Find the minimum value
                .orElseThrow(NoSuchElementException::new); // Throw if there are no flights
    }
    // Method to find the maximum available price among all flights
    public int findMaximumFlightPrice() {
        Set<Flight> allFlights = getAllFlights();

        // Using the Stream API to find the maximum price efficiently
        return allFlights.stream()
                .mapToInt(Flight::getPrice) // Transform OOP_Q1.Flight objects to their price values
                .max()                      // Find the maximum value
                .orElseThrow(NoSuchElementException::new); // Throw if there are no flights
    }

//    public Set<OOP_Q1.Airline> getAirlines(String str){
//        Set<OOP_Q1.Airline> l = new HashSet<OOP_Q1.Airline>();
//
//
//
//        return l;
//    }
}
