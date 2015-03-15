import java.awt.*;
import javax.swing.*;

public class StatsPanel extends JPanel
   {
   private Label[] stats;
   private Hero hero;
   
   public StatsPanel( Hero hero, int floorLvl )
      {
      this.hero = hero;
      setPreferredSize( new Dimension( 240, 400 ) );
      setBackground( Color.white );
      setBorder( BorderFactory.createLineBorder( Color.darkGray ));
      setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );
      
      stats = new Label[12];
      for( int index = 0; index < stats.length; index++ )
         {
         stats[index] = new Label();
         stats[index].setBackground( Color.white );
         add( stats[index] );
         } // end for
      
      refreshStats( floorLvl );
      } // end constructor StatsPanel
   
   public void refreshStats( int floorLvl )
      {
      String[] eStat = new String[9];
      int[] equipStat = new int[9];
      equipStat[0] = hero.getEAtt();
      equipStat[1] = hero.getEMagicAtt();
      equipStat[2] = hero.getEDef();
      equipStat[3] = hero.getEMagicDef();
      equipStat[4] = hero.getESpd();
      equipStat[5] = hero.getEEvasion();
      equipStat[6] = hero.getEAccuracy();
      equipStat[7] = hero.getEMaxHP();
      equipStat[8] = hero.getEMaxSP();
      for( int index = 0; index < equipStat.length; index++ )
         {
         if( equipStat[index] > 0 )
            {
            eStat[index] = " (+" + equipStat[index] + ")";
            } // end if
         else
            {
            eStat[index] = " (" + equipStat[index] + ")";
            } // end else
         } // end for
      
      stats[0].setText( "Floor Level: " + floorLvl );
      stats[1].setText( "Lvl " + hero.getLvl() + " " + hero.getHeroType() + 
                        ": " + hero.getName() );
      stats[2].setText( "exp: " + hero.getExp() + 
                        "\t\texpToNextLvl: " + hero.getExpToLvl() );
      stats[3].setText( "HP:  " + hero.getHP() + " / " + hero.getMaxHP() + eStat[7] );
      stats[4].setText( "SP:  " + hero.getSP() + " / " + hero.getMaxSP() + eStat[8] );
      stats[5].setText( "att:    " + hero.getAtt() + eStat[0] );
      stats[6].setText( "magAtt: " + hero.getMagicAtt() + eStat[1] );
      stats[7].setText( "def:    " + hero.getDef() + eStat[2] );
      stats[8].setText( "magDef: " + hero.getMagicDef() + eStat[3] );
      stats[9].setText( "spd:    " + hero.getSpd() + eStat[4] );
      stats[10].setText( "eva:    " + hero.getEvasion() + eStat[5] );
      stats[11].setText( "acc:    " + hero.getAccuracy() + eStat[6] );
      repaint();
      } // end method refreshStats
   
   
   
   
   
   public StatsPanel( Hero hero )
      {
      this.hero = hero;
      setPreferredSize( new Dimension( 240, 400 ) );
      setBackground( Color.white );
      setBorder( BorderFactory.createLineBorder( Color.darkGray ));
      setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );
      
      stats = new Label[11];
      for( int index = 0; index < stats.length; index++ )
         {
         stats[index] = new Label();
         stats[index].setBackground( Color.white );
         add( stats[index] );
         } // end for
      
      refreshStats();
      } // end constructor StatsPanel
   
   public void refreshStats()
      {
      String[] eStat = new String[9];
      int[] equipStat = new int[9];
      equipStat[0] = hero.getEAtt();
      equipStat[1] = hero.getEMagicAtt();
      equipStat[2] = hero.getEDef();
      equipStat[3] = hero.getEMagicDef();
      equipStat[4] = hero.getESpd();
      equipStat[5] = hero.getEEvasion();
      equipStat[6] = hero.getEAccuracy();
      equipStat[7] = hero.getEMaxHP();
      equipStat[8] = hero.getEMaxSP();
      for( int index = 0; index < equipStat.length; index++ )
         {
         if( equipStat[index] > 0 )
            {
            eStat[index] = " (+" + equipStat[index] + ")";
            } // end if
         else
            {
            eStat[index] = " (" + equipStat[index] + ")";
            } // end else
         } // end for
      
      stats[0].setText( "Lvl " + hero.getLvl() + " " + hero.getHeroType() + 
                        ": " + hero.getName() );
      stats[1].setText( "exp: " + hero.getExp() + 
                        "\t\texpToNextLvl: " + hero.getExpToLvl() );
      stats[2].setText( "HP:  " + hero.getHP() + " / " + hero.getMaxHP() + eStat[7] );
      stats[3].setText( "SP:  " + hero.getSP() + " / " + hero.getMaxSP() + eStat[8] );
      stats[4].setText( "att:    " + hero.getAtt() + eStat[0] );
      stats[5].setText( "magAtt: " + hero.getMagicAtt() + eStat[1] );
      stats[6].setText( "def:    " + hero.getDef() + eStat[2] );
      stats[7].setText( "magDef: " + hero.getMagicDef() + eStat[3] );
      stats[8].setText( "spd:    " + hero.getSpd() + eStat[4] );
      stats[9].setText( "eva:    " + hero.getEvasion() + eStat[5] );
      stats[10].setText( "acc:    " + hero.getAccuracy() + eStat[6] );
      repaint();
      } // end method refreshStats
   
   } // end class StatsPanel