import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // System objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        String[] enemies = {"グレムリン", "スケルトン", "ウォーリアー", "ゴースト"};

        //Item
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;

        Player player = new Player(100,50);

        boolean running = true;

        System.out.println("ダンジョンへようこそ!");

        GAME:
        while (running) {
            System.out.println("--------------------------------------------------");

            int enemyNum = rand.nextInt(enemies.length);
            Enemy enemy = new Enemy(50,25);
            int enemyHealth = rand.nextInt(enemy.getEnemyAttackDamage());
            System.out.println("\t# " + enemies[enemyNum] + "が現れた! #\n");

            while (enemyHealth > 0) {
                System.out.println("\tあなたのHP: " + player.getHealth());
                System.out.println("\t" + enemies[enemyNum] + "のHP: " + enemyHealth);
                System.out.println("\n\tどうしますか？");
                System.out.println("\t1. 攻撃する");
                System.out.println("\t2. ポーションを使う" + "(" + numHealthPotions + ")");
                System.out.println("\t3. 逃げる!");

                String input = in.nextLine();
                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(player.getAttackDamage());
                    int damageTaken = rand.nextInt(enemy.getEnemyAttackDamage());

                    enemyHealth -= damageDealt;
                    player.setHealth(player.getHealth() - damageTaken);

                    System.out.println("\t> あなたは" + enemies[enemyNum] + "に" + damageDealt + "のダメージをあたえた.");
                    System.out.println("\t> あなたは" + damageTaken + "のダメージを受けた");

                    if (player.getHealth() < 1) {
                        System.out.println("\t あなたの体力は尽きました.もう闘うことができません.");
                        break;
                    }
                } else if (input.equals("2")) {
                    if (numHealthPotions > 0) {
                        player.setHealth(player.getHealth() + healthPotionHealAmount);
                        numHealthPotions--;
                        System.out.println("\t> ポーションを使いました.体力が" + healthPotionHealAmount + "回復しました."
                                + "\n\t>現在のHPは" + player.getHealth() + "です"
                                + "残りのポーションは、あと" + numHealthPotions + "です.\n");
                    } else {
                        System.out.println("\n> もうポーションを一つも持っていません!");
                    }

                } else if (input.equals("3")) {
                    int runChance = rand.nextInt(2);
                    if (runChance == 0) {
                        System.out.println("\t あなたは" + enemies[enemyNum] + "から逃げました.");
                        continue GAME;
                    } else {
                        System.out.println("\t 逃げるのに失敗しました!");
                        int damageTaken = rand.nextInt(enemy.getEnemyAttackDamage());

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
            System.out.println("# " + enemies[enemyNum] + "を倒しました! #");
            System.out.println("# 残りHPは" + player.getHealth() + "です. #");
            if (rand.nextInt(100) > healthPotionDropChance) {
                numHealthPotions++;
                System.out.println("# " + enemies[enemyNum] + "はポーションを落としました! #");
                System.out.println("# 現在の所持ポーションは" + numHealthPotions + "つ. #");
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

