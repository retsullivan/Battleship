package battleship;



import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class Cell {

    private String uncheckedCell = "-";
    private String hit = "X";
    private String miss = "O";
    private String status = "-";

    private Coordinates coordinates = new Coordinates();

    private Map<Coordinates, String> cellData = new HashMap<>();


    public Cell() {
    }

    //constructor for a single cell
    public Cell(Coordinates coordinates, String status){
        this.coordinates = coordinates;
        this.status = status;
    }


    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
//    public String getStatus(Coordinates coordinates) {
//
//        return cellData.get(coordinates);
//    }
    public String getStatus(Coordinates coordinates) {
        return status;

    }

    public void setStatus(Coordinates coordinates, String status) {
        this.status = status;
        cellData.put(coordinates, status);
    }

}
