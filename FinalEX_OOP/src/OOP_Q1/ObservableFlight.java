package OOP_Q1;

import java.util.HashSet;
import java.util.Set;

public class ObservableFlight extends Flight {
    private final Set<Observable> observers = new HashSet<Observable>();

    public ObservableFlight(String f1, int i, boolean b, int i1, int i2, Airline air) {
        super(f1, i, b, i1, i2, air);
    }

    public void addObserver(Observable o){
        observers.add(o);
    }

    public void removeObserver(Observable o){
        observers.remove(o);
    }

    public void notifyObservers(){
        for(Observable o : observers){
            o.update();
        }
    }

    public void setPrice(int price, boolean isDiscounted){
        super.setPrice(price);
        if (isDiscounted){
            notifyObservers();
        }
    }

    public void setSeatsAvailable(boolean seatsAvailable){
        super.setSeatsAvailable(seatsAvailable);
        notifyObservers();
    }

    public void setDepartureTime(int departureTime){
        super.setDepartureTime(departureTime);
        notifyObservers();
    }

    public void setDuration(int duration){
        super.setDuration(duration);
        notifyObservers();
    }

}
