public class FireElemental extends Elemental
   {
   private boolean burn;
   private int burnDmg;
   
   public FireElemental()
      {
      super();
      setName( "Fire " + getName() );
      setMagicUser( true );
      setMagicAtt( 65 );
      setAccuracy( 40 );
      setMaxSP( 70 );
      setSP( getMaxSP() );
      
      burn = false;
      burnDmg = 0;
      } // end constructor FireElemental
   
   public void attack( Character defender )
      {
      burn( defender );
      super.attack( defender );
      } // end method attack
   public void specAttack( Hero defender )
      {
      burn( defender );
      super.specAttack();
      int dmg = Battle.magicAttack( getMagicAtt()+20 , getAccuracy(), defender, "Fire Spin" );
      BattleScreen.flashImageOnH( "ElementalFireSpec.png" );
      int rand = (int) (Math.random() * 4 );
      if( rand == 0 && dmg != 0 )
         {
         burnDmg = dmg / 5;
         if( burnDmg < 3 )
            {
            burnDmg = 3;
            } // end if
         burn = true;
         } // end if
      } // end method specAttack
   
   private void burn( Character defender )
      {
      if( burn )
         {
         defender.setHP( defender.getHP() - burnDmg );
         System.out.println( "The " + getName() + "'s Fire Spin burned you for an extra "
            + burnDmg + " damage" );
         burn = false;
         } // end if
      } // end method burn
   
   public String getImage()
      {
      return "ElementalFire.png";
      } // end method getImage
   public String getBattleImage()
      {
      return "ElementalFire.png";
      } // end method getImage
   } // end class FireElemental