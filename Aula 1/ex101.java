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

public class ex101 {

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		out.print("Operação: ");
		
		double op1 = sc.nextDouble();
		char opP = sc.next().charAt(0); //String opP = sc.next();
		double op2 = sc.nextDouble();
		
		//if(opP.length()!=1)
		if(opP != '+' && opP != '-' && opP != '*' && opP != '/')
			err.printf("Operador inválido: %c ", opP);
		else
			switch (opP){
			
				case '+': out.printf("%8.6f\n", op1+op2);
						break;
				case '-': out.printf("%8.6f\n", op1-op2);
						break;
				case '*': out.printf("%8.6f\n", op1*op2);
						break;
				case '/': out.printf("%8.6f\n", op1/op2);
						break;
			
			}
	
	}

}
