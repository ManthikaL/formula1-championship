package Formula1Championship;

import java.util.ArrayList;

public class Races {

    private String raceDate;
    ArrayList<Formula1Driver> RaceInfo = new ArrayList<>();

    Races(){}

    public String getDate() {
        return raceDate;
    }

    public void setDate(String date) {
        this.raceDate = date;
    }

    public ArrayList<Formula1Driver> getRaceDetails() {
        return RaceInfo;
    }

    public void setRaceDetails(ArrayList<Formula1Driver> raceDetails) {
        RaceInfo = raceDetails;
    }
}
