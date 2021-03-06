public class Staff extends Equipment
   {
   
   public Staff( int floorLvl )
      {
      super( floorLvl );
      } // end constructor Staff
   
   
   public void setStats()
      {
      setESlotNum( 0 );
      int f = getFloorLvl();
      setAtt( (int)( Math.random() * (f+1) ) + f );
      setMagicAtt( (int)( Math.random() * (2*f+2) ) + 2*f+2 );
      setDef( 0 );
      setMagicDef( (int)( Math.random() * 3*f ) + f );
      setSpd( (int)( Math.random() * (f+1) ) );
      setEvasion( (int)( Math.random() * f ) );
      setAccuracy( (int)( Math.random() * 2*f ) + f );
      setMaxHP( (int)( Math.random() * f ) );
      setMaxSP( (int)( Math.random() * 3*f ) );
      
      setName();
      } // end method setStats
   
   public void setName()
      {
      String name = new String();
      int att = getMagicAtt();
      if( att < 10 )
         {
         name += "Wooden";
         } // end if
      else if( att < 16 )
         {
         name += "Copper";
         } // end if
      else if( att < 22 )
         {
         name += "Iron";
         } // end if
      else if( att < 28 )
         {
         name += "Bronze";
         } // end if
      else if( att < 34 )
         {
         name += "Steel";
         } // end if
      else if( att < 40 )
         {
         name += "Silver";
         } // end if
      else if( att < 46 )
         {
         name += "Gold";
         } // end if
      else if( att < 52 )
         {
         name += "Cobalt";
         } // end if
      else if( att < 58 )
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
         name += "Staff";
         } // end if
      else if( randomizer == 1 )
         {
         name += "Wand";
         } // end if
      else if( randomizer == 2 )
         {
         name += "Tome";
         } // end if
      else if( randomizer == 3 )
         {
         name += "Sceptor";
         } // end if
      
      setName( name );
      } // end method setName
   
   } // end class Staff