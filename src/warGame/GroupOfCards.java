package warGame;

/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
import warGame.Card;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 *
 * @author
 *
 */
public class GroupOfCards
{
   //The group of cards, stored in an ArrayList
   private Card cards[];
   private int size;//the size of the grouping

   public GroupOfCards (int givenSize)
   {
      size = givenSize;
      cards = new Card[size];
   }

   public ArrayList<Card> addCards ()
   {
      ArrayList<Card> cardList = new ArrayList<>();
      for (Card sub : cards) {
         cardList.add(sub);
      }
      return cardList;
   }

   public void showCards (LinkedList<Card> deck)
   {
      for (Card sub : deck) {
         System.out.println(sub.toString());
      }
   }

   public int getSize ()
   {
      return size;
   }

   public void setSize (int givenSize)
   {
      size = givenSize;
   }

   public void generateCards ()
   {
      int countCards = 0;
      for (Card.Suit s : Card.Suit.values()) {
         for (Card.Value v : Card.Value.values()) {
            //Creating objects using constructor and 
            //assigning values of emun fields 
            //from list of possible discrete values
            cards[countCards] = new Card(s, v);
            countCards++;
         }
      }
   }
}
