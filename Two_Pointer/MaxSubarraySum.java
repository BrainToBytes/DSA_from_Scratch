import java.util.*;

public class MaxSubarraySum {

    public static int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        int windowSum = 0;

        // Build the first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxAns = windowSum;

        // Slide the window across the rest of the array
        for (int j = k; j < n; j++) {
            windowSum += arr[j];
            windowSum -= arr[j - k];
            maxAns = Math.max(maxAns, windowSum);
        }

        return maxAns;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the value of k (window size): ");
        int k = sc.nextInt();

        int result = maxSubarraySum(arr, k);
        System.out.println("Maximum sum of subarray of size " + k + ": " + result);

        sc.close();
    }
}