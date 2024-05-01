package OOP_Q1;

import java.util.Set;
import java.util.HashSet;


public class Flight implements Observable {
    private String id;

    private int departureTime;

    private boolean seatsAvailable;

    private int duration;

    private int price;

    private Airline airline;

    private Set<Observable> observers = new HashSet<>();


    public Flight(String f1, int i, boolean b, int i1, int i2, Airline air) {
        id = f1;
        departureTime = i;
        seatsAvailable = b;
        duration = i1;
        price = i2;
        airline = air;
        air.addFlight(this);
    }
    // Methods to manage observers
    public void addObserver(Observable observer) {
        observers.add(observer);
    }
    public void removeObserver(Observable observer) {
        observers.remove(observer);
    }
    public void notifyObservers(){
        for (Observable observer : observers) {
            observer.update();
        }
    }



    public int getDeparture() {
        return departureTime;
    }
    public int getDuration() {
        return duration;
    }
    public int getPrice() {
        return price;
    }
    public boolean hasSeatsAvailable() {
        return seatsAvailable;
    }
    public String getId() {
        return id;
    }

    public void setPrice(int price){
        this.price = price;
        notifyObservers();
    }

    public void setSeatsAvailable(boolean seatsAvailable){
        this.seatsAvailable = seatsAvailable;
        notifyObservers();
    }

    public void setDepartureTime(int departureTime){
        this.departureTime = departureTime;
        notifyObservers();

    }

    public void setDuration(int duration){
        this.duration = duration;
        notifyObservers();

    }

    public String toString() {
        return  this.id ;
    }

    public Airline getAirline() {
        return airline;
    }
    public String getAirlinename() {
        return airline.getName();
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    @Override
    public void update() {

    }
}
