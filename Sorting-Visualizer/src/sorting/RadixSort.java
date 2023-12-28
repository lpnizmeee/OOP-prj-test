package sorting;

import java.util.Arrays;

public class RadixSort extends Sort {
    /* RADIX SORT */
    public static <T extends Comparable<T>> T getMax(T[] data, int n) {
        T mx = data[0];
        for (int i = 1; i < n; i++)
            if (data[i].compareTo(mx) > 0)
                mx = data[i];
        return mx;
    }

    public static <T extends Comparable<T>> void countSort(T[] data, int n, int exp) {
        T[] output = Arrays.copyOf(data, data.length); // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[data[i].compareTo(output[0]) / exp % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            count[data[i].compareTo(output[0]) / exp % 10]--;
            output[count[data[i].compareTo(output[0]) / exp % 10]] = data[i];
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to the current digit
        System.arraycopy(output, 0, data, 0, n);
    }

    public static <T extends Comparable<T>> void radixSort(T[] data, int n) {
        // Find the maximum number to know the number of digits
        T m = getMax(data, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is the current digit number
        for (int exp = 1; m.compareTo(m) / exp > 0; exp *= 10)
            countSort(data, n, exp);
    }
    /*--------------------------------------------------------*/
}
