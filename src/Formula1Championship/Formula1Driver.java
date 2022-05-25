package Formula1Championship;

public class Formula1Driver extends Driver {

    private int numberFirstPosition;
    private int numberSecondPosition;
    private int numberThirdPosition;
    private int numberRaces;
    private int numberPoints;

    public  Formula1Driver(){}

    public Formula1Driver(String F1driverName, String location, String F1driverTeam, int firstPosition, int secondPosition, int thirdPosition,
                          int numRaces, int numPoints) {
        super(F1driverName, location, F1driverTeam);
        this.numberFirstPosition = firstPosition;
        this.numberSecondPosition = secondPosition;
        this.numberThirdPosition = thirdPosition;
        this.numberRaces = numRaces;
        this.numberPoints = numPoints;
    }

    public int getNumberFirstPosition()
    {
        return numberFirstPosition;
    }

    public void setNumberFirstPosition(int firstPosition)
    {
        this.numberFirstPosition = firstPosition;
    }

    public int getNumberSecondPosition()
    {
        return numberSecondPosition;
    }

    public void setNumberSecondPosition(int secondPosition)
    {
        this.numberSecondPosition = secondPosition;
    }

    public int getNumberThirdPosition()
    {
        return numberThirdPosition;
    }

    public void setNumberThirdPosition(int thirdPosition)
    {
        this.numberThirdPosition = thirdPosition;
    }

    public int getNumberRaces()
    {
        return numberRaces;
    }

    public void setNumRaces(int numRaces)
    {
        this.numberRaces = numRaces;
    }

    public int getNumberPoints()
    {
        return numberPoints;
    }

    public void setNumberPoints(int numRaces)
    {
        this.numberPoints = numRaces;
    }


    @Override
    public int compareTo(Object o) {
        int oldPP=((Formula1Driver)o).getNumberPoints();
        /* For Ascending order*/
        //return this.noPoints-compareage;
        if (oldPP == this.numberPoints){
            int num1PP = ((Formula1Driver)o).getNumberFirstPosition();
            return num1PP - this.numberFirstPosition;
        }
        /* For Descending order do like this */
        return oldPP-this.numberPoints;
    }
}
