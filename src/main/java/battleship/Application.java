package battleship;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collector;

@Component
public class Application{

    private final Scanner scanner;
    private Cell cell;
    private ArrayList<Cell> cells = new ArrayList<>();
    private BoardDisplay boardDisplay = new BoardDisplay();
    private ShipLocations shipLocations = new ShipLocations();
    private ArrayList<Coordinates> shipCoordinates = new ArrayList<>();
    private ArrayList<Ship> myShips;

    public Application(Scanner scanner, ShipLocations shipLocations) {
        this.scanner = scanner;
        this.shipLocations = shipLocations;
    }

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        var app = context.getBean(Application.class);
        app.run();
    }

    private void run() {

        System.out.println("Welcome to Battleship!");

        System.out.println("       _~  _~\n" +
                        "   __|=|_|=|__\n" +
                        "   \\ o.o.o.oY/\n" +
                        "    \\_______/\n" +
                        "  ~~~~~~~~~~~~~~");

        System.out.print("Press Enter to begin");
        scanner.nextLine();
        initializeCells(cells);
        boardDisplay.Display(cells);
        myShips = shipLocations.PlaceAllShips();
        myShips.stream().forEach(ship -> ship.getCoordinates().stream()
                .forEach(coordinates ->shipCoordinates.add(coordinates)));

        var loop = true;
        while (loop) {

            System.out.println("Enter your guess. Type the x coordinate");
            int xInput = scanner.nextInt();
            System.out.println();

            System.out.println("Enter your guess. Type the y coordinate");
            int yInput = scanner.nextInt();
            System.out.println();

            Coordinates coordinates = new Coordinates();
            coordinates.setX(xInput);
            coordinates.setY(yInput);

            for (Coordinates shipCoordinate:shipCoordinates) {
                if (shipCoordinate.isEqual(coordinates)) {
                    for (Cell cell : cells) {
                        if (cell.getCoordinates().isEqual(coordinates)) {
                            cell.setStatus(coordinates, "H");

                        }
                    }
                    System.out.println("You have hit a battleship!");
                } else {
                    for (Cell cell : cells) {
                        if (cell.getCoordinates().isEqual(coordinates)) {
                            cell.setStatus(coordinates, "M");

                        }
                    }
                    System.out.println("Miss. Try Again.");
                }
            }
            boardDisplay.Display(cells);
        }
    }


        public void initializeCells(ArrayList<Cell> cells){
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    Cell cell = new Cell();
                    Coordinates coordinates = new Coordinates();
                    coordinates.setX(x);
                    coordinates.setY(y);
                    cell.setCoordinates(coordinates);
                    cell.setStatus(coordinates,"-");
                    cells.add(cell);
                }
            }
    }

}






