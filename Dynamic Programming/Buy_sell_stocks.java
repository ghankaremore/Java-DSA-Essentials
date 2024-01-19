public class Buy_sell_stocks {
    public static void main(String[] args) {
        int[] prices = {5,6,7,2,3,5,2};
        System.out.println("The maxprofit is " + maxProfit(prices));

    }
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Update the minimum price encountered so far
            minPrice = Math.min(minPrice, prices[i]);

            // Calculate the potential profit if you sell at the current price
            int potentialProfit = prices[i] - minPrice;

            // Update the maximum profit if the potential profit is higher
            maxProfit = Math.max(maxProfit, potentialProfit);
        }

        return maxProfit;
    }
}
