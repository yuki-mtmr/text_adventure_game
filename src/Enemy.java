public class Enemy {

    private static String[] enemies = {"グレムリン", "スケルトン", "ウォーリアー", "ゴースト"};
    private int maxEnemyHealth;
    private int enemyAttackDamage;

    Enemy(int maxEnemyHealth, int enemyAttackDamage) {
        this.maxEnemyHealth = maxEnemyHealth;
        this.enemyAttackDamage = enemyAttackDamage;
    }

    public static String[] getEnemies() {
        return enemies;
    }

    public static void setEnemies(String[] enemies) {
        Enemy.enemies = enemies;
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
