package battleship;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class ShipLocations {

    HashMap<Ship, String> shipStatus= new HashMap<>();

//    public void initializeShipStatus(){
//        ArrayList<Ship> shipLocations = new ArrayList<>();
//        shipLocations.PlaceAllShips();
//        for(Ship ship: shipLocations){
//
//        }
//
//
//    }




    public ArrayList<Ship> PlaceAllShips(){

        Ship ship2 = new Ship();
        Ship ship3 = new Ship();
        Ship ship4 = new Ship();
        Ship ship5 = new Ship();
        Coordinates coordinates = new Coordinates();
        ArrayList<Ship> shipLocations = new ArrayList<>();
        HashMap<Ship, String> shipStatus= new HashMap<>();


//      this will need to be randomized - lots of stuff needed here
//        ship2.PlaceShip();
//        ship3.PlaceShip();
//        ship4.PlaceShip();
//        ship5.placeShip();
//
        //hard coding for now
        ship5.setCoordinates(7,7);
        ship5.setCoordinates(7,6);
        ship5.setCoordinates(7,5);
        ship5.setCoordinates(7,4);
        ship5.setCoordinates(7,3);

        ship4.setCoordinates(0,0);
        ship4.setCoordinates(0,1);
        ship4.setCoordinates(0,2);
        ship4.setCoordinates(0,3);

        ship3.setCoordinates(4,5);
        ship3.setCoordinates(4,4);
        ship3.setCoordinates(4,3);

        ship2.setCoordinates(2,2);
        ship2.setCoordinates(2,1);

        shipLocations.add(ship2);
        shipLocations.add(ship3);
        shipLocations.add(ship4);
        shipLocations.add(ship5);

        return shipLocations;
    }

//    private void Ship PlaceShip(){
//
//    }




    }




