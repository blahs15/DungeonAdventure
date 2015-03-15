public class DarkKnight extends Monster
   {
   
   public DarkKnight()
      {
      setName( "Dark Knight" );
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
      
      setSpecAttackCost( 10 );
      setExp( 5 );
      } // end constructor DarkKnight
      
   public void specAttack( Hero defender )
      {
      super.specAttack();
      int dmg = Battle.magicAttack( getMagicAtt() * 3/2, getAccuracy(), defender, "Evil Slash" );
      BattleScreen.flashImageOnH( "KnightDarkSpec.png" );
      //BattleScreen.shootMToH( "KnightDarkSpec.png" );
      if( dmg > 0 )
         {
         defender.setSP( defender.getSP() - 8 );
         System.out.println( "You were cursed and lost some will power (8 SP)" );
         } // end if
      if( defender.getSP() < 0 )
         {
         defender.setSP( 0 );
         } // end if
      } // end method specAttack
   
   
   public String getImage()
      {
      return "KnightDark.png";
      } // end method getImage
   public String getBattleImage()
      {
      return "KnightDark.png";
      } // end method getImage
   } // end class DarkKnight