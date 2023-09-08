import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class BucketSort {
    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // No need to sort
        }
        int maxVal = getMaxValue(arr);
        int minVal = getMinValue(arr);
        int numBuckets = (maxVal - minVal) / arr.length + 1;
        List<List<Integer>> buckets = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }
        // Place each element in the appropriate bucket
        for (int num : arr) {
            int index = (num - minVal) / arr.length;
            buckets.get(index).add(num);
        }
        // Sort each bucket individually (using any sorting algorithm)
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        // Concatenate the buckets to obtain the sorted array
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }
    private static int getMaxValue(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    private static int getMinValue(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] arr = {29, 17, 3, 40, 15, 9, 8, 28};
        System.out.println("Original Array: " + Arrays.toString(arr));
        bucketSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
