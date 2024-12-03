import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {
    public static void main(String[] args) {
        //We're testing with these arry sizes as they provide a good amount of variablity without taking 8 hours to run (I'm looking at you 10,000,000 item bubble sort)
        int[] sizes = {10,100,1000,10000,100000,1000000};

        //Initialize random number generator
        Random random = new Random();

        //Test all sorting algorithms
        for (int size : sizes) {
            System.out.println("Array size: " + size);

            //Generate a random array of the given size
            int[] array = random.ints(size, 0, 100000).toArray();

            //bogo sort solution
            int[] solution = new int[size];
            for (int i = 0; i < size; i++) {
                solution[i] = i+1;
            }  
            
            //Test each sorting algorithm
            /*testSorter("Bubble Sort", array.clone(), SortingAlgorithms::bubbleSort);
            testSorter("Selection Sort", array.clone(), SortingAlgorithms::selectionSort);
            testSorter("Insertion Sort", array.clone(), SortingAlgorithms::insertionSort);
            testSorter("Merge Sort", array.clone(), SortingAlgorithms::mergeSort);
            testSorter("Quick Sort", array.clone(), SortingAlgorithms::quickSort);
            testSorter("Heap Sort", array.clone(), SortingAlgorithms::heapSort);
            testSorter("Counting Sort", array.clone(), SortingAlgorithms::countingSort);
            testSorter("Radix Sort", array.clone(), SortingAlgorithms::radixSort);
            testSorter("Shell Sort", array.clone(), SortingAlgorithms::shellSort);
            testSorter("Tim Sort", array.clone(), Arrays::sort);*/
            testSorter("Bogo Sort", array.clone(), SortingAlgorithms::bogoSort);



            System.out.println();
        }
    }

    //Method to test a sorting algorithm and output its time
    public static void testSorter(String name, int[] array, Sorter sorter) {
        long startTime = System.nanoTime();
        sorter.sort(array);
        long endTime = System.nanoTime();
        System.out.printf("%-20s: %d ms%n", name, (endTime - startTime) / 1000000);
    }

    //Sorting algorithm interfaces
    interface Sorter {
        void sort(int[] array);
    }

    //Bubble Sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    //Selection Sort
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    //Insertion Sort
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    //Merge Sort
    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid, array.length);

            mergeSort(left);
            mergeSort(right);

            merge(array, left, right);
        }
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    //Quick Sort
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    //Heap Sort
    public static void heapSort(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            heapify(array, n, largest);
        }
    }

    //Counting Sort
    public static void countingSort(int[] array) {
        int max = Arrays.stream(array).max().orElse(0);
        int min = Arrays.stream(array).min().orElse(0);
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[array.length];

        for (int num : array) {
            count[num - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        System.arraycopy(output, 0, array, 0, array.length);
    }

    //Radix Sort
    public static void radixSort(int[] array) {
        int max = Arrays.stream(array).max().orElse(0);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(array, exp);
        }
    }

    private static void countingSortByDigit(int[] array, int exp) {
        int[] output = new int[array.length];
        int[] count = new int[10];

        for (int num : array) {
            count[(num / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, array, 0, array.length);
    }

    //Shell Sort
    public static void shellSort(int[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    //Bogo Sort
    public static void bogoSort(int[] array) {
        while (!isSorted(array)) {
            shuffle(array);
        }
    }

    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
              return false;
            }
        }

        return true;
    }

    static void shuffle(int[] array) {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
    }
}
