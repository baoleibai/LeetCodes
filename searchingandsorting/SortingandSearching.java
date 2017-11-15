package searchingandsorting;

public class SortingandSearching {
	/**
	 * Linear search costs O(n) time complexity. In best case, the first time is
	 * the target O(1) and in worst case, the target is not in the list, O(n).
	 * On average, O(n/2)
	 * 
	 * @param pool
	 * @param min
	 * @param max
	 * @param target
	 * @return
	 */
	public static <T extends Comparable<? super T>> boolean linearSearch(T[] pool, int min, int max, T target) {
		while (min <= max) {
			if (pool[min].compareTo(target) == 0) {
				return true;
			}
			min++;
		}
		return false;
	}

	/**
	 * binary search.O(log2n). the best case, O(1), worst case, O(Log(N)), on
	 * average O(Log(N)/2) 查找数据长度为N，每次查找后减半， 第一次 N/2 ... 第k次 N/2^k
	 * 最坏的情况下第k次才找到，此时只剩一个数据，长度为1。 即 N/2^k = 1 -> N = 2^k -> 查找次数 k=log(N)。
	 * 
	 * @param pool
	 * @param min
	 * @param max
	 * @param target
	 * @return
	 */
	public static <T extends Comparable<? super T>> boolean binarySearch(T[] pool, int min, int max, T target) {

		int lowerIndex = min;
		int higherIndex = max;
		boolean found = false;
		int middleIndex = (lowerIndex + higherIndex) / 2;

		if (pool[middleIndex].compareTo(target) == 0) {
			found = true;
		} else if (pool[middleIndex].compareTo(target) > 0) {
			if (lowerIndex <= middleIndex - 1) {
				found = binarySearch(pool, lowerIndex, middleIndex - 1, target);
			}
		} else if (pool[middleIndex].compareTo(target) < 0) {
			if ((middleIndex + 1) <= higherIndex) {
				found = binarySearch(pool, lowerIndex + 1, higherIndex, target);
			}
		}
		return found;
	}

	/**
	 * Selection Sort is a Sequential Sorting Algorithm.
	 * 
	 * O(n^2)
	 * 
	 * The general strategy of the selection sort algorithm is as follows: Scan
	 * the entire list to find the smallest value. Exchange that value with the
	 * value in the first position of the list. Scan the rest of the list (all
	 * but the first value) to find the smallest value, and then exchange it
	 * with the value in the second position of the list. Scan the rest of the
	 * list (all but the first two values) to find the smallest value, and then
	 * exchange it with the value in the third position of the list. Continue
	 * this process for each position in the list. When complete, the list is
	 * sorted.
	 */
	public static <T extends Comparable<? super T>> T[] selectionSort(T[] data) {
		int length = data.length;
		for (int i = 0; i < length - 1; i++) {
			int smallest = i;
			for (int j = i + 1; j < length; j++) {
				if (data[smallest].compareTo(data[j]) > 0) {
					smallest = j;
				}
			}
			T temp = data[i];
			data[i] = data[smallest];
			data[smallest] = temp;
		}
		return data;
	}

	/**
	 * Insertion Sort is a Sequential Sorting Algorithm.
	 * 
	 * O(n^2)
	 * 
	 * Sort the first two values in the list relative to each other by
	 * exchanging them if necessary. Insert the list’s third value into the
	 * appropriate position relative to the first two (sorted) values. Then
	 * insert the fourth value into its proper position relative to the first
	 * three values in the list. Each time an insertion is made, the number of
	 * values in the sorted subset increases by one. Continue this process until
	 * all values in the list are completely sorted. The insertion process
	 * requires that the other values in the array shift to make room for the
	 * inserted element.
	 * 
	 * @param data
	 * @return
	 */
	public static <T extends Comparable<? super T>> T[] insertionSort(T[] data) {

		for (int index = 1; index < data.length; index++) {
			T target = data[index];
			int position = index;

			// if the data[position -1] is larger than the current target
			// object,
			// shift the data[position -1] to data[position]
			while (position > 0 && (data[position - 1].compareTo(target) > 0)) {
				data[position] = data[position - 1];
				position--;
			}
			data[position] = target;
		}
		return data;
	}

