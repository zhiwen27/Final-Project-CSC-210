import java.util.Arrays;

public class MergeSort{
    public static void mergeSort(int[] a, int n) {
        // if every array contains one element, return
        if (n < 2) {
            return;
        }
        // separate the array from the middle
        int mid = n / 2;
        // define left half array
        int[] l = new int[mid];
        // define right half array
        int[] r = new int[n - mid];

        // left int[] l contain all the elements from the left half
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        // left int[] r contain all the elements from the right half
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        // split the left part
        mergeSort(l, mid);
        // split the right part
        mergeSort(r, n - mid);
        // merge the left part with the right part
        merge(a, l, r, mid, n - mid);
    }

    // merge two arrays and return the new array sorted in order
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        // while i's and j's do not exceed the left and right bounds
        while (i < left && j < right) {
            // if array element from left is smaller than array element from right
            if (l[i] <= r[j]) {
                a[k++] = l[i++]; // add left element to the merged array
            }
            else {
                a[k++] = r[j++]; // else, add the right element to the merged array
            }
        }
        // if there are more elements contained in the left array
        while (i < left) {
            a[k++] = l[i++]; // add all of them to the merged array
        }
        // if there are more elements contained in the right array
        while (j < right) {
            a[k++] = r[j++]; // add all of them to the merged array
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,4,5,1,2};
        MergeSort.mergeSort(arr, 5);
        System.out.println(Arrays.toString(arr));
    }
}