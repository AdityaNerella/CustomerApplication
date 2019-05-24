import java.io.*;
import java.util.*;

class Input{
    static Scanner scan =new Scanner(System.in);

    static int getScanInteger(){
        int var = scan.nextInt();
        if(scan.hasNextLine()==true){
            scan.nextLine();
        }
        return var;
    }

    static String getScanString(){
        return scan.nextLine();
    }

    static boolean getScanBoolean(){
        return scan.nextBoolean();
    }

}