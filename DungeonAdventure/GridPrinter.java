import javax.swing.*;
import java.awt.*;

public final class GridPrinter
   {
   /**
    * Prints the dungeon grid in a text format
    * Only used in original testing of program before animation was used
    * @param 2D String array of the grid
    */
   public static void printGrid( String[][] grid )
      {
      String[][] grid2 = new String[ grid.length ][ grid[0].length ];
      for( int r = 0; r < grid.length; r++ )
         {
         for( int c = 0; c < grid[r].length; c ++ )
            {
            if( grid[r][c] != null )
               {
               if( grid[r][c].equals( "hero" ) )
                  {
                  grid2[r][c] = "H";
                  } // end if
               else if( grid[r][c].equals( "monster" ) )
                  {
                  grid2[r][c] = "m";
                  } // end if
               else if( grid[r][c].equals( "wall" ) )
                  {
                  grid2[r][c] = "w";
                  } // end if
               else if( grid[r][c].equals( "chest" ) )
                  {
                  grid2[r][c] = "c";
                  } // end if
               else if( grid[r][c].equals( "goldChest" ) )
                  {
                  grid2[r][c] = "g";
                  } // end if
               else if( grid[r][c].equals( "stairs" ) )
                  {
                  grid2[r][c] = "s";
                  } // end if
               } // end if
            else
               {
               grid2[r][c] = " ";
               } // end else
            } // end for
         } // end for
      
      //System.out.print( (char) 12 );
      
      for( int r = 0; r < grid2.length; r++ )
         {
         for( int c = 0; c < grid2[r].length; c ++ )
            {
            System.out.print( grid2[r][c] + " " );
            } // end for
         System.out.println();
         } // end for
         
      
      System.out.print( "\n\n\n\n\n\n\n" );
      } // end method printGrid
   
   
   /**
    * Prints the dungeon grid in a text format
    * Only used in original testing of program before animation was used
    * @param dungeon 2D array
    * @param 2D array with the Hero
    * @param the current floor level
    */
   public static void printGrid( DungeonObject[][] dungeon, Hero[][] heroGrid, int f )
      {
      String[][] dungeon2 = new String[ dungeon.length ][ dungeon[0].length ];
      Hero hero = null;
      
      for( int r = 0; r < dungeon.length; r++ )
         {
         for( int c = 0; c < dungeon[r].length; c ++ )
            {
            if( dungeon[r][c] != null )
               {
               if( dungeon[r][c] instanceof Monster )
                  {
                  dungeon2[r][c] = "m";
                  } // end if
               if( dungeon[r][c] instanceof Wall )
                  {
                  dungeon2[r][c] = "w";
                  } // end if
               if( dungeon[r][c] instanceof Chest )
                  {
                  dungeon2[r][c] = "c";
                  Chest chest = (Chest) dungeon[r][c];
                  if( chest.getIsOpen() == true )
                     {
                     dungeon2[r][c] = "o";
                     } // end if
                  } // end if
               if( dungeon[r][c] instanceof GoldChest )
                  {
                  dungeon2[r][c] = "g";
                  Chest chest = (Chest) dungeon[r][c];
                  if( chest.getIsOpen() == true )
                     {
                     dungeon2[r][c] = "o";
                     } // end if
                  } // end if
               if( dungeon[r][c] instanceof Stairs )
                  {
                  dungeon2[r][c] = "s";
                  } // end if
               } // end if
            if( heroGrid[r][c] != null )
               {
               if( heroGrid[r][c] instanceof Hero )
                  {
                  dungeon2[r][c] = "H";
                  hero = heroGrid[r][c];
                  } // end if
               } // end if
            } // end for
         } // end for
      
      //System.out.print( (char) 12 );
      System.out.println( "Floor Level: " + f + "\n" );
      
      for( int r = 0; r < dungeon2.length; r++ )
         {
         for( int c = 0; c < dungeon2[r].length; c ++ )
            {
            if( dungeon2[r][c] != null )
               {
               System.out.print( dungeon2[r][c] + " " );
               } // end if
            else
               {
               System.out.print( "  " );
               } // end else
            } // end for
         System.out.println();
         } // end for
         
         
      System.out.println( "\n" + hero + "\n\n\n\n");
      } // end method printGrid
   
   
   
   } // end class GridPrinter