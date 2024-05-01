package OOP_Q1;

import java.util.HashSet;
import java.util.Set;

public class Client implements Observable {
    private String name;

    private int balance; //how much he can pay


    private Set<Observable> bookedFlights; // Flights that the client has booked
    private Set<Observable> observedFlights; // Flights the client is observing for updates


    public Client(String name, int balance) {
        this.name = name;
        this.balance = balance;
        this.bookedFlights = new HashSet<>();
        this.observedFlights = new HashSet<>();
    }


    // Book a flight
//    public void bookFlight(OOP_Q1.ObservableFlight flight) {
//        bookedFlights.add(flight);
//        flight.addObserver(this); // Subscribe to updates from the flight
//        System.out.println(name + " booked a flight: " + flight.getId());
//    }

    public void bookFlight(Flight flight) {
        if (flight.hasSeatsAvailable()) {
            flight.addObserver(this);
            bookedFlights.add(flight); // תוספת הטיסה לרשימת הטיסות שהלקוח הזה הזמין
            observedFlights.add(flight);
            System.out.println("Booked flight " + flight.getId() + " and subscribed to updates.");
            System.out.println("You have successfully booked the flight: " + flight);
        } else {
            System.out.println("Failed to book flight " + flight.getId() + " - no seats available.");
        }
    }


    @Override
    public void update() {
        System.out.println("Notified of a flight update.");
    }


        // Cancel a flight booking
    public void cancelFlight(ObservableFlight flight) {
        if (bookedFlights.remove(flight)) {
            flight.removeObserver(this); // Unsubscribe from updates
            System.out.println(name + " canceled a flight: " + flight.getId());
        } else {
            System.out.println(name + " had not booked this flight: " + flight.getId());
        }
    }



    // Subscribe to flight updates without booking
    public void observeFlight(ObservableFlight flight) {
        observedFlights.add(flight);
        flight.addObserver(this);
        System.out.println(name + " is now observing flight: " + flight.getId());
    }

    // Unsubscribe from flight updates
    public void stopObservingFlight(ObservableFlight flight) {
        if (observedFlights.remove(flight)) {
            flight.removeObserver(this);
            System.out.println(name + " stopped observing flight: " + flight.getId());
        }
    }

    public int getBalance() {
        return balance;
    }


    // Method to display flights the client is observing for updates
    public void displayObservedFlights() {
        if (observedFlights.isEmpty()) {
            System.out.println(name + " is not observing any flights currently.");
        } else {
            System.out.println(name + " is observing the following flights for updates:");
            for (Observable flight : observedFlights) {
                System.out.println("flight id " + ((Flight)flight).getId() + " -price $" + ((Flight)flight).getPrice());
            }
        }
    }


        public void setBalance(int balance) {
        this.balance = balance;
    }
}
