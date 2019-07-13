package pl.exercise.ferry.screen;

import java.util.Scanner;

public class SearchPassenger implements Screen {
    private final Scanner in = new Scanner(System.in);
    public void interact(){
        System.out.println("Wyszukanie uczestnika rejsu > Wybierz dalszą akcję:");
        System.out.println("1. Wyszukaj uczesnika");
        System.out.println("2. Wyszukaj pojazd");
        System.out.println("0. Powrót");

        int response = in.nextInt();

        switch (response){
            case 1:
                System.out.println("szukam uczestnika");
            case 2:
                System.out.println("szukam pojazd");
            case 0:
                MainScreen mainScreen = new MainScreen();
                mainScreen.interact();
        }
    }
}
