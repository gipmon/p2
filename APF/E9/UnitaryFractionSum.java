/*
 * Rafael Ferreira - APF
 */
import java.util.*;

public class UnitaryFractionSum{
	public static void main(String[] args){
		if(args.length!=2){
			System.err.println("Usage: java -ea UnitaryFractionSum <NUM> <DEN>");
		}else
			try{
				System.out.println(args[0]+"/"+args[1]+" = "+divisor(Double.parseDouble(args[0]),Double.parseDouble(args[1])));
			}catch(InputMismatchException e){
				System.err.println("ERROR: one of the arguments ("+args[0]+", "+args[1]+") is not an integer number!");
			}catch(AssertionError e){
				System.err.println(e.getMessage());
			}
	}
	private static String divisor(double num, double den){
		assert (num/den)<1 : "ERROR: fraction is required to be lower than one!";
		double d = (int)(den/num)+1; //pode ser omitido e colocado na condição em baixo
		return (den%num==0) ? "1/"+Integer.toString((int)(d-1)) : "1/"+Integer.toString((int)d)+" + "+divisor(num*d-den,den*d);
	}
}