package Formula1Championship;

import java.io.*;
import java.util.*;

public class Formula1ChampionshipManager implements ChampionshipManager
{
    ArrayList<Formula1Driver> F1DriStats  = new ArrayList<>();
    ArrayList<Races> raceList = new ArrayList<>();
    Scanner driScanner = new Scanner(System.in);

    int Points [] = {0, 25, 18, 15, 12, 10, 8, 6, 4, 2, 1};//points that driver's will get

    public Formula1ChampionshipManager(){}

    public Formula1ChampionshipManager(ArrayList<Formula1Driver> F1DriStats, ArrayList<Races> raceList) {
        this.F1DriStats = F1DriStats;
        this.raceList = raceList;
    }

        @Override
    public void addNewF1Driver()        //option to add new drivers
    {
        //boolean raceStuff = false;
        int num1s = 0, num2s = 0, num3s = 0;

        //Collecting driver details
        System.out.print("Enter new Formula 1 Driver's Name: ");
        String name = driScanner.nextLine();
        driScanner.nextLine();
        System.out.print("Enter new Formula 1 Driver's Location: ");
        String location = driScanner.nextLine();
        System.out.print("Enter new Formula 1 Driver's Team: ");
        String team = driScanner.nextLine();
        System.out.print("Enter number of races that participated by New Driver: ");
        int allRaces = driScanner.nextInt();

        Formula1Driver d1 = new Formula1Driver("", "" , "", 0, 0,0, 0, 0);
        d1.setF1driverName(name);
        d1.setLocation(location);
        d1.setF1driverTeam(team);
        d1.setNumRaces(allRaces);
        F1DriStats.add(d1);
    }

    @Override
    public void deleteF1Driver()       //deleting drivers
    {
        boolean driverDel = false;
        while (!(driverDel)){
            System.out.println("Enter the driver's team to delete : ");        //collecting the driver name that have to delete
            String team = driScanner.next();
            for (int i=0; i < F1DriStats.size(); i++) {
                Formula1Driver f1 = F1DriStats.get(i);
                if (team.equalsIgnoreCase(f1.getF1driverTeam())){
                    F1DriStats.remove(i);
                    driverDel = true;
                    System.out.println("Driver has deleted");
                }
            }
        }
    }

    @Override
    public void changeF1Driver()          //change the driver from a team and add new driver to that team
    {
        boolean F1driverCha = false;
        while (!(F1driverCha)){
            //collecting data to change the drivers
            System.out.println("Enter the Team to Change: ");        //get team name
            String team = driScanner.nextLine();
            driScanner.nextLine();
            System.out.println("Enter the New F1 Driver's Name: ");       //add new driver
            String newF1Driver = driScanner.nextLine();
            System.out.println("Enter the New F1 Driver's Location: ");
            String newLocation = driScanner.nextLine();

            for (int i=0; i < F1DriStats.size(); i++) {
                Formula1Driver f1 = F1DriStats.get(i);
                if (team.equalsIgnoreCase(f1.getF1driverTeam())){
                    f1.setF1driverName(newF1Driver);
                    f1.setLocation(newLocation);
                    F1DriStats.set(i,f1);
                    F1driverCha = true;
                }
            }
        }
    }

    @Override
    public void displayDriverStatistics() //display drivers details
    {
        boolean driverThere = false;
        while (!(driverThere)){
            System.out.println("Enter the Team you wont to display: ");   //collecting the data of driver that wont to display
            String team = driScanner.next();
            for (int i=0; i < F1DriStats.size(); i++) {
                Formula1Driver f1 = F1DriStats.get(i);
                if (team.equalsIgnoreCase(f1.getF1driverTeam())){
                    System.out.println("Driver Name: " + f1.getF1driverName() + '\n' + "Team: " + f1.getF1driverTeam() + '\n' + "Country: " + f1.getLocation() + '\n' +"Points: " + f1.getNumberPoints()
                            + '\n' + "Number of 1st Place Won: " + f1.getNumberFirstPosition() + '\n' + "Number of 2nd Place Won: " + f1.getNumberSecondPosition() + '\n' + "Number of 3rd Place Won:  "+ f1.getNumberThirdPosition()
                            + '\n' + "Number of Races Participate: " + f1.getNumberRaces());
                    driverThere = true;
                }
            }
        }
    }

    @Override
    public void displayTable() //display the table of driver details
    {
        Table details = new Table();
        details.setShowVerticalLines(true);
        details.setHeaders("Name", "Team", "Country", "Points", "1st Places", "2nd Places", "3rd Places", "Number of Races");//optional - if not used then there will be no header and horizontal lines
        Collections.sort(F1DriStats);
        for (int i=0; i < F1DriStats.size(); i++){
            Formula1Driver f1 = F1DriStats.get(i);
            details.addRow(String.valueOf(f1.getF1driverName()), String.valueOf(f1.getF1driverTeam()), String.valueOf(f1.getLocation()), String.valueOf(f1.getNumberPoints()), String.valueOf(f1.getNumberFirstPosition()), String.valueOf(f1.getNumberSecondPosition()), String.valueOf(f1.getNumberThirdPosition()), String.valueOf(f1.getNumberRaces()));
        }
        details.print();
    }

