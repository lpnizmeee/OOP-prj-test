package sorting;// Sorting.Sort algorithms

public class Sort {
	// swap element and target in the array
	protected static <T extends Comparable<T>> void swap(T[] data, int element1, int element2)
	{
		T temp = data[element2];
		data[element2] = data[element1];
		data[element1] = temp;
	}

	/*QUICK SORT*/
	public static <T extends Comparable<T>> void quickSort(T[] data)
	{
		quickSort(data, 0, data.length - 1);
	}


	private static <T extends Comparable<T>> void quickSort(T[] data, int start, int end)
	{
		if (start < end)
		{
			// get the pivot index (here I choose the middle one)
			int middle = partition(data, start, end);

			// sort the left partition
			quickSort(data, start, middle - 1);

			// sort the right partition
			quickSort(data, middle + 1, end);
		}
	}


	private static <T extends Comparable<T>> int partition(T[] data, int start, int end)
	{
		int pivot = (start + end) / 2;
		int left, right;
		T pivotElem = data[pivot];  // the pivot element

		// move the pivot to the beginning of the array
		swap(data, pivot, start);

		left = start + 1;
		right = end;

		while (left < right)
		{
			// find the next element that is greater than pivot
			while (left < right && data[left].compareTo(pivotElem) <= 0)
				left++;

			// find the next element that is less than pivot
			while (data[right].compareTo(pivotElem) > 0)
				right--;

			if (left < right)
				swap(data, left, right);
		}

		// move pivot back to its position
		// right is now the index of an element that less than pivot
		swap(data, start, right);

		return right;
	}
}

