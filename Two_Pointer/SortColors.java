import java.util.*;

public class SortColors {

    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                nums[mid] = nums[low];
                nums[low] = 0;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                nums[mid] = nums[high];
                nums[high] = 2;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements (only 0, 1, or 2):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        sortColors(nums);

        System.out.print("Sorted array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}