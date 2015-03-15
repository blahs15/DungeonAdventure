import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class BattleScreen extends JFrame implements ActionListener, KeyListener
   {
   private Hero hero;
   private Monster monster;
   
   private FightPanel fightPanel;
   private JPanel attackPanel;
   private StatsPanel statsPanel;
   private ArrayList<JButton> attackButtons;
   
   private Image[] floorImages;
   
   private int heroX;
   private int heroY;
   private int monsterX;
   private int monsterY;
   // booleans for attack moves are at the bottom
   
   /**initializes frame, hero, and Monster
    * @param Hero
    * @param Monster hero is battling
    * @param main Thread (not currently being used)
    */
   public BattleScreen( Hero h, Monster m, GUI gui )
      {
      hero = h;
      monster = m;
      
      floorImages = gui.getBattleFloorImages();
      
      setTitle( "Battle with " + monster.getName() );
      setLayout( new BorderLayout() );
      setSize( 640, 261 - 38 ); //23Y top, 400Xx200Y pics, 240X labels, 38Y button panel
      setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
      setResizable( false );
      setLocationRelativeTo( null );
      createAttackPanel();
      addKeyListener( this );
      
      statsPanel = new StatsPanel( h );
      statsPanel.setSize( new Dimension( 240, 600 ) );
      getContentPane().add( BorderLayout.EAST, statsPanel );
      
      fightPanel = new FightPanel();
      getContentPane().add( BorderLayout.CENTER, fightPanel );
      
      fightPanel.start();
      
      setFocusable( true );
      setVisible( true );
      
      } // end constructor BattleScreen
   
   /**creates the attackPanel with attack move buttons placed on battleScreen
    * BUG: buttons don't show up if there is no room for it
    *  - can increase frame size to see buttons
    */
   public void createAttackPanel()
      {
      ArrayList<String> moveNames = hero.getMoves();
      attackPanel = new JPanel();
      attackPanel.setLayout( new GridLayout( 0, 4, 20, 8 ) );
      attackButtons = new ArrayList<JButton>();
      for( int index = 0; index < moveNames.size(); index++ )
         {
         attackButtons.add( new JButton( moveNames.get(index)  + " (" + (index+1) + ")" ) );
         if( index != 0 && index % 4 == 0 )
            {
            setSize( getSize().width, getSize().height + 37 );
            }  // end if
         else if( index == 0 )
            {
            setSize( getSize().width, getSize().height + 28 );
            } // end if
         } // end for
      for( JButton a : attackButtons )
         {
         attackPanel.add( a );
         a.addActionListener( this );
         } // end for
      attackPanel.setBackground( Color.gray );
      getContentPane().add( BorderLayout.SOUTH, attackPanel );
      //attackPanel.setBounds( 0, 200, 300, 300 );
      setVisible( true );
      attackButtons.get( 2 ).setFocusable( true );
      } // end method createAttackPanel
      
   public void refreshStatsPanel()
      {
      statsPanel.refreshStats();
      } // end method refreshStatsPanel()
   
   /**Listener to what attack move button was pressed
    * calls the chooseMove method in Hero depending on which attack button was pressed
    * @param button pressed event
    */
   public void actionPerformed( ActionEvent event )
      {
      if( event.getSource() == attackButtons.get(0) )
         {
         hero.chooseMove( 0, monster );
         } // end if
      else if( event.getSource() == attackButtons.get(1) )
         {
         hero.chooseMove( 1, monster );
         } // end if
      else if( event.getSource() == attackButtons.get(2) )
         {
         hero.chooseMove( 2, monster );
         } // end if
      else if( event.getSource() == attackButtons.get(3) )
         {
         hero.chooseMove( 3, monster );
         } // end if
      else if( event.getSource() == attackButtons.get(4) )
         {
         hero.chooseMove( 4, monster );
         } // end if
      else if( event.getSource() == attackButtons.get(5) )
         {
         hero.chooseMove( 5, monster );
         } // end if
      else if( event.getSource() == attackButtons.get(6) )
         {
         hero.chooseMove( 6, monster );
         } // end if
      
      statsPanel.refreshStats();
      }
   
   public void keyTyped ( KeyEvent e )
      {
      } // end method keyTyped
   
   public void keyReleased ( KeyEvent e )
      {
      } // end method keyReleased
   
   /**meant to be a shortcut to buttons
    * press a number key correlating with each button
    * is not currently working
    * @param key pressed
    */
   public void keyPressed ( KeyEvent e )
      {
      if( e.getKeyCode() == KeyEvent.VK_1 )
         {
         try{
            actionPerformed( new ActionEvent( attackButtons.get(0),
               ActionEvent.ACTION_PERFORMED, null ) );
            } catch( Exception ex ) {}
         } // end if
      else if( e.getKeyCode() == KeyEvent.VK_2 )
         {
         try{
            actionPerformed( new ActionEvent( attackButtons.get(1),
               ActionEvent.ACTION_PERFORMED, null ) );
            } catch( Exception ex ) {}
         } // end if
      else if( e.getKeyCode() == KeyEvent.VK_3 )
         {
         try{
            actionPerformed( new ActionEvent( attackButtons.get(2),
               ActionEvent.ACTION_PERFORMED, null ) );
            } catch( Exception ex ) {}
         } // end if
      else if( e.getKeyCode() == KeyEvent.VK_4 )
         {
         try{
            actionPerformed( new ActionEvent( attackButtons.get(3),
               ActionEvent.ACTION_PERFORMED, null ) );
            } catch( Exception ex ) {}
         } // end if
      else if( e.getKeyCode() == KeyEvent.VK_5 )
         {
         try{
            actionPerformed( new ActionEvent( attackButtons.get(4),
               ActionEvent.ACTION_PERFORMED, null ) );
            } catch( Exception ex ) {}
         } // end if
      else if( e.getKeyCode() == KeyEvent.VK_6 )
         {
         try{
            actionPerformed( new ActionEvent( attackButtons.get(5),
               ActionEvent.ACTION_PERFORMED, null ) );
            } catch( Exception ex ) {}
         } // end if
      else if( e.getKeyCode() == KeyEvent.VK_7 )
         {
         try{
            actionPerformed( new ActionEvent( attackButtons.get(6),
               ActionEvent.ACTION_PERFORMED, null ) );
            } catch( Exception ex ) {}
         } // end if
      } // end method keyPressed
   
   private class FightPanel extends JPanel implements Runnable
      {
      private Thread runner;
      private int pause;
      private boolean heroTurn;
      /** attack booleans are below this inner class
       * the methods to set the attack booleans to true are also below
       */
      private boolean hasMoved;
      private boolean hasDodged;
      private int shootImageX;
      private int counter;
      private int counterMax;
      
      public FightPanel()
         {
         setBackground( Color.darkGray );
         setSize( 400, 200 );
         setBorder( BorderFactory.createLineBorder( Color.black ));
         
         heroX = 0;
         heroY = 0;
         monsterX = 200;
         monsterY = 0;
         
         pause = 3;
         
         hasMoved = false;
         moveHForward = false;
         moveMForward = false;
         hasDodged = false;
         dodgeH = false;
         dodgeM = false;
         shootHToM = false;
         shootMToH = false;
         shootImageX = -300;
         flashOnSelfH = false;
         flashOnSelfM = false;
         flashImageOnH = false;
         flashImageOnM = false;
         counter = 0;
         counterMax = 150;
         } // end constructor FightPanel
      
      public void start()
         {
         if( runner == null )
            {
            runner = new Thread(this);
            runner.start();
            } // end if
         } // end method start
      
      public void run()
         {
         Thread thisThread = Thread.currentThread();
         while ( runner != null )
            {
            if( flashOnSelfH || moveHForward || shootHToM || flashImageOnM )
               heroTurn = true;
            else
               heroTurn = false;
            
            if( heroTurn )
               {
               /** move hero forward and back */
               if( moveHForward )
                  moveHForward();
               /** an image going towards monster */
               else if( shootHToM )
                  shootHToM();
               /** image flashes over monster */
               else if( flashImageOnM )
                  flashImageOnM();
               /** flashes image on hero */
               else if( flashOnSelfH )
                  flashOnSelfH();
               } // end if
            
            else
               {
               /** move monster forward and back */
               if( moveMForward )
                  moveMForward();
               /** an image going towards hero */
               else if( shootMToH && !dodgeM)
                  shootMToH();
               /** image flashes over hero */
               else if( flashImageOnH )
                  flashImageOnH();
               /** flashes image on monster */
               else if( flashOnSelfM )
                  flashOnSelfM();
               } // end else
            
            if( dodgeM && !dodgeMDelay )
               {
               dodgeM();
               } // end if
            else if ( dodgeH && !heroTurn && !dodgeHDelay )
               {
               dodgeH();
               } // end if
            
            
            repaint();
            try {
                thisThread.sleep(pause);
                } // end try
            catch (InterruptedException e) {} // end catch
            } // end while
         } // end method run
      public void stop()
         {
         if( runner != null )
            {
            runner = null;
            } // end if
         } // end method stop
      
      public void paintComponent( Graphics g )
         {
         g.drawImage( floorImages[0], 0, 0, 200, 200, null );
         g.drawImage( floorImages[1], 0, 0, 200, 200, null );
         g.drawImage( floorImages[2], 200, 0, 200, 200, null );
         g.drawImage( floorImages[3], 200, 0, 200, 200, null );
         
         Image monsterImage = new ImageIcon( monster.getBattleImage() ).getImage();
         g.drawImage( monsterImage, monsterX, monsterY, 200, 200, null );
         Image heroImage = new ImageIcon( hero.getImage() ).getImage();
         g.drawImage( heroImage, heroX, heroY, 200, 200, null );
         
         Image healthBar = new ImageIcon( "HealthBar.png" ).getImage();
         g.drawImage( healthBar, 20, 180, 
            160*hero.getHP()/hero.getMaxHP(), 10, null );
         g.drawImage( healthBar, 220, 180, 
            160*monster.getHP()/monster.getMaxHP(), 10, null );
         Image manaBar = new ImageIcon( "ManaBar.png" ).getImage();
         g.drawImage( manaBar, 20, 190, 
            160*hero.getSP()/hero.getMaxSP(), 10, null );
         g.drawImage( manaBar, 220, 190, 
            160*monster.getSP()/monster.getMaxSP(), 10, null );
         Image healthBarBorder = new ImageIcon( "HealthBarBorder.png" ).getImage();
         g.drawImage( healthBarBorder, 20, 180, 160, 10, null );
         g.drawImage( healthBarBorder, 20, 190, 160, 10, null );
         g.drawImage( healthBarBorder, 220, 180, 160, 10, null );
         g.drawImage( healthBarBorder, 220, 190, 160, 10, null );
         
         if( heroTurn )
            {
            if( shootHToM )
               {
               Image i = new ImageIcon( shootImageHToM ).getImage();
               g.drawImage( i, shootImageX, 75, 150, 75, null );
               } // end if
            else if( flashImageOnM )
               {
               Image i;
               if( counter < counterMax / 2 )
                  i = new ImageIcon( imageOnM ).getImage();
               else
                  i = new ImageIcon( imageOnM2 ).getImage();
               if( shouldFlash(counter) )
                  g.drawImage( i, 200, 0, 200, 200, null );
               } // end if
            else if( flashOnSelfH )
               {
               Image i;// = new ImageIcon( imageOnSelfH ).getImage();
               if( counter < counterMax / 2 )
                  i = new ImageIcon( imageOnSelfH ).getImage();
               else
                  i = new ImageIcon( imageOnSelfH2 ).getImage();
               if( shouldFlash(counter) )
                  g.drawImage( i, heroX, heroY, 200, 200, null );
               } // end if
            } // end if
         else
            {
            if( shootMToH )
               {
               Image i = new ImageIcon( shootImageMToH ).getImage();
               g.drawImage( i, shootImageX, 75, 150, 75, null );
               } // end if
            else if( flashImageOnH )
               {
               Image i;
               if( counter < counterMax / 2 )
                  i = new ImageIcon( imageOnH ).getImage();
               else
                  i = new ImageIcon( imageOnH2 ).getImage();
               if( shouldFlash(counter) )
                  g.drawImage( i, 0, 0, 200, 200, null );
               } // end if
            else if( flashOnSelfM )
               {
               Image i;// = new ImageIcon( imageOnSelfM ).getImage();
               if( counter < counterMax / 2 )
                  i = new ImageIcon( imageOnSelfM ).getImage();
               else
                  i = new ImageIcon( imageOnSelfM2 ).getImage();
               if( shouldFlash(counter) )
                  g.drawImage( i, monsterX, monsterY, 200, 200, null );
               } // end if
            } // end if
         } // end method paintComponent
      private boolean shouldFlash( int counter )
         {
         if(( counter %3==0 || counter %4==0 || counter %5==0 || counter %7==0 
           || counter %11==0 || counter %13==0 ) && counter != 0 )
            return true;
         return false;
         } // end method shouldFlash
      
      
      private void moveHForward()
         {
         if( !hasMoved )
            heroX++;
         if( hasMoved && heroX > 0)
            heroX--;
         else if( hasMoved )
            {
            moveHForward = false;
            hasMoved = false;
            dodgeMDelay = false;
            } // end else if
         if( heroX >= 100 )
            hasMoved = true;
         } // end method moveHeroForward
      private void moveMForward()
         {
         if( !hasMoved )
            monsterX--;
         if( hasMoved && monsterX < 200)
            monsterX++;
         else if( hasMoved )
            {
            moveMForward = false;
            hasMoved = false;
            dodgeHDelay = false;
            } // end else if
         if( monsterX <= 100 )
            hasMoved = true;
         } // end method moveMForward
      
      private void dodgeH()
         {
         if( !hasDodged )
            heroX--;
         if( hasDodged && heroX < 0)
            heroX++;
         else if( hasDodged )
            {
            dodgeH = false;
            hasDodged = false;
            } // end else if
         if( heroX <= -100 )
            hasDodged = true;
         } // end method dodgeH
      private void dodgeM()
         {
         if( !hasDodged )
            monsterX++;
         if( hasDodged && monsterX > 200)
            monsterX--;
         else if( hasDodged )
            {
            dodgeM = false;
            hasDodged = false;
            } // end else if
         if( monsterX >= 300 )
            hasDodged = true;
         } // end method dodgeM
      
      private void shootHToM()
         {
         if( shootImageX == -300 )
            shootImageX = 100;
         else
            shootImageX++;
         if( shootImageX > 200 )
            {
            shootHToM = false;
            shootImageX = -300;
            dodgeMDelay = false;
            } // end if
         } // end method moveHToM
      private void shootMToH()
         {
         if( shootImageX == -300 )
            shootImageX = 150;
         else
            shootImageX--;
         if( shootImageX < 50 )
            {
            shootMToH = false;
            shootImageX = -300;
            dodgeHDelay = false;
            } // end if
         } // end method moveMToH()
      
      private void flashImageOnM()
         {
         counter++;
         if( counter > counterMax )
            {
            counter = 0;
            flashImageOnM = false;
            dodgeMDelay = false;
            } // end if
         } // end method flashImageOnM
      private void flashImageOnH()
         {
         counter++;
         if( counter > counterMax )
            {
            counter = 0;
            flashImageOnH = false;
            dodgeHDelay = false;
            } // end if
         } // end method flashImageOnH
      private void flashOnSelfH()
         {
         counter++;
         if( counter > counterMax )
            {
            counter = 0;
            flashOnSelfH = false;
            } // end if
         } // end method flashOnSelfM
      private void flashOnSelfM()
         {
         counter++;
         if( counter > counterMax )
            {
            counter = 0;
            flashOnSelfM = false;
            } // end if
         } // end method flashOnSelfM
      } // end class FightPanel
      
   public void stop()
      {
      fightPanel.stop();
      } // end method stop
   
   private static boolean moveHForward;
   private static boolean moveMForward;
   private static boolean dodgeH;
   private static boolean dodgeM;
   private static boolean dodgeHDelay;
   private static boolean dodgeMDelay;
   private static boolean shootHToM;
   private static String shootImageHToM;
   private static boolean shootMToH;
   private static String shootImageMToH;
   private static boolean flashOnSelfH;
   private static String imageOnSelfH;
   private static String imageOnSelfH2;
   private static boolean flashOnSelfM;
   private static String imageOnSelfM;
   private static String imageOnSelfM2;
   private static boolean flashImageOnH;
   private static String imageOnH;
   private static String imageOnH2;
   private static boolean flashImageOnM;
   private static String imageOnM;
   private static String imageOnM2;
   
   public static void moveHForward()
      {
      moveHForward = true;
      } // end method moveHeroForward
   public static void moveMForward()
      {
      moveMForward = true;
      } // end method moveMonsterForward
   public static void dodgeH()
      {
      dodgeH = true;
      } // end method dodgeH
   public static void dodgeM()
      {
      dodgeM = true;
      } // end emthod dodgeM
   public static void dodgeHDelay()
      {
      dodgeHDelay = true;
      } // end method dodgeHDelay
   public static void dodgeMDelay()
      {
      dodgeMDelay = true;
      } // end method dodgeMDelay
   public static void shootHToM( String image )
      {
      shootHToM = true;
      shootImageHToM = image;
      } // end method shootHToM
   public static void shootMToH( String image )
      {
      shootMToH = true;
      shootImageMToH = image;
      } // end method shootMToH
   public static void flashOnSelfH( String image )
      {
      flashOnSelfH = true;
      imageOnSelfH = image;
      imageOnSelfH2 = image;
      } // end method flashOnSelfH
   public static void flashOnSelfH( String image, String image2 )
      {
      flashOnSelfH = true;
      imageOnSelfH = image;
      imageOnSelfH2 = image2;
      } // end method flashOnSelfH
   public static void flashOnSelfM( String image )
      {
      flashOnSelfM = true;
      imageOnSelfM = image;
      imageOnSelfM2 = image;
      } // end method flashOnSelfM
   public static void flashOnSelfM( String image, String image2 )
      {
      flashOnSelfM = true;
      imageOnSelfM = image;
      imageOnSelfM2 = image2;
      } // end method flashOnSelfM
   public static void flashImageOnH( String image )
      {
      flashImageOnH = true;
      imageOnH = image;
      imageOnH2 = image;
      } // end method flashImageOnH
   public static void flashImageOnH( String image1, String image2 )
      {
      flashImageOnH = true;
      imageOnH = image1;
      imageOnH2 = image2;
      } // end method flashImageOnH
   public static void flashImageOnM( String image )
      {
      flashImageOnM = true;
      imageOnM = image;
      imageOnM2 = image;
      } // end method flashImageOnM
   public static void flashImageOnM( String image1, String image2 )
      {
      flashImageOnM = true;
      imageOnM = image1;
      imageOnM2 = image2;
      } // end method flashImageOnM
   } // end class BattleScreen