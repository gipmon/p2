/* Ordenação e Complexidade Algorítmica - Aula 8 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos

 Nota: este algoritmo não está completamente correto. Existe uma diferença entre o número de SWAPS e COMPARISONS entre o jar e este.
 
 */
import static java.lang.System.*;
import java.util.*;

public class p83
{
   static public void main(String[] args)
   {
      if (args.length != 1)
      {
         err.println("Test sorting algorithms for a N number array.");
         err.println("Usage: java -ea p83 <N>");
         exit(1);
      }

      int n = Integer.valueOf(args[0]);

      //Table Head
      out.printf("%-16s | %-14s | %10s |   %10s |  %10s | %10s\n", "Algorithm", "Array", "Dimension", "Swaps", "Comparisons", "Time (m:s:ms)");
      
      //Random
      program(n, "random");
      //Increasing
      program(n, "increasing");
      //decreasing
      program(n, "decreasing");

   }

   //Testing algorithms
   static void program(int n, String type){
        //sequentialSort
        long time = nanoTime(); // To calculate execution time
        int resultsSequential[] = sequentialSort(getArray(type, n), 0, n);
        long elapsedTime = nanoTime() - time;

        int[] sequentialSortTime = timeConvert(elapsedTime);
        //sequentialSort
        
        //bubbleSort
        time = nanoTime(); // To calculate execution time
        int resultsBuble[] = bubbleSort(getArray(type, n), 0, n);
        elapsedTime = nanoTime() - time;

        int[] bubbleSortTime = timeConvert(elapsedTime);
        //bubbleSort
        
        //InsertionSort
        time = nanoTime(); // To calculate execution time
        int resultsInsertion[] = insertionSort(getArray(type, n), 0, n);
        elapsedTime = nanoTime() - time;

        int[] insertionSortTime = timeConvert(elapsedTime);
        //InsertionSort

        //mergeSort
        time = nanoTime(); // To calculate execution time
        int resultsMerge[] = new int[2];
        resultsMerge[0] = resultsMerge[1] = 0;
        mergeSort(getArray(type, n), 0, n, resultsMerge);
        elapsedTime = nanoTime() - time;

        int[] mergeSortTime = timeConvert(elapsedTime);
        //mergeSort
      //print
      out.printf("-----------------|----------------|------------|--------------|--------------|---------------\n");
      out.printf("%-16s | %-14s | %10d | %12d | %12d |     %03d:%02d:%03d\n", "Sequential", type, n, resultsSequential[0], resultsSequential[1], sequentialSortTime[1], sequentialSortTime[0], sequentialSortTime[2]);
      out.printf("%-16s | %-14s | %10d | %12d | %12d |     %03d:%02d:%03d\n", "Bubble", type, n, resultsBuble[0], resultsBuble[1], bubbleSortTime[1], bubbleSortTime[0], bubbleSortTime[2]);
      out.printf("%-16s | %-14s | %10d | %12d | %12d |     %03d:%02d:%03d\n", "Insertion", type, n, resultsInsertion[0], resultsInsertion[1], insertionSortTime[1], insertionSortTime[0], insertionSortTime[2]);
      out.printf("%-16s | %-14s | %10d | %12d | %12d |     %03d:%02d:%03d\n", "Merge", type, n, resultsMerge[0], resultsMerge[1], mergeSortTime[1], mergeSortTime[0], mergeSortTime[2]);
   }

   //giving the array
   static int[] getArray(String type, int n){
      if(type.equals("random"))
        return randomArray(n, n/2);
      else if(type.equals("increasing"))
        return increasing(n);
      else
        return decreasing(n);
   }
   /*
    * timeConvert para dar em segundos, minutos, e milésimos de segundos
    */
   static int[] timeConvert(long elapsedTime){
      int[] time = new int[3];
      //time[0] = seg; time[1] = min; time[2] = mseg

      time[0] = (int)(elapsedTime / 1000000000L);
      elapsedTime -= time[0] * 1000000000L;

      time[1] = time[0] / 60;
      time[0] = time[0] % 60;

      time[2] = (int)(elapsedTime / 1000000L);

      return time;
   }

   /*
    * Vai gerar um array de números em ordem decrescente
    * System.out.println(Arrays.toString(decreasing(n)));
    */
   static int[] decreasing(int n){
      assert n >= 0;

      int[] array = new int[n];

      for(int i=0, d=n-1; i<n; i++, d--)
        array[i] = d;

      return array;
   }

   /*
    * Vai gerar um array de números em ordem crescente
    * System.out.println(Arrays.toString(increasing(n)));
    */
   static int[] increasing(int n){
      assert n >= 0;

      int[] array = new int[n];

      for(int i=0; i<n; i++)
        array[i] = i;

      return array;
   }

