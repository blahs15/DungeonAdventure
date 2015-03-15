public interface DungeonObject
   {
   /**returns true if the object blocks the path of the Hero
    * @return true if path is blocked
    */
   public abstract boolean getPathBlocked();
   
   /**
    * @return the name of the image file for the Object
    */
   public abstract String getImage();
   } // end interface DungeonObject