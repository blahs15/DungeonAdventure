public class Fighter extends Hero
   {
   
   /** initializes stats and Equipment
    */
   public Fighter( String name )
      {
      super( name );
      setAtt(20);
      setMagicAtt(5);
      setDef(15);
      setMagicDef(5);
      setSpd(10);
      setEvasion(10);
      setAccuracy(15);
      setMaxHP(70);
      setMaxSP(15);
      // lvl 1 stats
      // put in starting equips
      setStartingEquips();
      calculateStats();
      setHP( getMaxHP() );
      setSP( getMaxSP() );
      } // end constructor Fighter
   
   public void lvlUp()
      {
      for( int index = 0; index < 20; index++ )
         {
         int randomizer = (int) (Math.random() * 100 );
         if( randomizer < 30 )
            {
            setAtt( getAtt() - getEAtt() + 1 );
            } // end if
         else if( randomizer < 35 )
            {
            setMagicAtt( getMagicAtt() - getEMagicAtt() + 1 );
            } // end if
         else if( randomizer < 55 )
            {
            setDef( getDef() - getEDef() + 1 );
            } // end if
         else if( randomizer < 65 )
            {
            setMagicDef( getMagicDef() - getEMagicDef() + 1 );
            } // end if
         else if( randomizer < 80 )
            {
            setSpd( getSpd() - getESpd() + 1 );
            } // end if
         else if( randomizer < 90 )
            {
            setEvasion( getEvasion() - getEEvasion() + 1 );
            } // end if
         else
            {
            setAccuracy( getAccuracy() - getEAccuracy() + 1 );
            } // end if
         } // end for
      int HPrand = (int)(Math.random() * 3 * getLvl() ) + 1;
      int SPrand = (int)(Math.random() * 1 * getLvl() ) + 1;
      setMaxHP( getMaxHP() - getEMaxHP() + HPrand );
      setMaxSP( getMaxSP() - getEMaxSP() + SPrand );
      super.lvlUp();
      
      if( getLvl() == 2 )
         {
         addAttackMove( "Power Strike" );
         } // end if
      else if( getLvl() == 5 )
         {
         addAttackMove( "Aimed Slash" );
         } // end if
      } // end method lvlUp
   
   public void setStartingEquips()
      {
      super.setStartingEquips();
      setEquip0( new Sword( 2 ) );
      setEquip1( new Shield( 1 ) );
      } // end method setStartingEquips
      
   public void equip( Equipment e )
      {
      if( e instanceof Sword )
         {
         if( checkEquip( getEquip0(), e ) )
            {
            setEquip0( e );
            } // end if
         } // end if
      else if( e instanceof Shield )
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
      if( e instanceof Staff || e instanceof Pendant || e instanceof Dagger )
         {
         return false;
         } // end if
      return true;
      } // end method equipUsable
   
   
   
   /** ATTACKS: */
   public void attack( Character defender )
      {
      Battle.attack( getAtt(), getAccuracy(), defender, "Attack" );
      BattleScreen.moveHForward();
      // basic attack
      } // end method attack
   
   public void powerAttack( Character defender )
      {
      if( getSP() >= 10 )
         {
         int att = getAtt() * 3/2;
         Battle.attack( att, getAccuracy(), defender, "Power Strike" );
         BattleScreen.moveHForward();
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
         int att = getAtt() * 5/7;
         Battle.attack( att, defender, "Aimed Slash" );
         BattleScreen.moveHForward();
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
      return "Fighter.png";
      } // end method getImage
   public String getHeroType()
      {
      return "Fighter";
      } // end method getHeroType
   
   } // end class Fighter