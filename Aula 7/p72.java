/* Backtracking - Aula 7 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import java.util.*;
import java.lang.*;

public class p72{
  
  public static void main(String args[]){
    try{
      if(args.length != 2)
        throw new IllegalArgumentException("USO: java -ea p72 <a> <b>\n");
      else if(Integer.parseInt(args[0])<0)
        throw new NumberFormatException("ERROR: argument "+args[0]+" is a negative number!\n");
      else if(Integer.parseInt(args[1])<0)
        throw new NumberFormatException("ERROR: argument "+args[1]+" is a negative number!\n");
      else
        System.out.printf("mdc(%d,%d) = %d\n", Integer.parseInt(args[0]), Integer.parseInt(args[1]), mdc(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }catch(Throwable e){
        System.err.printf(e.getMessage());
    }
  }
  public static int mdc(int a, int b){
    return ((b==0)? a : mdc(b, a%b));
  }
}
