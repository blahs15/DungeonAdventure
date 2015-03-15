public interface Stats
   {
   /**
    * getters and setters of stats
    * also includes name
    */
   public void setAtt( int att );
   public void setMagicAtt( int magAtt );
   public void setDef( int def );
   public void setMagicDef( int magDef );
   public void setSpd( int spd );
   public void setEvasion( int evasion );
   public void setAccuracy( int acc );
   public void setMaxHP( int maxHP );
   public void setMaxSP( int maxSP );
   public void setName( String name );
   
   public int getAtt();
   public int getMagicAtt();
   public int getDef();
   public int getMagicDef();
   public int getSpd();
   public int getEvasion();
   public int getAccuracy();
   public int getMaxHP();
   public int getMaxSP();
   public String getName();
   } // end interface Stats