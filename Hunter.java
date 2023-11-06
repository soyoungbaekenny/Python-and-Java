import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hunter {
    private ArrayList<Weapons> weapons;
    private ArrayList<Currency> currency;

    public Hunter() {
        weapons = new ArrayList<Weapons>();
        ArrayList<Weapons> weapons = new ArrayList<>();
        currency = new ArrayList<Currency>();
        ArrayList<Currency> currency = new ArrayList<>();
    }

    public Hunter(ArrayList<Weapons> weapons, ArrayList<Currency> currency) {
        this.weapons = weapons;
        this.currency = currency;
    }

    public void display() {
        String contents = "";
        for (int i = 0; i < weapons.size(); i++) {
            contents += (weapons.get(i)) + "\n";
        }
    }

    public void displayHunter2() {
        for (int i = 0; i < weapons.size(); i++) {
            System.out.println("Please buy a weapon. /nPress " + (i + 1) + " for " + weapons.get(i));
        }
    }


    //instead return the right contents. write here.
    /*for arcade mode
        return..
        else .. return -> this method is for writing file.
    }*/



    public ArrayList<Currency> getCurrency() {
        return currency;
    }

    public ArrayList<Weapons> getWeapons() {
        return weapons;
    }

    public static void main(String[] args) {
        user();
        mode();
        turnDisplay();

        Currency currency = new Currency();//(10);
        System.out.print("Your Balance: ");
        Currency.calculateBalance();
        System.out.print("Your required fish today: ");
        currency.requiredFish();
        currency.calculateInsurance();
        currency.calculateLoanPayable();
        currency.calculateBalance();
        readFile();

    }

    public static void mode() {
        int mode;

        Scanner console = new Scanner(System.in);
        while (true) {
            System.out.println("Press 1 to play in Arcade Mode \nPress 2 to play in Story Mode ");
            mode = console.nextInt();
            if (!(mode == 1 || mode == 2)) {
                System.out.println("Please press 1 or 2 only!");
            } else if (mode == 1) {
                System.out.println("You'are playing in Arcade Mode.");//mothod call somewhere...
                break;
            } else if (mode == 2) {
                System.out.println("You'are playing in Story Mode.");//method call somewhere.
                break;
            }
        }
    }

    public static int[][] readFile() {
        String path = "/Users/imac2013/Desktop/Java Practice/Hunter_V2/src/Weapons.txt";
        String line = "";
        System.out.println("Select your choice of a weapon.");
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println("\nPress" + (i + 1) + " (Weapon): " + values[0] + ", (Damage Level):" + values[1] + ", (Strong Against): " + values[2] + ", (Weak Against):" + values[3] + ", (Cost): " + values[4] + ", (Min Fish):" + values[5] + ", (Max Fish):" + values[6]);
                i++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("I/O input error occured.");
        } catch (Exception e) {
            System.out.println("An exception occured.");
        }
        return new int[0][];
    }

    public void setCurrency(ArrayList<Currency> currency) {
        this.currency = currency;
    }

    public void setWeapons(ArrayList<Weapons> weapons) {
        this.weapons = weapons;
    }


    public static void select() {
        Scanner console = new Scanner(System.in);
        String[] selection = {"1", "2", "3"};
        String sel;

        while (true) {
            System.out.println("Press 1 to select a weapon to hunt for fish \n Press 2 to borrow fish from the loan shark  \nPress 3 to skip.");

            sel = console.nextLine();
            if (sel.equals("1")) {
                Currency.caughtFish();
            } else if (sel.equals("2")) {
                Currency.borrowLoan();
            } else {
                turnDisplay();
            }


        }

        //write results in a format I designate for both arcade and story.

    }


    public static String turnDisplay() {
        int i;
        for (i = 1; i >= 3; i++) {
            System.out.println("Turn " + i);
        }
        return "Turn " + i;
    }

    public static void user() {
        Scanner console = new Scanner(System.in);
        String name = "";
        boolean username = true;
        while (username) {
            try {
                System.out.println("Welcome to Java Penguin Hunter. \nPlease enter your name (must be between 3 and 12 characters long)");
                name = console.nextLine();
                if (name.length() >= 3 && name.length() <= 12) {
                    username = false;
                    break;
                }
                System.out.println("Please enter between 3 and 12 characters only!");
            } catch (Exception e) {
                System.out.println("Please enter valid input (3-12 characters)");
            }
        }
    }






}
