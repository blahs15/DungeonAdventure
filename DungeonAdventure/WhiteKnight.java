public class WhiteKnight extends Monster
   {
   
   public WhiteKnight()
      {
      setName( "White Knight" );
      setMagicUser( true );
      setAtt( 0 );
      setMagicAtt( 10 );
      setDef( 35 );
      setMagicDef( 45 );
      setSpd( 30 );
      setEvasion( 15 );
      setAccuracy( 15 );
      setMaxHP( 30 );
      setMaxSP( 15 );
      
      setHP( getMaxHP() );
      setSP( getMaxSP() );
      
      setSpecAttackCost( 7 );
      setExp( 5 );
      } // end constructor WhiteKnight
      
   public void specAttack( Hero defender )
      {
      super.specAttack();
      Battle.magicAttack( getMagicAtt() * 5/3, getAccuracy(), defender, "Smite" );
      BattleScreen.dodgeHDelay();
      BattleScreen.shootMToH( "KnightWhiteSpec2.png" );
      BattleScreen.flashImageOnH( "KnightWhiteSpec.png" );
      } // end method specAttack
   
   
   public String getImage()
      {
      return "KnightWhite.png";
      } // end method getImage
   public String getBattleImage()
      {
      return "KnightWhiteBattle.png";
      } // end method getImage
   } // end class WhiteKnight