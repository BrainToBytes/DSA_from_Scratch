import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int right = 0; right < n; right++) {
            while (!deque.isEmpty() && deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            deque.addLast(right);
            if (right >= k - 1) {
                result[right - k + 1] = nums[deque.peekFirst()];
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

        System.out.print("Enter the value of k (window size): ");
        int k = sc.nextInt();

        int[] result = maxSlidingWindow(nums, k);

        System.out.print("Maximum of each sliding window: ");
        for (int val : result) {
            System.out.print(val + " ");
        }

        sc.close();
    }
}