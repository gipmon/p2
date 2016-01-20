/* Recursividade - Aula 6 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import java.util.*;
import java.io.*;

public class p65{

	public static void main(String[] args){
		try{
			if(args.length>1)
				throw new IllegalArgumentException("Uso: java -ea p65 [<ficheiro>]");
			else if(args.length==1)
				validacoes(args[0]);
			else
				validacoes(".");
		}catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	private static void validacoes(String a) throws IOException{
		File dir = new File(a);
		if(!dir.exists())
			throw new IOException("ERRO: O directorio \""+a+"\" nao existe!");
		System.out.print(listAll(dir));
	}
	private static String listAll(File a){
		String list = a.getPath()+"\n";

		File[] contents = a.listFiles();
		
		for(File f : contents){
			if(f.isDirectory() && f.canRead())
				list+=listAll(f);
		    list+=f.getPath()+"\n";
		}
		return list;
	}
}
