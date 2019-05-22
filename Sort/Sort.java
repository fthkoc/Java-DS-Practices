package Sort;

public class Sort {
    /** Selection sort ==> Quadratic sort
     *
     * Number of comparisons: Best Case: O(n^2), Worst Case: O(n^2),
     * Number of swaps: Best Case: O(n), Worst Case: O(n)
     *
     * Best case: O(n^2)
     * Average case: O(n^2)
     * Worst case: O(n^2)
     **/
    public static <T extends Comparable<T>> void selectionSort(T[] itemList) {
        int indexOfMinItem;
        for (int index = 0; index < (itemList.length - 2); index++) {
            indexOfMinItem = index;
            for (int nextIndex = (index + 1); nextIndex < (itemList.length - 1); nextIndex++) {
                if (itemList[indexOfMinItem].compareTo(itemList[nextIndex]) > 0) {
                    indexOfMinItem = nextIndex;
                }
            }
            swapElements(itemList, index, indexOfMinItem);
        }
    }

    /** Bubble sort ==> Quadratic sort
     *
     * Smaller values bubble up to the top of the array and larger values sink to the bottom; hence the name
     *
     * Number of comparisons: Best Case: O(n), Worst Case: O(n^2),
     * Number of swaps: Best Case: O(1), Worst Case: O(n^2)
     *
     * Best case: O(n)
     * Average case: O(n^2)
     * Worst case: O(n^2)
     **/
    public static <T extends Comparable<T>> void bubbleSort(T[] itemList) {
        boolean swapFlag = false;
        int sortedItemCount = 1;
        do {
            swapFlag = false;
            for (int i = 0; i < (itemList.length - sortedItemCount); i++) {
                if (itemList[i].compareTo(itemList[i + 1]) > 0) {
                    swapElements(itemList, i, i+1);
                    swapFlag = true;
                }
            }
            sortedItemCount++;
        } while (swapFlag);
    }

    /** Insertion sort ==> Quadratic sort
     *
     * Based on the technique used by card players to arrange a hand of cards
     *
     * Number of comparisons: Best Case: O(n), Worst Case: O(n^2),
     * Number of swaps: Best Case: O(n), Worst Case: O(n^2)
     *
     * Best case: O(n)
     * Average case: O(n^2)
     * Worst case: O(n^2)
     **/
    public static <T extends Comparable<T>> void insertionSort(T[] itemList) {
        for (int nextPosition = 1; nextPosition < itemList.length; nextPosition++) {
            // Insert operation
            T nextValue = itemList[nextPosition];
            while ((nextPosition > 0) && (nextValue.compareTo(itemList[nextPosition - 1]) < 0)) {
                itemList[nextPosition] = itemList[nextPosition - 1];
                nextPosition--;
            }
            itemList[nextPosition] = nextValue;
        }
    }

    /** Shell sort
     *
     * A Shell sort is a type of insertion sort, but with O(n^3/2) or better performance than the O(n^2) sorts.
     * Shell sort can be thought of as a "divide and conquer" approach to insertion sort. Instead of sorting the
     * entire array, Shell sort sorts many smaller sub arrays using insertion sort before sorting the entire array
     *
     * Best case: O(n^7/6)
     * Average case: O(n^5/4)
     * Worst case: O(n^2)
     **/
    public static <T extends Comparable<T>> void shellSort(T[] itemList) {
        int gap = itemList.length / 2;
        while (gap > 0) {
            for (int nextPosition = gap; nextPosition < itemList.length; nextPosition++) {
                // Insert operation
                T nextValue = itemList[nextPosition];
                while ((nextPosition > (gap - 1)) && (nextValue.compareTo(itemList[nextPosition - gap]) < 0)) {
                    itemList[nextPosition] = itemList[nextPosition - gap]; // Shift Down
                    nextPosition -= gap;
                }
                itemList[nextPosition] = nextValue;
            }
            if (gap == 2) {
                gap = 1;
            }
            else {
                gap = (int) (gap / 2.2); // 2.2 is chosen by experimentation
            }
        }
    }

