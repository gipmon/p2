/*
 * Rafael Ferreira - APF
 */
import java.util.Scanner;
import java.io.*;
import exameP2.*;

public class CityTraveler{
	public static void main(String[] args){
		HistogramaCidades cityTraveler = new HistogramaCidades();

		for(String arg : args)
			cityTraveler.cityIn(arg);

		cityTraveler.printHistogram();		
	}
}
