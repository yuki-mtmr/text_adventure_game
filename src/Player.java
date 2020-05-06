public class Player extends Creature {

    private int exp = 0;

    Player(int health, int attackDamage) {
        super(health, attackDamage);
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
