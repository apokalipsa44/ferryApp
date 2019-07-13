package pl.exercise.ferry.screen;

import java.util.Scanner;

public class SavedTripsScreen implements Screen {
    private final Scanner in = new Scanner(System.in);
    public void interact(){
        System.out.println("Odczyt zapisanych danych rejsu > Wybierz dalszą akcję:");
        System.out.println("1. Wydrukuj ostatni rejs");
        System.out.println("2. Wyszukaj rejs");
        System.out.println("0. Powrót");

        int response = in.nextInt();

        switch (response){
            case 1:
                System.out.println("drukuje ostatni rejs");
            case 2:
                System.out.println("szukam rejsu");
            case 0:
                MainScreen mainScreen = new MainScreen();
                mainScreen.interact();
        }
    }
}
