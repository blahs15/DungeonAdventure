import javax.swing.JOptionPane;

public class Rogue extends Hero
   {
   
   /** initializes stats and Equipment
    */
   public Rogue( String name )
      {
      super( name );
      setAtt(10);
      setMagicAtt(5);
      setDef(10);
      setMagicDef(10);
      setSpd(20);
      setEvasion(20);
      setAccuracy(15);
      setMaxHP(50);
      setMaxSP(20);
      // lvl 1 stats
      // put in starting equips?
      setStartingEquips();
      calculateStats();
      setHP( getMaxHP() );
      setSP( getMaxSP() );
      } // end constructor Rogue
   
   public void lvlUp()
      {
      for( int index = 0; index < 20; index++ )
         {
         int randomizer = (int) ( Math.random() * 100 );
         if( randomizer < 15 )
            {
            setAtt( getAtt() - getEAtt() + 1 );
            } // end if
         else if( randomizer < 20 )
            {
            setMagicAtt( getMagicAtt() - getEMagicAtt() + 1 );
            } // end if
         else if( randomizer < 35 )
            {
            setDef( getDef() - getEDef() + 1 );
            } // end if
         else if( randomizer < 45 )
            {
            setMagicDef( getMagicDef() - getEMagicDef() + 1 );
            } // end if
         else if( randomizer < 65 )
            {
            setSpd( getSpd() - getESpd() + 1 );
            } // end if
         else if( randomizer < 85 )
            {
            setEvasion( getEvasion() - getEEvasion() + 1 );
            } // end if
         else
            {
            setAccuracy( getAccuracy() - getEAccuracy() + 1 );
            } // end if
         } // end for
      int HPrand = (int)(Math.random() * 2 * getLvl() ) + 1;
      int SPrand = (int)(Math.random() * 2 * getLvl() ) + 1;
      setMaxHP( getMaxHP() - getEMaxHP() + HPrand );
      setMaxSP( getMaxSP() - getEMaxSP() + SPrand );
      super.lvlUp();
      
      if( getLvl() == 2 )
         {
         addAttackMove( "Triple Stab" );
         } // end if
      else if( getLvl() == 5 )
         {
         addAttackMove( "Aimed Stab" );
         } // end if
      } // end method lvlUp
   
   public void setStartingEquips()
      {
      super.setStartingEquips();
      setEquip0( new Dagger( 2 ) );
      setEquip1( new Dagger( 2 ) );
      } // end method setStartingEquips
   
   public void equip( Equipment e )
      {
      if( e instanceof Dagger )
         {
         Equipment d1 = getEquip0();
         Equipment d2 = getEquip1();
         String spacing = "                   ";
         String stats = "Dagger 1 Name:   " + d1.getName() + 
         "\nDagger 2 Name:   " + d2.getName() + 
         "\nNew Dagger Name:       " + e.getName() + 
         "\n             Dagger 1:      Dagger 2:      New Dagger:" +
         "\natt:            " + d1.getAtt() + spacing + d2.getAtt() + spacing + e.getAtt() +
         "\nspd:          " + d1.getSpd() + spacing + d2.getSpd() + spacing + e.getSpd() +
         "\neva:           " + d1.getEvasion() + spacing + d2.getEvasion() + spacing + e.getEvasion() + 
         "\nacc:           " + d1.getAccuracy() + spacing + d2.getAccuracy() + spacing + e.getAccuracy() +
         "\nmaxHP:     " + d1.getMaxHP() + spacing + d2.getMaxHP() + spacing + e.getMaxHP() +
         "\nmaxSP:      " + d1.getMaxSP() + spacing + d2.getMaxSP() + spacing + e.getMaxSP();
         String slotNum = "\n  SLOT 1?   SLOT 1?   SLOT 1?   SLOT 1?   SLOT 1?";
         
         String title = "Equip Dagger in SLOT 1?";
         int answer = JOptionPane.showConfirmDialog( null, stats+slotNum, title, 
                      JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE );
         if( answer == JOptionPane.YES_OPTION )
            {
            setEquip0( e );
            } // end if
         else
            {
            title = "Equip Dagger in SLOT 2?";
            slotNum = "\n  SLOT 2?   SLOT 2?   SLOT 2?   SLOT 2?   SLOT 2?";
            answer = JOptionPane.showConfirmDialog( null, stats+slotNum, title, 
                         JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE );
            if( answer == JOptionPane.YES_OPTION )
               {
               setEquip1( e );
               } // end if
            } // end else
         } // end if
      super.equip( e );
      } // end method equip
   
   public boolean equipUsable( Equipment e )
      {
      if( e instanceof Staff || e instanceof Pendant || e instanceof Sword || e instanceof Shield )
         {
         return false;
         } // end if
      return true;
      } // end method equipUsable
   
   
   
   /** ATTACKS: */
   public void attack( Character defender )
      {
      int att = ( getAtt() + getSpd() ) / 2;
      Battle.attack( att, getAccuracy(), defender, "First Stab" );
      Battle.attack( att, getAccuracy(), defender, "Second Stab" );
      BattleScreen.moveHForward();
      BattleScreen.moveHForward();
      // basic attack -- attack twice
      } // end method attack
   
   public void powerAttack( Character defender )
      {
      if( getSP() >= 7 )
         {
         int att = ( getAtt() + getSpd() ) / 2;
         Battle.attack( att, getAccuracy(), defender, "First Stab" );
         Battle.attack( att, getAccuracy(), defender, "Second Stab" );
         Battle.attack( att, getAccuracy(), defender, "Third Stab" );
         BattleScreen.moveHForward();
         BattleScreen.moveHForward();
         BattleScreen.moveHForward();
         // attack 3 times
         setSP( getSP() - 7 );
         } // end if
      else
         {
         System.out.println( "You do not have enough SP for that attack" );
         // choose another attack
         } // end else
      } // end method powerStrike
      
   public void aimedAttack( Character defender )
      {
      if( getSP() >= 5 )
         {
         int att = ( getAtt() + getSpd() ) * 2 / 3;
         Battle.attack( att, defender, "Aimed Stab" );
         BattleScreen.moveHForward();
         // attack can not miss
         setSP( getSP() - 5 );
         } // end if
      else
         {
         System.out.println( "You do not have enough SP for that attack" );
         // choose another attack
         } // end else
      } // end method aimedSlash
   
   
   
   public String getImage()
      {
      return "Rogue.png";
      } // end method getImage
   public String getHeroType()
      {
      return "Rogue";
      } // end method getHeroType
   
   } // end class Rogue