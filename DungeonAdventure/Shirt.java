public class Shirt extends Equipment
   {
   
   public Shirt( int floorLvl )
      {
      super( floorLvl );
      } // end constructor Shirt
   
   
   public void setStats()
      {
      setESlotNum( 3 );
      int f = getFloorLvl();
      setAtt( 0 );
      setMagicAtt( 0 );
      setDef( (int)( Math.random() * 3*f ) + 3*f );
      setMagicDef( (6*f) - getDef() );
      setSpd( (int)( Math.random() * 2*f ) - ( getDef() / 4 ) );
      setEvasion( getSpd() - (f/2) );
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
      if( def < 9 )
         {
         name += "Cloth";
         } // end if
      else if( def < 16 )
         {
         name += "Leather";
         } // end if
      else if( def < 23 )
         {
         name += "Rubber";
         } // end if
      else if( def < 30 )
         {
         name += "Copper";
         } // end if
      else if( def < 37 )
         {
         name += "Iron";
         } // end if
      else if( def < 44 )
         {
         name += "Bronze";
         } // end if
      else if( def < 51 )
         {
         name += "Steel";
         } // end if
      else if( def < 58 )
         {
         name += "Silver";
         } // end if
      else if( def < 65 )
         {
         name += "Gold";
         } // end if
      else if( def < 72 )
         {
         name += "Cobalt";
         } // end if
      else if( def < 79 )
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
         name += "Shirt";
         } // end if
      else if( randomizer == 1 )
         {
         name += "Vest";
         } // end if
      else if( randomizer == 2 )
         {
         name += "Robe";
         } // end if
      else if( randomizer == 3 )
         {
         name += "Cloak";
         } // end if
         
      setName( name );
      } // end method setName
   
   } // end class Shirt