package battleship;

import java.util.ArrayList;

public class BoardDisplay {

    private Cell cell;
    private ArrayList<Cell> cells = new ArrayList<>();

    public void Display (ArrayList<Cell> cells) {
        System.out.print("y-axis___________________________");
        for (int x = 0; x < 8; x++) { //row
            System.out.println();
            System.out.print("   " + x + "   |  ");
            for (int y = 0; y < 8; y++) { //column
                for (Cell cell : cells)
                    if (x == cell.getCoordinates().getX() && y == cell.getCoordinates().getY()) {
                        String status = cell.getStatus(cell.getCoordinates());
                        System.out.print(status + "  ");
                    }
                if (y == 8) {
                    System.out.println();
                }
            }

        }
        System.out.println();
        System.out.println("        ________________________");
        System.out.println("          0  1  2  3  4  5  6  7  x-axis");
    }
}
