package battleship;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Application{

    private final Scanner scanner;
    private final GameBoard gameBoard;
    private Cell cell;
    private ArrayList<Cell> cells = new ArrayList<>();


    public Application(Scanner scanner, GameBoard gameBoard) {
        this.scanner = scanner;
        this.gameBoard = gameBoard;
    }

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        var app = context.getBean(Application.class);
        app.run();
    }

    private void run() {
        var loop = true;
        while (loop) {
            System.out.println("> ");
            var input = scanner.nextLine();
            System.out.println(input);
            initializeCells(cells);
//            for (Cell cell:cells) {
//                System.out.print(cell.getCellData(cell.getStatus(x,y)));
//            }

            for (Cell cell : cells) {

                    for (Integer i = 0; i < 8; i++) {
                        for (Integer n = 0; n < 8; n++) {
                            if (i == cell.getX() && n == cell.getY()) {
                                String status = cell.getStatus(i, n);
                                System.out.println(status);
                            }
                        }
                    }
                }

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

//            for (Integer i = 0; i < 8; i++) {
//                for (Integer n = 0; n < 8; n++) {
//                    String status = cell.getStatus(i,n);
//                    System.out.println(status);
//                }
//            }


//                GameBoard gameBoard = new GameBoard(cells);
//                gameBoard.setCells(cells);
//
//
//                gameBoard.printCurrentGameboard(cells);
            }

        }

        public ArrayList initializeCells (ArrayList < Cell > cells) {
            var cell = new Cell();
            for (Integer i = 0; i < 8; i++) {
                for (Integer n = 0; n < 8; n++) {
                    cell.setX(i);
                    cell.setY(n);
                    cell.setStatus("-");
                    cells.add(cell);
                }
            }
            return cells;
        }

}



