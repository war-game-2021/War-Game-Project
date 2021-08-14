package warGame;

/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 *
 * @author
 *
 */
public class Player
{

   private String playerID; //the unique ID for this player

   //A constructor that allows you to set the player's unique ID
   public Player (String name)
   {
      playerID = name;
   }

   //return the playerID
   public String getPlayerID ()
   {
      return playerID;
   }

   //Ensure that the playerID is unique
   public void setPlayerID (String givenID)
   {
      playerID = givenID;
   }

   public void play ()
   {
      //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

}
