public class Dagger extends Equipment
   {
   
   public Dagger( int floorLvl )
      {
      super( floorLvl );
      } // end constructor Dagger
   
   
   public void setStats()
      {
      setESlotNum( 0 );
      int f = getFloorLvl();
      setAtt( (int)( Math.random() * (f+2) ) + f+2 );
      setMagicAtt( 0 );
      setDef( 0 );
      setMagicDef( 0 );
      setSpd( (int)( Math.random() * 2*f ) + f );
      setEvasion( (int)( Math.random() * 2*f ) );
      setAccuracy( (int)( Math.random() * 2*f ) + f );
      setMaxHP( (int)( Math.random() * 2*f ) );
      setMaxSP( (int)( Math.random() * 2*f ) );
      
      setName();
      } // end method setStats
   
   public void setName()
      {
      String name = new String();
      int att = getAtt();
      if( att < 7 )
         {
         name += "Wooden";
         } // end if
      else if( att < 10 )
         {
         name += "Copper";
         } // end if
      else if( att < 13 )
         {
         name += "Iron";
         } // end if
      else if( att < 16 )
         {
         name += "Bronze";
         } // end if
      else if( att < 19 )
         {
         name += "Steel";
         } // end if
      else if( att < 22 )
         {
         name += "Silver";
         } // end if
      else if( att < 24 )
         {
         name += "Gold";
         } // end if
      else if( att < 27 )
         {
         name += "Cobalt";
         } // end if
      else if( att < 30 )
         {
         name += "Mythril";
         } // end if
      else
         {
         name += "Adamantium";
         } // end if
      
      name += " ";
      int randomizer = (int) ( Math.random() * 5 );
      if( randomizer == 0 )
         {
         name += "Dagger";
         } // end if
      else if( randomizer == 1 )
         {
         name += "Knife";
         } // end if
      else if( randomizer == 2 )
         {
         name += "Stiletto";
         } // end if
      else if( randomizer == 3 )
         {
         name += "Dirk";
         } // end if
      else if( randomizer == 4 )
         {
         name += "Shank";
         } // end if
      
      setName( name );
      } // end method setName
   
   } // end class Dagger