   /**
    * Creates an integer random array with numbers in the interval [0; max].
    * @param len length of the array.
    * @param max maximum random value.
    * @return the array
    */
   static int[] randomArray(int len, int max)
   {
      assert len >= 0;
      assert max >= 0;

      int[] result = new int[len];
      for (int i = 0; i < len; i++)
         result[i] = (int)(Math.random()*(max+1));
      return result;
   }

   /**
    * Swaps two elements of an integer array.
    * @param a the array
    * @param i index of an element to swap
    * @param j index of the other element to swap
    * {@code i},{@code j} must be valid indexes within array {@code a}
    */
   static void swap(int[] a, int i, int j)
   {
      assert a!=null;
      assert 0<=i && i<a.length;
      assert 0<=j && j<a.length;

      int temp;
      temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }

   /**
    * Sequential sort ("greed" variation of selection sort).
    * Increasing sorting of integer subarray a[start..end[
    * @param a      the array to be (partially) sorted.
    * @param start  index of the first element to sort.
    * @param end    index of the first element not to be sorted (the last element to sort is {@code end-1}).
    * Requires:   a!=null and 0 <= start <= end <= a.length
    * Ensures:  The elements a[k] with start <= k < end are sorted.  the remaining elements are not changed.
    */
   static int[] sequentialSort(int[] a, int start, int end)
   {
      assert a!=null;
      assert 0<=start && start<=end && end<=a.length;

      int[] results = new int[2];
      results[0] = results[1] = 0;

      for (int i=start; i<end-1; i++) // For each elements (except the last one):
      {
         for (int j=i+1; j<end; j++)
         { 
            results[1]++;
            if (a[j] < a[i]){               // compares them
               swap(a, i, j);
               results[0]++;
            }              // if necessary a swap occurs
         }
      }

      assert isSorted(a, start, end); // checking for possible incorrections of the algorithm!

      return results;
   }

   /*
    * Ordenação por bolha
    */
    static int[] bubbleSort(int[] a, int start, int end) 
    { 
      assert validSubarray(a, start, end);
        
      boolean swapExists; 
      int f = end-1;
      
      int[] results = new int[2];
      results[0] = results[1] = 0;

      do {
          swapExists = false;
    
          for(int i = start;i < f;i++){
            results[1]++;
            if (a[i] > a[i+1]) { 
              swap(a, i, i+1); 
              swapExists = true;
              results[0]++;
            } 
          }
        f--;
      }while(swapExists);
  
      assert isSorted(a, start, end);

      return results;
    }
    private static boolean validSubarray(int a[], int start, int end){
      return (end >=start) ? true : false;
    }
    /* MergeSort */
    static void mergeSort(int[] a, int start, int end, int[] results) { 
      assert validSubarray(a, start, end);

      if (end - start > 1) {
        int middle = (end + start) / 2; 
        mergeSort(a, start, middle, results); 
        mergeSort(a, middle, end, results); 
        mergeSubarrays(a, start, middle, end, results);
      }
        
        assert isSorted(a, start, end);
    }

    static void mergeSubarrays(int[] a, int start, int middle, int end, int[] results) { 
      
      int[] b = new int[end-start];
      int i1 = start;
      int i2 = middle;
      int j = 0;

      while(i1 < middle && i2 < end) {
        results[1]++;
        if (a[i1] < a[i2])
          b[j++] = a[i1++];
        else
              b[j++] = a[i2++];
        }
      
      while(i1 < middle){ 
        results[1]++;
        results[0]++;
        b[j++] = a[i1++];
      }
      while(i2 < end){
        results[1]++;
        results[0]++;
        b[j++] = a[i2++];
      }
        arraycopy(b, 0, a, start, end-start);
    }
    /* MergeSort */

    /* InsertionSort */
    static int[] insertionSort(int[] a, int start, int end) {
        assert validSubarray(a, start, end);

      int[] results = new int[2];
      results[0] = results[1] = 0;

      for(int i = start;i < end;i++) {
        int j;
        int v = a[i];

        for(j = i-1;j >= start && a[j] > v;j--){
              results[0]++;
              a[j+1] = a[j];
        }
          results[0]++;
          a[j+1] = v;
      }
        
        assert isSorted(a, start, end);
    
        return results;
    }

   /**
    * Checks if a given subarray is sorted (increasing order).
    * @param a[start..end[  the subarray to chack.
    * @return true    if subarray is sorted.
    */
   static boolean isSorted(int [] a, int start, int end)
   {
      assert a!=null;
      assert 0<=start && start<=end && end<=a.length;

      boolean result = true;
      for (int k=start+1; result && k<end; k++) 
         result = (a[k-1]<=a[k]);
      return result;
   }
}

