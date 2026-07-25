import java.util.*;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int area = w * h;
            maxArea = Math.max(area, maxArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] height = new int[n];

        System.out.println("Enter " + n + " heights:");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int result = maxArea(height);

        System.out.println("Maximum water container area: " + result);

        sc.close();
    }
}