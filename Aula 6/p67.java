/* Recursividade - Aula 5 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import java.util.*;
import java.io.*;

public class p67{
	private static String padrao;
	public static void main(String[] args){
		try{
			if(args.length==2){
				padrao=args[0];
				validacoes(args[1]);
			}else if(args.length==1){
				padrao=args[0];
				validacoes(".");
			}else 
				throw new IllegalArgumentException("Uso: java -ea p67 <padrao> [<dir>]");
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}
	private static void validacoes(String dirName) throws FileNotFoundException{
		File dir = new File(dirName);
		if(!dir.exists())
			throw new FileNotFoundException("ERRO: O directorio \""+padrao+"\" nao existe!");
		System.out.print(searchListAll(dir));
	}
	private static String searchListAll(File a){
		String list = new String();

		File[] contents = a.listFiles();
		
		for(File f : contents){
			if(f.getName().indexOf(padrao)>-1)
		    	list+=f.getPath()+"\n";
			if(f.isDirectory() && f.canRead())
				list+=searchListAll(f);
		}
		return list;
	}
}

