/*
 * Rafael Ferreira - APF
 */
import java.util.Scanner;
import java.io.*;
import exameP2.*;

public class JustifiedText{
	
	public static void main(String[] args){
		if(args.length<2)
			System.err.println("Usage: java -ea JustifiedText <NUM-COLUMNS> <FILE>");
		else
			try{
				Justify text = new Justify(Integer.parseInt(args[0]));
				text.in(args[1]);
				text.out();
			}catch(NumberFormatException e){
				System.err.println("ERROR: argument "+args[0]+" is not an integer number!");
			}
	}
}

