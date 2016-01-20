/* Ficheiros - Aula 5 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import java.util.*;
import java.io.*;

public class p53{
	public static void main(String[] args){
		if(args.length!=0)
			impDir(args[0]);
		else
			impDir(".");
	}
	private static void impDir(String a){
		try{
			File dir = new File(a);
		
			if(!dir.exists())
				throw new FileNotFoundException("ERROR: input directory \""+a+"\" does not exist!");
			if(!dir.canRead())
				throw new IllegalAccessException("ERROR: cannot read from input directory \""+a+"\"!");
			if(!dir.isDirectory())
				throw new IOException("ERROR: input \""+a+"\" is not a directory!");
			
		
			String s = new String();
			
			File f[] = dir.listFiles();
			for(File dit : f)
				if(!a.equals("."))
					System.out.printf("%-19s%s\n",dit.getPath(),permDir(dit));
				else
					System.out.printf("%-19s%s\n",dit.getName(),permDir(dit));
		
		}catch(Throwable e){
			System.err.println(e.getMessage());
		}
	}
	private static String permDir(File a) throws IOException{
		
		String d[] = new String[4];
		int i=0;

		if(a.isDirectory())
			d[i++]="DIR";
		if(a.canRead())
			d[i++]="READ";
		if(a.canWrite())
			d[i++]="WRITE";

		String s = " (";

		for(i=0; i<d.length; i++)
			if(d[i]!=null && d[i+1]!=null)
				s+=d[i]+",";
			else if(d[i] != null)
				s+=d[i];

		return s+")";
	}
}