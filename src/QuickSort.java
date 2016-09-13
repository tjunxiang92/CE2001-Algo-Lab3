/**
 * Created by junxiang92 on 13/9/16.
 */
public class QuickSort {
    private int arr[];
    private int comparisons;
    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    public int[] mergeAll() {
        comparisons = 0;
        quickSort(0, arr.length - 1, 0);
        return arr;
    }

    public void quickSort(int wall, int pivot, int start) {
        if (pivot - wall <= 0) return;
        // printArr(arr);
        // System.out.println("Start: " + start + ", PivotV: " + arr[pivot]);
        int buff;
        int max = pivot;
        for (int i = wall; i < max; i++) {
            if (arr[i] <= arr[pivot]) { // swap arr[wall] <-> arr[i]
                comparisons++;
                buff = arr[wall];
                arr[wall++] = arr[i];
                arr[i] = buff;
            }
        }

        // arr[wall] <-> arr[pivot]
        buff = arr[wall];
        arr[wall] = arr[pivot];
        arr[pivot] = buff;

        if (wall == start) start++;

        quickSort(start, wall - 1, start);
        quickSort(wall + 1, pivot, start);
    }

    public int getComparisons() {
        return comparisons;
    }

    public void printArr(int[] arr) {
        for (int i : arr) System.out.print(i + ", ");
        System.out.println();
    }
}
