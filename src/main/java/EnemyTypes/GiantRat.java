package EnemyTypes;

import EnemyTypes.Enemies;

public class GiantRat extends Enemies {
    private String enemyName = "Giant Rat";
    private int maxEnemyHealth = 75;
    private int maxEnemyAttackDamage = 25;
    private boolean isWeakToFire = false;
    private boolean isWeakToPoison = true;


    public GiantRat() {

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
