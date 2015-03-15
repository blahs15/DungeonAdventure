public class Helmet extends Equipment
   {
   
   public Helmet( int floorLvl )
      {
      super( floorLvl );
      } // end constructor Helmet
   
   
   public void setStats()
      {
      setESlotNum( 2 );
      int f = getFloorLvl();
      setAtt( 0 );
      setMagicAtt( 0 );
      setDef( (int)( Math.random() * f ) + f );
      setMagicDef( (int)( Math.random() * f ) );
      setSpd( 0 );
      setEvasion( 0 );
      setAccuracy( (int)( Math.random() * 2*f ) );
      setMaxHP( 0 );
      setMaxSP( 0 );
      
      setName();
      } // end method setStats
   
   public void setName()
      {
      String name = new String();
      int def = getDef();
      if( def < 4 )
         {
         name += "Cloth";
         } // end if
      else if( def < 6 )
         {
         name += "Leather";
         } // end if
      else if( def < 8 )
         {
         name += "Rubber";
         } // end if
      else if( def < 10 )
         {
         name += "Copper";
         } // end if
      else if( def < 12 )
         {
         name += "Iron";
         } // end if
      else if( def < 14 )
         {
         name += "Bronze";
         } // end if
      else if( def < 16 )
         {
         name += "Steel";
         } // end if
      else if( def < 18 )
         {
         name += "Silver";
         } // end if
      else if( def < 20 )
         {
         name += "Gold";
         } // end if
      else if( def < 22 )
         {
         name += "Cobalt";
         } // end if
      else if( def < 24 )
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
         name += "Cap";
         } // end if
      else if( randomizer == 1 )
         {
         name += "Helmet";
         } // end if
      else if( randomizer == 2 )
         {
         name += "Hat";
         } // end if
      else if( randomizer == 3 )
         {
         name += "Hood";
         } // end if
      
      setName( name );
      } // end method setName
   
   } // end class Helmet