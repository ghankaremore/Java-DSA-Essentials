import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class Item {
    public double valueToWeightRatio;
    String name;
    int value;
    int weight;
    public Item(String name, int value, int weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }
}
public class GreedyKnapsack {
    public static List<Item> greedyKnapsack(List<Item> items, int maxWeight) {
        // Calculate the value-to-weight ratio for each item
        for (Item item : items) {
            item.valueToWeightRatio = (double) item.value / item.weight;
        }
        // Sort the items by value-to-weight ratio in descending order
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return Double.compare(item2.valueToWeightRatio, item1.valueToWeightRatio);
            }
        });
        int totalWeight = 0;
        int totalValue = 0;
        List<Item> knapsack = new ArrayList<>();
        for (Item item : items) {
            if (totalWeight + item.weight <= maxWeight) {
                knapsack.add(item);
                totalWeight += item.weight;
                totalValue += item.value;
            }
        }
        return knapsack;
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", 10, 5));
        items.add(new Item("Item2", 12, 7));
        items.add(new Item("Item3", 8, 3));
        items.add(new Item("Item4", 6, 3));


        int maxWeight = 5;

        List<Item> selectedItems = greedyKnapsack(items, maxWeight);
        int totalWeight = 0;
        int totalValue = 0;

        System.out.println("Selected Items:");
        for (Item item : selectedItems) {
            System.out.println(item.name);
            totalWeight += item.weight;
            totalValue += item.value;
        }

        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Total Value: " + totalValue);
    }
}
