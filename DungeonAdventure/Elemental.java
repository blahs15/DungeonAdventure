public abstract class Elemental extends Monster
   {
   
   public Elemental()
      {
      setName( "Elemental" );
      setMagicUser( false );
      setAtt( 50 );
      setMagicAtt( 50 );
      setDef( 100 );
      setMagicDef( 100 );
      setSpd( 50 );
      setEvasion( 40 );
      setAccuracy( 50 );
      setMaxHP( 100 );
      setMaxSP( 60 );
      
      setHP( getMaxHP() );
      setSP( getMaxSP() );
      
      setSpecAttackCost( 20 );
      setExp( 10 );
      } // end constructor Elemental
   
   } // end class Elemental