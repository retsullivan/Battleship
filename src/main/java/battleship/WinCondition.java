package battleship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinCondition {

    private ArrayList<Coordinates> shipCoordinates = new ArrayList<>();

    private ArrayList<Cell> cellData = new ArrayList<>();
//    public WinCondition (ArrayList<Coordinates> shipCoordinates, Map<Coordinates, String> cellData){
//        this.shipCoordinates = shipCoordinates;
//        this.cellData = cellData;
//    }


    //this method loop is adding all the statuses at each ship coordinate
    //if every "-" has been replaced, it means that every ship coordinate has been hit

    public Boolean fleetSunk (ArrayList<Coordinates> shipCoordinates, ArrayList<Cell> cellData) {
        ArrayList<String> cellStatus = new ArrayList<>();
        for (Coordinates coordinates : shipCoordinates) {
            for (Cell cell : cellData) {
                if(cell.getCoordinates().isEqual(coordinates)) {
                    cellStatus.add(cell.getStatus(coordinates));
                }
            }
        }
        if (!cellStatus.contains("-"))    {
            return true;
        } else {
            return false;
        }
    }
}
