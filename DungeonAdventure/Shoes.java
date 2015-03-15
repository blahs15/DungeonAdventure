public class Shoes extends Equipment
   {
   
   public Shoes( int floorLvl )
      {
      super( floorLvl );
      } // end constructor Shoes
   
   
   public void setStats()
      {
      setESlotNum( 6 );
      int f = getFloorLvl();
      setAtt( 0 );
      setMagicAtt( 0 );
      setDef( (int)( Math.random() * 2*f ) + f );
      setMagicDef( (int)( Math.random() * 2*f ) + f );
      setSpd( (int)( Math.random() * f ) + 2*f );
      setEvasion( (int)( Math.random() * ( getSpd() + 3 ) ) );
      setAccuracy( 0 );
      setMaxHP( (int)( Math.random() * 2 ) );
      setMaxSP( 0 );
      
      setName();
      } // end method setStats
   
   public void setName()
      {
      String name = new String();
      int def = getDef() + getMagicDef();
      if( def < 7 )
         {
         name += "Cloth";
         } // end if
      else if( def < 14 )
         {
         name += "Leather";
         } // end if
      else if( def < 21 )
         {
         name += "Rubber";
         } // end if
      else if( def < 28 )
         {
         name += "Copper";
         } // end if
      else if( def < 35 )
         {
         name += "Iron";
         } // end if
      else if( def < 42 )
         {
         name += "Bronze";
         } // end if
      else if( def < 49 )
         {
         name += "Steel";
         } // end if
      else if( def < 56 )
         {
         name += "Silver";
         } // end if
      else if( def < 63 )
         {
         name += "Gold";
         } // end if
      else if( def < 70 )
         {
         name += "Cobalt";
         } // end if
      else if( def < 77 )
         {
         name += "Mythril";
         } // end if
      else
         {
         name += "Adamantium";
         } // end if
      
      name += " ";
      int randomizer = (int) ( Math.random() * 2 );
      if( randomizer == 0 )
         {
         name += "Shoes";
         } // end if
      else if( randomizer == 1 )
         {
         name += "Boots";
         } // end if
      
      setName( name );
      } // end method setName
   
   } // end class Shoes