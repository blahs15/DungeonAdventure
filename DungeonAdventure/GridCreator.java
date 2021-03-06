public final class GridCreator
   {
   /**
    * this class has all the 2D arrays
    * dungeon floor layouts
    * 
    * 2D String array
    * have "wall", "monster", "hero", "chest", "stairs", "goldChest"
    * 
    * Monsters are randomized based on floor
    * Chest has chance of being GoldChest
    *
    */
   
   /**creates a grid with Strings representing the objects to later be created
    * which layout is used is randomized
    * h = Hero, m = Monster, w = Wall, c = Chest, g = GoldChest, s = Stairs
    * @return 2D String array with layout of dungeon floor
    */
   public static String[][] getGrid()
      {
      String[][] grid = new String[10][10];
      int gridRand = (int) ( Math.random() * 6 );
      if( gridRand == 0 )
         {
         grid[0][0] = "h";
         grid[0][1] = "w";
         grid[0][2] = "c";
         grid[0][4] = "m";
         grid[0][6] = "w";
         grid[0][7] = "c";
         grid[0][8] = "m";
         grid[0][9] = "g";
         grid[1][1] = "w";
         grid[1][2] = "w";
         grid[1][3] = "w";
         grid[1][6] = "w";
         grid[1][7] = "m";
         grid[1][9] = "m";
         grid[2][2] = "m";
         grid[2][3] = "w";
         grid[2][6] = "w";
         grid[2][9] = "c";
         grid[3][1] = "m";
         grid[3][4] = "w";
         grid[3][7] = "m";
         grid[3][8] = "w";
         grid[3][9] = "w";
         grid[4][0] = "w";
         grid[4][2] = "w";
         grid[4][3] = "m";
         grid[4][4] = "c";
         grid[4][5] = "w";
         grid[5][0] = "w";
         grid[5][2] = "w";
         grid[5][4] = "m";
         grid[5][6] = "m";
         grid[5][9] = "m";
         grid[6][0] = "w";
         grid[6][1] = "m";
         grid[6][2] = "w";
         grid[6][4] = "m";
         grid[6][6] = "w";
         grid[6][7] = "w";
         grid[6][8] = "w";
         grid[7][2] = "w";
         grid[7][4] = "m";
         grid[7][6] = "w";
         grid[7][7] = "g";
         grid[7][8] = "w";
         grid[7][9] = "c";
         grid[8][2] = "w";
         grid[8][3] = "w";
         grid[8][4] = "w";
         grid[8][5] = "m";
         grid[8][6] = "w";
         grid[8][7] = "w";
         grid[8][9] = "m";
         grid[9][0] = "c";
         grid[9][2] = "m";
         grid[9][3] = "c";
         grid[9][4] = "w";
         grid[9][8] = "m";
         grid[9][9] = "s";
         } // end if
      else if( gridRand == 1 )
         {
         grid[0][0] = "m";
         grid[0][1] = "w";
         grid[0][4] = "m";
         grid[0][6] = "w";
         grid[0][7] = "s";
         grid[0][8] = "m";
         grid[1][0] = "c";
         grid[1][1] = "w";
         grid[1][3] = "w";
         grid[1][6] = "c";
         grid[1][7] = "w";
         grid[2][0] = "m";
         grid[2][1] = "w";
         grid[2][3] = "w";
         grid[2][7] = "w";
         grid[2][8] = "c";
         grid[3][1] = "m";
         grid[3][3] = "h";
         grid[3][4] = "w";
         grid[3][5] = "m";
         grid[3][6] = "m";
         grid[3][7] = "w";
         grid[3][8] = "w";
         grid[3][9] = "m";
         grid[4][1] = "w";
         grid[4][2] = "w";
         grid[4][3] = "w";
         grid[4][7] = "w";
         grid[4][8] = "c";
         grid[5][2] = "w";
         grid[5][3] = "c";
         grid[5][6] = "w";
         grid[5][7] = "w";
         grid[6][0] = "w";
         grid[6][1] = "m";
         grid[6][2] = "w";
         grid[6][4] = "m";
         grid[6][5] = "m";
         grid[6][6] = "w";
         grid[6][7] = "g";
         grid[6][8] = "m";
         grid[7][2] = "w";
         grid[7][3] = "c";
         grid[7][6] = "w";
         grid[7][7] = "m";
         grid[8][2] = "w";
         grid[8][3] = "w";
         grid[8][4] = "m";
         grid[8][5] = "m";
         grid[8][6] = "w";
         grid[8][7] = "m";
         grid[8][8] = "w";
         grid[8][9] = "m";
         grid[9][0] = "c";
         grid[9][2] = "m";
         } // end if
      else if( gridRand == 2 )
         {
         grid[0][0] = "c";
         grid[0][4] = "w";
         grid[0][5] = "c";
         grid[0][7] = "m";
         grid[1][1] = "m";
         grid[1][2] = "w";
         grid[1][3] = "m";
         grid[1][7] = "w";
         grid[1][8] = "g";
         grid[2][1] = "w";
         grid[2][4] = "w";
         grid[2][5] = "m";
         grid[2][6] = "w";
         grid[2][7] = "g";
         grid[2][8] = "w";
         grid[2][9] = "m";
         grid[3][1] = "w";
         grid[3][3] = "w";
         grid[3][7] = "w";
         grid[4][1] = "m";
         grid[4][2] = "m";
         grid[4][3] = "m";
         grid[4][5] = "h";
         grid[4][7] = "m";
         grid[4][9] = "c";
         grid[5][1] = "w";
         grid[5][3] = "w";
         grid[5][7] = "w";
         grid[5][9] = "w";
         grid[6][1] = "w";
         grid[6][4] = "w";
         grid[6][5] = "m";
         grid[6][6] = "w";
         grid[6][8] = "m";
         grid[7][0] = "m";
         grid[7][1] = "w";
         grid[7][2] = "c";
         grid[7][5] = "m";
         grid[7][8] = "w";
         grid[8][1] = "c";
         grid[8][2] = "w";
         grid[8][3] = "w";
         grid[8][4] = "w";
         grid[8][5] = "m";
         grid[8][6] = "w";
         grid[8][7] = "w";
         grid[8][8] = "m";
         grid[9][0] = "s";
         grid[9][2] = "m";
         grid[9][9] = "c";
         } // end if
      else if( gridRand == 3 )
         {
         grid[0][2] = "m";
         grid[0][5] = "m";
         grid[0][9] = "c";
         grid[1][1] = "c";
         grid[1][2] = "w";
         grid[1][4] = "c";
         grid[1][5] = "w";
         grid[1][8] = "w";
         grid[2][0] = "m";
         grid[2][1] = "w";
         grid[2][2] = "w";
         grid[2][3] = "m";
         grid[2][4] = "w";
         grid[2][5] = "w";
         grid[2][6] = "w";
         grid[2][7] = "m";
         grid[3][2] = "m";
         grid[3][4] = "m";
         grid[3][7] = "w";
         grid[4][1] = "c";
         grid[4][2] = "w";
         grid[4][3] = "m";
         grid[4][4] = "c";
         grid[4][5] = "m";
         grid[4][7] = "w";
         grid[4][9] = "m";
         grid[5][0] = "m";
         grid[5][1] = "w";
         grid[5][2] = "w";
         grid[5][4] = "m";
         grid[5][7] = "w";
         grid[5][8] = "m";
         grid[5][9] = "c";
         grid[6][2] = "w";
         grid[6][6] = "h";
         grid[6][7] = "w";
         grid[6][9] = "m";
         grid[7][2] = "m";
         grid[7][3] = "w";
         grid[7][4] = "w";
         grid[7][5] = "w";
         grid[7][6] = "w";
         grid[7][7] = "c";
         grid[7][8] = "m";
         grid[8][1] = "w";
         grid[8][5] = "m";
         grid[8][7] = "m";
         grid[9][0] = "c";
         grid[9][4] = "m";
         grid[9][5] = "c";
         grid[9][6] = "m";
         grid[9][9] = "s";
         } // end if
      else if( gridRand == 4 )
        {
         grid[0][0] = "h";
         grid[0][3] = "m";
         grid[0][6] = "m";
         grid[0][7] = "c";
         grid[0][8] = "c";
         grid[0][9] = "m";
         grid[1][3] = "m";
         grid[1][7] = "m";
         grid[1][8] = "m";
         grid[2][0] = "w";
         grid[2][1] = "w";
         grid[2][2] = "w";
         grid[2][3] = "w";
         grid[2][4] = "w";
         grid[3][0] = "c";
         grid[3][1] = "m";
         grid[3][2] = "m";
         grid[3][3] = "c";
         grid[3][4] = "w";
         grid[3][5] = "m";
         grid[3][9] = "w";
         grid[4][0] = "m";
         grid[4][3] = "m";
         grid[4][4] = "w";
         grid[4][5] = "c";
         grid[4][6] = "w";
         grid[4][8] = "m";
         grid[4][9] = "c";
         grid[5][4] = "w";
         grid[5][5] = "m";
         grid[5][6] = "w";
         grid[5][9] = "w";
         grid[6][3] = "m";
         grid[6][8] = "m";
         grid[6][9] = "c";
         grid[7][0] = "w";
         grid[7][1] = "w";
         grid[7][2] = "w";
         grid[7][9] = "w";
         grid[8][2] = "m";
         grid[8][5] = "m";
         grid[8][7] = "m";
         grid[8][9] = "m";
         grid[9][0] = "s";
         grid[9][2] = "m";
         grid[9][4] = "w";
         grid[9][5] = "c";
         grid[9][6] = "w";
         grid[9][7] = "c";
         grid[9][8] = "w";
         grid[9][9] = "c";
        } // end if
      else if( gridRand == 5 )
         {
         grid[0][0] = "s";
         grid[0][3] = "m";
         grid[0][6] = "m";
         grid[0][8] = "w";
         grid[1][1] = "m";
         grid[1][3] = "w";
         grid[1][4] = "w";
         grid[1][6] = "c";
         grid[1][7] = "w";
         grid[2][2] = "w";
         grid[2][3] = "w"; // chest?
         grid[2][4] = "w";
         grid[2][5] = "m";
         grid[2][6] = "w";
         grid[2][7] = "c";
         grid[2][8] = "m";
         grid[3][0] = "w";
         grid[3][2] = "w";
         grid[3][3] = "w";
         grid[3][6] = "m";
         grid[3][7] = "w";
         grid[4][1] = "w";
         grid[4][2] = "c";
         grid[4][3] = "m";
         grid[4][5] = "m";
         grid[4][6] = "m";
         grid[4][7] = "c";
         grid[4][8] = "w";
         grid[5][0] = "m";
         grid[5][1] = "c";
         grid[5][2] = "w";
         grid[5][5] = "w";
         grid[5][6] = "c";
         grid[5][7] = "w";
         grid[6][1] = "w";
         grid[6][2] = "c";
         grid[6][3] = "m";
         grid[6][4] = "m";
         grid[6][5] = "c";
         grid[6][6] = "w";
         grid[6][7] = "c";
         grid[6][8] = "m";
         grid[7][2] = "w";
         grid[7][5] = "w";
         grid[7][6] = "c";
         grid[7][7] = "g";
         grid[7][8] = "w";
         grid[8][1] = "w";
         grid[8][2] = "c";
         grid[8][3] = "w";
         grid[8][6] = "m";
         grid[8][7] = "w";
         grid[9][4] = "m";
         grid[9][7] = "m";
         grid[9][9] = "h";
      } // end if
      return grid;
      } // end method getGrid
   
   
   
   
   
   /** creates a grid with JUST the Hero
    * @param the grid layout
    * @param the Hero
    * @return 2D Hero grid with hero in starting position
    */
   public static Hero[][] createHeroGrid( String[][] grid, Hero h )
      {
      Hero[][] heroGrid = new Hero[ grid.length ][ grid[0].length ];
      for( int r = 0; r < grid.length; r++ )
         {
         for( int c = 0; c < grid[r].length; c++ )
            {
            if( grid[r][c] != null )
               {
               if( grid[r][c].equals( "h" ) )
                  {
                  heroGrid[r][c] = h;
                  break;
                  } // end if
               } // end if
            } // end for
         } // end for
         
      return heroGrid;
      } // end method createHeroGrid
   
   /**finds the location of the Hero in the HeroGrid
    * @param heroGrid with Hero in it
    * @return ROW of hero location
    */
   public static int getHeroRow( Hero[][] heroGrid )
      {
      for( int r = 0; r < heroGrid.length; r++ )
         {
         for( int c = 0; c < heroGrid[r].length; c++ )
            {
            if( heroGrid[r][c] != null )
               {
               return r;
               } // end if
            } // end for
         } // end for
      return -1;
      } // end method getHeroRow
   /**finds the location of the Hero in the HeroGrid
    * @param heroGrid with Hero in it
    * @return COLUMN of hero location
    */
   public static int getHeroCol( Hero[][] heroGrid )
      {
      int heroR = getHeroRow( heroGrid );
      for( int c = 0; c < heroGrid[heroR].length; c++ )
         {
         if( heroGrid[heroR][c] != null )
            {
            return c;
            } // end if
         } // end for
      return -1;
      } // end method getHeroCol
   
   /**creates all the Objects in the dungeon
    * @param the grid layout
    * @param the current floorLevel
    * @return 2D array with all the DungeonObjects initialized
    */
   public static DungeonObject[][] createDungeon( String[][] grid, int floorLvl )
      {
      DungeonObject[][] dungeon = new DungeonObject[ grid.length ][ grid[0].length ];
      for( int r = 0; r < grid.length; r++ )
         {
         for( int c = 0; c < grid[r].length; c++ )
            {
            if( grid[r][c] != null )
               {
               if( grid[r][c].equals( "m" ) )
                  {
                  dungeon[r][c] = createMonster( floorLvl );
                  } // end if
               else if( grid[r][c].equals( "w" ) )
                  {
                  dungeon[r][c] = new Wall();
                  } // end if
               else if( grid[r][c].equals( "c" ) )
                  {
                  int GCrand = (int) ( Math.random() * 20 );
                  if( GCrand == 0 )
                     {
                     dungeon[r][c] = new GoldChest();
                     } // end if
                  else
                     {
                     dungeon[r][c] = new Chest();
                     } // end else
                  } // end if
               else if( grid[r][c].equals( "g" ) )
                  {
                  dungeon[r][c] = new GoldChest();
                  } // end if
               else if( grid[r][c].equals( "s" ) )
                  {
                  dungeon[r][c] = new Stairs();
                  } // end if
               } // end if
            } // end for
         } // end for
      
      return dungeon;
      } // end method createDungeon
   
   
   /**
    * creates a monster, randomized depending on what the current floor level is
    * @param current floor level
    * @return Monster created
    */
   private static Monster createMonster( int floorLvl )
      {
      Monster m = null;
      int rand = (int) (Math.random() * 4) + floorLvl - 3;
      if( rand <= 0 )
         m = new Skeleton();
      else if( rand == 1 )
         m = new Beasty();
      else if( rand == 2 )
         m = new WhiteKnight();
      else if( rand == 3 )
         m = new DarkKnight();
      else if( rand == 4 )
         m = new Schr�dingersCat();
      else if( rand == 5 )
         m = new Ogre();
      else if( rand == 6 )
         m = new Vampire();
      else if( rand == 7 )
         m = new WaterElemental();
      else if( rand == 8 )
         m = new AirElemental();
      else if( rand == 9 )
         m = new EarthElemental();
      else if( rand == 10 )
         m = new FireElemental();
      else if( rand == 11 )
         m = new Satyr();
      else if( rand == 12 )
         m = new Mimic();
      else
         m = new Dragon();
      
      return m;
      } // end method createMonster
   } // end class GridCreator