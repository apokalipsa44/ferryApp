package pl.exercise.ferry.pax;

public class Passenger {
    private String name;
    private  PaxType type;

    public Passenger(String name, PaxType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PaxType getType() {
        return type;
    }

    public void setType(PaxType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", age=" + type +
                '}';
    }
}
//do 3 lat: 0zł
//        od 3 do 18 lat: 5zł
//        od 18 do 70 lat: 10zł
//        powyżej 70 lat: 5zł