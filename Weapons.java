import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Weapons {
    private String wName;
    private int damage;
    private int strongAgst;
    private int weakAgst;
    private int cost;
    private int minFish;
    private int maxFish;

    private ArrayList<Hunter> hunter;

    public Weapons() {
        wName = "Unknown";
        damage = 5;
        strongAgst = 5;
        weakAgst = 2;
        cost = 0;
        minFish = 0;
        maxFish = 10;
        hunter = new ArrayList<Hunter>();
        ArrayList<Hunter> hunter = new ArrayList<>();
    }

    public Weapons(String wName, int damage, int strongAgst, int weakAgst, int cost, int minFish, int maxFish, ArrayList<Hunter> hunter) {
        this.wName = wName;
        this.damage = damage;
        this.strongAgst = strongAgst;
        this.weakAgst = weakAgst;
        this.cost = cost;
        this.minFish = minFish;
        this.maxFish = maxFish;
        this.hunter = hunter;
    }

    public void display() {
        //somehow reads file and display here..
        System.out.println("Select your choice.\nPress 1 - (Weapon): " + wName + ", (Damage Level):" + damage + ", (Strong Against): " + strongAgst + ", (Weak Against):" + weakAgst + ", (Cost): " + cost + ", (Min Fish):" + minFish + ", (Max Fish):" + maxFish);
    }

    public int getCost() {
        return cost;
    }

    public int getDamage() {
        return damage;
    }

    public ArrayList<Hunter> getHunter() {
        return hunter;
    }

    public int getMaxFish() {
        return maxFish;
    }

    public int getMinFish() {
        return minFish;
    }

    public int getStrongAgst() {
        return strongAgst;
    }

    public int getWeakAgst() {
        return weakAgst;
    }

    public String getWName() {
        return wName;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHunter(ArrayList<Hunter> hunter) {
        this.hunter = hunter;
    }

    public void setMaxFish(int maxFish) {
        this.maxFish = maxFish;
    }

    public void setMinFish(int minFish) {
        this.minFish = minFish;
    }

    public void setStrongAgst(int strongAgst) {
        this.strongAgst = strongAgst;
    }

    public void setWeakAgst(int weakAgst) {
        this.weakAgst = weakAgst;
    }

    public void setWName(String wName) {
        this.wName = wName;
    }


    public static void minMaxFishPerWeapon() throws IOException {
        System.out.println("Number of Fish that can be caught using this weapon: ");
        List<String> file = Files.readAllLines(Path.of("/Users/imac2013/Desktop/Java Practice/Hunter_V2/src/Weapons.txt"));

        int[][] comb = new int[file.size()][];

        for (int i = 0; i < comb.length; i++) {
            String[] split = file.get(i).split(",");
            comb[i] = new int[split.length];
            for (int j = 0; j < split.length; j++) {
                comb[i][j] = Integer.parseInt(split[j]);
            }
        }

        Random ra = new Random();
        for (int i = 0; i < comb.length; i++) {
            int low = Math.min(comb[i][0], comb[i][1]);
            int high = Math.max(comb[i][0], comb[i][1]);

            int r = ra.nextInt(high - low) + low;

            System.out.println(r);
        }

    }
}