/**
 * Created by junxiang92 on 13/9/16.
 */
public class MergeSort {
    private int arr[];
    private int comparisons;

    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    public int[] mergeAll() {
        comparisons = 0;
        mergeSort(0, arr.length - 1);
        return arr;
    }

    public void mergeSort(int n, int m) {
        int mid = (n + m) / 2; // 1
        if (m - n < 0) return; //3 0
        else if (m - n > 1){
            mergeSort(n, mid); // 0, 1
            mergeSort(mid + 1, m); // 2, 3
        }
        merge(n, m);
    }

    public void merge(int n, int m) {
        // System.out.println("N: " + n + ", M: " + m);
        if(m - n <= 0) return;
        int mid = (n + m) / 2 + 1; // Plus 1 as the next elem is taken.
        int midBuff = mid;
        int nBuff = n;

        int buff[] = new int[m - n + 1];
        for (int i = 0; i < buff.length; i++) {
            if (mid > m || arr[n] <= arr[mid]) { // Equal because equal elements can take either
                comparisons++;
                buff[i] = arr[n++];
            } else if (n >= midBuff || arr[n] > arr[mid]) {
                comparisons++;
                buff[i] = arr[mid++];
            }
        }
        // printArr(buff);
        for (int i = 0; i < buff.length; i++) arr[i + nBuff] = buff[i];
        // printArr(arr);
        //System.out.println();

    }

    public int getComparisons() {
        return comparisons;
    }

    public void printArr(int[] arr) {
        for (int i : arr) System.out.print(i + ", ");
        System.out.println();
    }
}
