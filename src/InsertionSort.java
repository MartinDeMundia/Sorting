import java.util.Arrays;
public class InsertionSort {
    public static int[] insertionSort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i -= 1;
            }
            arr[i + 1] = key;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {29, 17, 3, 40, 15, 9, 8, 28};
        System.out.println("Original Array: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
