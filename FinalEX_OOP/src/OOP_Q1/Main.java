package OOP_Q1;

import OOP_Q1.Airline;
import OOP_Q1.AppController;
import OOP_Q1.Flight;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static Set<Flight> flights = new HashSet<>();
    public static Set<Airline> airlines = new HashSet<>();

    public static void main(String[] args) {
        // Initialize airlines
        Airline ALL = new Airline("ALL");
        Airline ELAL = new Airline("ELAL");
        Airline Globalia_Corporación_Empresarial = new Airline("Globalia Corporación Empresarial");
        Airline Air_Europa = new Airline("Air Europa");
        Airline K_L_M = new Airline("K.L.M");
        Airline International_Airlines_Group = new Airline("International Airlines Group");
        Airline Aer_Lingus = new Airline("Aer Lingus");
        Airline IBERIA_EXPRES = new Airline("IBERIA EXPRES");
        Airline SUNDOR = new Airline("SUNDOR");
        Airline Delta_Air_Lines = new Airline("Delta Air Lines");
        Airline Aeromexico = new Airline("Aeromexico");
        Airline Virgin_Atlantic = new Airline("Virgin Atlantic");
        // Assign flights to airlines
        ALL.addSubAirline(ELAL);
        ALL.addSubAirline(Globalia_Corporación_Empresarial);
        ALL.addSubAirline(Air_Europa);
        ALL.addSubAirline(K_L_M);
        ALL.addSubAirline(International_Airlines_Group);
        ALL.addSubAirline(Aer_Lingus);
        ALL.addSubAirline(IBERIA_EXPRES);
        ALL.addSubAirline(SUNDOR);
        ALL.addSubAirline(Delta_Air_Lines);
        ALL.addSubAirline(Aeromexico);
        ALL.addSubAirline(Virgin_Atlantic);
        ELAL.addSubAirline(SUNDOR);
        Delta_Air_Lines.addSubAirline(Aeromexico);
        Delta_Air_Lines.addSubAirline(Virgin_Atlantic);
        Globalia_Corporación_Empresarial.addSubAirline(Air_Europa);
        International_Airlines_Group.addSubAirline(IBERIA_EXPRES);
        International_Airlines_Group.addSubAirline(Aer_Lingus);


        // Create flights
        Flight flight1 = new Flight("F1", 1000, true, 120, 100, Virgin_Atlantic);
        Flight flight2 = new Flight("F2", 1200, true, 120, 200, ELAL);
        Flight flight3 = new Flight("F3", 1400, false, 120, 300,Air_Europa);
        Flight flight4 = new Flight("F4", 1600, true, 120, 400,Air_Europa);
        Flight flight5 = new Flight("F5", 1800, false, 120, 500, K_L_M);
        Flight flight6 = new Flight("F6", 2000, true, 90, 600, Aer_Lingus);
        Flight flight7 = new Flight("F7", 2200, false, 75, 700,IBERIA_EXPRES);
        Flight flight8 = new Flight("F8", 2400, true, 150, 800,SUNDOR);
        Flight flight9 = new Flight("F9", 1000, true, 110, 900,K_L_M);
        Flight flight10 = new Flight("F10", 2000, false, 130, 1000, Aeromexico);

        // Parent Company
        ELAL.addFlight(flight1);
        ELAL.addFlight(flight2);
        ELAL.addFlight(flight6);
        // Parent Company
        Globalia_Corporación_Empresarial.addFlight(flight7);
        // Parent Company
        International_Airlines_Group.addFlight(flight10);

        Air_Europa.addFlight(flight3);
        Air_Europa.addFlight(flight4);
        Air_Europa.addFlight(flight8);
        // Parent Company
        K_L_M.addFlight(flight5);
        K_L_M.addFlight(flight9);
        // Parent Company
        Delta_Air_Lines.addFlight(flight9);

        Aer_Lingus.addFlight(flight6);
        IBERIA_EXPRES.addFlight(flight7);
        SUNDOR.addFlight(flight8);
        Aeromexico.addFlight(flight10);
        Virgin_Atlantic.addFlight(flight1);

        airlines.add(ALL);
        airlines.add(ELAL);
        airlines.add(Globalia_Corporación_Empresarial);
        airlines.add(Air_Europa);
        airlines.add(K_L_M);
        airlines.add(International_Airlines_Group);
        airlines.add(Aer_Lingus);
        airlines.add(IBERIA_EXPRES);
        airlines.add(SUNDOR);
        airlines.add(Delta_Air_Lines);
        airlines.add(Aeromexico);
        airlines.add(Virgin_Atlantic);
        //
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        flights.add(flight5);
        flights.add(flight6);
        flights.add(flight7);
        flights.add(flight8);
        flights.add(flight9);
        flights.add(flight10);

        // Create and start the app controller
        AppController appController = new AppController();
        appController.start();

            }

    public static Set<Flight> getAllFlights() {
        return Collections.unmodifiableSet(flights);
    }

}



