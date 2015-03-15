import javax.swing.JOptionPane;
import java.util.ArrayList;

public abstract class Hero extends Character
   {
   private int lvl;
   private int exp;
   private int expToLvl;
   
   private Equipment equips[];
   private int eAtt;
   private int eMagicAtt;
   private int eDef;
   private int eMagicDef;
   private int eSpd;
   private int eEvasion;
   private int eAccuracy;
   private int eMaxHP;
   private int eMaxSP;
   
   private ArrayList<String> moves;
   private boolean hasAttacked;
   
   /** gain a certain amount of experience, and checks if the Hero has leveled up
    * @param amount of exp gained
    */
   public void gainExp( int expGained )
      {
      expGained -= lvl - 1;
      if( expGained < 0 )
         {
         expGained = 0;
         } // end if
      System.out.println( "You gained " + expGained + " exp" );
      exp = exp + expGained;
      while( exp >= expToLvl )
         {
         lvlUp();
         } // end if
      System.out.println( "You need " + (expToLvl - exp) + " more exp to lvl up" );
      } // end method gainExp
   
   /**levels up the hero, must be overridden to increase the stats of the Hero
    */
   public void lvlUp()
      {
      lvl++;
      exp = exp - expToLvl;
      expToLvl = 25*lvl;
      setHP( getMaxHP() );
      setSP( getMaxSP() );
      System.out.println( "\nYou leveled up! You are now level " + lvl );
      // add new moves to moves ArrayList
      } // end method lvlUp
   
   /**adds an attack move to the moves ArrayList of attack moves
    * @param name of the attack move
    */
   public void addAttackMove( String move )
      {
      moves.add( move );
      System.out.println( "You learned the move " + move );
      } // end method addAttackMove
   
   /** initializes the name, lvl, starting equipment, and basic moves
    * @param name of the hero
    */
   public Hero( String name )
      {
      setName( name );
      lvl = 1;
      expToLvl = 25;
      // set lvl 1 stats here
      // set starting equips
      equips = new Equipment[9];
      moves = new ArrayList<String>();
      moves.add( "Guard" );
      moves.add( "Rest" );
      moves.add( "Attack" );
      } // end constructor Hero
      
      
      
   /** ALL METHODS DEALING WITH BATTLES: */
   /** ALL ACTUAL ATTACKS WILL BE SPECIFIC TO EACH HERO */
   /** ARRAYLIST USE:
    *  list of attack moves
    *  that increases in length as the hero lvls up and gains more skills
    */
   /**makes the Hero do a basic attack to an enemy
    * only a temporary method until battle System works properly
    * @param enemy to attack
    */
   public void chooseMove( Monster enemy )
      {
      attack( enemy );
      hasAttacked = true;
      } // end method chooseMove()
   /**chooses the attack move to use against an enemy
    * should only be called when player presses buttons to choose the attack
    * @param the int representing which attack method to be called
    * @param the enemy to be attacked
    */
   public void chooseMove( int attack, Monster enemy )
      {
      resetTempStatBonuses();
      setHasAttacked( true );
      
      if( attack == 0 )
         {
         guard();
         } // end if
      if( attack == 1 )
         {
         rest();
         } // end if
      if( attack == 2 )
         {
         attack( enemy );
         } // end if
      if( attack == 3 )
         {
         powerAttack( enemy );
         } // end if
      if( attack == 4 )
         {
         aimedAttack( enemy );
         } // end if
      
      if( getHP() <= 0 )
         {
         Battle.endBattle( this, enemy, false );
         return;
         } // end if
      if( enemy.getHP() <= 0 )
         {
         Battle.endBattle( this, enemy, true );
         return;
         } // end if
      
      boolean hasAttacked = getHasAttacked();
      if( getHasAttacked() )
         {
         gainSP();
         enemy.resetTempStatBonuses();
         enemy.chooseMove( this );
         enemy.gainSP();
         setHasAttacked( false );
         } // end if
      
      if( getHP() <= 0 )
         {
         Battle.endBattle( this, enemy, false );
         return;
         } // end if
      if( enemy.getHP() <= 0 )
         {
         Battle.endBattle( this, enemy, true );
         return;
         } // end if
      } // end method chooseMove
   
   /**setter and getter for a boolean that is true if the Hero has already attacked the monster or not
    */
   public void setHasAttacked( boolean hasAttacked )
      {
      this.hasAttacked = hasAttacked;
      } // end method setHasAttacked
   public boolean getHasAttacked()
      {
      return hasAttacked;
      } // end method getHasAttacked
   
   public void dodge( String attackName)
      {
      System.out.println( "You dodged the enemy's " + attackName );
      // override method to print out dodge message
      BattleScreen.dodgeH();
      } // end method dodge()
   public void guard()
      {
      super.guard();
      BattleScreen.flashOnSelfH( "GuardShield.png" );
      } // end method guard
   
   /**attack moves for each Hero to have
    * @param the enemy to attack
    */
   public abstract void attack( Character defender );
   public abstract void powerAttack( Character defender );
   public abstract void aimedAttack( Character defender );
   
   public void rest()
      {
      System.out.println( "You rested and recovered " + lvl*2 + " SP" );
      setSP( getSP() + ( lvl * 2 ) );
      super.rest();
      BattleScreen.flashOnSelfH( "RestZs.png" );
      } // end method rest
   
   /**recover some HP after winning a battle
    */
   public void recover()
      {
      System.out.println( "After the battle you took a short breather and recovered " + 
                           getMaxHP() / 40 + " HP" );
      setHP( getHP() + ( getMaxHP() / 40 ) );
      if( getHP() > getMaxHP() )
         {
         setHP( getMaxHP() );
         } // end if
      } // end method recover
   
   /** END OF METHODS DEALING WITH BATTLES */
   
   
   
   
   /** ALL METHODS DEALING WITH EQUIPMENT: */
   /**calculates the stats given to the Hero by the equipment being worn
    */
   public void calculateStats()
      {
      eAtt = 0;
      eMagicAtt = 0;
      eDef = 0;
      eMagicDef = 0;
      eSpd = 0;
      eEvasion = 0;
      eAccuracy = 0;
      eMaxHP = 0;
      eMaxSP = 0;
      for( Equipment e : equips )
         {
         if( e != null )
            {
            eAtt += e.getAtt();
            eMagicAtt += e.getMagicAtt();
            eDef += e.getDef();
            eMagicDef += e.getMagicDef();
            eSpd += e.getSpd();
            eEvasion += e.getEvasion();
            eAccuracy += e.getAccuracy();
            eMaxHP += e.getMaxHP();
            eMaxSP += e.getMaxSP();
            } // end if
         } // end for
      if( getMaxHP() < getHP() )
         {
         setHP( getMaxHP() );
         } // end if
      if( getMaxSP() < getSP() )
         {
         setSP( getMaxSP() );
         } // end if
      // set stats with equipment
      }
   
   /**asks the player if he wants to equip the equipment found, if possible
    * puts the equipment in the appropriate equips[] slot
    * @param the Equipment found
    */
   public void equip( Equipment e )
      {
      // checkEquip( Equip currentE, Equip newE ) method -- asks if you want to wear it, 
      // if ring/dagger, asks which to replace
      // ring/dagger -- special method
      if( equipUsable( e ) )
         {
         int slotNum = e.getESlotNum();
         if( slotNum > 1 )
            {
            if( e instanceof Ring )
               {
               Ring ring1 = (Ring) equips[7];
               Ring ring2 = (Ring) equips[8];
               Ring newRing = (Ring) e;
               String space = "                                         ";
               String stats =   "Current Ring 1: " + ring1.getName() +
                              "\n" + space + ring1.getRingStat() +
                              "\nCurrent Ring 2: " + ring2.getName() +
                              "\n" + space + ring2.getRingStat() +
                              "\nNew Ring: " + newRing.getName() +
                              "\n" + space + newRing.getRingStat();
               String title = "Equip Ring in SLOT 1?";
               int answer = JOptionPane.showConfirmDialog( null, stats, title, 
                            JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE );
               if( answer == JOptionPane.YES_OPTION )
                  {
                  equips[7] = e;
                  } // end if
               else
                  {
                  title = "Equip Ring in SLOT 2?";
                  answer = JOptionPane.showConfirmDialog( null, stats, title, 
                               JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE );
                  if( answer == JOptionPane.YES_OPTION )
                     {
                     equips[8] = e;
                     } // end if
                  } // end else
               } // end if
            
            else if( checkEquip( equips[ slotNum ], e ) )
               {
               equips[ slotNum ] = e;
               } // end if
            } // end if
         
         calculateStats();
         } // end if
      
      System.out.println( "You found a " + e.getName() );
      if( equipUsable( e ) == false )
         {
         System.out.println( "But you don't know how to use this equipment :(\n" );
         } // end if
         
      } // end method equip()
   
   /**specific to each Hero checks if an equipment can be equipped by the Hero
    * @param the Equipment being checked
    * @return false if the Equipment can not be used, else true
    */
   public abstract boolean equipUsable( Equipment e );
   
   /**asks whether player wants to equip the Equipment
    * @param current Equipment
    * @param new Equipment
    * @return true if the player wants to equip the Equipment
    */
   public boolean checkEquip( Equipment currentE, Equipment newE )
      {
      String stats = compareEquips( currentE, newE );
      String title = "Do you want to equip this item?";
      /* YES_NO_OPTION optionType
       * YES_OPTION , NO_OPTION return values
       * showConfirmDialog(Component parentComponent, Object message, 
       *    String title, int optionType, int messageType) 
      /*     ERROR_MESSAGE
       *     INFORMATION_MESSAGE
       *     WARNING_MESSAGE
       *     QUESTION_MESSAGE
       *     PLAIN_MESSAGE */
      int answer = JOptionPane.showConfirmDialog( null, stats, title, 
                   JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE );
      if( answer == JOptionPane.YES_OPTION )
         {
         return true;
         } // end if
      return false;
      } // end method checkEquip()
   
   /**compares stats of current Equipment and new Equipment
    * @param current Equipment
    * @param new Equipment
    * @return String of stats comparison
    */
   private String compareEquips( Equipment cE, Equipment nE )
      { // currentEquip, newEquip
      // may be more efficient to make an array with all the stats, and getStatArray()
      // instead of all individual getStat() methods
      int[] statInt = new int[9];
      String[] statArray = new String[9];
      statInt[0] = nE.getAtt() - cE.getAtt();
      statInt[1] = nE.getMagicAtt() - cE.getMagicAtt();
      statInt[2] = nE.getDef() - cE.getDef();
      statInt[3] = nE.getMagicDef() - cE.getMagicDef();
      statInt[4] = nE.getSpd() - cE.getSpd();
      statInt[5] = nE.getEvasion() - cE.getEvasion();
      statInt[6] = nE.getAccuracy() - cE.getAccuracy();
      statInt[7] = nE.getMaxHP() - cE.getMaxHP();
      statInt[8] = nE.getMaxSP() - cE.getMaxSP();
      for( int index = 0; index < statInt.length; index++ )
         {
         if( statInt[index] > 0 )
            {
            statArray[index] = "+";
            } // end if
         else
            {
            statArray[index] = "";
            } // end else
         statArray[index] += statInt[index];
         } // end for
      String space1 = "                      ";
      String space2 = "                   ";
      String stats = "Current Item Name:   " + cE.getName() + 
      "\nNew Item Name:       " + nE.getName() + 
      "\n               Current Item:     New Item:     New Stats:" +
      "\natt:            " + cE.getAtt() + space1 + nE.getAtt() + space2 + statArray[0] +
      "\nmagAtt:     " + cE.getMagicAtt() + space1 + nE.getMagicAtt() + space2 + statArray[1] +
      "\ndef:           " + cE.getDef() + space1 + nE.getDef() + space2 + statArray[2] +
      "\nmagDef:    " + cE.getMagicDef() + space1 + nE.getMagicDef() + space2 + statArray[3] +
      "\nspd:          " + cE.getSpd() + space1 + nE.getSpd() + space2 + statArray[4] +
      "\neva:           " + cE.getEvasion() + space1 + nE.getEvasion() + space2 + statArray[5] + 
      "\nacc:           " + cE.getAccuracy() + space1 + nE.getAccuracy() + space2 + statArray[6] +
      "\nmaxHP:     " + cE.getMaxHP() + space1 + nE.getMaxHP() + space2 + statArray[7] +
      "\nmaxSP:      " + cE.getMaxSP() + space1 + nE.getMaxSP() + space2 + statArray[8];
      
      return stats;
      } // end method compareEquips
   
   /**intializes the starting Equipment
    * to only be called in constructors of each Hero
    */
   public void setStartingEquips()
      {
      equips[2] = new Helmet( 0 );
      equips[3] = new Shirt( 0 );
      equips[4] = new Pants( 0 );
      equips[5] = new Gloves( 0 );
      equips[6] = new Shoes( 0 );
      equips[7] = new Ring( 0 );
      equips[8] = new Ring( 0 );
      } // end method setStartingEquips
   
   /**setters and getters for first two Equipment slots
    * to be called by subclasses, as first two slots hold Equipment specific to each Hero
    */
   public void setEquip0( Equipment e )
      { // for specialized weapon equip
      equips[0] = e;
      } // end method setEquip0
   public Equipment getEquip0()
      {
      return equips[0];
      } // end method getEquip0
   public void setEquip1( Equipment e )
      { // for specialized off-hand equip
      equips[1] = e;
      } // end method setEquip1
   public Equipment getEquip1()
      {
      return equips[1];
      } // end method getEquip0
   
   /** END OF METHODS DEALING WITH EQUIPMENT */
   
   
   
   
   /** ETC. METHODS: */
   /**getters and setters for all stats and other instance variables
    * stats getters add Equipment stats
    */
   public int getAtt()
      {
      return eAtt + super.getAtt();
      } // end method
   public int getMagicAtt()
      {
      return eMagicAtt + super.getMagicAtt();
      } // end method
   public int getDef()
      {
      return eDef + super.getDef();
      } // end method
   public int getMagicDef()
      {
      return eMagicDef + super.getMagicDef();
      } // end method
   public int getSpd()
      {
      return eSpd + super.getSpd();
      } // end method
   public int getEvasion()
      {
      return eEvasion + super.getEvasion();
      } // end method
   public int getAccuracy()
      {
      return eAccuracy + super.getAccuracy();
      } // end method
   public int getMaxHP()
      {
      return eMaxHP + super.getMaxHP();
      } // end method
   public int getMaxSP()
      {
      return eMaxSP + super.getMaxSP();
      } // end method
      
   
   public int getEAtt()
      {
      return eAtt;
      } // end method
   public int getEMagicAtt()
      {
      return eMagicAtt;
      } // end method
   public int getEDef()
      {
      return eDef;
      } // end method
   public int getEMagicDef()
      {
      return eMagicDef;
      } // end method
   public int getESpd()
      {
      return eSpd;
      } // end method
   public int getEEvasion()
      {
      return eEvasion;
      } // end method
   public int getEAccuracy()
      {
      return eAccuracy;
      } // end method
   public int getEMaxHP()
      {
      return eMaxHP;
      } // end method
   public int getEMaxSP()
      {
      return eMaxSP;
      } // end method
   
   
   public int getLvl()
      {
      return lvl;
      } // end method
   public int getExp()
      {
      return exp;
      } // end method
   public int getExpToLvl()
      {
      return expToLvl - exp;
      } // end method
      
   public ArrayList<String> getMoves()
      {
      return moves;
      } // end method
   
   
   public String toString()
      {
      String[] eStat = new String[9];
      int[] equipStat = new int[9];
      equipStat[0] = getEAtt();
      equipStat[1] = getEMagicAtt();
      equipStat[2] = getEDef();
      equipStat[3] = getEMagicDef();
      equipStat[4] = getESpd();
      equipStat[5] = getEEvasion();
      equipStat[6] = getEAccuracy();
      equipStat[7] = getEMaxHP();
      equipStat[8] = getEMaxSP();
      for( int index = 0; index < equipStat.length; index++ )
         {
         if( equipStat[index] > 0 )
            {
            eStat[index] = " (+" + equipStat[index] + ")";
            } // end if
         else
            {
            eStat[index] = " (" + equipStat[index] + ")";
            } // end else
         } // end for
      return "Lvl " + lvl + " Hero: " + getName() + 
             "\nexp: " + exp + "\t\texpToNextLvl: " + getExpToLvl() +
             "\nHP:  " + getHP() + " / " + getMaxHP() + eStat[7] +
             "\nSP:  " + getSP() + " / " + getMaxSP() + eStat[8] + "\n" +
             "\natt:    " + getAtt() + eStat[0] +
             "\nmagAtt: " + getMagicAtt() + eStat[1] +
             "\ndef:    " + getDef() + eStat[2] +
             "\nmagDef: " + getMagicDef() + eStat[3] +
             "\nspd:    " + getSpd() + eStat[4] +
             "\neva:    " + getEvasion() + eStat[5] +
             "\nacc:    " + getAccuracy() + eStat[6];
      } // end method toString
      
   public abstract String getHeroType();
   
   } // end class Hero