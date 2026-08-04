import java.util.*;

public class MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int n = nums.length;

        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            if (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
        }

        return n - left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements (only 0 or 1):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter the value of k (number of flips allowed): ");
        int k = sc.nextInt();

        int result = longestOnes(nums, k);
        System.out.println("Longest consecutive ones (with " + k + " flips): " + result);

        sc.close();
    }
}