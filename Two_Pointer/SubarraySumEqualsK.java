import java.util.*;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int prefixSum = 0;

        for (int n : nums) {
            prefixSum += n;
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements (can include negative numbers):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        int result = subarraySum(nums, k);
        System.out.println("Number of subarrays with sum equal to " + k + ": " + result);

        sc.close();
    }
}