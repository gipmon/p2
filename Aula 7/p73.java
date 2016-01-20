/* Backtracking - Aula 7 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import java.util.*;

public class p73{
	public static int n = 0;
	public static void main(String[] args){
		try{
			if(args.length!=0){
				int n=0;
				double arr[] = new double[args.length];

				for(String arg : args){
					try{
						arr[n++]=Double.parseDouble(arg);
					}catch(NumberFormatException e){
						throw new IllegalArgumentException("ERROR: unable to convert \""+arg+"\" ro a real number!");
					}
				}
				
				System.out.printf("all arguments sum = %s\n",Double.toString(sumRec(arr)));
			}else{
				System.out.println("all arguments sum = 0.0");
			}
		}catch(IllegalArgumentException e){
			System.err.println(e.getMessage());
		}
	}
	private static double sumRec(double[] arr){
		return ((arr.length-1==n)?(arr[n]):(arr[n++] + sumRec(arr)));
	}
}