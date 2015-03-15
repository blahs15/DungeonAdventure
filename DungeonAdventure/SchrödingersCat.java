public class Schr�dingersCat extends Monster
   {
   private int chanceToKill;
   
   public Schr�dingersCat()
      {
      chanceToKill = 3;
      
      setName( "Schr�dingers Cat" );
      setMagicUser( false );
      setAtt( 30 );
      setMagicAtt( 0 );
      setDef( 35 );
      setMagicDef( 40 );
      setSpd( 40 );
      setEvasion( 40 );
      setAccuracy( 50 );
      setMaxHP( 25 );
      setMaxSP( 20 );
      
      setHP( getMaxHP() );
      setSP( getMaxSP() );
      
      setSpecAttackCost( 10 );
      setExp( 6 );
      } // end constructor Schr�dingersCat
      
   public void specAttack( Hero defender )
      {
      super.specAttack();
      Battle.attack( getAtt(), getAccuracy(), defender, "Scratch" );
      Battle.attack( getAtt(), getAccuracy(), defender, "Scratch" );
      BattleScreen.flashImageOnH( "Schr�dingersCatSpec.png", "Schr�dingersCatSpec2.png" );
      } // end method specAttack
   
   public void setHP( int HP )
      {
      super.setHP(HP);
      if( getHP() <= 0 )
         {
         int isDead = (int) ( Math.random() * chanceToKill );
         if( isDead != 0 )
            {
            super.setHP( getMaxHP() );
            System.out.println( "You killed the Schr�dingers Cat... or did you...?" );
            } // end if
         chanceToKill--;
         } // end if
      } // end method setHP
   
   
   public String getImage()
      {
      return "Schr�dingersCat.png";
      } // end method getImage
   public String getBattleImage()
      {
      return "Schr�dingersCat.png";
      } // end method getImage
   } // end class Schr�dingersCat