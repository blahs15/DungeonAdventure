public class Skeleton extends Monster
   {
   
   public Skeleton()
      {
      setName( "Skeleton" );
      setMagicUser( false );
      setAtt( 8 );
      setMagicAtt( 0 );
      setDef( 40 );
      setMagicDef( 50 );
      setSpd( 20 );
      setEvasion( 10 );
      setAccuracy( 15 );
      setMaxHP( 15 );
      setMaxSP( 10 );
      
      setHP( getMaxHP() );
      setSP( getMaxSP() );
      
      setSpecAttackCost( 10 );
      setExp( 3 );
      } // end constructor Skeleton
      
   public void specAttack( Hero defender )
      {
      super.specAttack();
      int dmg = Battle.attack( getAtt() * 3/2, getAccuracy(), defender, "Bone Throw" );
      BattleScreen.shootMToH( "SkeletonSpec.png" );
      if( dmg > 0 )
         {
         defender.setSP( defender.getSP() - 5 );
         System.out.println( "You get creeped out by the Bone and lose some will power (5 SP)" );
         } // end if
      if( defender.getSP() < 0 )
         {
         defender.setSP( 0 );
         } // end if
      } // end method specAttack
   
   
   public String getImage()
      {
      return "Skeleton.png";
      } // end method getImage
   public String getBattleImage()
      {
      return "Skeleton.png";
      } // end method getImage
   } // end class Skeleton