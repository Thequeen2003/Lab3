/**********************************************************************
 * @file Hero.java
 * @brief This is a program about Array Lists
 * @author Alantis Green
 * @date: 2/22/2023
 * @acknowledgement: Just me
 */
public class Hero {
    private String heroName;
    private int hitPoints;
    private int lightAttackDamage;
    private int heavyAttackDamage;

    public Hero() {
        heroName = "";
        hitPoints = 0;
        lightAttackDamage = 0;
        heavyAttackDamage = 0;
    }

    public Hero(String heroName, int hitPoints, int lightAttackDamage, int heavyAttackDamage) {
        this.heroName = heroName;
        this.hitPoints = hitPoints;
        this.lightAttackDamage = lightAttackDamage;
        this.heavyAttackDamage = heavyAttackDamage;

    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getlightAttackDamage() {
        return lightAttackDamage;
    }

    public void setlightAttackDamage() {
        this.lightAttackDamage = lightAttackDamage;
    }
    public int getheavyAttackDamage() {
        return heavyAttackDamage;
    }

    public void setheavyAttackDamage(int heavyAttackDamage) {
        this.heavyAttackDamage = heavyAttackDamage;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    public void takeDamage(int damage) {
        hitPoints -= damage;
        if (hitPoints < 0) {
            hitPoints = 0;
        }
    }

    public int attack() {
        double attackType = Math.random();
        if( attackType < 0.75){
            return lightAttackDamage;
        } else { // 25% chance for a heavy attack
            return heavyAttackDamage;
        }
        }


    public int displayHealth() {
        if (hitPoints > 0) {
            System.out.println(heroName + " has " + hitPoints + " HP.");
        } else {
            System.out.println(heroName + " has fainted.");
        }
        return hitPoints;
    }


    }





