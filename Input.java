import java.io.*;
import java.util.*;

class Input{
    public static Input input; 
    Scanner scan;
    
    public static Input getInput(){
        if(input == null){
            input = new Input();
        }
        return input;
    }

    private Input(){
        scan = new Scanner(System.in);
    }

    int getScanInteger(){
        int var = scan.nextInt();
        if(scan.hasNextLine()==true){
            scan.nextLine();
        }
        return var;
    }

    String getScanString(){
        return scan.nextLine();
    }

    boolean getScanBoolean(){
        return scan.nextBoolean();
    }

}