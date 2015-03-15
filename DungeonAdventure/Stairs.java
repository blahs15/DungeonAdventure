public class Stairs implements DungeonObject
   {
   /**
    * increases the floor level by 1
    * has a Maximum floor level of 15
    * @param current floor level
    * @return new floor level
    */
   public int goUpstairs( int floorLvl )
      {
      if( floorLvl >= 15 )
         {
         return 15;
         } // end if
      return floorLvl + 1;
      } // end method goUpstairs
   
   public boolean getPathBlocked()
      {
      return false;
      } // end method blockPath
   
   public String getImage()
      {
      return "Stairs.png";
      } // end method getImage
   } // end class Stairs