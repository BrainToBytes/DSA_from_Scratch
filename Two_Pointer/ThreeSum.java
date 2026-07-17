import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // No triplet possible if smallest remaining value is already positive
            if (nums[i] > 0) break;

            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    l++;
                    r--;

                    // Skip duplicates for l
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    // Skip duplicates for r
                    while (l < r && nums[r] == nums[r + 1]) r--;

                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> result = threeSum(nums);

        System.out.println("Unique triplets that sum to zero:");
        if (result.isEmpty()) {
            System.out.println("No triplets found.");
        } else {
            for (List<Integer> triplet : result) {
                System.out.println(triplet);
            }
        }

        sc.close();
    }
}