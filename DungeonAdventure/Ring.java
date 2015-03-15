public class Ring extends Equipment
   {
   private int statBonus;
   private int randStat;
   private String ringStat;
   
   public Ring( int floorLvl )
      {
      super( floorLvl );
      } // end constructor Ring
   
   
   public void setStats()
      {
      setESlotNum( 7 );
      randStat = (int)( Math.random() * 9 );
      statBonus = (int)( Math.random() * 5 ) - 2;
      int f = getFloorLvl();
      f += statBonus;
      if( f < 1 ) // in case stat bonus brings f to negative
         {
         f = 1;
         } // end if
      
      if( getFloorLvl() == 0 ) // for starting rings ( same as null )
         {
         f = 0;
         } // end if
      
      else if( randStat == 0 )
         {
         setAtt( f );
         ringStat = "att: +" + f;
         } // end if
      else if( randStat == 1 )
         {
         setMagicAtt( f );
         ringStat = "magAtt: +" + f;
         } // end if
      else if( randStat == 2 )
         {
         setDef( f );
         ringStat = "def: +" + f;
         } // end if
      else if( randStat == 3 )
         {
         setMagicDef( f );
         ringStat = "magDef: +" + f;
         } // end if
      else if( randStat == 4 )
         {
         setSpd( f );
         ringStat = "spd: +" + f;
         } // end if
      else if( randStat == 5 )
         {
         setEvasion( f );
         ringStat = "eva: +" + f;
         } // end if
      else if( randStat == 6 )
         {
         setAccuracy( f );
         ringStat = "acc: +" + f;
         } // end if
      else if( randStat == 7 )
         {
         setMaxHP( f );
         ringStat = "maxHP: +" + f;
         } // end if
      else if( randStat == 8 )
         {
         setMaxSP( f );
         ringStat = "maxSP: +" + f;
         } // end if
      
      setName();
      } // end method setStats
   
   public void setName()
      {
      String name = new String();
      int f = getFloorLvl();
      if( getFloorLvl() == 0 )
         {
         name = " ";
         ringStat = " ";
         } // end if
      else
         {
         if( statBonus < 0 )
            {
            name += "Corrupted ";
            } // end if
         else if( statBonus > 0 )
            {
            name += "Blessed ";
            } // end if
      
         if( randStat == 0 )
            {
            name += "Frenzied";
            } // end if
         else if( randStat == 1 )
            {
            name += "Magical";
            } // end if
         else if( randStat == 2 )
            {
            name += "Strong";
            } // end if
         else if( randStat == 3 )
            {
            name += "Enchanted";
            } // end if
         else if( randStat == 4 )
            {
            name += "Hasty";
            } // end if
         else if( randStat == 5 )
            {
            name += "Transparent";
            } // end if
         else if( randStat == 6 )
            {
            name += "True Seeing";
            } // end if
         else if( randStat == 7 )
            {
            name += "Healing";
            } // end if
         else if( randStat == 8 )
            {
            name += "Skillful";
            } // end if
         
         name += " ";
         
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
      
         name += " Ring";
         } // end else
      setName( name );
      } // end method setName
   
   public String getRingStat()
      {
      return ringStat;
      } // end method getRingStat
   
   } // end class Ring