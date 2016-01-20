/* Ordenação e Complexidade Algorítmica - Aula 8 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;

public class p85
{  
   // Note that the Program is not robust!
   public static void main(String[] args) throws IOException 
   {
      if (args.length != 1){
         System.err.println("Usage: java p84 <file> ...");
         exit(1);
      }
      File fin = new File(args[0]);
      assert fin.exists() : "Unknown Source";

      String[] words = extractsWords(fin);
      
      sequentialSort(words, 0, words.length);

      String without[] = removeRepetedWords(words, 0, words.length);

      for(int i = 0; i < without.length; i++)
            out.printf("%s\n",without[i]);

      //Impressao
      File outfile = new File("words.txt");

      assert outfile.canWrite() : "Can't write in that location";

      PrintWriter impressao = new PrintWriter(outfile);

      for(int i = 0; i < without.length; i++)
            impressao.printf("%s\n",without[i]);

      impressao.close();
      //Impressao

      System.out.println("Number of different words is: "+(without.length));
   }
   //Remove Repeted Words
   static String[] removeRepetedWords(String[] a, int start, int end){
      assert validSubarray(a, start, end);

      int repetedWords = 0;

      for(int i=0; i<end-1; i++)
            if(a[i].equals(a[i+1]))
               repetedWords++;
         
      String b[] = new String[a.length-repetedWords];
      
      for(int i=0, j=0; i<end-1; i++)
         if(!a[i].equals(a[i+1]) && i+1==end-1){
            b[j++] = a[i];
            b[j] = a[++i]; 
         }else if(!a[i].equals(a[i+1]))
            b[j++] = a[i];

      return b;
   }
   //Remove Repeted Words
   //sequentialSort
   static void sequentialSort(String[] a, int start, int end) {
      assert validSubarray(a, start, end);
      
      for(int i = start; i < end-1; i++) 
         for(int j = i+1; j < end; j++)
            if (a[i].compareToIgnoreCase(a[j]) > 0)
               swap(a, i, j); // swaps values a[i] and a[j]
      
      assert isSorted(a, start, end);
   }
   static boolean validSubarray(String a[], int start, int end){
      return (0<=start && start<=end && end<=a.length) ? true : false;
   }
   static boolean isSorted(String [] a, int start, int end)
   {
      assert a!=null;
      assert validSubarray(a, start, end);

      boolean result = true;
      for (int k=start+1; result && k<end; k++) 
         result = (a[k-1].compareToIgnoreCase(a[k]) >= 0);
      return result;
   }
   static void swap(String[] a, int i, int j)
   {
      assert a!=null;
      assert 0<=i && i<a.length;
      assert 0<=j && j<a.length;

      String temp;
      temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }
   //sequentialSort
   static String[] extractsWords(File fin) throws IOException
   {
      assert fin != null;
      assert !fin.isDirectory(); // Note that this precondition does not 100% ensure this kind of assertion!
      assert fin.canRead();      // Note that this precondition does not 100% ensure this kind of assertion!

      // count the words
      int n = 0;
      Scanner scf = new Scanner(fin).useDelimiter("[\\p{Punct}\\p{Space}]+");
      while(scf.hasNext())
      {
         scf.next();
         n++;
      }
      scf.close();

      String[] result = new String[n];

      // read the words
      int i = 0;
      scf = new Scanner(fin).useDelimiter("[\\p{Punct}\\p{Space}]+");
      while(scf.hasNext())
      {
         result[i] = scf.next();
         i++;
      }
      scf.close();

      return result;
   }
}

