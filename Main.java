import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        // Establish Database Connection using JDBC
        
        Customers customer = new Customers();

        int ssn;
        boolean isExit = true;          
        Scanner read = new Scanner(System.in);
        while(isExit){

            System.out.println("Please enter your choice: \n 1)CREATE USER\n 2)UPDATE USER\n 3)DELETE USER\n4)SHOW USER\n5)EXIT");
            int choice = read.nextInt();
            read.nextLine();

                switch (choice) {
                    // Create User
                    case 1: 
                        customer.insert();  
                        break;
                    // Update User
                    case 2:
                        System.out.println("Please enter the SSN to update record");
                        ssn = read.nextInt();
                        read.nextLine();
                        customer.update(ssn);
                        break;
                    case 3:
                        System.out.println("Please enter the SSN to delete record");
                        ssn = read.nextInt();
                        read.nextLine();
                        customer.delete(ssn);
                        break;
                    case 4: 
                        System.out.println("User Information: ");
                        customer.printAll();
                        break;
                    case 5:
                        isExit = !isExit;
                        break;
                    default: 
                        System.out.println("Please Enter Valid input");
                    break;      
                }
            }
            read.close();

    }
}