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
    private InputCheck inputCheck = new InputCheck();

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
        ArrayList<Ship> myShips = shipLocations.PlaceAllShips();
        myShips.stream().forEach(ship -> ship.getCoordinates().stream()
                .forEach(coordinates ->shipCoordinates.add(coordinates)));


        var loop = true;
        while (loop) {

            boolean validColumnInput = false;
            boolean validRowInput = false;
            Integer columnInput = null;
            Integer rowInput = null;

            while (validColumnInput == false) {
                System.out.println("Enter your guess. Type the x coordinate:");
                String input = scanner.next();
                if (inputCheck.isValid(input)) {
                    columnInput = Integer.parseInt(input);
                    validColumnInput = true;
                    System.out.println();
                }
                else {
                    System.out.println("Type the x coordinate:");
                    System.out.println();
                }
            }

            while (validRowInput == false) {
                System.out.println("Enter your guess. Type the y coordinate:");
                String input = scanner.next();
                if (inputCheck.isValid(input)) {
                    rowInput = Integer.parseInt(input);
                    validRowInput = true;
                    System.out.println();
                }
                else {
                    System.out.println("Type the y coordinate:");
                    System.out.println();
                }

            }

            Coordinates inputCoordinates = new Coordinates();
            inputCoordinates.setX(rowInput);
            inputCoordinates.setY(columnInput);
            System.out.println("You have guessed <"+inputCoordinates.getX() + "," + inputCoordinates.getY() + ">.");


             if (shipCoordinates.stream().anyMatch(coordinates -> coordinates.isEqual(inputCoordinates))){
                   for (Cell cell : cells) {
                        if (cell.getCoordinates().isEqual(inputCoordinates)) {
                            //cell.setStatus(coordinates, "H");
                            if(cell.getStatus(inputCoordinates).equals("-")) {
                                cell.setStatus(cell.getCoordinates(), "*");
                                System.out.println("You have hit a battleship!");
                            }else{
                                System.out.println("You have already guessed this space.");
                            }
//                            System.out.println(cell.getStatus(inputCoordinates));
                        }
                    }

            } else {
            for (Cell cell : cells) {
                    if (cell.getCoordinates().isEqual(inputCoordinates)) {
                        //cell.setStatus(coordinates, "M");
                        if(cell.getStatus(inputCoordinates).equals("-")) {
                            cell.setStatus(cell.getCoordinates(), "M");
                            System.out.println("Miss. Try Again.");
                        // System.out.println(cell.getStatus(inputCoordinates));
                        } else{
                            System.out.println("You have already guessed this space.");
                        }
                    }
                }
             }





            boardDisplay.Display(cells);
             WinCondition winCondition = new WinCondition();
             if(winCondition.fleetSunk(shipCoordinates, cells)) {
                 System.out.println("Congratulations! You sunk all the Battleships!");
                 loop = false;
             }
            }

        }


        public void initializeCells(ArrayList<Cell> cells){
            for (int x = 0; x <8 ; x++) {
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






