package pl.exercise.ferry.Cargo;

public class CargoFactory {
    public Cargo createCargo(int type, String content){
        if (type ==1){
            return new Cargo(CargoType.BIG, content);
        }if (type ==2){
            return new Cargo(CargoType.SMALL, content);
        }if (type ==3){
            return new Cargo(CargoType.PALLETE, content);
        }
        return null;
    }
}
