import javax.swing.*;

public final class Battle
   {
   private static BattleScreen screen;
   private static GUI gui;
   
   public static void startBattle( Hero h, Monster m, GUI guii, int floorLvl )
      {
      gui = guii;
      screen = new BattleScreen( h, m, gui );
      
      System.out.println( "\nA Wild " + m.getName() + " Appears!" );
      boolean heroTurn = getFirstAttacker( h, m );
      if( !heroTurn )
         {
         m.resetTempStatBonuses();
         m.chooseMove( h );
         m.gainSP();
         if( h.getHP() <= 0 )
            {
            endBattle( h, m, false );
            return;
            } // end if
         if( m.getHP() <= 0 )
            {
            endBattle( h, m, true );
            return;
            } // end if
         } // end if
      screen.refreshStatsPanel();
      } // end method startBattle
   
   public static void endBattle( Hero h, Monster m, boolean heroWin )
      {
      if( heroWin )
         {
         System.out.println( "You defeated the enemy " + m.getName() );
         h.recover();
         h.gainExp( m.getExp() );
         h.resetTempStatBonuses();
         } // end if
      else
         {
         System.out.println( "You just LOST to the enemy " + m.getName() );
         GUI.gameOver();
         } // end else
      screen.stop();
      screen.dispose();
      gui.battleFinished( heroWin );
      System.out.println();
      
      } // end method endBattle
   
   
   
   /**compares speed of Hero and Monster to decide who goes first
    * @param Hero
    * @param Monster the Hero is battling
    * @return true if the Hero goes first
    */
   private static boolean getFirstAttacker( Hero h, Monster m )
      { // true == heroTurn
      if( h.getSpd() >= m.getSpd() )
         {
         System.out.println( "You go first!" );
         return true;
         } // end if
      else
         {
         System.out.println( "The monster goes first!" );
         return false;
         } // end else
      } // end method getFirstAttacker
   
   /**A basic attack that can't miss
    * @param attack stat
    * @param character being attacked
    * @param name of the attack
    * @return damage dealt
    */
   public static int attack( int att, Character defender, String attackName )
      {
      int dmg = att + (int)(Math.random() * ( att / 5 ) ) - ( att / 10 )
                - ( defender.getDef() * 2/5 );
      if( dmg < 1 )
         {
         dmg = 1;
         } // end if
      
      if( defender instanceof Hero )
         {
         System.out.println( "The Monster's " + attackName + " did " + dmg
                           + " dmg to you" );
         } // end if
      else
         {
         System.out.println( "Your " + attackName + " did " + dmg 
                           + " dmg to the " + defender.getName() );
         } // end else
      
      defender.setHP( defender.getHP() - dmg );
      return dmg;
      } // end method attack
   
   /**A basic MAGIC attack that can't miss
    * @param magic attack stat
    * @param character being attacked
    * @param name of the attack
    * @return damage dealt
    */
   public static int magicAttack( int magAtt, Character defender, String attackName )
      {
      int dmg = magAtt + (int)(Math.random() * ( magAtt / 5 ) ) - ( magAtt / 10 )
                - ( defender.getMagicDef() * 3/5 );
      if( dmg < 1 )
         {
         dmg = 1;
         } // end if
      
      if( defender instanceof Hero )
         {
         System.out.println( "The Monster's " + attackName + " did " + dmg
                           + " magic dmg to you" );
         } // end if
      else
         {
         System.out.println( "Your " + attackName + " did " + dmg 
                           + " magic dmg to the " + defender.getName() );
         } // end else
      
      defender.setHP( defender.getHP() - dmg );
      return dmg;
      } // end method magicAttack
      
   /**A basic attack that has a chance of being dodged
    * @param attack stat
    * @param accuracy stat
    * @param character being attacked
    * @param name of the attack
    * @return damage dealt
    */
   public static int attack( int att, int acc, Character defender, String attackName )
      {
      int dmg = 0;
      int dodgeChance = (int) ( Math.random() * 10 );
      if( dodgeChance == 0 )
         {
         defender.dodge( attackName );
         }
      else
         {
         dodgeChance = (int) ( Math.random() * defender.getEvasion() * 4/3 );
         //dodgeChance = 10000;
         if( acc < dodgeChance )
            {
            defender.dodge( attackName );
            } // end if
         else
            {
            dmg = Battle.attack( att, defender, attackName );
            } // end else
         } // end else
      return dmg;
      } // end method attack
   
   /** different dodge message for magic attack? */
   /**A basic MAGIC attack that has a chance of being dodged
    * @param magic attack stat
    * @param accuracy stat
    * @param character being attacked
    * @param name of the attack
    * @return damage dealt
    */
   public static int magicAttack( int magAtt, int acc, Character defender, String attackName )
      {
      int dmg = 0;
      int dodgeChance = (int) ( Math.random() * 10 );
      if( dodgeChance == 0 )
         {
         defender.dodge( attackName );
         }
      else
         {
         dodgeChance = (int) ( Math.random() * defender.getEvasion() * 4/3 );
         //dodgeChance = 10000;
         if( acc < dodgeChance )
            {
            defender.dodge( attackName );
            } // end if
         else
            {
            dmg = Battle.magicAttack( magAtt, defender, attackName );
            } // end else
         } // end else
      return dmg;
      } // end method magicAttack
   
   
   
   
   } // end class Battle