package battleship;

import com.sun.jdi.IntegerType;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.Random;


@Component
public class ShipLocations {


    //Grid has 64 spaces
    //8 columns & 8 rows

    //start each ship pointing up at origin
    //randomly generate 2 numbers
    //number1 mod 6 is the horizontal shift
    //number2 mod 6 is the vertical shift
    //that number mod 4 is the orientation

    //length of ship + |shift| <=8

    public ArrayList<Ship> RandomlyPlaceShips() {
        ArrayList<Coordinates> shipLocations = new ArrayList<>();
        ArrayList<Ship> fleet = new ArrayList<>();

        Random hrand = new Random();
        Random vrand = new Random();
        Random orand = new Random();
        Random posneg = new Random();


        Integer shipSize = 5;

        while (shipSize >= 2) {

            boolean validPlacement = false;
            Ship ship = null;

            //System.out.println(fleet.size());
            //System.out.println("Ship size" + shipSize);

            while (!validPlacement) {
                ship = new Ship();
                int repeatedCoordinates = 0;
                Integer horizontalShift = hrand.nextInt(100000) % 7;
                Integer verticalShift = vrand.nextInt(100000) % 7;
                Integer orientation = orand.nextInt(100000) % 2;  //0 = vertical 1 = horizontal
                Integer direction = posneg.nextInt(100000) % 2;  //0 =neg 1 = pos

                if (orientation == 0) { //vertical orientation
                    if (direction == 1) {
                        if (shipSize + verticalShift <= 8)
                            for (int i = 0; i < shipSize; i++) {
                                ship.addIndividualCoordinates(horizontalShift, verticalShift + i);
                            }
                    } else {
                        if (verticalShift - shipSize >= 0)
                            for (int i = 0; i < shipSize; i++) {
                                ship.addIndividualCoordinates(horizontalShift, verticalShift - i);
                            }
                    }
                } else { //horizontal orientation
                    if (direction == 1) {
                        if (shipSize + horizontalShift <= 8)
                            for (int i = 0; i < shipSize; i++) {
                                ship.addIndividualCoordinates(horizontalShift + i, verticalShift);
                            }
                    } else {
                        if (horizontalShift - shipSize >= 0)
                            for (int i = 0; i < shipSize; i++) {
                                ship.addIndividualCoordinates(horizontalShift - i, verticalShift);
                            }
                    }
                }

                //I think this is the last part that needs to be fixed
                //may need to iterate a different way

                //ship.getCoordinates().stream().findAny (shipLocations.stream()).;

                if (ship.shipLength() != 0) {
                    for (Coordinates coordinates : ship.getCoordinates()) {
                        for (Coordinates c : shipLocations) {
                            if (coordinates.isEqual(c)) {
                                repeatedCoordinates++;
                            }
                        }
                    }
                    if (repeatedCoordinates == 0) {
                        validPlacement = true;
                        //System.out.println("Ship Placed");
                    }
                }
            }

            //adding ship to our list of ships
            for (Coordinates coordinates : ship.getCoordinates()) {
                shipLocations.add(coordinates);
            }
            //iterating down to a smaller ship size
            shipSize--;
            //adding ship to fleet
            fleet.add(ship);
        }
        return fleet;  //in retrospect, should have done a list of coordinates, but whatever

    }

    public ArrayList<Ship> PlaceAllShips() { //hardcoded locations

        Ship ship2 = new Ship();
        Ship ship3 = new Ship();
        Ship ship4 = new Ship();
        Ship ship5 = new Ship();
        Coordinates coordinates = new Coordinates();
        ArrayList<Ship> shipLocations = new ArrayList<>();
        HashMap<Ship, String> shipStatus = new HashMap<>();

        ship5.addIndividualCoordinates(7, 7);
        ship5.addIndividualCoordinates(7, 6);
        ship5.addIndividualCoordinates(7, 5);
        ship5.addIndividualCoordinates(7, 4);
        ship5.addIndividualCoordinates(7, 3);

        ship4.addIndividualCoordinates(0, 0);
        ship4.addIndividualCoordinates(0, 1);
        ship4.addIndividualCoordinates(0, 2);
        ship4.addIndividualCoordinates(0, 3);

        ship3.addIndividualCoordinates(4, 5);
        ship3.addIndividualCoordinates(4, 4);
        ship3.addIndividualCoordinates(4, 3);

        ship2.addIndividualCoordinates(2, 2);
        ship2.addIndividualCoordinates(2, 1);

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




