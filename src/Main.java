import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // System objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        Player player = new Player(100,50);
        Enemy enemy = new Enemy(50,25);
        Item item = new Item("ポーション",3,30,50);

        boolean running = true;

        System.out.println("ダンジョンへようこそ!");


        GAME:
        while (running) {
            System.out.println("--------------------------------------------------");

            int enemyNum = rand.nextInt(Enemy.getEnemies().length);
            int enemyHealth = rand.nextInt(enemy.getAttackDamage());
            System.out.println("\t# " + Enemy.getEnemies()[enemyNum] + "が現れた! #\n");

            while (enemyHealth > 0) {
                System.out.println("\tあなたのHP: " + player.getHealth());
                System.out.println("\t" + Enemy.getEnemies()[enemyNum] + "のHP: " + enemyHealth);
                System.out.println("\n\tどうしますか？");
                System.out.println("\t1. 攻撃する");
                System.out.println("\t2. " + item.getName() + "を使う" + "(" + item.getNumHealthPotions() + ")");
                System.out.println("\t3. 逃げる!");

                String input = in.nextLine();
                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(player.getAttackDamage());
                    int damageTaken = rand.nextInt(enemy.getAttackDamage());

                    enemyHealth -= damageDealt;
                    player.setHealth(player.getHealth() - damageTaken);

                    System.out.println("\t> あなたは" + Enemy.getEnemies()[enemyNum] + "に" + damageDealt + "のダメージをあたえた.");
                    System.out.println("\t> あなたは" + damageTaken + "のダメージを受けた");

                    if (player.getHealth() < 1) {
                        System.out.println("\t あなたの体力は尽きました.もう闘うことができません.");
                        break;
                    }
                } else if (input.equals("2")) {
                    if (item.getNumHealthPotions() > 0) {
                        player.setHealth(player.getHealth() + item.getHealthPotionHealAmount());
                        item.setNumHealthPotions(item.getNumHealthPotions() -1);
                        System.out.println("\t>"  + item.getName() + "を使いました.体力が" + item.getHealthPotionHealAmount() + "回復しました."
                                + "\n\t>現在のHPは" + player.getHealth() + "です"
                                + "残りの" + item.getName() + "は、あと" + item.getNumHealthPotions() + "です.\n");
                    } else {
                        System.out.println("\n> もう" + item.getName() + "を一つも持っていません!");
                    }

                } else if (input.equals("3")) {
                    int runChance = rand.nextInt(2);
                    if (runChance == 0) {
                        System.out.println("\t あなたは" + Enemy.getEnemies()[enemyNum] + "から逃げました.");
                        continue GAME;
                    } else {
                        System.out.println("\t 逃げるのに失敗しました!");
                        int damageTaken = rand.nextInt(enemy.getAttackDamage());

                        player.setHealth(player.getHealth() - damageTaken);

                        System.out.println("\t> あなたは" + damageTaken + "のダメージを受けた");

                        if (player.getHealth() < 1) {
                            System.out.println("\t あなたの体力は尽きました.もう闘うことができません.");
                            break;
                        }
                    }

                } else {
                    System.out.println("\t不正な入力です!");
                }
            }

            if (player.getHealth() < 1) {
                System.out.println("あなたはダンジョンを攻略できませんでした.");
                break;
            }

            System.out.println("--------------------------------------------------");
            System.out.println("# " + Enemy.getEnemies()[enemyNum] + "を倒しました! #");
            System.out.println("# あなたは50の経験値を得ました #");
            player.setExp(player.getExp() + 50);
            if (player.getExp() % 100 == 0 && player.getExp() / 100 == player.getLv()) {
                player.setLv(player.getLv() + 1);
                System.out.println("# あなたはレベル" + player.getLv() + "になりました! #");
                player.setAttackDamage(50);
                player.setAttackDamage(player.getAttackDamage() * player.getLv());
            }
            System.out.println("# 残りHPは" + player.getHealth() + "です. #");
            if (rand.nextInt(100) > item.getHealthPotionDropChance()) {
                item.setNumHealthPotions(item.getNumHealthPotions() + 1);
                System.out.println("# " + Enemy.getEnemies()[enemyNum] + "は" + item.getName() + "を落としました! #");
                System.out.println("# 現在の所持" + item.getName() +"は" + item.getNumHealthPotions() + "つ. #");
            }
            System.out.println("--------------------------------------------------");
            System.out.println("行動を選択してください.");
            System.out.println("1. 対戦を続ける");
            System.out.println("2. ダンジョンから出る");

            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("不正な入力です!");
                input = in.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("ダンジョン探索を続けます!");
            } else if (input.equals("2")) {
                System.out.println("あなたはダンジョンから出ました.");
                break;
            }
        }


        System.out.println("######################");
        System.out.println("# THANKS FOR PLAYING #");
        System.out.println("######################");
    }
}

