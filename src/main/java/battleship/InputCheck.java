package battleship;

public class InputCheck {

    //gonna do this eventually
    String input = new String();

    public boolean isValid (String input) {
        this.input = input;
        boolean isValid = false;
        try{
        if (Integer.parseInt(input) >=0 && Integer.parseInt(input) <=7 ) {
            isValid = true;
        }
        } catch( Exception e){
            System.out.println("Invalid input '" + e.getMessage() + "'.");
        }
         return isValid;
    }


}
