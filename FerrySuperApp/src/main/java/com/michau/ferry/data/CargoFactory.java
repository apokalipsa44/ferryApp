package com.michau.ferry.data;

public class CargoFactory {
    public Cargo createCargo(int type, String content){
        if (type ==1){
            return new Cargo(CargoType.BIG, content, 36.52);
        }if (type ==2){
            return new Cargo(CargoType.SMALL, content, 4.25);
        }if (type ==3){
            return new Cargo(CargoType.PALLETE, content, 124.00);
        }
        return null;
    }
}
