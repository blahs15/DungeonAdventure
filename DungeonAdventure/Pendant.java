public class Pendant extends Equipment
   {
   
   public Pendant( int floorLvl )
      {
      super( floorLvl );
      } // end constructor Pendant
   
   
   public void setStats()
      {
      setESlotNum( 1 );
      int f = getFloorLvl();
      setAtt( 0 );
      setMagicAtt( (int)( Math.random() * f ) + f );
      setDef( 0 );
      setMagicDef( (int)( Math.random() * 2*f ) );
      setSpd( 0 );
      setEvasion( 0 );
      setAccuracy( 0 );
      setMaxHP( (int)( Math.random() * f ) );
      setMaxSP( (int)( Math.random() * (2*f+2) ) );
      
      setName();
      } // end method setStats
   
   public void setName()
      {
      String name = new String();
      int f = getFloorLvl();
      
      if( f == 1 )
         {
         name += "Cloth";
         } // end if
      else if( f == 2 )
         {
         name += "Leather";
         } // end if
      else if( f == 3 )
         {
         name += "Rubber";
         } // end if
      else if( f == 4 )
         {
         name += "Stone";
         } // end if
      else if( f == 5 )
         {
         name += "Copper";
         } // end if
      else if( f == 6 )
         {
         name += "Iron";
         } // end if
      else if( f == 7 )
         {
         name += "Bronze";
         } // end if
      else if( f == 8 )
         {
         name += "Steel";
         } // end if
      else if( f == 9 )
         {
         name += "Silver";
         } // end if
      else if( f == 10 )
         {
         name += "Gold";
         } // end if
      else if( f == 11 )
         {
         name += "Cobalt";
         } // end if
      else if( f == 12 )
         {
         name += "Mythril";
         } // end if
      else if( f == 13 || f == 14 )
         {
         name += "Adamantium";
         } // end if
      else if( f > 14 )
         {
         name += "Rainbow";
         } // end if
      
      name += " ";
      int randomizer = (int) ( Math.random() * 2 );
      if( randomizer == 0 )
         {
         name += "Pendant";
         } // end if
      else if( randomizer == 1 )
         {
         name += "Necklace";
         } // end if
      
      setName( name );
      } // end method setName
   
   } // end class Pendant