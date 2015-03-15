public class Dragon extends Monster
   {
   private int type;
   private String typeName;
   private String specAttName;
   private int effectCounter;
   private int counterDmg;
   
   public Dragon()
      {
      setMagicUser( false );
      setAtt( 100 );
      setMagicAtt( 100 );
      setDef( 125 );
      setMagicDef( 125 );
      setSpd( 100 );
      setEvasion( 75 );
      setAccuracy( 75 );
      setMaxHP( 100 );
      setMaxSP( 20 );
      
      setSpecAttackCost( 15 );
      setExp( 20 );
      
      effectCounter = 0;
      type = (int) ( Math.random() * 4 ); // no bone dragon yet
      if( type == 0 )
         {
         setMagicAtt( 120 );
         typeName = "Fire";
         specAttName = "Fire Breath";
         } // end if
      if( type == 1 )
         {
         setMagicAtt( 70 ); // will freeze
         typeName = "Ice";
         specAttName = "Cold Breath";
         } // end if
      if( type == 2 )
         {
         typeName = "Poison";
         specAttName = "Acid Breath";
         } // end if
      if( type == 3 )
         {
         setAccuracy( 60 );
         typeName = "Ghost";
         specAttName = "Ethereal Breath";
         } // end if
      if( type == 4 )
         {
         typeName = "Bone";
         } // end if
      setName( typeName + " Dragon" );
      
      setHP( getMaxHP() );
      setSP( getMaxSP() );
      } // end constructor Dragon
   
   public void attack( Character defender )
      {
      effect( defender );
      super.attack( defender );
      } // end method attack
   
   public void specAttack( Hero defender )
      {
      effect( defender );
      super.specAttack();
      int dmg = Battle.magicAttack( getMagicAtt(), getAccuracy(), defender,
         specAttName );
      BattleScreen.shootMToH( "DragonBolt" + typeName + ".png" );
      if( dmg > 0 )
         {
         if( typeName.equals( "Fire" ) )
            {
            int rand = (int) (Math.random() * 3);
            if( rand == 0 && dmg != 0 )
               {
               effectCounter = 3;
               counterDmg = dmg / 5;
               if( counterDmg < 9 )
                  counterDmg = 9;
               } // end if
            } // end if
         if( typeName.equals( "Poison" ) )
            {
            int rand = (int) (Math.random() * 3);
            if( rand == 0 && dmg != 0 )
               {
               effectCounter = 3;
               counterDmg = dmg / 8;
               if( counterDmg < 5 )
                  counterDmg = 5;
               } // end if
            } // end if
         if( typeName.equals( "Ice" ) )
            {
            int rand = (int) (Math.random() * 2 );
            if( rand == 0 && dmg != 0 )
               {
               System.out.println( "You have been frozen, you are unable to make an attack" );
               resetTempStatBonuses();
               try { Thread.currentThread().sleep( 500 ); } catch(Exception ex) {}
               chooseMove( defender ); // ANIMATION PROBLEM?
               gainSP();
               } // end if
            } // end if
         if( typeName.equals( "Ghost" ) )
            { // nothing? just evasion specialty
            } // end if
         } // end if
      } // end method specAttack
   
   private void effect( Character defender )
      {
      if( effectCounter > 0 )
         {
         if( typeName.equals( "Fire" ) )
            {
            defender.setHP( defender.getHP() - counterDmg );
            System.out.println( "The " + getName() + "'s "+ specAttName + " burned you for "
               + counterDmg + " damage" );
            counterDmg -= counterDmg / 3;
            } // end if
         if( typeName.equals( "Poison" ) )
            {
            defender.setHP( defender.getHP() - counterDmg );
            System.out.println( "The " + getName() + "'s "+ specAttName + " poisoned you for "
               + counterDmg + " damage" );
            } // end if
         
         effectCounter--;
         } // end if
      } // end method burn
   
   public int getEvasion()
      {
      if( typeName.equals( "Ghost" ) )
         {
         int rand = (int) ( Math.random() * 5/2 );
         if( rand == 0 )
            return 1000;
         } // end if
      return super.getEvasion();
      } // end method getEvasion
   
   public String getImage()
      {
      return "Dragon" + typeName + ".png";
      } // end method getImage
   public String getBattleImage()
      {
      return "Dragon" + typeName + "Battle.png";
      } // end method getImage
   } // end class Dragon