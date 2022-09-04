package EnemyTypes;

import EnemyTypes.Enemies;

public class Goblin extends Enemies {
    private String enemyName = "Goblin";
    private int maxEnemyHealth = 60;
    private int maxEnemyAttackDamage = 30;
    private boolean isWeakToFire = false;
    private boolean isWeakToPoison = true;


    public Goblin() {

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
