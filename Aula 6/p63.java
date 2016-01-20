/* Recursividade - Aula 6 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import java.util.*;

public class p63{
  public static void main (String args[]){
    printStr(args, args.length-1);
  }
  private static void  printStr(String args[], int n){
    if(n==-1)
      return;
    else
      System.out.println(args[n]);
    printStr(args, n-1);
  }
}