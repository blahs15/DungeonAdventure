public class Pants extends Equipment
   {
   
   public Pants( int floorLvl )
      {
      super( floorLvl );
      } // end constructor Pants
   
   
   public void setStats()
      {
      setESlotNum( 4 );
      int f = getFloorLvl();
      setAtt( 0 );
      setMagicAtt( 0 );
      setDef( (int)( Math.random() * 3*f ) + 2*f );
      setMagicDef( (5*f) - getDef() );
      setSpd( (int)( Math.random() * 2*f ) - ( getDef() / 5 ) );
      setEvasion( getSpd() - (f/3) );
      setAccuracy( 0 );
      setMaxHP( (int)( Math.random() * f ) );
      setMaxSP( 0 );
      
      setName();
      } // end method setStats
   
   public void setName()
      {
      String name = new String();
      
      int spd = getSpd();
      if( spd > 0 )
         {
         name += "Light";
         } // end if
      else if( spd < 0 )
         {
         name += "Heavy";
         } // end if
      
      name+= " ";
      int def = getDef();
      if( def < 8 )
         {
         name += "Cloth";
         } // end if
      else if( def < 14 )
         {
         name += "Leather";
         } // end if
      else if( def < 20 )
         {
         name += "Rubber";
         } // end if
      else if( def < 26 )
         {
         name += "Copper";
         } // end if
      else if( def < 32 )
         {
         name += "Iron";
         } // end if
      else if( def < 38 )
         {
         name += "Bronze";
         } // end if
      else if( def < 44 )
         {
         name += "Steel";
         } // end if
      else if( def < 50 )
         {
         name += "Silver";
         } // end if
      else if( def < 56 )
         {
         name += "Gold";
         } // end if
      else if( def < 62 )
         {
         name += "Cobalt";
         } // end if
      else if( def < 68 )
         {
         name += "Mythril";
         } // end if
      else
         {
         name += "Adamantium";
         } // end if
      
      name += " ";
      int randomizer = (int) ( Math.random() * 4 );
      if( randomizer == 0 )
         {
         name += "Pants";
         } // end if
      else if( randomizer == 1 )
         {
         name += "Bottoms";
         } // end if
      else if( randomizer == 2 )
         {
         name += "Grieves";
         } // end if
      else if( randomizer == 3 )
         {
         name += "Pajamas";
         } // end if
      
      setName( name );
      } // end method setName
   
   } // end class Pants