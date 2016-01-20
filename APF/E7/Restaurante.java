/*
 * Rafael Ferreira - APF
 */
import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import exameP2.*;

public class Restaurante
{
   public static void main(String[] args){
   		FoodManagement restaurant = new FoodManagement();

   		for(String arg : args)
   			restaurant.parseFile(arg);

   		restaurant.stats();
   }
}
