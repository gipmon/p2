/*************************************************************************
 * Compilation: javac j21.java 
 * Execution: java j21
 *************************************************************************/
import java.util.*;

public class p21 {
  // Exemplo simples de utilização da class Complex
  public static void main(String[] args) {

    Scanner  sc = new Scanner(System.in);

    Complexo a;

    if(args.length==2){
      double first = Double.parseDouble(args[0]);
      double  second = Double.parseDouble(args[1]);
      a = new Complexo(first, second);
    }else{
      System.out.print("Re: ");
      double first = sc.nextInt();
      System.out.print("Im: ");
      double second = sc.nextInt();
      a = new Complexo(first, second);
    }
    // Vamos usar métodos de 'a'
    System.out.println("(" + a.real() + " + " + a.imag() + "i)");
    System.out.println("  parte real = " + a.real());
    System.out.println("  parte imaginaria = " + a.imag());
    System.out.println("  modulo = " + a.abs());
    System.out.printf("  fase   =  %2.2f\n", a.phase());
  }

}
