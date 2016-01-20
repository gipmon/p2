/* Recursividade - Aula 6 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import java.util.*;

public class p64{
  public static void main(String args[]){
    for(String s : args)
      System.out.println("\""+s+"\" -> "+"\""+invString(s, s.length()-1)+"\"");
  }
  private static String invString(String a, int n){
      String s = new String();
      if(n==-1)
        return "";
      else
        return s+=a.charAt(n)+invString(a, n-1);
  }
}
