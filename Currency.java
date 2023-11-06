import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Currency {
    private int insurance;
    private int disasterPay;
    private int loan;
    private int fishing;

    private ArrayList<Hunter> hunter;
    private ArrayList<Weapons> weapons;

    public Currency() {
        int insurance = 1;
        int disasterPay = 50;
        int loan = 0;
        int fishing = 10;
        hunter = new ArrayList<Hunter>();
        ArrayList<Hunter> hunter = new ArrayList<>();
        weapons = new ArrayList<Weapons>();
        ArrayList<Weapons> weapons = new ArrayList<>();
    }

    public Currency(int insurance, int disasterPay, int loan, int fishing, ArrayList<Hunter> hunter, ArrayList<Weapons> weapons) {
        this.insurance = insurance;
        this.disasterPay = disasterPay;
        this.loan = loan;
        this.fishing = fishing;
        this.hunter = hunter;
        this.weapons = weapons;
    }

    public static int borrowLoan() {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the number of fish you want to borrow (Limit 30/day) ");
        int num = 0;
        num = console.nextInt();
        if (num <= 30) {
            System.out.println("You have borrowed " + num + " fish");
        } else {
            System.out.println("Limit is 30/day");
        }
        return num;
    }

    public static void calculateBalance() {
        int i = 10;
        System.out.println(i);
        int ins = calculateInsurance();
        int totLoan = calculateLoanPayable();
        int dis = calculateDisasterPay();

        System.out.println(" Your fish balance today is(carried forward from previous day): " + (i - ins - dis - totLoan));
    }

    public static int calculateDisasterPay() {
        Random r = new Random();
        int low = 50;
        int high = 100;
        int dis = r.nextInt(high - low) + low;
        return dis;
    }

    public static int calculateInsurance() {
        Random r = new Random();
        int low = 1;
        int high = 10;
        int ins = r.nextInt(high - low) + low;
        System.out.println("Your insurance premium today is: " + ins);
        return ins;
    }

    public static int calculateLoanPayable() {
        int num = 0;
        do {
            num = borrowLoan();
        } while (num > 0);
        int totLoan = (int) (num * 1.5);
        System.out.println("Loan payable today is " + totLoan + " fish");
        return totLoan;
    }

    public static void caughtFish() {
        String fish = prey();

    }

    public int getDisasterPay() {
        return disasterPay;
    }

    public ArrayList<Hunter> getHunter() {
        return hunter;
    }

    public int getFishing() {
        return fishing;
    }

    public int getInsurance() {
        return insurance;
    }

    public int getLoan() {
        return loan;
    }

    public ArrayList<Weapons> getWeapons() {
        return weapons;
    }

    public static String prey() {
        Scanner input = new Scanner(System.in);
        String[] fish = {"Sardine", "Mackarel", "Shirimp", "Cod"};
        Random ran = new Random();
        int randomFish = ran.nextInt(fish.length);
        System.out.println("Your target fish today is " + fish);
        return null;
    }

    public static int requiredFish() {
        Random r = new Random();
        int low = 10;
        int high = 20;
        int req = r.nextInt(high - low) + low;
        return req;
    }

    public void setDisasterPay(int disasterPay) {
        this.disasterPay = disasterPay;
    }

    public void setFishing(int fishing) {
        this.fishing = fishing;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    public void setHunter(ArrayList<Hunter> hunter) {
        this.hunter = hunter;
    }

    public void setLoan(int loan) {
        this.loan = loan;
    }


    public void setWeapons(ArrayList<Weapons> weapons) {
        this.weapons = weapons;
    }
}
















//arcademode()
//Storymode()v