abstract public class Creature {

    protected int health;
    protected int attackDamage;

    Creature(int health, int attackDamage) {
        this.health = health;
        this.attackDamage = attackDamage;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
}
