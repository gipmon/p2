/* Programação por contratos - Aula 4 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual.
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 * */

import static java.lang.System.*;

public class p42
{
  public static void main(String[] args){
    try{ 
      if(args.length==0)
        throw new IllegalArgumentException("Uso: p42 <data-inicial> <data-final> <texto> ...");
      if(args.length%7==0){
        Nota[] notas = new Nota[args.length / 7]; // argumentos em grupo    s de sete (data-inicio data-fim texto) 

        for(int i = 0; i < notas.length; i++)
        {  
          int dia, mes, ano;
          dia = parseIntInput(args[i*7], i*7);
          mes = parseIntInput(args[i*7+1], i*7+1);
          ano = parseIntInput(args[i*7+2], i*7+2);
          Data inicio = new Data(dia, mes, ano);
          dia = parseIntInput(args[i*7+3], i*7+3);
          mes = parseIntInput(args[i*7+4], i*7+4);
          ano = parseIntInput(args[i*7+5], i*7+5);
          Data fim = new Data(dia, mes, ano);
          String texto = args[i*7+6]; 
          notas[i] = new Nota(inicio, fim, texto);
        }
        for(int i = 0; i < notas.length; i++)
          notas[i].escreve();

      }else
        throw new IllegalArgumentException("ERRO: Os argumentos têm de ser em grupos de 7!");

    }catch(IllegalArgumentException e){
      System.err.println(e.toString().replaceAll("java.lang.IllegalArgumentException: ",""));
      System.exit(0);
    }
  }
  private static int parseIntInput(String x, int arg) throws IllegalArgumentException{
    try{
      return Integer.parseInt(x);
    }catch(NumberFormatException e){
      throw new IllegalArgumentException("ERRO: Argumento "+arg+" ("+x+") não é um número inteiro!");
    }
  }
}
