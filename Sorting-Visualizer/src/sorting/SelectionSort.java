package sorting;

public class SelectionSort extends Sort {
    /*SELECTION SORT*/
    public static <T extends Comparable<T>> void selectionSort(T[] data)
    {
        for (int i = 0; i < data.length; i++)
        {
            // find the minimum value from i to the end
            int min = i;

            for (int scan = i; scan < data.length; scan++)
                if (data[scan].compareTo(data[min]) < 0)
                    min = scan;

            swap(data, i, min);
        }

    }
}
