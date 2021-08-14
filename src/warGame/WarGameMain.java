package warGame;

import warGame.WarGame;
import java.util.Scanner;

/**
 *
 * @author Parteek
 *
 */

public class WarGameMain
{
   public static void main (String args[])
   {
      WarGame wg = WarGame.getInstance("WarGame"); // since only one instance of WarGame is needed

      Scanner k = new Scanner(System.in);
      wg.dealCards();
      int rounds;

      while (true) {
         System.out.println("Press Y to continue or N to exit");
         //System.out.println("Press Y to continue or N to exit");
         String choice = k.nextLine();

         if (choice.equalsIgnoreCase("y")) {
            wg.play();
         }
         else {
            wg.declareWinner();
            rounds = wg.getRounds();
            System.out.println("Number of rounds: " + rounds);
            break;
         }
      }
   }
}
