/* Ordenação e Complexidade Algorítmica - Aula 8 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import static java.lang.System.*;
import java.util.Scanner;

public class p82
{
   	public static void main(String[] args){
      	NumberArray na = new NumberArray();
      	insertionSort(na.array(), 0, na.length());
      	na.print();
   	}

   	private static void insertionSort(int[] a, int start, int end){
   		assert validSubarray(a, start, end);

		for(int i = start;i < end;i++) {
			int j;
			int v = a[i];
			
			for(j = i-1;j >= start && a[j] > v;j--)
			    a[j+1] = a[j];
			
			a[j+1] = v;
		}
  		
  		assert isSorted(a, start, end);
  	}
  	private static boolean isSorted(int[] a, int start, int end){
   		for(int i=start; i<end-1; i++){
   			if(a[i]>a[i+1])
   				return false;
   		}
   		return true;
   }
   private static boolean validSubarray(int a[], int start, int end){
   		if(end >=start)
			return true;
		else{
			return false;
		}
   }
}

