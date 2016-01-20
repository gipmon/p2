/*
 * Rafael Ferreira - APF
 */
import java.io.*;

public class PhoneCalls{
	public static void main(String[] args){
		if(args.length==0){
			System.exit(1);	
		}
		
		ParsePhoneCalls phone = new ParsePhoneCalls();

		for(String arg : args){
			File f = new File(arg);
			phone.initParse(f);
		}

	}
}
