/*Classes, Objectos e Pacotes - Aula 2 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 *  */
import java.util.Scanner;

public class p25{
  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    int opcao=-1;
    Data d = new Data();
    printMenu();
    do{
      opcao=sc.nextInt();
      sc.nextLine();
  
      switch (opcao){

        case 1: d = new Data();
                break;
        case 2: 
                System.out.print("dia: ");
                int dia = sc.nextInt();
                System.out.print("mes: ");
                int mes = sc.nextInt();
                System.out.print("ano: ");
                int ano = sc.nextInt();
                d = new Data(dia,mes,ano);
                break;
        case 3:
                if(d.dataValida())
                  System.out.println("Data válida!");
                else
                  System.out.println("Data inválida!");
                break;
        case 4: System.out.print("Data: ");
                d.dataPrint();
                break;
        case 5: System.out.println("Data: "+d.dataExtenso());
                break;
        case 6: d.vaiParaOntem();
                break;
        case 7: d.vaiParaAmanha();
                break;
        default:
                break;
      }
      if(opcao>0 && opcao<8){
        System.out.print("\nData: ");
        d.dataPrint();
        System.out.print("<Prima RETURN>");
        sc.nextLine(); 
        System.out.println();
        printMenu();
      }
    }while(opcao!=0);

  }
  public static void printMenu(){
    System.out.println("1. Cria novo objecto com a data actual");
    System.out.println("2. Cria novo objecto com uma qualquer data");
    System.out.println("3. Indica se a data é válida");
    System.out.println("4. Escreve data");
    System.out.println("5. Escreve data por extenso");
    System.out.println("6. Dia anterior");
    System.out.println("7. Dia seguinte");
    System.out.println("0. Termina");
    System.out.println("\nNOTA: Se não houver outra indicação, todas as operações\n      fazem-se sobre o último objecto criado");
    System.out.print("\nOpção: ");
  }
}
