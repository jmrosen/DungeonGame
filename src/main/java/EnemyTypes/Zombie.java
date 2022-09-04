package EnemyTypes;

import EnemyTypes.Enemies;

public class Zombie extends Enemies {
    private String enemyName = "Zombie";
    private int maxEnemyHealth = 75;
    private int maxEnemyAttackDamage = 20;
    private boolean isWeakToFire = true;
    private boolean isWeakToPoison = false;


    public Zombie() {

    }

    @Override
    public String getEnemyName() {
        return enemyName;
    }

    @Override
    public int getMaxEnemyHealth() {
        return maxEnemyHealth;
    }

    @Override
    public int getMaxEnemyAttackDamage() {
        return maxEnemyAttackDamage;
    }

    @Override
    public boolean isWeakToFire() {
        return isWeakToFire;
    }

    @Override
    public boolean isWeakToPoison() {
        return isWeakToPoison;
    }
}
