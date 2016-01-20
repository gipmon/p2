/* Recursividade - Aula 6 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import java.util.*;

public class p61{
  private static int[] array; // ATENÇÃO: Em vez de enviar o array pela função fiz um objeto

  public static void main(String args[]){
    try{
      if (args.length==0)
        throw new IllegalArgumentException("USO: java -ea p61 <n>\n");
      else if(Integer.parseInt(args[0])<0)
        throw new IllegalArgumentException("");

      //Inicialização do array
      array = new int[Integer.parseInt(args[0])+1];

      fibonacci(Integer.parseInt(args[0]));
      
      for(int i=0;i<array.length;i++)
        System.out.printf("fibonacci(%d) = %d\n", i, array[i]);
    }catch(IllegalArgumentException e){
      System.out.print(e.getMessage());
      System.exit(0);
    }
  }

  public static int fibonacci(int n){
    if(n==0)
      return array[n] = 0;
    else if(n==1)
      return array[n] = 1;
    else 
      return array[n] = fibonacci(n-2)+fibonacci(n-1);
  }



}
