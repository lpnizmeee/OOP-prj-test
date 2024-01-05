package sorting;

public class CountingSort extends Sort {
    /*COUNTING SORT*/
    public static <T extends Comparable<T>> void countingSort(Integer[] arr) {
        int N = arr.length;
        int M = 0;

        for (int i = 0; i < N; i++) {
            M = Math.max(M, arr[i]);
        }

        int[] countArray = new int[M + 1];

        for (int i = 0; i < N; i++) {
            countArray[arr[i]]++;
        }

        for (int i = 1; i <= M; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] outputArray = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[arr[i]] - 1] = arr[i];
            countArray[arr[i]]--;
        }
    }
}
