/*
* This program shows the swap and time comparisions to execution between a 
* quick Sort and a Bubble Sort algoritim. it outputs to the user the time taken
* for execution of each comparision and the number of swaps completed for a
* collection of an array of Catalogue Items.
*/
package quicksortexam;

/**
 * @Date 11/07/2019.
 * @author lauren/Antony Jones 92019124.
 */
public class QuickSortExam {
    
    int quickSortSwapCounter = 0;//Set quickSwapCounter to int type start 0.
    int bubbleSortSwapCounter = 0;//Set bubbleSortSwapCounter to int type start 0.
    private CatalogueItem[] items;
    private int number;//set variable number to int type.
    public void sort(CatalogueItem[] values) {
         
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        this.items = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
       
        long startTime = System.nanoTime();
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = items[low + (high-low)/2].getItemId();

        // Divide into two lists
        while (i <= j) {
             
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (items[i].getItemId() < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (items[j].getItemId() > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
        quickSortSwapCounter++;
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        //Print out execution time for each swap in nanoseconds.
	System.out.println("Execution time in (nanoseconds): " + timeElapsed);
        //Print out each swap to full amount of swaps.
        System.out.println("Amount of swaps is: " + quickSortSwapCounter);
    }
    
    private void exchange(int i, int j) {
   
        CatalogueItem temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    // Prints method for quick Sort array.
    void printArrayQuickSort(CatalogueItem arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(
                    //getter methods from CatalogueItem class.
                    "id: " + arr[i].getItemId() + " "
                    //getter methods from CatalogueItem class.
                    + "name: " + arr[i].getItemName() + " "
                    //getter methods from CatalogueItem class.
                    + "category: " + arr[i].getCategory() + "\n");
        System.out.println();
        System.out.println();
    }
    //Create bubbleSort Method for bubbleArray[].
    void bubbleSort(CatalogueItem bubbleArray[])
    {
        long startTime = System.nanoTime();//Initialise the system timer.
        int n = bubbleArray.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (bubbleArray[j].getItemName().compareTo(bubbleArray[j+1]
                        .getItemName()) > 0)
                {
                    // swap temp and arr[i]
                    CatalogueItem temp = bubbleArray[j];
                    bubbleArray[j] = bubbleArray[j+1];
                    bubbleArray[j+1] = temp;
                    bubbleSortSwapCounter++;
                    long endTime = System.nanoTime();//End system timer.
                    //endTime takaway startTime set to variable timeElapsed
                    long timeElapsed = endTime - startTime;
                    //Print out Execution time for each swap.
                    System.out.println("Execution time in (nanoseconds): "
                            + "" + timeElapsed);
                    //Print out number of swaps.
                    System.out.println("amount of swaps is: " 
                            + bubbleSortSwapCounter);
                }
    }
 
    //Print out method for bubbleArray.
    void printArrayBubbleSort(CatalogueItem bubbleArray[])
    {
        int n = bubbleArray.length;
        for (int i=0; i<n; ++i)
             System.out.print(
                    "id: " + bubbleArray[i].getItemId() + " "
                    + "name: " + bubbleArray[i].getItemName() + " "
                    + "category: " + bubbleArray[i].getCategory() + "\n");
        System.out.println();
        System.out.println();
    }
    
    // Driver method for Quick Sort array.
    public static void main(String args[])
    {
        QuickSortExam quickSort = new QuickSortExam();
        
        CatalogueItem arr[] = {
            new CatalogueItem( 3, "Life of Pi","Books"),
            new CatalogueItem( 7, "Deelongie 4 way toaster","Home and Kitchen"),
            new CatalogueItem( 2, "Glorbarl knife set","Home and Kitchen"),
            new CatalogueItem( 4, "Diesorn vacuum cleaner","Appliances"),
            new CatalogueItem( 5, "Jennie Olivier sauce pan","Home and Kitchen"),
            new CatalogueItem( 6, "This book will save your life","Books"),
            new CatalogueItem( 9, "Kemwould hand mixer","Appliances"),
            new CatalogueItem( 1, "Java for Dummies","Books"),
        };
        
        //Print out.
        System.out.println("(QuickSort version)\n");
        System.out.println("The quick sort had (five) swaps that were needed\n"
                + "to complete the Sort compared to (Eleven) for bubble Sort.\n"
                + "the time taken till execution was alot more for bubble sort\n"
                + "than for Quick sort making its Time complexity -\n"
                + "Avrage: Ω(n log(n))\n" +"Avrage: Θ(n log(n))\n" +"Worst: O(n^2)" + "\n");
        
        //Print out.
        System.out.println("The Unsorted array of Catalogue items is:\n");
        quickSort.printArrayQuickSort(arr);
        
         //apply sort to QuickSort array.
        quickSort.sort(arr);
        System.out.println("\nThe Quick Sorted array of catalogue items by "
                + "name acending is:\n");
        quickSort.printArrayQuickSort(arr);
       
        // Driver method for Bubble Sort Array.
        QuickSortExam bubbleSort = new QuickSortExam();
        CatalogueItem bubbleArray[] = {
            new CatalogueItem( 3, "Life of Pi","Books"),
            new CatalogueItem( 7, "Deelongie 4 way toaster","Home and Kitchen"),
            new CatalogueItem( 2, "Glorbarl knife set","Home and Kitchen"),
            new CatalogueItem( 4, "Diesorn vacuum cleaner","Appliances"),
            new CatalogueItem( 5, "Jennie Olivier sauce pan","Home and Kitchen"),
            new CatalogueItem( 6, "This book will save your life","Books"),
            new CatalogueItem( 9, "Kemwould hand mixer","Appliances"),
            new CatalogueItem( 1, "Java for Dummies","Books"),
        };
        
         //Print out.
        System.out.println("(Bubble Sort version)\n");
        //Print out.
        
        System.out.println("The Bubble sort version had (Eleven) swaps compared\n"
                + "to the Quick Sort only needed (Five) Swaps to complete. Time\n"
                + "of execution compared to quick sort was alot slower - \n"
                + "Fair: Ω(n)\n" +"Worst: Θ(n^2)\n" +"Worst: O(n^2)" + "\n");
        
        //Print out.
        System.out.println("The Bubble sort Unsorted array of Catalogue items is:\n");
        bubbleSort.printArrayBubbleSort(bubbleArray);
        
        // apply sort to bubble array.
        bubbleSort.bubbleSort(bubbleArray);
        
        System.out.println("\nThe Basic Bubble array Sorted by catalogue item "
                + "Name ascending is:\n");
        bubbleSort.printArrayBubbleSort(bubbleArray);
        
    }//End of Main.
}//End of QuickSortExam.



