/* Programação modular - Aula 3 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual.
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 * */
import java.util.*;
public class p35
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int menu;

    Caixa c = new Caixa();
    do{

      System.out.print("(PRIMA ENTER)");
      sc.nextLine();
      printMenu();
      menu=sc.nextInt();

      switch (menu){
        case 1:
          System.out.print("Moedas: ");
          long moeda;
          do{
            moeda=sc.nextLong();
            if(moeda!=0)
              c.adicionaMoeda(moeda);
          }while(moeda!=0);
          sc.nextLine();
          break;
        case 2:
          System.out.print("Valor mínimo a retirar: ");
          long valorMin = sc.nextLong();
          long r[] = c.retiraDinheiro(valorMin);
          if(r[0]!=-1){
          for(int i=0; i<r.length-1; i++)
            System.out.print(r[i]+", ");
          System.out.println(r[r.length-1]);
          sc.nextLine();
          }
          break;
        case 3:
          long a[] = c.moedas();
          for(int i=0; i<a.length-1; i++)
            System.out.print(a[i]+", ");
          System.out.println(a[a.length-1]);
          break;
        case 4: System.out.println("Dinheiro na caixa: "+c.total());
                sc.nextLine();
                break;
        case 0: System.exit(0);
                break;
      }
    }while(menu!=0);    
  }
  public static void printMenu(){
    System.out.println("\n1. Adicionar moedas (termina com valor zero)");
    System.out.println("2. Retirar dinheiro");
    System.out.println("3. Ver moedas na caixa");
    System.out.println("4. Ver total da caixa");
    System.out.println("0. Termina\n");
    System.out.print("Opção: ");
  }
}
