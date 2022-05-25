package Formula1Championship;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {

        Scanner driScanner = new Scanner(System.in);
        Formula1ChampionshipManager f1CM = new Formula1ChampionshipManager();
        f1CM.readF1DriverDetails();

        //menu list
        System.out.println("A. Add a New Driver & Team");
        System.out.println("B. Delete Driver & Team");
        System.out.println("C. Change The Driver For an Existing Constructor Team");
        System.out.println("D. Statistics Of a Driver");
        System.out.println("E. Display The Formula1 Driver Table");
        System.out.println("F. Completed Races");
        System.out.println("G. Store Data");
        System.out.println("H. Read Data");
        System.out.println("I. Show GUI");
        System.out.println("J. Exit");
        System.out.println("******************************************************************");

        String option;
        do{
            //options to choose from the menu
            System.out.print( "Enter a letter to active the Option: ");
            option = driScanner.nextLine();
            if (option.equals("A") || option.equals("a")){
                f1CM.addNewF1Driver();
            }else if (option.equals("B") || option.equals("b")){
                f1CM.deleteF1Driver();
            }else if (option.equals("C") || option.equals("c")){
                f1CM.changeF1Driver();
            }else if (option.equals("D") || option.equals("d")){
                f1CM.displayDriverStatistics();
            }else if (option.equals("E") || option.equals("e")){
                f1CM.displayTable();
            }else if (option.equals("F") || option.equals("f")){
                f1CM.addRace(); //ask kstar savior
            }else if (option.equals("G") || option.equals("g")){
                f1CM.saveF1DriverDetails();
            }else if (option.equals("H") || option.equals("h")){
                f1CM.readF1DriverDetails();
            }else if (option.equals("I") || option.equals("i")){
                f1CM.displayGUI();
            }
        } while (!(option.equals("J") || option.equals("j")));
    }
}


