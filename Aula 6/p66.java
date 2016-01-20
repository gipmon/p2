/* Recursividade - Aula 6 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import java.util.*;

public class p66{
  private static double taxa, prestacao, montante;
  private static int meses;
  public static void main(String[] args){
    try{
    	if(args.length<4)
    		  throw new IllegalArgumentException("USO: java -ea p66 <n> <M> <T> <P>");
      else{
          //inicializacao
          taxa=Double.parseDouble(args[2]);
          prestacao=Double.parseDouble(args[3]);
          meses=Integer.parseInt(args[0]);
          montante=Double.parseDouble(args[1]);
          //inicializacao
          System.out.println("(iterativo) d("+args[0]+") = "+cI());
          System.out.println("(recursivo) d("+args[0]+") = "+cR(meses));
      }
    }catch(IllegalArgumentException e){
    	System.err.println(e.getMessage());
    }
  }
  private static double cI(){
      double recorrencia = montante;
      for(int i=1; i<=meses; i++)
        recorrencia=(((100+taxa)*recorrencia)/100)-prestacao;
      return recorrencia;
  }
  private static double cR(int mes){
    return ((mes==0) ? montante : ((((100+taxa)*cR(mes-1))/100)-prestacao)); //T(n-1)()*(1+taxas)-P
  }
}