	/**
	 * Insertion Sort is a Sequential Sorting Algorithm.
	 * 
	 * O(n^2)
	 * 
	 * Scan through the list comparing adjacent elements and exchange them if
	 * they are not in relative order. This has the effect of “bubbling” the
	 * largest value to the last position in the list, which is its appropriate
	 * position in the final sorted list. Then scan through the list again,
	 * bubbling up the second-to-last value.
	 * 
	 * @param data
	 * @return
	 */
	public static <T extends Comparable<? super T>> T[] BubbleSort(T[] data) {
		for (int i = data.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				// if data[j] is larger than data[i], swap data[j] and data[j]
				if (data[j].compareTo(data[j + 1]) > 0) {
					// swap;
					T temp = data[j + 1];
					data[j + 1] = data[j];
					data[j] = temp;
				}
			}
		}
		return data;
	}

	public static <T extends Comparable<? super T>> void quickSort(T[] data, int min, int max) {
		if (max - min > 0) {
			int left, right;
			T temp, partitionelement;

			int middle = (min + max) / 2;

			partitionelement = data[middle];
			left = min;
			right = max;
			// System.out.println("range["+ min + ","+max +"]. left is " + left
			// + " right is " + right);
			while (left < right) {
				while (data[left].compareTo(partitionelement) < 0) {
					left++;
				}

				while (data[right].compareTo(partitionelement) > 0) {
					right--;
				}
				if (left <= right) {
					// swap the elements
					temp = data[left];
					data[left] = data[right];
					data[right] = temp;
					left++;
					right--;
				}
				/*
				 * for (int i = min ; i <= max; i++) {
				 * System.out.print(data[i]); System.out.print(" "); }
				 * System.out.println();
				 */
			}

			// System.out.println("range["+ min + ","+max +"]. left is " + left
			// + " right is " + right);
			// move partition element to partition index
			if (min < right) {
				quickSort(data, min, right);
			}
			if (left < max) {
				quickSort(data, left, max);
			}
		}
	}

	private static int array[];
	private static int length;

	public static void sort(int[] inputArr) {
		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		array = inputArr;
		length = inputArr.length;
		quickSort(0, length - 1);
	}

	private static void quickSort(int lowerIndex, int higherIndex) {
		int i = lowerIndex;
		int j = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
		// Divide into two arrays
		while (i <= j) {
			/**
			 * * In each iteration, we will identify a number from left side
			 * which * is greater then the pivot value, and also we will
			 * identify a number * from right side which is less then the pivot
			 * value. Once the searc is done, then we exchange both numbers.
			 */
			while (array[i] < pivot && i < j) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(i, j);
				for (int x : array) {
					System.out.print(x);
					System.out.print(" ");
				}
				System.out.println(" ");
				// move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (lowerIndex < j) {
			quickSort(lowerIndex, j);
		}
		if (i < higherIndex) {
			quickSort(i, higherIndex);
		}
	}

	private static void exchangeNumbers(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void quickSortNew(int[] data, int min, int max) {
		int left, right;
		int temp, partitionelement;
		int middle = (min + max) / 2;
		partitionelement = data[middle]; // use middle element as partition
		left = min;
		right = max;
		System.out.println("range["+ min + ","+max +"]. left is " + left);
		for (int x : data) {
			System.out.print(x);
			System.out.print(" ");
		}
		System.out.println(" ");
		while (left < right) {
			// search for an element that is > the partitionelement
			while (data[left] < partitionelement)
				left++;
			// search for an element that is < the partitionelement
			while (data[right] > partitionelement)
				right--;
			// swap the elements
			if (left <= right) {
				temp = data[left];
				data[left] = data[right];
				data[right] = temp;
				left ++;
				right--;
			}
			
			System.out.println("left is " + left + " right is " + right);
			for (int x : data) {
				System.out.print(x);
				System.out.print(" ");
			}
			System.out.println(" ");
		}
		
		System.out.println("range["+ min + ","+max +"]. left is " + left + " right is " + right);
		if (min < right) {
			quickSortNew(data, min, right);
		}
		
		if (left < max) {
			quickSortNew(data, left, max);
		}
	}
	/**
	 * The general strategy of the merge sort algorithm is as follows:
	 * Begin by dividing the list in two roughly equal parts and then recursively
	 * calling itself with each of those lists. Continue the recursive
	 * decomposition of the list until the base case of the recursion is
	 * reached, where the list is divided into lists of length one, which are
	 * by definition sorted. Then, as control passes back up the recursive
	 * calling structure, the algorithm merges the two sorted sublists resulting
	 * from the two recursive calls into one sorted list.
	 * @param data
	 * @param min
	 * @param max
	 */
	public static <T extends Comparable<? super T>> void mergeSort(T[] data, int min, int max) {
		T[] temp;
		int index1, left, right;
		
		// Only one node left
		if (min == max) {
			return;
		}
		
		int size = max - min + 1;
		int pivot = (max+ min) /2;
		temp = (T[]) (new Comparable[size]);
		
		mergeSort(data, min, pivot);
		mergeSort(data, pivot + 1, max);
		
		for (index1 = 0; index1 < size; index1++) {
			temp[index1] = data[min+ index1];
		}
		
		//merge the two sorted lists.
		left = 0;
		right = pivot - min + 1;
		for (index1 = 0; index1 < size; index1++) {
			if (right <= max - min) {
				if (left <= pivot - min) {
					if (temp[left].compareTo(temp[right]) > 0) {
						data[index1 + min] = temp[right++];
					} else {
						data[index1 + min] = temp[left++];
					}
				} else {
					data[index1 + min] = temp[right++];
				}
			} else {
				// right > (max -min)表示右侧的元素都已经被移到原data数组中，左侧剩下的都是小的元素。
				//因此将左侧元素拷贝大data数组中。
				data[index1 + min] = temp[left++];
			}
		}
	}
}
