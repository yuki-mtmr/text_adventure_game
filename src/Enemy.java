public class Enemy {

    private int maxEnemyHealth;
    private int enemyAttackDamage;

    Enemy(int maxEnemyHealth, int enemyAttackDamage) {
        this.maxEnemyHealth = maxEnemyHealth;
        this.enemyAttackDamage = enemyAttackDamage;
    }

    public int getMaxEnemyHealth() {
        return maxEnemyHealth;
    }

    public void setMaxEnemyHealth(int maxEnemyHealth) {
        this.maxEnemyHealth = maxEnemyHealth;
    }

    public int getEnemyAttackDamage() {
        return enemyAttackDamage;
    }

    public void setEnemyAttackDamage(int enemyAttackDamage) {
        this.enemyAttackDamage = enemyAttackDamage;
    }

}
