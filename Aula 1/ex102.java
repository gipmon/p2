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

public class ex102 {

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		double aitp1, aip, aitp2, apf;
		
		do{
			out.print("AITP1: ");
			aitp1 = sc.nextDouble();
			
			if(aitp1>20 || aitp1<0)
				err.println("ERRO: classificação inválida!");
		
		}while(aitp1>20 || aitp1<0);
		
		do{
			out.print("AIP: ");
			aip = sc.nextDouble();
			
			if(aip>20 || aip<0)
				err.println("ERRO: classificação inválida!");
			
		}while(aip>20 || aip<0);
			
		do{
			out.print("AITP2: ");
			aitp2 = sc.nextDouble();
			
			if(aitp2>20 || aitp2<0)
				err.println("ERRO: classificação inválida!");
			
		}while(aitp2>20 || aitp2<0);	
		
		do{
			out.print("APF: ");
			apf = sc.nextDouble();
			
			if(apf>20 || apf<0)
				err.println("ERRO: classificação inválida!");
			
		}while(apf>20 || apf<0);	
		
		double nf = aitp1*0.15 + aip*0.2 + aitp2*0.15 + apf*0.5;
		
		if(nf<9.5)
			out.printf("Nota final: %3.1f - REPROVADO!\n", nf);
		else
		   	out.printf("Nota final: %3.1f - APROVADO!\n", nf);
		
	}

}