    @Override
    public void addRace()
    {
        ArrayList<Formula1Driver> RaceDriversData = new ArrayList<>();
        System.out.println("Race Date: ");
        String f1RaceDate = driScanner.next();
        System.out.println("Enter the number of Teams going to participate: ");
        int driverCount = driScanner.nextInt();   //enter the number of participated team
        boolean f1Dri = false;

        for (int i=1; i < driverCount+1; i++)
        {
            System.out.println("Enter the Team Name won" + i  + " Place: ");
            String F1teamPosition = driScanner.next();      //enter the positions that teams won(1st team should be a team that u used)
            Formula1Driver f1C = null;
            //updated Driver
            for (int j=0; j < F1DriStats.size(); j++){
                f1C = F1DriStats.get(j);
                if (F1teamPosition.equalsIgnoreCase(f1C.getF1driverTeam())){
                    f1Dri = true;
                    f1C.setNumRaces(f1C.getNumberRaces()+1);
                    if (i == 1){
                        f1C.setNumberFirstPosition(f1C.getNumberFirstPosition()+1);
                    } else if (i == 2){
                        f1C.setNumberSecondPosition(f1C.getNumberSecondPosition()+1);
                    } else if (i == 3){
                        f1C.setNumberThirdPosition(f1C.getNumberThirdPosition()+1);
                    }
                    f1C.setNumberPoints(f1C.getNumberPoints()+Points[i]);
                    RaceDriversData.add(f1C);
                }
            }
            if (!f1Dri){
                System.out.println("Incorrect Team, Please Try again!");
                i--;
            }
        }
        Races race = new Races();
        race.setDate(f1RaceDate);
        race.setRaceDetails(RaceDriversData);
        raceList.add(race);
    }

    @Override
    public void saveF1DriverDetails()        //this will save the all details to a txt file
    {
        try
        {
            FileWriter boothFile = new FileWriter("Formula1Championship.txt");  //creating .txt file

            for (int i=0; i < F1DriStats.size(); i++){
                Formula1Driver f1 = F1DriStats.get(i);
                boothFile.write("Driver Name: " + f1.getF1driverName() + ", Team: " + f1.getF1driverTeam() + ", Country: " + f1.getLocation() + ", Points: " + f1.getNumberPoints()
                        + ", Number of 1st Place: " + f1.getNumberFirstPosition() + ", Number of 2nd Place: " + f1.getNumberSecondPosition() + ", Number of 3rd Place: " + f1.getNumberThirdPosition()
                        + ", Number of Races: " + f1.getNumberRaces() + '\n');  //all driver details will be save on txt file
            }
            boothFile.close();
            System.out.println("Data File(Formula1Championship.txt) has been created.");   //when driver details saved on txt file this will display
        } catch (IOException Y)
        {
            Y.printStackTrace();
        }

    }

    @Override
    public void readF1DriverDetails()
    {
        Scanner f1C = null;
        try {
            f1C = new Scanner(new File("Formula1Championship.txt"));

        while (f1C.hasNext())
        {
            String line = f1C.nextLine();
            line = line.replace("Driver Name:","");
            line = line.replace("Team:","");
            line = line.replace("Country:","");
            line = line.replace("Points:","");
            line = line.replace("Number of 1st Place:","");
            line = line.replace("Number of 2nd Place:","");
            line = line.replace("Number of 3rd Place:","");
            line = line.replace("Number of Races:","");
            line = line.replace(" ","");
            ArrayList<String> sepWords = new ArrayList<String>(Arrays.asList(line.split(",")));
            Formula1Driver f1 = new Formula1Driver();
            for (int i=0 ; i<sepWords.size();  i++)
            {
                f1.setF1driverName(sepWords.get(0));
                f1.setF1driverTeam(sepWords.get(1));
                f1.setLocation(sepWords.get(2));
                f1.setNumberPoints(Integer.parseInt(sepWords.get(3)));
                f1.setNumberFirstPosition(Integer.parseInt(sepWords.get(4)));
                f1.setNumberSecondPosition(Integer.parseInt(sepWords.get(5)));
                f1.setNumberThirdPosition(Integer.parseInt(sepWords.get(6)));
                f1.setNumRaces(Integer.parseInt(sepWords.get(7)));
            }
            F1DriStats.add(f1);
        }

            f1C.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("Incorrect value File Not Found!");
        }
    }
    @Override
    public void displayGUI()     //display GUi
    {
        System.out.println("size1: "+ F1DriStats.size());
        GUI guiNew = new GUI(F1DriStats, raceList);
    }
}