import java.util.HashMap;
import java.util.Map;

public class Enemy extends Creature {

    private static String[] enemies = {"グレムリン", "スケルトン", "ウォーリアー", "ゴースト"};

    Enemy(int health, int attackDamage) {
        super(health, attackDamage);
    }

    public static String[] getEnemies() {
        return enemies;
    }

    public static void setEnemies(String[] enemies) {
        Enemy.enemies = enemies;
    }
}
