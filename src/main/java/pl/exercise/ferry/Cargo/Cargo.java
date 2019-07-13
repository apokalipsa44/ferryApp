package pl.exercise.ferry.Cargo;

public class Cargo {
    private CargoType cargoType;
    private String content;

    public Cargo(CargoType cargoType, String content) {
        this.cargoType = cargoType;
        this.content = content;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "cargoType=" + cargoType +
                ", content='" + content + '\'' +
                '}';
    }
}
