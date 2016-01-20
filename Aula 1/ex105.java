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

public class ex105 {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		double media=0, soma=0, n;
		int i=0;
		
		do{
			out.print("Valor: ");
			n=sc.nextDouble();
			if(n!=0){
				soma+=n;
				i++;
				media=soma/i;
			}
		}while(n!=0);
		
		if(i==0){
			out.printf("Soma = %g\n",soma);
			out.printf("Lista vazia!\n");
		}else{
			out.printf("Soma = %g\n",soma);
			out.printf("Média = %g\n",media);
		}
			
	}

}
