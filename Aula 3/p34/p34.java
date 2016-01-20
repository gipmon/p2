/* Programação modular - Aula 3 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual.
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 * */
import static java.lang.System.*;

public class p34
{
  public static void main(String[] args)
  {
    Agenda agenda = new Agenda();
    agenda.novaNota(new Nota(new Data(14,6,2012), new Data(27,6,2012), "Prog2: APF"));
    agenda.novaNota(new Nota(new Data(2,7,2012), new Data(13,7,2012), "Prog2: Recurso"));
    agenda.novaNota(new Nota(new Data(6,6,2012), new Data(6,6,2012), "Prog2: ACITP2"));
    agenda.novaNota(new Nota(new Data(9,5,2012), new Data(9,5,2012), "Prog2: AIP"));
    agenda.novaNota(new Nota(new Data(22,3,2012), new Data(27,3,2012), "Prog2: ACITP1"));
    agenda.escreve();
    out.println();
    Data d1 = new Data(27,3,2012);
    Data d2 = new Data(15,6,2012);
    Nota[] todo = agenda.compromissos(d1, d2);
    out.print("Compromissos de ");
    d1.escreve();
    out.print(" a ");
    d2.escreve();
    out.println(":");
    for(int i = 0; i < todo.length; i++)
      todo[i].escreve();
  }
}


