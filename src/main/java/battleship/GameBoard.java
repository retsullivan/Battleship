package battleship;

import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class GameBoard {

    private String uncheckedSpace = "-";
    private String hit = "X";
    private String miss = "O";
    private int x;
    private int y;
    private String status;
    private Cell cell;
    private List cells = new ArrayList();

    public GameBoard (ArrayList cells){
        this.cells = cells;
    }


    public void printBlankGameBoard(){
        System.out.println("y-axis  ________________________");
        System.out.println("   7   |  -  -  -  -  -  -  -  -");
        System.out.println("   6   |  -  -  -  -  -  -  -  -");
        System.out.println("   5   |  -  -  -  -  -  -  -  -");
        System.out.println("   4   |  -  -  -  -  -  -  -  -");
        System.out.println("   3   |  -  -  -  -  -  -  -  -");
        System.out.println("   2   |  -  -  -  -  -  -  -  -");
        System.out.println("   1   |  -  -  -  -  -  -  -  -");
        System.out.println("   0   |  -  -  -  -  -  -  -  -");
        System.out.println("        ________________________");
        System.out.println("          0  1  2  3  4  5  6  7  x-axis");
    }

    public void editGameBoard (Cell cell) {
        cells.add(new Cell(x, y, status));
    }

    public String getCellInfo(Integer x, Integer y){
        return (cell.getStatus(x,y));

    }



    public void setCells(List cells) {
        this.cells = cells;
    }

//    public  getCells(GameBoard gameboard){
//        return cells;
//    }

    public void printCurrentGameboard (ArrayList<Cell> cells) {

        System.out.println("y-axis  ________________________");

            for (int i = 0; i < 8; i++) { //row iterator
                //for (int n = 0; i < 8; n++) { //column iterator
                System.out.println("   " + i + "   |  "
                        + cell.getStatus(i, 0) + "  "
                        + cell.getStatus(i, 1) + "  "
                        + cell.getStatus(i, 2) + "  "
                        + cell.getStatus(i, 3) + "  "
                        + cell.getStatus(i, 4) + "  "
                        + cell.getStatus(i, 5) + "  "
                        + cell.getStatus(i, 6) + "  "
                        + cell.getStatus(i, 7) + "  ");
            }
            System.out.println("        ________________________");
            System.out.println("          0  1  2  3  4  5  6  7  x-axis");
        }


    }




