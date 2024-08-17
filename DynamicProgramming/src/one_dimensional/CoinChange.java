package one_dimensional;

import java.util.Arrays;

public class CoinChange {
    // 零钱兑换
    // 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
    // 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
    // 你可以认为每种硬币的数量是无限的。
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // 存放多少面额的钱被兑换的最少硬币数
        Arrays.fill(dp, amount + 1); // amount + 1 是不可能的数字
        dp[0] = 0;
        for (int money = 1; money <= amount; money++) {
            for (int coin : coins) {
                if (money >= coin) {
                    // 不加当前硬币和加上当前硬币(之前金额: money-coin)的最少数量
                    dp[money] = Math.min(dp[money], dp[money - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
