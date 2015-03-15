public class Gloves extends Equipment
   {
   
   public Gloves( int floorLvl )
      {
      super( floorLvl );
      } // end constructor Gloves
   
   
   public void setStats()
      {
      setESlotNum( 5 );
      int f = getFloorLvl();
      setAtt( (int)( Math.random() * 3*f ) / 2 );
      setMagicAtt( (int)( Math.random() * f/2 ) );
      setDef( (int)( Math.random() * 2*f ) + 1 );
      setMagicDef( (int)( Math.random() * 2*f ) );
      setSpd( (int)( Math.random() * f ) );
      setEvasion( (int)( Math.random() * f ) );
      setAccuracy( (int)( Math.random() * 2*f ) + f );
      setMaxHP( (int)( Math.random() * f ) );
      setMaxSP( (int)( Math.random() * f ) );
      
      setName();
      } // end method setStats
   
   public void setName()
      {
      String name = new String();
      int def = getDef() + getMagicDef();
      if( def < 4 )
         {
         name += "Cloth";
         } // end if
      else if( def < 9 )
         {
         name += "Leather";
         } // end if
      else if( def < 14 )
         {
         name += "Rubber";
         } // end if
      else if( def < 19 )
         {
         name += "Copper";
         } // end if
      else if( def < 24 )
         {
         name += "Iron";
         } // end if
      else if( def < 29 )
         {
         name += "Bronze";
         } // end if
      else if( def < 34 )
         {
         name += "Steel";
         } // end if
      else if( def < 39 )
         {
         name += "Silver";
         } // end if
      else if( def < 44 )
         {
         name += "Gold";
         } // end if
      else if( def < 49 )
         {
         name += "Cobalt";
         } // end if
      else if( def < 54 )
         {
         name += "Mythril";
         } // end if
      else
         {
         name += "Adamantium";
         } // end if
      
      name += " ";
      int randomizer = (int) ( Math.random() * 3 );
      if( randomizer == 0 )
         {
         name += "Gloves";
         } // end if
      else if( randomizer == 1 )
         {
         name += "Work Gloves";
         } // end if
      else if( randomizer == 2 )
         {
         name += "Gauntlet";
         } // end if
      
      setName( name );
      } // end method setName
   
   } // end class Gloves