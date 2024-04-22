/**********************************************************************
 * @file ReadyToMarvel.java
 * @brief This is a program about Array Lists
 * @author Alantis Green
 * @date: 2/22/2023
 * @acknowledgement: Just me
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

    public class ReadytoMarvel {
        public static void main(String[] args) {
            boolean printFlag; // set default value
            if (args.length > 0) {
                printFlag = Boolean.parseBoolean(args[0]);
            }



            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of the file:");
            String fileName = scanner.nextLine();

             File herolist = new File(fileName);
             while(!herolist.exists()){
                 System.out.println("File not found.please enter another file name");
                  fileName = scanner.nextLine();
                 herolist = new File(fileName);
             }

            ArrayList<Hero> team1 = new ArrayList<>();
            ArrayList<Hero> team2 = new ArrayList<>();
            try {
                Scanner fileScanner = new Scanner(herolist);
                fileScanner.nextLine(); // Skip header line
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(",");
                    String name = parts[0];
                    int hitPoints = Integer.parseInt(parts[1]);
                    int lightAttackDamage = Integer.parseInt(parts[2]);
                    int heavyAttackDamage = Integer.parseInt(parts[3]);
                    int teamNumber = Integer.parseInt(parts[4]);
                    Hero hero = new Hero(name, hitPoints, lightAttackDamage, heavyAttackDamage);
                    if (teamNumber == 1) {
                        team1.add(hero);
                    } else if (teamNumber == 2) {
                        team2.add(hero);
                    }
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error reading hero list file.");
                e.printStackTrace();
            }

            //pring heors using loop
            for (int i = 0; i < team1.size(); i++) {
                Hero hero1 = team1.get(i);
                Hero hero2 = team2.get(i);
                doBattle(hero1, hero2, true); // either change this to false or true for a test
            }
        }





        public static void doBattle(Hero hero1, Hero hero2, boolean printflag) {
            // simulate battle between hero1 and hero2 and print out details if printFlag is true
            System.out.println(hero1.getHeroName() + " vs " + hero2.getHeroName() + "!");
            hero1.displayHealth();
              hero2.displayHealth();
              System.out.println();
            while (hero1.isAlive() && hero2.isAlive()) {

                int damage = hero1.attack();
                hero2.takeDamage(damage);
                if(printflag) {
                    System.out.printf("%s performs a %s attack with damage: %d\n", hero1.getHeroName(), damage > 5 ? "heavy" : "light", damage);
                    System.out.println();
                    hero2.displayHealth();
                }
                if(!hero2.isAlive())
                {
                    System.out.println( hero1.getHeroName() + " VANQIUSHES " + hero2.getHeroName() + " with " + hero1.displayHealth() + " to spare");
               break;
                }
                damage = hero2.attack();
                hero1.takeDamage(damage);
                if(printflag){
                    System.out.printf("%s performs a %s attack with damage: %d\n", hero2.getHeroName(), damage > 5 ? "heavy" : "light", damage);
                    System.out.println();
                    hero1.displayHealth();
                }
                if(!hero1.isAlive()){
                    System.out.println( hero2.getHeroName() + " VANQIUSHES " + hero1.getHeroName() + " with " + hero2.displayHealth() + " to spare ");
                break;
                }

            }
        }}














