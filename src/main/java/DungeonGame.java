import EnemyTypes.*;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class DungeonGame {
    public static void main(String[] args) {

        // System Objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        // Game Variables
        Enemies[] enemies = {new Skeleton(), new Zombie(), new GiantRat(), new Goblin()};
        int numEnemiesSlain = 0;
        int skeletonsSlain = 0;
        int zombiesSlain = 0;
        int giantRatsSlain = 0;
        int goblinsSlain = 0;
        boolean isGoblinKingSlain = false;
        boolean isSkeletonWarriorSlain = false;
        boolean isZombieHordeSlain = false;
        boolean isGiantRatSwarmSlain = false;


        // Player Variables
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 60; // Percentage
        int numPoisonVial = 2;
        int numTorches = 1;
        int poisonVialDropChance = 40;
        int torchDropChance = 40;
        int runAwayHitChance = 50;
        boolean attackWithPoison = false;
        boolean attackWithFire = false;

        boolean running = true;

        System.out.println("------------------------------------------------------------------------");
        System.out.println("Welcome Adventurer! Beware, for the path ahead is filled with monsters!");


        GAME:
        while (running) {
            if (numEnemiesSlain == 0) {
                System.out.println("Are ready to enter the dungeon (Y/N)");
                System.out.println("------------------------------------------------------------------------");
                String readyOrNot = in.nextLine();
                if (readyOrNot.equalsIgnoreCase("Y")) {
                    System.out.println("Good Luck! Remember it's never to late to turn back.");
                } else if (readyOrNot.equalsIgnoreCase("N")) {
                    break;
                } else {
                    System.out.println("Too Bad! There's no turning back now!");
                }
            }



            Enemies enemy = enemies[rand.nextInt(enemies.length)];
            int enemyHealth = rand.nextInt(enemy.getMaxEnemyHealth()) + 1;
            System.out.println("\t# A " + enemy.getEnemyName() + " has appeared! #\n");

            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy.getEnemyName() + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Use an item");
                System.out.println("\t3. Run away!");


                String input = in.nextLine();
                if (input.equals("1")) {
                    // Player Attacks
                    if (attackWithFire == true && (enemy.getEnemyName().equals("Zombie") || enemy.getEnemyName().equals("Skeleton"))) {
                        int damageDealt = 2 * rand.nextInt(attackDamage);
                        enemyHealth -= damageDealt;
                        attackWithFire = false;
                        System.out.println("\t> You strike the " + enemy.getEnemyName() + " for " + damageDealt + " damage.");
                        System.out.println("\t> It's a critical hit, but your torch breaks when you hit the " + enemy.getEnemyName() +".");
                    }
                    else if (attackWithPoison == true && (enemy.getEnemyName().equals("Goblin") || enemy.getEnemyName().equals("Giant Rat"))) {
                        int damageDealt = 2 * rand.nextInt(attackDamage);
                        enemyHealth -= damageDealt;
                        attackWithPoison = false;
                        System.out.println("\t> You strike the " + enemy.getEnemyName() + " for " + damageDealt + " damage.");
                        System.out.println("\t> It's a critical hit, but the poison leaves your blade when you hit the " + enemy.getEnemyName() +".");

                    }
                    else {
                        int damageDealt = rand.nextInt(attackDamage);
                        enemyHealth -= damageDealt;
                        System.out.println("\t> You strike the " + enemy.getEnemyName() + " for " + damageDealt + " damage.");
                        if (attackWithFire == true) {
                            attackWithFire = false;
                            System.out.println("\t> The torch you are holding goes out");
                        }
                        if (attackWithPoison == true) {
                            attackWithPoison = false;
                            System.out.println("\t> The poison on your blade has faded");
                        }
                    }

                   // Enemy Attacks
                    int damageTaken = rand.nextInt(enemy.getMaxEnemyAttackDamage());
                    health -= damageTaken;
                    System.out.println("\t> You receive " + damageTaken + " in retaliation.");

                    if (health < 1) {
                        System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                        break;
                    }
                }
                else if (input.equals("2")) {
                    // use an item
                    System.out.println("\tYour HP: " + health);
                    System.out.println("\t" + enemy.getEnemyName() + "'s HP: " + enemyHealth);
                    System.out.println("\n\tWhat item would you like to use??");
                    System.out.println("\t1. Health potion (" + numHealthPotions + " remaining)");
                    System.out.println("\t2. Poison vial (" + numPoisonVial + " remaining)");
                    System.out.println("\t3. Torch (" + numTorches + " remaining)");

                    String inventoryChoice = in.nextLine();

                    if (inventoryChoice.equals("1")) {
                        if (numHealthPotions > 0) {
                            health += healthPotionHealAmount;
                            numHealthPotions--;
                            if (health > 100) {
                                health = 100;
                            }
                            System.out.println("\t> You drink a health potion."
                                    + "\n\t> You now have " + health + " HP."
                                    + "\n\t> You have " + numHealthPotions + " health potions remaining.");
                        }
                        else {
                            System.out.println("\t> you have no health potions left! Defeat an enemies for a chance to get one!");
                        }
                    }
                    else if (inventoryChoice.equals("2")) {
                        if (numPoisonVial > 0) {
                            attackWithPoison = true;
                            numPoisonVial--;
                            System.out.println("\t> You coat your blade in poison ready for the next attack.");
                            System.out.println("\t> you have " + numPoisonVial + " poison vial(s) left.");

                        } else {
                            System.out.println("\t> you have no poison vials left! Defeat an enemies for a chance to get one!");
                        }
                    }
                    else if (inventoryChoice.equals("3")) {
                        if (numTorches > 0) {
                            attackWithFire = true;
                            numTorches--;
                            System.out.println("You ready a torch for the next attack, it casts a dim light into the area ahead.");
                            System.out.println("\t> you have " + numTorches + " torch(es) left.");

                        } else {
                            System.out.println("\t> you have no torches left! Defeat an enemies for a chance to get one!");
                        }
                    }
                    else {
                        System.out.println("Invalid Command");
                    }

                        // enemy still attacks if you use an item
                        int damageTaken = rand.nextInt(enemy.getMaxEnemyAttackDamage());
                        health -= damageTaken;
                        System.out.println("\t> The " + enemy.getEnemyName()+ " attacks for " + damageTaken +
                                " when you use the item.");

                }
                else if ( input.equals("3")) {
                    if (rand.nextInt(100) > runAwayHitChance) {
                        // chance to get hit when you run away.
                        int damageTaken = rand.nextInt(enemy.getMaxEnemyAttackDamage());
                        health -= damageTaken;
                        System.out.println("\t> The " + enemy.getEnemyName()+ " attacks for " + damageTaken +
                                " as you run away.");
                    }

                    System.out.println("\tYou run away from the " + enemy.getEnemyName() + "!");
                    continue GAME;
                }
                else {
                    System.out.println("\tInvalid command ");
                }
            }
            if (health < 1) {
                System.out.println("You limp out of the dungeon, weak from battle.");
                break;
        }

            System.out.println("------------------------------------------------------------------------");
            System.out.println(" # " + enemy.getEnemyName() + " was defeated! # ");
            System.out.println(" # You have " + health + " HP left. # ");

            // update number of enemies slain
            numEnemiesSlain++;
            if (enemy.getEnemyName().equals("Skeleton")) {
                skeletonsSlain++;
            }
            else if (enemy.getEnemyName().equals("Zombie")) {
                zombiesSlain++;
            }
            else if (enemy.getEnemyName().equals("Giant Rat")) {
                giantRatsSlain++;
            }
            else if (enemy.getEnemyName().equals("Goblin")) {
                goblinsSlain++;
            }

            // update if bosses are alive


            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println(" # The " + enemy.getEnemyName() + " dropped a health potion! # ");
                System.out.println(" You now have " + numHealthPotions + " health potion(s). # ");
            }
            if (rand.nextInt(100) < torchDropChance &&
                    (enemy.getEnemyName().equals("Skeleton") || enemy.getEnemyName().equals("Goblin"))) {
                numTorches++;
                System.out.println(" # The " + enemy.getEnemyName() + " dropped a torch! # ");
                System.out.println(" You now have " + numTorches + " torch(es). # ");
            }
            if (rand.nextInt(100) < poisonVialDropChance &&
                    (enemy.getEnemyName().equals("Zombie") || enemy.getEnemyName().equals("Giant Rat"))) {
                numPoisonVial++;
                System.out.println(" # The " + enemy.getEnemyName() + " dropped a poison vial! # ");
                System.out.println(" You now have " + numPoisonVial + " poison vial(s). # ");
            }
            System.out.println("------------------------------------------------------------------------");
            System.out.println("What would you like to do?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit the dungeon");

            String input = in.nextLine();
            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command");
                input = in.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("You continue on your adventure!");
            }
            else if (input.equals("2")) {
                System.out.println("You exit the dungeon, successful from your adventure!");
                break;
            }

        }
        System.out.println("------------------------------------------------------------------------");
        System.out.println("############################");
        System.out.println("###  THANKS FOR PLAYING! ###");
        System.out.println("## You defeated " + numEnemiesSlain + " enemies ##");
        System.out.println("############################");
    }
}