    /** Merge sort
     *
     * For two input sequences each containing n elements, each element needs to move from its input sequence to the
     * output sequence
     *
     * Each backward step requires a movement of n elements from smaller-size arrays to larger arrays, effort is O(n)
     * The number of steps which require merging is log(n) because each recursive call splits the array in half
     * The total effort to reconstruct the sorted array through merging is O(n*log(n))
     *
     * Best case: O(n*log(n))
     * Average case: O(n*log(n))
     * Worst case: O(n*log(n))
     *
     * The array cannot be merged in place, additional space usage is O(n)
     **/
    public static <T extends Comparable<T>> void mergeSort(T[] itemList) {
        if (itemList.length > 1) {
            int halfSize = itemList.length / 2;
            T[] left = (T[]) new Comparable[halfSize];
            T[] right = (T[]) new Comparable[itemList.length - halfSize];
            System.arraycopy(itemList, 0, left, 0, halfSize);
            System.arraycopy(itemList, halfSize, right, 0, itemList.length - halfSize);
            mergeSort(left);
            mergeSort(right);
            merge(itemList, left, right);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] itemList, T[] left, T[] right) {
        int index = 0, leftIndex = 0, rightIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex].compareTo(right[rightIndex]) < 0) {
                itemList[index++] = left[leftIndex++];
            } else {
                itemList[index++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            itemList[index++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            itemList[index++] = right[rightIndex++];
        }
    }

    /** Heap sort
     *
     * Because a heap is a complete binary tree, it has log n levels
     * Building a heap of size n requires finding the correct location for an item in a heap with log(n) levels
     * Each insert (or remove) is O(log(n))
     * With n items, building a heap is O(n*log(n))
     *
     * Best case: O(n*log(n))
     * Average case: O(n*log(n))
     * Worst case: O(n*log(n))
     *
     * No extra storage is needed
     **/
    public <T extends Comparable<T>> void heapSort(T[] itemList) {
        buildHeap(itemList);
        shrinkHeap(itemList);
    }

    private <T extends Comparable<T>> void buildHeap(T[] itemList) {
        int heapSize = 1;
        while (heapSize < itemList.length) {
            heapSize++;
            int childIndex = heapSize - 1;
            int parentIndex = (childIndex - 1) / 2;
            while ((parentIndex >= 0) && (itemList[parentIndex].compareTo(itemList[childIndex]) < 0)) {
                swapElements(itemList, parentIndex, childIndex);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            }
        }
    }

    private <T extends Comparable<T>> void shrinkHeap(T[] itemList) {
        int lastItemIndex = itemList.length;
        while (lastItemIndex > 0) {
            lastItemIndex--;
            swapElements(itemList, 0, lastItemIndex);
            int parentIndex = 0;
            while (true) {
                int leftChildIndex = (2 * parentIndex) + 1;
                if (leftChildIndex >= lastItemIndex) {
                    break;
                }
                int rightChildIndex = leftChildIndex + 1;
                int maxChildIndex = leftChildIndex;
                if ((rightChildIndex < lastItemIndex) && (itemList[leftChildIndex].compareTo(itemList[rightChildIndex]) < 0)) {
                    maxChildIndex = rightChildIndex;
                }
                if (itemList[parentIndex].compareTo(itemList[maxChildIndex]) < 0) {
                    swapElements(itemList, parentIndex, maxChildIndex);
                    parentIndex = maxChildIndex;
                } else {
                    break;
                }
            }
        }
    }

    /** Quick sort
     *
     * If both subarrays have the same number of elements (best case), there will be log(n) levels of recursion
     * At each recursion level, the partitioning process involves moving every element to its correct position—n moves
     *
     * Best case: O(n*log(n))
     * Average case: O(n*log(n))
     * Worst case: O(n^2)
     **/
    public <T extends Comparable<T>> void quickSort(T[] itemList, int first, int last) {
        if (first < last) {
            int pivotIndex = partition(itemList, first, last);
            quickSort(itemList, first, pivotIndex - 1);
            quickSort(itemList, pivotIndex + 1, last);
        }
    }

    /**
     * Quicksort is O(n^2) when each split yields one empty subarray, which is the case when the array is presorted
     * A better solution is to pick the pivot value in a way that is less likely to lead to a bad split
     **/
    protected <T extends Comparable<T>> int partition(T[] itemList, int first, int last) {
        T pivotElement = itemList[first];
        int up = first;
        int down = last;
        do {
            while ((up < last) && (pivotElement.compareTo(itemList[up]) >= 0)) {
                up++;
            }
            while (pivotElement.compareTo(itemList[down]) < 0) {
                down--;
            }
            if (up < down) {
                swapElements(itemList, up, down);
            }
        } while (up < down);
        swapElements(itemList, first, down);
        return down;
    }

    private static <T extends Comparable<T>> void swapElements(T[] itemList, int left, int right) {
        T temp = itemList[left];
        itemList[left] = itemList[right];
        itemList[right] = temp;
    }
}
