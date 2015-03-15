public class Shield extends Equipment
   {
   
   public Shield( int floorLvl )
      {
      super( floorLvl );
      } // end constructor Shield
   
   
   public void setStats()
      {
      setESlotNum( 1 );
      int f = getFloorLvl();
      setAtt( 0 );
      setMagicAtt( 0 );
      setDef( (int)( Math.random() * 3*f ) + 2*f );
      setMagicDef( (int)( Math.random() * 2*f ) + f/2 );
      setSpd( 0 );
      setEvasion( 0 );
      setAccuracy( 0 );
      setMaxHP( (int)( Math.random() * 2*f ) );
      setMaxSP( 0 );
      
      setName();
      } // end method setStats
   
   public void setName()
      {
      String name = new String();
      int def = getDef();
      if( def < 11 )
         {
         name += "Wooden";
         } // end if
      else if( def < 18 )
         {
         name += "Copper";
         } // end if
      else if( def < 25 )
         {
         name += "Iron";
         } // end if
      else if( def < 32 )
         {
         name += "Bronze";
         } // end if
      else if( def < 39 )
         {
         name += "Steel";
         } // end if
      else if( def < 46 )
         {
         name += "Silver";
         } // end if
      else if( def < 53 )
         {
         name += "Gold";
         } // end if
      else if( def < 60 )
         {
         name += "Cobalt";
         } // end if
      else if( def <= 67 )
         {
         name += "Mythril";
         } // end if
      else
         {
         name += "Adamantium";
         } // end if
      
      name += " Shield";
      setName( name );
      } // end method setName
   
   } // end class Shield