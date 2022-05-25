package Formula1Championship;

abstract class Driver implements Comparable{
    private String F1driverName;
    private String location;
    private String F1driverTeam;

    public  Driver(){}

    public Driver(String name, String location, String team) {
        this.F1driverName = name;
        this.location = location;
        this.F1driverTeam = team;
    }

    public String getF1driverName() {
        return F1driverName;
    }

    public void setF1driverName(String name) {
        this.F1driverName = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getF1driverTeam() {
        return F1driverTeam;
    }

    public void setF1driverTeam(String team) {
        this.F1driverTeam = team;
    }

}
