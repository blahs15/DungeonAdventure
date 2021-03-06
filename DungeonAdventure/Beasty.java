public class Beasty extends Monster
   {
   
   public Beasty()
      {
      setName( "Beasty" );
      setMagicUser( false );
      setAtt( 10 );
      setMagicAtt( 0 );
      setDef( 45 );
      setMagicDef( 40 );
      setSpd( 20 );
      setEvasion( 10 );
      setAccuracy( 15 );
      setMaxHP( 15 );
      setMaxSP( 10 );
      
      setHP( getMaxHP() );
      setSP( getMaxSP() );
      
      setSpecAttackCost( 10 );
      setExp( 4 );
      } // end constructor Skeleton
      
   public void specAttack( Hero defender )
      {
      super.specAttack();
      Battle.attack( getAtt() * 5/3, getAccuracy(), defender, "Bite" );
      BattleScreen.flashImageOnH( "BeastySpec.png", "BeastySpec2.png" );
      } // end method specAttack
   
   
   public String getImage()
      {
      return "Beasty.png";
      } // end method getImage
   public String getBattleImage()
      {
      return "Beasty.png";
      } // end method getImage
   } // end class Beasty