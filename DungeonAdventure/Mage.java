public class Mage extends Hero
   {
   
   /** initializes stats and Equipment
    */
   public Mage( String name )
      {
      super( name );
      setAtt(10);
      setMagicAtt(30);
      setDef(15);
      setMagicDef(15);
      setSpd(10);
      setEvasion(10);
      setAccuracy(15);
      setMaxHP(50);
      setMaxSP(25);
      // lvl 1 stats
      // put in starting equips?
      setStartingEquips();
      calculateStats();
      setHP( getMaxHP() );
      setSP( getMaxSP() );
      } // end constructor Mage
   
   public void lvlUp()
      {
      for( int index = 0; index < 20; index++ )
         {
         int randomizer = (int) (Math.random() * 100 );
         if( randomizer < 5 )
            {
            setAtt( getAtt() - getEAtt() + 1 );
            } // end if
         else if( randomizer < 35 )
            {
            setMagicAtt( getMagicAtt() - getEMagicAtt() + 1 );
            } // end if
         else if( randomizer < 50 )
            {
            setDef( getDef() - getEDef() + 1 );
            } // end if
         else if( randomizer < 65 )
            {
            setMagicDef( getMagicDef() - getEMagicDef() + 1 );
            } // end if
         else if( randomizer < 75 )
            {
            setSpd( getSpd() - getESpd() + 1 );
            } // end if
         else if( randomizer < 85 )
            {
            setEvasion( getEvasion() - getEEvasion() + 1 );
            } // end if
         else
            {
            setAccuracy( getAccuracy() - getEAccuracy() + 1 );
            } // end if
         } // end for
      int HPrand = (int)(Math.random() * 1 * getLvl() ) + 1;
      int SPrand = (int)(Math.random() * 3 * getLvl() ) + 1;
      setMaxHP( getMaxHP() - getEMaxHP() + HPrand );
      setMaxSP( getMaxSP() - getEMaxSP() + SPrand );
      super.lvlUp();
      
      if( getLvl() == 2 )
         {
         addAttackMove( "Charged Bolt" );
         } // end if
      else if( getLvl() == 5 )
         {
         addAttackMove( "Aimed Bolt" );
         } // end if
      } // end method lvlUp
      
   public void setStartingEquips()
      {
      super.setStartingEquips();
      setEquip0( new Staff( 2 ) );
      setEquip1( new Pendant( 1 ) );
      } // end method setStartingEquips
   
   public void equip( Equipment e )
      {
      if( e instanceof Staff )
         {
         if( checkEquip( getEquip0(), e ) )
            {
            setEquip0( e );
            } // end if
         } // end if
      else if( e instanceof Pendant )
         {
         if( checkEquip( getEquip1(), e ) )
            {
            setEquip1( e );
            } // end if
         } // end if
      super.equip( e );
      } // end method equip
   
   public boolean equipUsable( Equipment e )
      {
      if( e instanceof Sword || e instanceof Shield || e instanceof Dagger )
         {
         return false;
         } // end if
      return true;
      } // end method equipUsable
   
   
   
   /** ATTACKS: */
   public void gainSP()
      {
      setSP( getSP() + 5 + (getLvl() / 2) );
      if( getSP() > getMaxSP() )
         {
         setSP( getMaxSP() );
         } // end if
      } // end method 
   
   public void attack( Character defender )
      {
      Battle.magicAttack( getMagicAtt(), getAccuracy(), defender, "Magic Bolt" );
      BattleScreen.shootHToM( "MagicBolt.png" );
      // basic attack
      } // end method attack
   
   public void powerAttack( Character defender )
      {
      if( getSP() >= 10 )
         {
         int att = getMagicAtt() * 3/2;
         Battle.magicAttack( att, getAccuracy(), defender, "Charged Bolt" );
         BattleScreen.shootHToM( "MagicBolt.png" );
         // 1.5x attack power
         setSP( getSP() - 10 );
         } // end if
      else
         {
         System.out.println( "You do not have enough SP for that attack" );
         setHasAttacked( false );
         // choose another attack
         } // end else
      } // end method powerStrike
      
   public void aimedAttack( Character defender )
      {
      if( getSP() >= 7 )
         {
         int att = getMagicAtt() * 5/7;
         Battle.magicAttack( att, defender, "Aimed Bolt" );
         BattleScreen.shootHToM( "MagicBolt.png" );
         // attack can not miss
         setSP( getSP() - 7 );
         } // end if
      else
         {
         System.out.println( "You do not have enough SP for that attack" );
         setHasAttacked( false );
         // choose another attack
         } // end else
      } // end method aimedSlash
   
   
   
   public String getImage()
      {
      return "Mage.png";
      } // end method getImage
   public String getHeroType()
      {
      return "Mage";
      } // end method getHeroType
   
   } // end class Mage