package sorting;

public class BubbleSort extends Sort {
    /*BUBBLE SORT*/
    public static <T extends Comparable<T>> void bubbleSort(T[] data)
    {
        int position, scan;

        for (position = data.length - 1; position > 0; position--)
        {
            for (scan = 0; scan < position; scan++)
            {
                if (data[scan].compareTo(data[scan + 1]) > 0)
                    swap(data, scan, scan + 1);
            }
        }
    }
}
