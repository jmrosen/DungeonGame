package EnemyTypes;

import EnemyTypes.Enemies;

public class Skeleton extends Enemies {
    private String enemyName = "Skeleton";
    private int maxEnemyHealth = 50;
    private int maxEnemyAttackDamage = 35;
    private boolean isWeakToFire = true;
    private boolean isWeakToPoison = false;


    public Skeleton() {

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
