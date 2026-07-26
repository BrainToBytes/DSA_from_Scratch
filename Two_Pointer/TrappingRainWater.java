import java.util.Scanner;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int water = 0;
        int left_max = height[left], right_max = height[right];

        while (left < right) {
            if (left_max < right_max) {
                left++;
                left_max = Math.max(left_max, height[left]);
                water += left_max - height[left];
            } else {
                right--;
                right_max = Math.max(right_max, height[right]);
                water += right_max - height[right];
            }
        }
        return water;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bars: ");
        int n = sc.nextInt();

        int[] height = new int[n];
        System.out.println("Enter " + n + " heights one by one:");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int result = trap(height);

        System.out.println("Trapped water: " + result);

        sc.close();
    }
}