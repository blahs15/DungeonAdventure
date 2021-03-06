public class WaterElemental extends Elemental
   {
   
   public WaterElemental()
      {
      super();
      setName( "Water " + getName() );
      setMagicDef( 130 );
      setAccuracy( 70 );
      setMaxHP( 120 );
      setHP( getMaxHP() );
      } // end constructor WaterElemental
   
   public void specAttack( Hero defender )
      {
      super.specAttack();
      Battle.attack( getAtt() * 3/2, getAccuracy(), defender, "Tsunami" );
      BattleScreen.dodgeHDelay();
      BattleScreen.shootMToH( "ElementalWaterSpec.png" );
      BattleScreen.flashImageOnH( "ElementalWaterSpec2.png" );
      } // end method specAttack
   
   
   public String getImage()
      {
      return "ElementalWater.png";
      } // end method getImage
   public String getBattleImage()
      {
      return "ElementalWater.png";
      } // end method getImage
   } // end class WaterElemental