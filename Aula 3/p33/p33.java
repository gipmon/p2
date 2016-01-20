/* Programação modular - Aula 3 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual.
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 * */
import static java.lang.System.*;

public class p33
{
   public static void main(String[] args)
   {
      Nota[] notas = new Nota[args.length / 7]; // argumentos em grupos de sete (data-inicio data-fim texto)
      for(int i = 0; i < notas.length; i++)
      {
         int dia, mes, ano;
         dia = Integer.parseInt(args[i*7]);
         mes = Integer.parseInt(args[i*7+1]);
         ano = Integer.parseInt(args[i*7+2]);
         Data inicio = new Data(dia, mes, ano);
         dia = Integer.parseInt(args[i*7+3]);
         mes = Integer.parseInt(args[i*7+4]);
         ano = Integer.parseInt(args[i*7+5]);
         Data fim = new Data(dia, mes, ano);
         String texto = args[i*7+6];
         notas[i] = new Nota(inicio, fim, texto);
      }
      for(int i = 0; i < notas.length; i++)
        notas[i].escreve();
   }
}

