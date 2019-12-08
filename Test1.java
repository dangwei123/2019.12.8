股票问题：


1.给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int min=prices[0];
        int res=0;
        for(int i=1;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            res=Math.max(res,prices[i]-min);
        }
        return res;
    }
}


2.给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int maxProfit(int[] prices) {
        int dp0=0;
        int dp1=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            dp0=Math.max(dp0,dp1+prices[i]);
            dp1=Math.max(dp1,dp0-prices[i]);
        }
        return dp0;
    }
}

3.给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    public int maxProfit(int[] prices) {
        int dp0=0;
        int dp1=Integer.MIN_VALUE;
        int dp_pre=0;
        for(int i=0;i<prices.length;i++){
            int tmp=dp0;
            dp0=Math.max(dp0,dp1+prices[i]);
            dp1=Math.max(dp1,dp_pre-prices[i]);
            dp_pre=tmp;
        }
        return dp0;
    }
}


4.给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。

你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

返回获得利润的最大值。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp0=0;
        int dp1=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            int tmp=dp0;
            dp0=Math.max(dp0,dp1+prices[i]);
            dp1=Math.max(dp1,tmp-prices[i]-fee);
        }
        return dp0;
    }
}

5.给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int[][][] dp=new int[prices.length][3][2];
        for(int i=0;i<prices.length;i++){
            for(int k=2;k>0;k--){
                if(i==0){
                    dp[0][k][0]=0;
                    dp[0][k][1]=-prices[0];
                }else{
                dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
                }    
            }
        }
        return dp[prices.length-1][2][0];
    }
}


6.给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0){
            return 0;
        }if(k>prices.length>>>1){
            return maxProfit(prices);
        }
        int[][][] dp=new int[prices.length][k+1][2];
        for(int i=0;i<prices.length;i++){
            for(int j=k;j>0;j--){
                if(i==0){
                    dp[0][j][0]=0;
                    dp[0][j][1]=-prices[0];
                }else{
                    dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                    dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
                }
            }
        }
        return dp[prices.length-1][k][0];
    }

    private int maxProfit(int[] prices){
        int dp0=0;
        int dp1=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            dp0=Math.max(dp0,dp1+prices[i]);
            dp1=Math.max(dp1,dp0-prices[i]);
        }
        return dp0;
    }
}