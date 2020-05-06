abstract public class Creature {

    protected int health;
    protected int attackDamage;
    protected int lv = 1;

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

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }
}
