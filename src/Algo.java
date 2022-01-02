import java.util.*;


public class Algo {

     private int length;
   private  int arr[]=new int[length];
    public static int radixCount=0;
    public static int quickCount=0;



   public Algo(int arr[],int length){

       this.length = length;
       this.arr=arr;

   }
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

   public  int insertion_sort(int arr[],int l){
       int i, key, j;
       int counter =1;
       for (i = 1; i < l; i++)
       {
           key = arr[i];
           counter++;
           j = i - 1;
           counter++;

        /* Move elements of arr[0..i-1], that are
        greater than key, to one position ahead
        of their current position */
           while (j >= 0 && arr[j] > key)
           {
                counter++;
               arr[j + 1] = arr[j];
                counter++;
               j = j - 1;
               counter++;

           }
           arr[j + 1] = key;
           counter++;
       }
       return counter;

   }
    public int merge_sort(int arr[], int l, int r)
    {
        int counter =0;
        if (l < r) {

            // Find the middle point
            int m =l+ (r-l)/2;
            counter++;

            // Sort first and second halves
            merge_sort(arr, l, m);
            counter++;
           counter+= merge_sort(arr, m + 1, r);


            // Merge the sorted halves
            merge(arr, l, m, r);
            counter++;
        }
        return counter;
    }
    int merge(int arr[], int l, int m, int r)
    {
       int counter = 0;
        int n1 = m - l + 1;
        counter++;
        int n2 = r - m;
        counter++;

        /* Create temp arrays */
        int L[] = new int[n1];
        counter++;
        int R[] = new int[n2];
        counter++;

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            counter++;
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {

            R[j] = arr[m + 1 + j];
            counter++;
        }
        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        counter++;

        // Initial index of merged subarray array
        int k = l;
        counter++;
        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {

                arr[k] = L[i];
                counter++;
                i++;
                counter++;
            }
            else {
                arr[k] = R[j];
                counter++;
                j++;
                counter++;
            }
            k++;
            counter++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {

            arr[k] = L[i];
            counter++;
            i++;
            counter++;
            k++;
            counter++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {

            arr[k] = R[j];
            counter++;
            j++;
            counter++;
            k++;
            counter++;
        }
        return counter;
    }
    public int heap_sort(int arr[],int l)
    {
        int counter = 0;
        int n = l;
        counter++;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {

            heapify(arr, n, i);
            counter++;
        }
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end

            int temp = arr[0];
            counter++;
            arr[0] = arr[i];
            counter++;
            arr[i] = temp;
            counter++;

            // call max heapify on the reduced heap
           counter += heapify(arr, i, 0);
            counter++;
        }
        return counter;
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    int heapify(int arr[], int n, int i)
    {
        int counter=0;
        int largest = i; // Initialize largest as root
        counter++;
        int l = 2 * i + 1; // left = 2*i + 1
        counter++;
        int r = 2 * i + 2; // right = 2*i + 2
        counter++;

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) {

            largest = l;
            counter++;
        }

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest]){

            largest = r;

            counter++;}
        // If largest is not root
        if (largest != i) {

            int swap = arr[i];
            counter++;
            arr[i] = arr[largest];
            counter++;
            arr[largest] = swap;
            counter++;

            // Recursively heapify the affected sub-tree
           counter+= heapify(arr, n, largest);

        }
        return counter;
    }
    int selection_sort(int arr[], int l)
    {
        int counter = 0;
        int n = l;
        counter++;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {

            // Find the minimum element in unsorted array
            int min_idx = i;
            counter++;
            for (int j = i+1; j < n; j++) {

                if (arr[j] < arr[min_idx]) {

                    min_idx = j;
                    counter++;
                }
            }

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            counter++;
            arr[min_idx] = arr[i];
            counter++;
            arr[i] = temp;
            counter++;
        }
        return counter;
    }
    public int count_Sort(int[] array,int size)

    {
        int counter = 0;
        int[] output = new int[size + 1];
        counter++;

        // Find the largest element of the array
        int max = array[0];
        counter++;
        for (int i = 1; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
                counter++;
            }
            counter++;

        }
        int[] count = new int[max + 1];

        // Initialize count array with all zeros.
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
            counter++;
        }

        // Store the count of each element
        for (int i = 0; i < size; i++) {
            count[array[i]]++;
            counter++;
        }

        // Store the cummulative count of each array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
            counter++;
        }

        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        for (int i = size - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            counter++;
            count[array[i]]--;
            counter++;
        }

        // Copy the sorted elements into original array
        for (int i = 0; i < size; i++) {
            array[i] = output[i];
            counter++;
        }
        return counter;
    }

    int getMax(int arr[], int n)
    {
        radixCount++;
        int mx = arr[0];
        radixCount++;
        for (int i = 1; i < n; i++) {

            if (arr[i] > mx)

                mx = arr[i];
            radixCount++;
        }
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {

        int output[] = new int[n]; // output array
        radixCount++;
        int i;
        radixCount++;
        int count[] = new int[10];
        radixCount++;
        Arrays.fill(count, 0);
        radixCount++;


        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {

            count[(arr[i] / exp) % 10]++;
            radixCount++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++) {

            count[i] += count[i - 1];
            radixCount++;
        }

        // Build the output array
        for (i = n - 1; i >= 0; i--) {

            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            radixCount++;
            count[(arr[i] / exp) % 10]--;
            radixCount++;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++) {

            arr[i] = output[i];
            radixCount++;
        }
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
   public   int radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        radixCount++;
        int m = getMax(arr, n);


        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
            radixCount++;
        }
        return radixCount;
    }
     int partition(int[] arr, int low, int high)
    {

        // pivot
        int pivot = arr[high];
        quickCount++;

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
        quickCount++;
        for(int j = low; j <= high - 1; j++)

        {


            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot)
            {


                // Increment index of
                // smaller element
                i++;
                quickCount++;
                swap(arr, i, j);
                quickCount++;
            }
        }
        swap(arr, i + 1, high);
        quickCount++;
        return (i + 1);

    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index

     */
   public  int quick_Sort(int[] arr, int low, int high)
    {
        if (low < high)
        {


            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
            quickCount++;

            // Separately sort elements before
            // partition and after partition
            quick_Sort(arr, low, pi - 1);
            quickCount++;
            quick_Sort(arr, pi + 1, high);
            quickCount++;
        }
        return quickCount;
    }

}