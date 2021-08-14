package warGame;

import warGame.Player;
import warGame.GroupOfCards;
import warGame.Game;
import warGame.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
/**
 *
 * @author
 *
 */
public class WarGame extends Game
{

   /**
    *
    * @param givenName
    */
   //implementing Singleton pattern since only one instance of WarGame is needed
   private static WarGame onlyObject = null;

   private WarGame (String givenName)
   {
      super(givenName);
   }

   public static WarGame getInstance (String givenName)
   {
      if (onlyObject == null) {
         onlyObject = new WarGame(givenName);
      }
      return onlyObject;
   }
   LinkedList<Card> deck1 = new LinkedList<>();
   LinkedList<Card> deck2 = new LinkedList<>();
   ArrayList<Player> players = getPlayers();
   String pname1 = players.get(0).getPlayerID();
   String pname2 = players.get(1).getPlayerID();

   public void dealCards ()
   {
      GroupOfCards three = new GroupOfCards(52);
      three.generateCards();
      ArrayList<Card> cards = three.addCards();
      Collections.shuffle(cards);

      deck1.addAll(cards.subList(0, 25));
      deck2.addAll(cards.subList(26, cards.size()));

   }

   int rounds = 0;

   public int getRounds ()
   {
      return rounds;
   }

   @Override
   public void play ()
   {
      // TODO - implement WarGame.play
      //throw new UnsupportedOperationException();
      Card p1Card = deck1.pop();  //each player place one card face up
      Card p2Card = deck2.pop();

      //display the face up card
      System.out.println(pname1 + " plays card is " + p1Card.toString());
      System.out.println(pname2 + " plays card is " + p2Card.toString());

      //rank comparison between two cards
      if (p1Card.getCardValue() > p2Card.getCardValue()) {//if player 1 win 
         deck1.addLast(p1Card);  //higher rank wins both cards and 
         deck1.addLast(p2Card);  //places them at the bottom of his deck.
         System.out.println(pname1 + " wins the round");
      }//end if

      else if (p2Card.getCardValue() > p1Card.getCardValue()) {//if player 2 win 
         deck2.addLast(p1Card);
         deck2.addLast(p2Card);
         System.out.println(pname2 + " wins the round");
      }//end else if

      else { //war happens when both cards' rank matched
         System.out.println("War");

         //creating war cards
         ArrayList<Card> war1 = new ArrayList<>();
         ArrayList<Card> war2 = new ArrayList<>();

         //checking do players have enough (4)cards to stay in game
         for (int x = 0; x < 3; x++) {
            //either one player runs out of card is game over
            if (deck1.size() == 0 || deck2.size() == 0) {
               break;
            }//end if

            System.out.println("War card for" + pname1 + " is xx\nWar card for" + pname2 + " is xx");

            war1.add(deck1.pop());  //place additional card for war
            war2.add(deck2.pop());
         }//end for

         //only compare result when both players have enough cards for war
         if (war1.size() == 3 && war2.size() == 3) {
            //display the war cards from each player
            System.out.println("War card for" + pname1 + " is " + war1.get(2).toString());
            System.out.println("War card for" + pname2 + " is " + war2.get(2).toString());

            //if player 1 wins the war round
            Card war1Card = war1.get(2);
            Card war2Card = war2.get(2);

            if (war1Card.getCardValue() > war2Card.getCardValue()) {
               deck1.addAll(war1); //player1 get all 10 cards
               deck1.addAll(war2);
               System.out.println(pname1 + " wins the war round");
            }//end if
            //otherwise player 2 wins the war round
            else {
               deck2.addAll(war1); //player2 get all 10 cards
               deck2.addAll(war2);
               System.out.println(pname2 + " wins the war round");
            }//end else                      
         }//end if 
      }//end war round else
      rounds++;
      System.out.println(pname1 + " has " + deck1.size() + "cards");
      System.out.println(pname2 + " has " + deck2.size() + "cards");
   }

   @Override
   public void declareWinner ()
   {
      System.out.println(pname1 + " has " + deck1.size() + "cards");
      System.out.println(pname2 + " has " + deck2.size() + "cards");
      if (deck1.size() > deck2.size()) {
         System.out.println(pname1 + " is the Winner of this game");
      }
      else if (deck2.size() > deck1.size()) {
         System.out.println(pname2 + " is the Winner of this game");
      }
      else {
         System.out.println("Game over");
      }
   }
}
