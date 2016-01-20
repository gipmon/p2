/* Exercícios de revisão - Aula 1 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dú
vida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas.  
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */

import java.util.*;
import static java.lang.System.*;

public class ex103 {

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		boolean prim;
		int primo;
		
		do{
			out.print("N: ");
			primo = sc.nextInt();
			
			if(primo<0)
				out.println("ERROR: invalid number!");
		}while(primo<0);
			
		if(primo==1 && primo==0)
			 prim = false;
		else 
			prim = true;
		
		for(int i=primo-1; i>1; i--)
			if(primo%i==0)
				prim=false;
		
		if(prim)
			out.println("Number "+primo+" is prime!");
		else
			out.println("Number "+primo+" is not prime!");
		
	}

}
