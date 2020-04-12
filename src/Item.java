public class Item {

    private String name;
    private int numHealthPotions;
    private int healthPotionHealAmount;
    private int healthPotionDropChance;

    Item(String name, int numHealthPotions, int healthPotionHealAmount, int healthPotionDropChance) {
        this.name = name;
        this.numHealthPotions = numHealthPotions;
        this.healthPotionHealAmount = healthPotionHealAmount;
        this.healthPotionDropChance = healthPotionDropChance;
    }

    public int getNumHealthPotions() {
        return numHealthPotions;
    }

    public void setNumHealthPotions(int numHealthPotions) {
        this.numHealthPotions = numHealthPotions;
    }

    public int getHealthPotionHealAmount() {
        return healthPotionHealAmount;
    }

    public void setHealthPotionHealAmount(int healthPotionHealAmount) {
        this.healthPotionHealAmount = healthPotionHealAmount;
    }

    public int getHealthPotionDropChance() {
        return healthPotionDropChance;
    }

    public void setHealthPotionDropChance(int healthPotionDropChance) {
        this.healthPotionDropChance = healthPotionDropChance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
