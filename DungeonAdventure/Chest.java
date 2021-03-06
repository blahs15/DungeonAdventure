public class Chest implements DungeonObject
   {
   private boolean isOpen;
   
   public Chest()
      {
      isOpen = false;
      } // end constructor Chest
   
   /**
    * make it a STATIC method?
    * how to create objects on grid...?
    * objects aren't static, methods are
    * NOT static so each chest can have boolean isOpen
    * 
    * automatically tell hero to equip, return void?
    * problem with GoldChest - checking equip before equipping.
    * maybe keep return as Equipment, but still tell hero to equip?
    * will only work if telling hero to equip in goldChest
    */
   
   /**
    * creates a random Equipment
    * @param floor level
    * @param Hero opening the chest
    * @return Equipment found in chest
    */
   public Equipment openChest( int floorLvl, Hero h )
      {
      Equipment equip = null;
      int equipRandomizer = (int) ( Math.random() * 12 );
      // BUG*** sometimes Ring cannot be equipped? ***BUG 
      
      if( equipRandomizer < 1 )
         {
         equip = new Sword( floorLvl );
         } // end if
      else if( equipRandomizer < 2 )
         {
         equip = new Staff( floorLvl );
         } // end if
      else if( equipRandomizer < 4 ) //double chance
         {
         equip = new Dagger( floorLvl );
         } // end if
      else if( equipRandomizer < 5 )
         {
         equip = new Shield( floorLvl );
         } // end if
      else if( equipRandomizer < 6 )
         {
         equip = new Pendant( floorLvl );
         } // end if
      else if( equipRandomizer < 7 )
         {
         equip = new Helmet( floorLvl );
         } // end if
      else if( equipRandomizer < 8 )
         {
         equip = new Shirt( floorLvl );
         } // end if
      else if( equipRandomizer < 9 )
         {
         equip = new Pants( floorLvl );
         } // end if
      else if( equipRandomizer < 10 )
         {
         equip = new Gloves( floorLvl );
         } // end if
      else if( equipRandomizer < 11 )
         {
         equip = new Shoes( floorLvl );
         } // end if
      else if( equipRandomizer < 12 )
        {
         equip = new Ring( floorLvl );
         } // end if
      
      isOpen = true;
      
      return equip;
      // remove chest from room -- chest is Open
      } // end method OpenChest
   
   /**
    * getter and setter for if the chest is open or not
    */
   public void setIsOpen( boolean isOpen )
      {
      this.isOpen = isOpen;
      } // end method setOpenChest
   public boolean getIsOpen()
      {
      return isOpen;
      } // end method getIsOpen
   
   public boolean getPathBlocked()
      {
      return true;
      } // end method blockPath
   
   public String getImage()
      {
      if( isOpen == false )
         {
         return "Chest.png";
         } // end if
      else
         {
         return "ChestOpen.png";
         } // end else
      } // end method getImage
   } // end class Chest