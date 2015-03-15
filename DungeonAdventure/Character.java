public abstract class Character implements Stats
   {
   private int att;
   private int magicAtt;
   private int def;
   private int magicDef;
   private int spd;
   private int evasion;
   private int accuracy;
   private int maxHP;
   private int HP;
   private int maxSP;
   private int SP;
    
   private int tempAttBonus;
   private int tempMagicAttBonus;
   private int tempDefBonus;
   private int tempMagicDefBonus;
   private int tempSpdBonus;
   private int tempEvasionBonus;
   private int tempAccuracyBonus;
   
   private String name;
   
   
   // public abstract void chooseMove( Character defender );
   // public abstract ArrayList<String> getAttacks();
     // returns array of attackMove names - use for loop to choose in chooseAttack()
   
   /**
    * prints out a dodge message specific to each character
    * @param the name of the attack that is being dodged
    */
   public abstract void dodge( String attackName );
   /**a basic attack move
    * @param the enemy to be attacked
    */
   public abstract void attack( Character defender );
   
   /**
    * an "attack" move that reduces defense and makes the Character gain SP
    */
   public void rest()
      {
      setDefBonus( getDef() / -2 + getDefBonus() );
      setMagicDefBonus( getMagicDef() / -2 + getMagicDefBonus() );
      setEvasionBonus( getEvasion() / -2 + getEvasionBonus() );
      if( getSP() > getMaxSP() )
         {
         setSP( getMaxSP() );
         } // end if
      } // end method Rest
   /**
    * an "attack" move that increases defense
    */
   public void guard()
      {
      System.out.println( name + " Guarded and their defenses increased" );
      setDefBonus( getBaseDef() / 2 + getDefBonus() );
      setMagicDefBonus( getBaseMagicDef() / 2 + getMagicDefBonus() );
      setEvasionBonus( getEvasion() / 2 + getEvasionBonus() );
      } // end method Guard
   /**
    * gain a small amount of SP, meant to be used after every turn
    */
   public void gainSP()
      {
      setSP( getSP() + 3 );
      if( getSP() > getMaxSP() )
         {
         setSP( getMaxSP() );
         } // end if
      } // end method
   
   /**
    * resets the temporaryStatBonuses, like extra def from Guard()
    */
   public void resetTempStatBonuses()
      {
      tempAttBonus = 0;
      tempMagicAttBonus = 0;
      tempDefBonus = 0;
      tempMagicDefBonus = 0;
      tempSpdBonus = 0;
      tempEvasionBonus = 0;
      tempAccuracyBonus = 0;
      } // end method resetStatBonuses
   
   
   
   
   
   /**
    * Setters and getters for all Stats
    * includes stat bonus getters and setters
    * getters for stats add the stat bonus
    */
   
   public void setAttBonus( int att )
      {
      tempAttBonus = att;
      } // end method
   public void setMagicAttBonus( int magAtt )
      {
      tempMagicAttBonus = magAtt;
      } // end method
   public void setDefBonus( int def )
      {
      tempDefBonus = def;
      } // end method
   public void setMagicDefBonus( int magDef )
      {
      tempMagicDefBonus = magDef;
      } // end method
   public void setSpdBonus( int spd )
      {
      tempSpdBonus = spd;
      } // end method
   public void setEvasionBonus( int evasion )
      {
      tempEvasionBonus = evasion;
      } // end method
   public void setAccuracyBonus( int acc )
      {
      tempAccuracyBonus = acc;
      } // end method
   public int getAttBonus()
      {
      return tempAttBonus;
      } // end method
   public int getMagicAttBonus()
      {
      return tempMagicAttBonus;
      } // end method
   public int getDefBonus()
      {
      return tempDefBonus;
      } // end method
   public int getMagicDefBonus()
      {
      return tempMagicDefBonus;
      } // end method
   public int getSpdBonus()
      {
      return tempSpdBonus;
      } // end method
   public int getEvasionBonus()
      {
      return tempEvasionBonus;
      } // end method
   public int getAccuracyBonus()
      {
      return tempAccuracyBonus;
      } // end method
   
   
   public void setAtt( int att )
      {
      this.att = att;
      } // end method
   public void setMagicAtt( int magAtt )
      {
      this.magicAtt = magAtt;
      } // end method
   public void setDef( int def )
      {
      this.def = def;
      } // end method
   public void setMagicDef( int magDef )
      {
      this.magicDef = magDef;
      } // end method
   public void setSpd( int spd )
      {
      this.spd = spd;
      } // end method
   public void setEvasion( int evasion )
      {
      this.evasion = evasion;
      } // end method
   public void setAccuracy( int acc )
      {
      this.accuracy = acc;
      } // end method
   public void setMaxHP( int maxHP )
      {
      this.maxHP = maxHP;
      } // end method
   public void setHP( int HP )
      {
      this.HP = HP;
      } // end method
   public void setMaxSP( int maxSP )
      {
      this.maxSP = maxSP;
      } // end method
   public void setSP( int SP )
      {
      this.SP = SP;
      } // end method
   public void setName( String name )
      {
      this.name = name;
      } // end method
   
   
   public int getAtt()
      {
      return att + tempAttBonus;
      } // end method
   public int getMagicAtt()
      {
      return magicAtt + tempMagicAttBonus;
      } // end method
   public int getDef()
      {
      return def + tempDefBonus;
      } // end method
   public int getMagicDef()
      {
      return magicDef + tempMagicDefBonus;
      } // end method
   public int getSpd()
      {
      return spd + tempSpdBonus;
      } // end method
   public int getEvasion()
      {
      return evasion + tempEvasionBonus;
      } // end method
   public int getAccuracy()
      {
      return accuracy + tempAccuracyBonus;
      } // end method
   public int getMaxHP()
      {
      return maxHP;
      } // end method
   public int getHP()
      {
      return HP;
      } // end method
   public int getMaxSP()
      {
      return maxSP;
      } // end method
   public int getSP()
      {
      return SP;
      } // end method
   public String getName()
      {
      return name;
      } // end method
      
   
   public int getBaseAtt()
      {
      return att;
      } // end method
   public int getBaseMagicAtt()
      {
      return magicAtt;
      } // end method
   public int getBaseDef()
      {
      return def;
      } // end method
   public int getBaseMagicDef()
      {
      return magicDef;
      } // end method
   public int getBaseSpd()
      {
      return spd;
      } // end method
   public int getBaseEvasion()
      {
      return evasion;
      } // end method
   public int getBaseAccuracy()
      {
      return accuracy;
      } // end method
   
   public String toString()
      {
      return name + 
             "\natt: " + att +
             "\nmagAtt: " + magicAtt +
             "\ndef: " + def +
             "\nmagDef: " + magicDef +
             "\nspd: " + spd +
             "\neva: " + evasion +
             "\nacc: " + accuracy +
             "\nmaxHP: " + maxHP +
             "\nHP: " + HP +
             "\nmaxSP: " + maxSP +
             "\nSP: " + SP;
             
      /*return "Lvl " + lvl + " Hero: " + getName() + 
             "\nexp: " + exp + "\t\texpToNextLvl: " + expToLvl +
             "\nHP:  " + getHP() + " / " + getMaxHP() + eStat[7] +
             "\nSP:  " + getSP() + " / " + getMaxSP() + eStat[8] + "\n" +
             "\natt:    " + getAtt() + eStat[0] +
             "\nmagAtt: " + getMagicAtt() + eStat[1] +
             "\ndef:    " + getDef() + eStat[2] +
             "\nmagDef: " + getMagicDef() + eStat[3] +
             "\nspd:    " + getSpd() + eStat[4] +
             "\neva:    " + getEvasion() + eStat[5] +
             "\nacc:    " + getAccuracy() + eStat[6];
             */
      } // end method toString
   
   /**
    * @return the name of the image file for the Character
    */
   public abstract String getImage();
      
   } // end class Character