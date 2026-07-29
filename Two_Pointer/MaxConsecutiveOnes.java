import java.util.*;

public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int curr_Count = 0, max_Count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                curr_Count++;
            } else {
                max_Count = Math.max(curr_Count, max_Count);
                curr_Count = 0;
            }
        }
        return Math.max(curr_Count, max_Count);
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

        int result = findMaxConsecutiveOnes(nums);
        System.out.println("Maximum consecutive ones: " + result);

        sc.close();
    }
}