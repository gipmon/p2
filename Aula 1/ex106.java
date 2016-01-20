/* Exercícios de revisão - Aula 1 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dú
vida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */

import static java.lang.System.*;
import java.util.*;

public class ex106{

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){

		int n = (int)(Math.random()*(100+1)), i=1, nuser=0;
			
		while(nuser!=n){
			out.print("[attempt "+i+"]: ");
			nuser=sc.nextInt();
			if(nuser==n)
				break;
			else if(nuser<n)
				out.println("Value "+nuser+" is lower than the mystery number");
			else if(nuser>n)
				out.println("Value "+nuser+" is greater than the mystery number");
		}
		out.println("Number "+n+" found in "+n+" attempts.");
	}

}
