public class GoldChest extends Chest
   {
   /**
    * calls super.openChest with a floor level 3 higher than current floorlvl
    * makes sure the Equipment is usable by the Hero
    * makes the Equipment "Shiny"
    */
   public Equipment openChest( int floorLvl, Hero h )
      {
      Equipment equip = super.openChest( floorLvl + 3, h );
      // make sure hero can get usable item (ex: mage can't get shield)
      boolean equipUsable = h.equipUsable( equip );
      while( equipUsable == false )
         {
         setIsOpen( false );
         equip = super.openChest( floorLvl + 3, h );
         equipUsable = h.equipUsable( equip );
         } // end while
      
      equip.setStats();
      equip.setName( "Shiny " + equip.getName() );
      return equip;
      } // end method OpenChest
   
   public String getImage()
      {
      if( getIsOpen() == false )
         {
         return "ChestGold.png";
         } // end if
      else
         {
         return "ChestGoldOpen.png";
         } // end else
      } // end method getImage
   } // end class GoldChest