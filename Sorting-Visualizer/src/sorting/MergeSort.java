package sorting;

public class MergeSort extends Sort {

    /*MERGE SORT*/
    public static <T extends Comparable<T>> void mergeSort(T[] data)
    {
        mergeSort(data, 0, data.length - 1);
    }


    private static <T extends Comparable<T>> void mergeSort(T[] data, int start, int end)
    {
        if (start < end)
        {
            int middle = (start + end) / 2;

            // recursively divide the list in half until there's only 1 left
            mergeSort(data, start, middle);
            mergeSort(data, middle + 1, end);

            // merge the two partition
            merge(data, start, middle, end);
        }
    }


    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void merge(T[] data, int start, int middle, int end)
    {
        T[] temp = (T[]) (new Comparable[end - start + 1]);  // store the merged list
        int left = start, right = middle + 1;  // start indexes of the two partitions
        int index = 0;

        // looping until one partition runs out of elements
        while (left <= middle && right <= end)
        {
            if (data[left].compareTo(data[right]) < 0)
            {
                temp[index] = data[left];
                left++;
            }
            else
            {
                temp[index] = data[right];
                right++;
            }

            index++;
        }

        // add the rest of elements to the list
        if (left <= middle)
            for (int i = 0; i <= middle - left; i++)
                temp[index + i] = data[left + i];

        if (right <= end)
            for (int i = 0; i <= end - right; i++)
                temp[index + i] = data[right + i];

        // add all elemnts to the original list
        for (int i = 0; i <= end - start; i++)
            data[start + i] = temp[i];
    }
    /*--------------------------------------------------------*/
}
