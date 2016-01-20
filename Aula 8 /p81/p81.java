/* Ordenação e Complexidade Algorítmica - Aula 8 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import static java.lang.System.*;
import java.util.Scanner;

public class p81
{
   public static void main(String[] args)
   {
      NumberArray na = new NumberArray();
      mergeSort(na.array(), 0, na.length());
      na.print();
   }

   private static void mergeSort(int[] a, int start, int end){
	   	assert validSubarray(a, start, end);
		
			if (end - start > 1) {
				int middle = (end + start) / 2; 
				mergeSort(a, start, middle); 
				mergeSort(a, middle, end); 
				mergeSubarrays(a, start, middle, end);
			}
		assert isSorted(a, start, end);
   }
   private static boolean validSubarray(int a[], int start, int end){
   		if(end >=start)
			return true;
		else{
			return false;
		}
   }
   private static boolean isSorted(int[] a, int start, int end){
   		for(int i=start; i<end-1; i++){
   			if(a[i]>a[i+1])
   				return false;
   		}
   		return true;
   }
   private static void mergeSubarrays(int[] a, int start, int middle, int end) { int[] b = new int[end-start];
		int i1 = start;
		int i2 = middle;
		int j = 0;
		
		while(i1 < middle && i2 < end) {
			if (a[i1] < a[i2]) 
				b[j++] = a[i1++];
			else
		      b[j++] = a[i2++];
		}
		
		while(i1 < middle) 
			b[j++] = a[i1++];
		
		while(i2 < end) 
		 	b[j++] = a[i2++];
	  	
	  	arraycopy(b, 0, a, start, end-start);
	}
}

