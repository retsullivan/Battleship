package battleship;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
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

//        for (Coordinates coordinates:shipCoordinates) {
//            System.out.println(coordinates.getX() + "," +coordinates.getY());
//        }

        var loop = true;
        while (loop) {

            System.out.println("Enter your guess. Type the x coordinate");
            int xInput = scanner.nextInt();
            System.out.println();

            System.out.println("Enter your guess. Type the y coordinate");
            int yInput = scanner.nextInt();
            System.out.println();

            Coordinates inputCoordinates = new Coordinates();
            inputCoordinates.setX(xInput);
            inputCoordinates.setY(yInput);
            System.out.println("You have guessed <"+inputCoordinates.getX() + "," + inputCoordinates.getY() + ">.");

            //if (shipCoordinates.contains(coordinates)) - I think this is the problem
            //it's not checking correctly whether or not the coordinates are ship coordinates
            //I know that this is the problem
            if(shipCoordinates.stream().map(Coordinates::getX).equals(inputCoordinates.getX()) &&
               shipCoordinates.stream().map(Coordinates::getX).equals(inputCoordinates.getY())) {
                   for (Cell cell : cells) {
                        if (cell.getCoordinates().isEqual(inputCoordinates)) {
                            //cell.setStatus(coordinates, "H");
                            cell.setStatus(cell.getCoordinates(), "H");
                            System.out.println(cell.getStatus(inputCoordinates));
                        }
                    }
                System.out.println("You have hit a battleship!");
            } else {
            for (Cell cell : cells) {
                    if (cell.getCoordinates().isEqual(inputCoordinates)) {
                        //cell.setStatus(coordinates, "M");
                        cell.setStatus(cell.getCoordinates(), "M");
                        System.out.println(cell.getStatus(inputCoordinates));
                    }
                }
                System.out.println("Miss. Try Again.");
            }
            boardDisplay.Display(cells);
            }

        }


        public void initializeCells(ArrayList<Cell> cells){
            for (int x = 7; x >=0; x--) {
                for (int y = 0; y < 8; y++) {

                    Coordinates coordinates = new Coordinates();
                    coordinates.setX(x);
                    coordinates.setY(y);
                    Cell cell = new Cell(coordinates, "-");
//                    cell.setCoordinates(coordinates);
//                    cell.setStatus(coordinates,"-");
                    cells.add(cell);
                }
            }
    }

}






