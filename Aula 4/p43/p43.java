/* Programação por contratos - Aula 4 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual.
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 * */
import static java.lang.System.*;

public class p43
{
  public static void main(String[] args){
      try{
          assert args.length!=0  : "Uso: p42 <data-inicial> <data-final> <texto> ...";
          assert args.length%7==0 : "ERRO: Os argumentos têm de ser em grupos de 7!";
      
        Nota[] notas = new Nota[args.length / 7]; // argumentos em grupo    s de sete (data-inicio data-fim texto) 

        for(int i = 0; i < notas.length; i++)
        {  
          int dia, mes, ano;
          dia = Integer.parseInt(args[i*7]);
          mes = Integer.parseInt(args[i*7+1]);
          ano = Integer.parseInt(args[i*7+2]);
          Data inicio = new Data(dia, mes, ano);
          assert inicio.dataValida(): "ERRO: Data inválida ("+dia+"/"+mes+"/"+ano+")!";
          dia = Integer.parseInt(args[i*7+3]);
          mes = Integer.parseInt(args[i*7+4]);
          ano = Integer.parseInt(args[i*7+5]);
          Data fim = new Data(dia, mes, ano);
          assert fim.dataValida(): "ERRO: Data inválida ("+dia+"/"+mes+"/"+ano+")!";
          assert inicio.menorDoQue(fim)||fim.igualA(inicio): "ERRO: Data final precede a data inicial!";
          String texto = args[i*7+6];
          notas[i] = new Nota(inicio, fim, texto);
        }
        for(int i = 0; i < notas.length; i++)
          notas[i].escreve();
      }catch(AssertionError e){
          String tratamento = e.toString().replaceAll("java.lang.AssertionError: ","");
          System.out.println(tratamento);
          System.exit(0);
      }
  }
}
