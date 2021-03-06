public class Satyr extends Monster
   {
   
   public Satyr()
      {
      setName( "Satyr" );
      setMagicUser( true );
      setAtt( 90 );
      setMagicAtt( 80 );
      setDef( 70 );
      setMagicDef( 80 );
      setSpd( 65 );
      setEvasion( 45 );
      setAccuracy( 50 );
      setMaxHP( 70 );
      setMaxSP( 15 );
      
      setHP( getMaxHP() );
      setSP( getMaxSP() );
      
      setSpecAttackCost( 5 );
      setExp( 15 );
      } // end constructor Satyr
      
   public void specAttack( Hero defender )
      {
      super.specAttack();
      Battle.attack( getAtt(), getAccuracy(), defender, "Head Butt" );
      BattleScreen.dodgeHDelay();
      BattleScreen.moveMForward();
      BattleScreen.flashImageOnH( "OgreSpec.png" );
      } // end method specAttack
   
   
   public String getImage()
      {
      return "Satyr.png";
      } // end method getImage
   public String getBattleImage()
      {
      return "Satyr.png";
      } // end method getImage
   } // end class Satyr