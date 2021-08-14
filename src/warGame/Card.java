package warGame;

/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 *
 * @author
 *
 */
public class Card
{
   //default modifier for child classes
   public enum Suit
   {
      HEARTS, DIAMONDS, SPADES, CLUBS
   };
   public enum Value
   {
      TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
   };
   String card = new String();

   private final Suit color;
   private final Value value;

   public Card (Suit s, Value gVal)
   {
      color = s;
      value = gVal;
   }

   public Value getValue ()
   {
      return this.value;
   }

   public Suit getSuit ()
   {
      return this.color;
   }

   public int getCardValue ()
   {
      int cardValue = 0;
      if (value == Value.TWO) {
         cardValue = 2;
      }
      else if (value == Value.THREE) {
         cardValue = 3;
      }
      else if (value == Value.FOUR) {
         cardValue = 4;
      }
      else if (value == Value.FIVE) {
         cardValue = 5;
      }
      else if (value == Value.SIX) {
         cardValue = 6;
      }
      else if (value == Value.SEVEN) {
         cardValue = 7;
      }
      else if (value == Value.EIGHT) {
         cardValue = 8;
      }
      else if (value == Value.NINE) {
         cardValue = 9;
      }
      else if (value == Value.TEN) {
         cardValue = 10;
      }
      else if (value == Value.JACK) {
         cardValue = 11;
      }
      else if (value == Value.QUEEN) {
         cardValue = 12;
      }
      else if (value == Value.KING) {
         cardValue = 13;
      }
      else if (value == Value.ACE) {
         cardValue = 14;
      }
      return cardValue;
   }

   /**
    * Students should implement this method for their specific children classes
    *
    * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
    */
   @Override
   public String toString ()
   {
      card = getSuit() + " " + getValue();
      return card;
   }
}
