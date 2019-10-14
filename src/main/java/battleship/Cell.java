package battleship;



import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@Component
public class Cell {

    private String uncheckedCell = "-";
    private String hit = "X";
    private String miss = "O";
    private Integer x;
    private Integer y;
    private String status = "-";
    private List cellData = new ArrayList<Cell>();

    public Cell() {

    }

    //constructor for a single cell
    public Cell(Integer x, Integer y, String status){
        this.x = x;
        this.y = y;
        this.status = status;
    }

    public void addCell(Cell cell){
        cellData.add(cell);
    }

//    public Cell getCellData(){
//
//        return
//    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public String getStatus(Integer x, Integer y) {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }










}
