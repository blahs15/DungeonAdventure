public class SchršdingersCat extends Monster
   {
   private int chanceToKill;
   
   public SchršdingersCat()
      {
      chanceToKill = 3;
      
      setName( "Schršdingers Cat" );
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
      } // end constructor SchršdingersCat
      
   public void specAttack( Hero defender )
      {
      super.specAttack();
      Battle.attack( getAtt(), getAccuracy(), defender, "Scratch" );
      Battle.attack( getAtt(), getAccuracy(), defender, "Scratch" );
      BattleScreen.flashImageOnH( "SchršdingersCatSpec.png", "SchršdingersCatSpec2.png" );
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
            System.out.println( "You killed the Schršdingers Cat... or did you...?" );
            } // end if
         chanceToKill--;
         } // end if
      } // end method setHP
   
   
   public String getImage()
      {
      return "SchršdingersCat.png";
      } // end method getImage
   public String getBattleImage()
      {
      return "SchršdingersCat.png";
      } // end method getImage
   } // end class SchršdingersCat