package EnemyTypes;

public class Enemies {

    private String enemyName;
    private int maxEnemyHealth;
    private int maxEnemyAttackDamage;
    private boolean isWeakToFire;
    private boolean isWeakToPoison;


    public Enemies() {

    }


    public String getEnemyName() {
        return enemyName;
    }

    public int getMaxEnemyHealth() {
        return maxEnemyHealth;
    }

    public int getMaxEnemyAttackDamage() {
        return maxEnemyAttackDamage;
    }

    public boolean isWeakToFire() {
        return isWeakToFire;
    }

    public boolean isWeakToPoison() {
        return isWeakToPoison;
    }
}
