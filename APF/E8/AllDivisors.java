/*
 * Rafael Ferreira - APF
 */
import static java.lang.System.*;

public class AllDivisors{
	public static void main(String[] args){
		if(args.length==1)
			printDivisors(Integer.parseInt(args[0]), "");
		else
			System.out.println("Usage: java -ea AllDivisors <NUM>");
	}
	private static void printDivisors(int n, String tab){
		System.out.println(tab+n);
		for(int i=n-1; i>1; i--)
			if(n%i==0)
				printDivisors(i, tab+"   ");
	}
}