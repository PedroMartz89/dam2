package model.pojos;

public class PuntosCasa {
    private House house;
    private int housePoints;

    public PuntosCasa(House house, int housePoints) {
        this.house = house;
        this.housePoints = housePoints;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public int getHousePoints() {
        return housePoints;
    }

    public void setHousePoints(int housePoints) {
        this.housePoints = housePoints;
    }
}
