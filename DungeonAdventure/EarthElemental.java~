public class EarthElemental extends Elemental
   {
   
   public EarthElemental()
      {
      super();
      setName( "Earth " + getName() );
      setAtt( 60 );
      setDef( 130 );
      setSpd( 40 );
      setMaxHP( 120 );
      setHP( getMaxHP() );
      } // end constructor EarthElemental
   
   public void specAttack( Hero defender )
      {
      super.specAttack();
      Battle.attack( getAtt() * 7/10 , getAccuracy(), defender, "Earthquake" );
      Battle.attack( getAtt() * 8/10 , getAccuracy(), defender, "Earthquake" );
      Battle.attack( getAtt() * 9/10 , getAccuracy(), defender, "Earthquake" );
      } // end method specAttack
   
   
   public String getImage()
      {
      return "ElementalEarth.png";
      } // end method getImage
   public String getBattleImage()
      {
      return "ElementalEarth.png";
      } // end method getImage
   } // end class EarthElemental