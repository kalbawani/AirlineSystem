public class Passenger {
    private String name;
    private int seatNo;
    public AirClass airClass;

    public Passenger(String name, int seatNo, AirClass airClass) {
        this.name = name;
        this.seatNo = seatNo;
        this.airClass = airClass;
    }

    //getter
    private String getName() {
        return name;
    }

    //setter
    public void setName(String name) {
        name = name;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public AirClass getAirClass() {
        return airClass;
    }

    public void setAirClass(AirClass airClass) {
        this.airClass = airClass;
    }
}
