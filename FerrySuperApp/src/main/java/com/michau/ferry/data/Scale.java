package com.michau.ferry.data;

import java.util.Random;


public class Scale<T> {

    Random random=new Random();

//    public int getCurrentWeight(T object){
//        if(object.equals(Passenger.class)){
//            currentWeight=120;
//        }
//        if(object.equals(Vehicle.class)){
//
//        }
//
//        return currentWeight;
//    }

    public int getCurrentWeightPasserger(){
        return 120;
    }

    public int getCurrentWeightCar(){
        return random.nextInt(500)+1000;
    }

    public int getCurrentWeightBike(){
        return random.nextInt(50)+250;
    }

    public int getCurrentWeighrTruck(){
        return random.nextInt(2000)+6000;
    }

    public int getCurrentWeightBus(){
        return random.nextInt(4000)+5000;
    }

    public int getCurrentWeightSmallCargo(){
        return random.nextInt(30)+50;
    }

    public int getCurrentWeightBigCargo(){
        return random.nextInt(200)+50;
    }

    public int getCurrentWeightPalleteCargo(){
        return random.nextInt(100)+300;
    }
}
