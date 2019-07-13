package pl.exercise.ferry.screen;

import org.apache.commons.lang3.math.NumberUtils;
import pl.exercise.ferry.ticket.TicketImpl;

import java.util.Scanner;

public class MainScreen implements Screen {

  private final Scanner in = new Scanner(System.in);
  private final NumberUtils nu=new NumberUtils();
  public void interact() {
    System.out.println("Witamy w systemie twój rejs, wybierz akcję:");
    System.out.println("1. Utworzenie nowego rejsu");
    System.out.println("2. Odczyt zapisanych danych rejsu");
    System.out.println("3. Wyszukanie uczestnika rejsu");
    int firstResponse = in.nextInt();

    switch (firstResponse){
      case 1:{
        TicketImpl ticket=new TicketImpl();

      }
    }
  }


}
