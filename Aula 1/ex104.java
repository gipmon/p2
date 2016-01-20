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

public class ex104{
	
	public static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		String a = new String();
		
		do{
			
			out.print("Linha: ");
			a=sc.nextLine();
			if(a.length()!=0)
				out.printf("%s\n", Traducao(a));
			
		}while(a.length()!=0);
		
	}	
	public static String Traducao(String a){
		String b = new String();
		for(int i=0; i<a.length(); i++){
			if(a.charAt(i)=='L')
				b+="U";
			else if(a.charAt(i)=='l')
				b+="u";
			else if(a.charAt(i)!='r' && a.charAt(i)!='R')
				b+=a.charAt(i);
		}
		return b;
		//Esta faz a leitura de todos os caracteres constituintes da String inserida e faz uma comparação de cada caracter
		//consuante as condições apresentadas; !Importante! referir que para comparar char com char podemos fazer da seguinte forma
		// char == 'c' <-
	}
}
