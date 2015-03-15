import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GUI extends JFrame implements KeyListener//, ActionListener
   {
   private static GUI thisGUI;
   private static DungeonPanel dungeonPanel;
   private static StatsPanel heroStats;
   private static boolean fogOfWar;
   
   private DungeonObject[][] dungeon;
   private Hero[][] heroGrid;
   private static Hero hero;
   private int oldHeroR;
   private int oldHeroC;
   private int heroR;
   private int heroC;
   private static int floorLvl;
   
   private static Monster currentBattleMonster;
   
   private static final int UP;
   private static final int DOWN;
   private static final int LEFT;
   private static final int RIGHT;
   
   static
      {
      UP = 1;
      DOWN = 2;
      LEFT = 3;
      RIGHT = 4;
      } // end static
   
   public GUI( Hero h, boolean fogOfWar )
      {
      this.fogOfWar = fogOfWar;
      hero = h;
      setUpGame();
      } // end constructor GUI
   public GUI()
      {
      setUpGame();
      } // end constructor GUI
   
      
   /**
    * initializes the DungeonGrid and the frame,
    * starts the KeyListener and creates the dungeonPanel
    * @param title of the game
    * @param the Hero to be used in the game
    * @param if the game will have fog of war or not
    */
   private void setUpGame()
      {
      thisGUI = this;
      floorLvl = 1;
      String[][] grid = GridCreator.getGrid();
      dungeon = GridCreator.createDungeon( grid, floorLvl );
      heroGrid = GridCreator.createHeroGrid( grid, hero );
      heroR = GridCreator.getHeroRow( heroGrid );
      heroC = GridCreator.getHeroCol( heroGrid );
      //GridPrinter.printGrid( grid );
      
      setTitle( "DungeonAdventure" );
      setSize( 640, 423 );
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      setResizable( false );
      setLocationRelativeTo( null );
      addKeyListener( this );
      
      dungeonPanel = new DungeonPanel();
      setBackground( Color.gray );
      getContentPane().add( BorderLayout.CENTER, dungeonPanel );
      
      heroStats = new StatsPanel( hero, floorLvl );
      heroStats.refreshStats( floorLvl );
      getContentPane().add( BorderLayout.EAST, heroStats );
      
      setFocusable( true );
      setVisible(true);
      
      //thread = new Thread( this );
      //thread.start();
      } // end method setUpGame
   
   
   public void keyTyped ( KeyEvent e )
      {
      if( e.getKeyChar() == (char) 78 ) // "N"
         {
         //l1.setText( "CHEATER" );
         Stairs stairs = new Stairs();
         floorLvl = stairs.goUpstairs( floorLvl );
         createNewFloor();
         } // end CHEATER if
      } // end method keyTyped
   
   public void keyReleased ( KeyEvent e )
      {
      //l1.setText( "Key Listener" );
      } // end method keyReleased
   
   /**
    * Listens for a keyPressed event.
    * can exit Game with esc,
    * Can move with arrows or WASD
    * repaints the screen when moved
    */
   public void keyPressed ( KeyEvent e )
      {
      if( e.getKeyCode() == KeyEvent.VK_ESCAPE )
         {
         System.exit(0);
         } // end CLOSE if
      
      boolean triedToMove = false;
      boolean hasMoved = false;
      
      if( e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W )
         {
         hasMoved = move( UP );
         triedToMove = true;
         } // end if
      else if( e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S )
         {
         hasMoved = move( DOWN );
         triedToMove = true;
         } // end if
      else if( e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A )
         {
         hasMoved = move( LEFT );
         triedToMove = true;
         } // end if
      else if( e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D )
         {
         hasMoved = move( RIGHT );
         triedToMove = true;
         } // end if
      
      
      if( triedToMove ) // so that the chest is refreshed if opened
         {
         if( hasMoved )
            {
            oldHeroR = heroR;
            oldHeroC = heroC;
            heroR = GridCreator.getHeroRow( heroGrid );
            heroC = GridCreator.getHeroCol( heroGrid );
            checkForStairs();
            checkForMonster();
            //GridPrinter.printGrid( dungeon, heroGrid, floorLvl );
            } // end if
         heroStats.refreshStats( floorLvl );
         dungeonPanel.repaint();
         } // end if
      } // end method keyPressed
      
   /**
    * Moves the Hero in the direction wanted if the Hero is not blocked
    * @param the direction the Hero is trying to move
    * @return whether the Hero has changed his place in the dungeon
    */
   private boolean move( int direction )
      {
      if( direction == UP && heroR != 0 )
         {
         if( canMove( dungeon[heroR - 1][heroC] ) )
            {
            heroGrid[heroR - 1][heroC] = hero;
            heroGrid[heroR][heroC] = null;
            return true;
            } // end if
         } // end if
      else if( direction == DOWN && heroR != 9 )
         {
         if( canMove( dungeon[heroR + 1][heroC] ) )
            {
            heroGrid[heroR + 1][heroC] = hero;
            heroGrid[heroR][heroC] = null;
            return true;
            } // end if
         } // end if
      else if( direction == LEFT && heroC != 0 )
         {
         if( canMove( dungeon[heroR][heroC - 1] ) )
            {
            heroGrid[heroR][heroC - 1] = hero;
            heroGrid[heroR][heroC] = null;
            return true;
            } // end if
         } // end if
      else if( direction == RIGHT && heroC != 9 )
         {
         if( canMove( dungeon[heroR][heroC + 1] ) )
            {
            heroGrid[heroR][heroC + 1] = hero;
            heroGrid[heroR][heroC] = null;
            return true;
            } // end if
         } // end if
      return false;
      } // end method move
   
   /**
    * Checks whether the Hero can move to the moveLocation
    * If the moveLocation has a chest, the Chest is opened
    * @param the object in the location the Hero is trying to move to
    * @return if the path is blocked
    */
   private boolean canMove( DungeonObject moveLocationObject )
      {
      if( moveLocationObject == null )
         {
         return true;
         } // end if
      else if( moveLocationObject instanceof Chest )
         {
         Chest chest = (Chest) moveLocationObject;
         if( chest.getIsOpen() == false )
            {
            hero.equip( chest.openChest( floorLvl, hero ) );
            } // end if
         } // end if
      return !moveLocationObject.getPathBlocked();
      } // end method canMove
   
   /**
    * checks if the Hero occupies the same space as a Monster
    * Starts a battle if it does
    */
   private void checkForMonster()
      {
      if( dungeon[heroR][heroC] != null )
         {
         if( dungeon[heroR][heroC] instanceof Monster )
            {
            setFocusable( false );
            currentBattleMonster = (Monster)(dungeon[heroR][heroC]);
            Battle.startBattle( hero, currentBattleMonster, this, floorLvl );
            //boolean heroWin = Battle.startBattle( hero,
            //                  (Monster)(dungeon[heroR][heroC]), floorLvl );
            //setFocusable( true );
            //if( heroWin )
            //   {
            //   dungeon[heroR][heroC] = null;
            //   } // end if
            } // end if
         } // end if
      
      }
   
   public void battleFinished( boolean heroWin )
      {
      setFocusable( true );
      if( heroWin )
         {
         dungeon[heroR][heroC] = null;
         } // end if
      currentBattleMonster = null;
      repaint();
      heroStats.refreshStats( floorLvl );
      } // end method battleFinished
      
   /**
    * checks if the Hero occupies the same space as a Stairs
    * Creates a new dungeon room and goes up one floor if it does
    */
   private void checkForStairs()
      {
      if( dungeon[heroR][heroC] != null )
         {
         if( dungeon[heroR][heroC] instanceof Stairs )
            {
            Stairs stairs = (Stairs) ( dungeon[heroR][heroC] );
            floorLvl = stairs.goUpstairs( floorLvl );
            createNewFloor();
            } // end if
         } // end if
      } // end method checkForStairs
   
   private void createNewFloor()
      {
      String[][] grid = GridCreator.getGrid();
      dungeon = GridCreator.createDungeon( grid, floorLvl );
      heroGrid = GridCreator.createHeroGrid( grid, hero );
      heroR = GridCreator.getHeroRow( heroGrid );
      heroC = GridCreator.getHeroCol( heroGrid );
      
      //GridPrinter.printGrid( grid );
      getContentPane().remove( dungeonPanel );
      dungeonPanel = new DungeonPanel();
      setBackground( Color.black );
      setBackground( Color.gray );
      getContentPane().add( BorderLayout.CENTER, dungeonPanel );
      setVisible( true );
      heroStats.refreshStats( floorLvl );
      } // end method createNewFloor
   
   public static void gameOver()
      {
      String gameOver = "GAME OVER\n" +
                      "\nCONTINUE?";
      int restart = JOptionPane.showConfirmDialog( null, gameOver, 
         "You Died", JOptionPane.YES_NO_OPTION, 
         JOptionPane.ERROR_MESSAGE );
      if( restart == JOptionPane.YES_OPTION )
         {
         hero.setHP( hero.getMaxHP() );
         hero.setSP( hero.getMaxSP() );
         hero.setStartingEquips();
         heroStats.refreshStats( floorLvl );
         thisGUI.dispose();
         thisGUI = new GUI();
         } // end if
      else
         {
         System.exit(0);
         } // end else
      } // end method gameOver()
   
   
   
   
   
   /**
    * An inner class that is the panel with the dungeon animation
    */
   private class DungeonPanel extends JPanel
      {  
      private Image[][] floors;
      private Image[][] floorsModifier;
      private boolean[][] hasBeenExplored;
      
      /**
       * sets the floor Images for the current room
       */
      public DungeonPanel()
         {
         setSize( new Dimension( 400, 400 ) );
         setBorder( BorderFactory.createLineBorder( Color.black ));
         
         hasBeenExplored = new boolean[dungeon.length][dungeon[0].length];
         
         floors = new Image[dungeon.length][dungeon[0].length];
         floorsModifier = new Image[dungeon.length][dungeon[0].length];
         for( int r = 0; r < dungeon.length; r++ )
            {
            for( int c = 0; c < dungeon[r].length; c++ )
               {
               int floorRand = (int) (Math.random() * 3 );
               floors[r][c] = new ImageIcon( "FloorBase" + floorRand + ".png" ).getImage();
               int modifierRand = (int) (Math.random() * 10 );
               floorsModifier[r][c] = new ImageIcon( "FloorModifier"
                     + modifierRand + ".png" ).getImage();
               
               hasBeenExplored[r][c] = false;
               } // end for
            } // end for
         } // end constructor DungeonPanel
      
      /**
       * refreshes the dungeon graphics by placing images on the grid
       * call repaint() to refresh the dungeon
       * @param graphics
       */
      public void paintComponent( Graphics g )
         {
         int rStart;
         int rLength;
         int cStart;
         int cLength;
         if( fogOfWar )
            {
            rStart = heroR - 2;
            rLength = heroR + 3;
            cStart = heroC - 2;
            cLength = heroC + 3;
            if( rStart < 0 )
               {
               rStart = 0;
               } // end if
            if( cStart < 0 )
               {
               cStart = 0;
               } // end if
            } // end if
         else
            {
            rStart = 0;
            rLength = dungeon.length;
            cStart = 0;
            cLength = dungeon[0].length;
            } // end else
            
         
         for( int r = rStart; r < rLength && r < dungeon.length; r++ )
            {
            for( int c = cStart; c < cLength && c < dungeon[r].length; c++ )
               {
               hasBeenExplored[r][c] = true;
               drawSquare( g, r, c );
               } // end for
            } // end for
         
         if( fogOfWar )
            {
            for( int r = 0; r < dungeon.length; r++ )
               {
               for( int c = 0; c < dungeon[r].length; c++ )
                  {
                  if( hasBeenExplored[r][c] )
                     {
                     drawSquare( g, r, c );
                     } // end if
                  } // end for
               } //end for
            } // end if
         } // end method paintComponent
      
      private void drawSquare( Graphics g, int r, int c )
         {
         g.drawImage( floors[r][c], c*40, r*40, null );
         g.drawImage( floorsModifier[r][c], c*40, r*40, null );
         if( heroGrid[r][c] != null )
            {
            Image image = new ImageIcon( heroGrid[r][c].getImage() ).getImage();
            g.drawImage( image, c*40, r*40, null );
            } // end if
         else if( dungeon[r][c] != null )
            {
            Image image = new ImageIcon( dungeon[r][c].getImage() ).getImage();
            g.drawImage( image, c*40, r*40, null );
            } // end else
         
         if( dungeon[r][c] != null && dungeon[r][c] instanceof Wall )
            {
            drawWall( g, r, c );
            } // end if
         } // end method drawSquare
      
      /**contains all the wall images, and the tests to see which images should be drawn
       * @param the Graphics g from paintComponent to allow drawing
       * @param current row of for loop
       * @param current column of for loop
       */
      private void drawWall( Graphics g, int r, int c )
         {
         // does not include main wall image
         if( r == 0 || dungeon[r-1][c] instanceof Wall )
            {
            Image wallImage = new ImageIcon( "WallUp.png" ).getImage();
            g.drawImage( wallImage, c*40, r*40, null );
            } // end if
         if( r == 9 || dungeon[r+1][c] instanceof Wall )
            {
            Image wallImage = new ImageIcon( "WallDown.png" ).getImage();
            g.drawImage( wallImage, c*40, r*40, null );
            } // end if
         if( c == 0 || dungeon[r][c-1] instanceof Wall )
            {
            Image wallImage = new ImageIcon( "WallLeft.png" ).getImage();
            g.drawImage( wallImage, c*40, r*40, null );
            } // end if
         if( c == 9 || dungeon[r][c+1] instanceof Wall )
            {
            Image wallImage = new ImageIcon( "WallRight.png" ).getImage();
            g.drawImage( wallImage, c*40, r*40, null );
            } // end if
         if( r == 0 || c == 0 || dungeon[r-1][c-1] instanceof Wall
                    || dungeon[r-1][c-1] instanceof Chest )
            {
            Image wallImage = new ImageIcon( "WallUpLeft.png" ).getImage();
            g.drawImage( wallImage, c*40, r*40, null );
            } // end if
         if( r == 0 || c == 9 || dungeon[r-1][c+1] instanceof Wall
                    || dungeon[r-1][c+1] instanceof Chest )
            {
            Image wallImage = new ImageIcon( "WallUpRight.png" ).getImage();
            g.drawImage( wallImage, c*40, r*40, null );
            } // end if
         if( r == 9 || c == 0 || dungeon[r+1][c-1] instanceof Wall
                    || dungeon[r+1][c-1] instanceof Chest )
            {
            Image wallImage = new ImageIcon( "WallDownLeft.png" ).getImage();
            g.drawImage( wallImage, c*40, r*40, null );
            } // end if
         if( r == 9 || c == 9 || dungeon[r+1][c+1] instanceof Wall
                    || dungeon[r+1][c+1] instanceof Chest )
            {
            Image wallImage = new ImageIcon( "WallDownRight.png" ).getImage();
            g.drawImage( wallImage, c*40, r*40, null );
            } // end if
         } // end method drawWall
         
      public Image getFloorImage1( int r, int c )
         {
         return floors[r][c];
         } // end method getFloorImage1
      public Image getFloorImage2( int r, int c )
         {
         return floorsModifier[r][c];
         } // end method getFloorImage2
      } // end class DungeonPanel
   
   public Image[] getBattleFloorImages()
      {
      Image[] images = new Image[4];
      images[0] = dungeonPanel.getFloorImage1( oldHeroR, oldHeroC );
      images[1] = dungeonPanel.getFloorImage2( oldHeroR, oldHeroC );
      images[2] = dungeonPanel.getFloorImage1( heroR, heroC );
      images[3] = dungeonPanel.getFloorImage2( heroR, heroC );
      return images;
      } // end method getBattleFloorImages
   
   } // end class GUI