package battleship;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Ship{

    private Cell cell = new Cell();
    private Coordinates coordinates = new Coordinates();
    private ArrayList<Coordinates> ship = new ArrayList<>();

    public Ship(){}

    public Ship(ArrayList<Coordinates> ship){
        this.ship = ship;
    }

    public ArrayList<Coordinates> getCoordinates() {
        ArrayList<Coordinates>shipCoordinates = new ArrayList<>();
        for(Coordinates coordinates:ship) {
            shipCoordinates.add(coordinates);
        }
        return shipCoordinates;
    }

    public void setCoordinates(int x, int y){
        Coordinates coordinates = new Coordinates();
        coordinates.setX(x);
        coordinates.setY(y);
        ship.add(coordinates);
    }

}

