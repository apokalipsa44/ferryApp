package pl.exercise.ferry.pax;

public class PassengerFactory {
    public Passenger createPassenger(String namme, int age) {
        if (age <= 3) {
            return new Passenger(namme, PaxType.CHILD);
        }
        if (age > 3 && age <= 18) {
            return new Passenger(namme, PaxType.YOUNG);
        }
        if (age > 18 && age <= 70) {
            return new Passenger(namme, PaxType.ADULT);
        }
        if (age >= 70) {
            return new Passenger(namme, PaxType.SENIOR);
        }


        return null;
    }
}
//do 3 lat: 0zł child
//        od 3 do 18 lat: 5zł young
//        od 18 do 70 lat: 10zł adult
//        powyżej 70 lat: 5zł senior