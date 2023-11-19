import java.util.Random;
public class VendingMachine {
    public static void main(String[] args) {
        Random rand = new Random();
        int balance = rand.nextInt(1001);
        int[][] items = {{456, 37}, {702, 42}, {382, 24}, {243, 45}, {480, 100}, {903, 15}, {321, 32}, {108, 95}};
        buyItem(items, balance, 702);
        buyRandomItem(items, balance);
        updateItems(items, 500, 20);
    }

    public static int buyItem(int[][] items, int balance, int code) {
        int price = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i][0] == code) {
                price = items[i][1];
            }
        }
        balance = updateBalance(price, balance);
        return balance;
    }

    public static int updateBalance(int cost, int balance) {
        if (balance >= cost) {
            balance = balance - cost;
            return balance;
        } else {
            return balance;
        }
    }

    public static int buyRandomItem(int[][] items, int balance) {
        Random rand = new Random();
        int index = rand.nextInt(items.length);
        int cost = items[index][1];
        balance = updateBalance(cost, balance);
        return balance;
    }

    public static void updateItems(int[][] items, int newCode, int newPrice) {
        int initialPrice = items[0][1];
        int lowestCode = 0;
        int lowestIndex = 0;
        int check;
        int run = 0;
        for (int i = 0; i < items.length; i++) {
            if ((items[i][1]) > initialPrice) {
                continue;
            } else {
                initialPrice = items[i][1];
                lowestCode = items[i][0];
                lowestIndex = i;
            }
        }
        for (int n = 0; n < items.length; n++) {
            check = items[n][0];
            if (check == newCode) {
                items[n][1] = newPrice;
                run = 5;
            }
        }

        if (run == 0) {
            items[lowestIndex][0] = newCode;
            items[lowestIndex][1] = newPrice;
        }
    }
}