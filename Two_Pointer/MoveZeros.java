

import java.util.Scanner;

public class MoveZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements: ");
        for(int i=0; i<n; i++)
        {
            nums[i]  = sc.nextInt();
        }
        moveZeros(nums);
        System.out.println("Array after moving Zeros: ");
        for(int num : nums)
        {
            System.out.print(num + " ");
        }
        sc.close();
    }

    public static void moveZeros(int[] nums)
    {
        int left = 0;
        for(int right=0; right < nums.length; right++)
        {
            if(nums[right] != 0)
            {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}
