public class Ogre extends Monster
   {
   
   public Ogre()
      {
      setName( "Ogre" );
      setMagicUser( false );
      setAtt( 50 );
      setMagicAtt( 0 );
      setDef( 80 );
      setMagicDef( 60 );
      setSpd( 30 );
      setEvasion( 20 );
      setAccuracy( 40 );
      setMaxHP( 40 );
      setMaxSP( 20 );
      
      setHP( getMaxHP() );
      setSP( getMaxSP() );
      
      setSpecAttackCost( 15 );
      setExp( 8 );
      } // end constructor Ogre
      
   public void specAttack( Hero defender )
      {
      super.specAttack();
      Battle.attack( getAtt() , getAccuracy() / 2, defender, "Skull Crush" );
      BattleScreen.dodgeHDelay();
      BattleScreen.moveMForward();
      BattleScreen.flashImageOnH( "OgreSpec.png" );
      } // end method specAttack
   
   public String getImage()
      {
      return "Ogre.png";
      } // end method getImage
   public String getBattleImage()
      {
      return "Ogre.png";
      } // end method getImage
   } // end class Ogre