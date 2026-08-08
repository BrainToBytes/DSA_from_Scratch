import java.util.*;

public class FruitIntoBaskets {

    public static int totalFruit(int[] fruits) {
        int ans = 0;
        int left = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] fruits = new int[n];

        System.out.println("Enter " + n + " elements (fruit types as integers):");
        for (int i = 0; i < n; i++) {
            fruits[i] = sc.nextInt();
        }

        int result = totalFruit(fruits);
        System.out.println("Maximum fruits collected (at most 2 types): " + result);

        sc.close();
    }
}