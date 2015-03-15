public class Mimic extends Monster
   {
   private boolean goldMimic;
   
   public Mimic()
      {
      goldMimic = false;
      setName( "Mimic" );
      setMagicUser( false );
      setAtt( 80 );
      setMagicAtt( 80 );
      setDef( 140 );
      setMagicDef( 140 );
      setSpd( 80 );
      setEvasion( 65 );
      setAccuracy( 85 );
      setMaxHP( 150 );
      setMaxSP( 14 );
      
      setSpecAttackCost( 7 );
      setExp( 17 );
      
      int rand = (int) ( Math.random() * 20 );
      if( rand == 0 )
         {
         goldMimic = true;
         setName( "Gold " + getName() );
         setAtt( getAtt() + 10 );
         setMagicAtt( getMagicAtt() + 10 );
         setDef( getDef() + 10 );
         setMagicDef( getMagicDef() + 10 );
         setSpd( getSpd() + 10 );
         setEvasion( getEvasion() + 10 );
         setAccuracy( getAccuracy() + 10 );
         setMaxHP( getMaxHP() + 50 );
         setMaxSP( getMaxSP() + getSpecAttackCost() );
         setExp( getExp() * 3/2 );
         } // end if
      
      setHP( getMaxHP() );
      setSP( getMaxSP() );
      } // end constructor Dragon
      
   public void specAttack( Hero defender )
      {
      super.specAttack();
      int dmg = Battle.magicAttack( getMagicAtt(), getAccuracy(),
         defender, "Abyssal Swallow" );
      BattleScreen.flashImageOnH( "MimicSpec.png" );
      int rand = (int) (Math.random() * 5);
      if( rand == 0 && dmg != 0 )
         {
         System.out.println( "You fall into the black depths of the Mimic " +
                             "and can't find a way out" +
                           "\nYou get scared and can't attack" );
         resetTempStatBonuses();
         try { Thread.currentThread().sleep( 500 ); } catch(Exception ex) {}
         chooseMove( defender );
         gainSP();
         } // end if
      } // end method specAttack
   
   
   public String getImage()
      {
      if( goldMimic )
         {
         return "MimicGold.png";
         } // end if
      return "Mimic.png";
      } // end method getImage
   public String getBattleImage()
      {
      if( goldMimic )
         {
         return "MimicGoldBattle.png";
         } // end if
      return "MimicBattle.png";
      } // end method getImage
   } // end class Mimic