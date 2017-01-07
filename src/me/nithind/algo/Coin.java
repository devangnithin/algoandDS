package me.nithind.algo;

/**
 * Created by devangn on 01-01-17.
 */
public class Coin {
    public int coinChange(int[] coins, int amount) {
        int[] tillNow = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i =1; i<amount; i++) {
            int amountT = 0;
            for (int j=1; j<coins.length; j++) {
                //amount =
            }
        }
        return 0;
    }

    public int coinChangeRec(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int min = 999999;
        int cur = 0;
        for (int coin : coins) {
            int a2 = coinChangeRec(coins, amount-coin);
            if (a2 >=0  && a2<min) {
                min = 1 + a2;
            }
        }
        return min;
    }

    public int coinChangeRecBU(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int[] amtC = new int[amount];
        int min = 999999;
        int cur = 0;
        for (int coin : coins) {
            int a2 = coinChangeRec(coins, amount-coin);
            if (a2 >=0  && a2<min) {
                min = 1 + a2;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        Coin c = new Coin();
        c.coinChangeRec(coins, 11);
    }
}