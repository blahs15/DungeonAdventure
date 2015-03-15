public class AirElemental extends Elemental
   {
   
   public AirElemental()
      {
      super();
      setName( "Air " + getName() );
      setMagicUser( true );
      setSpd( 75 );
      setEvasion( 75 );
      } // end constructor AirElemental
   
   public void specAttack( Hero defender )
      {
      super.specAttack();
      Battle.attack( getSpd(), getAccuracy() * 3/4, defender, "Tornado" );
      BattleScreen.dodgeHDelay();
      BattleScreen.shootMToH( "ElementalAirSpec.png" );
      BattleScreen.flashImageOnH( "ElementalAirSpec.png" );
      } // end method specAttack
   
   
   public String getImage()
      {
      return "ElementalAir.png";
      } // end method getImage
   public String getBattleImage()
      {
      return "ElementalAir.png";
      } // end method getImage
   } // end class AirElemental