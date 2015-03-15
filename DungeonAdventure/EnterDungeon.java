import javax.swing.*;

public class EnterDungeon
   {
   public static void main( String[] args )
      {
      /**
       * choose hero class
       * name the hero
       * use FogOfWar?
       * input hero, fogOfWar into GUI
       */
      
      Hero hero;
      String[] options = { "Rogue", "Mage", "Fighter" };
      int heroChoice = JOptionPane.showOptionDialog( null, "Choose a Hero", "Dungeon Adventure", 
            JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION, 
            null, options, options[2] );
      String name = JOptionPane.showInputDialog( "What shall your name be?" );
      if( name.equals( "" ) )
         name = "blahs";
      
      if( heroChoice == JOptionPane.CANCEL_OPTION )
         {
         hero = new Fighter( name );
         } // end if
      else if( heroChoice == JOptionPane.NO_OPTION )
         {
         hero = new Mage( name );
         } // end if
      else
         {
         hero = new Rogue( name );
         } // end else
      
      int fogOfWarChoice = JOptionPane.showConfirmDialog( null, "Fog of War?", 
            "It can be dark out there...", JOptionPane.YES_NO_OPTION, 
            JOptionPane.PLAIN_MESSAGE );
      boolean fogOfWar = false;
      if( fogOfWarChoice == JOptionPane.YES_OPTION )
         {
         fogOfWar = true;
         } // end if
      
      //hero.gainExp( 5000 );
      new GUI( hero, fogOfWar );
      
      //new Music(
      //new GUI( "Dungeon Adventure", hero);
      } // end method main
   } // end class EnterDungeon