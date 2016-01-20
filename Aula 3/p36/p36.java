/* Programação modular - Aula 3 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual.
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 * */
import java.util.Scanner;

public class p36{
  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    int opcao=-1;
    Data d[] = new Data[2];
    boolean primeira=true;

    do{
      menu();
      opcao=sc.nextInt();
      System.out.println();
      switch (opcao){

        case 1: if(!primeira)
                  d[0]=d[1].getData();
                else
                  primeira = false;
                d[1] = new Data();
                sc.nextLine();
                break;
        case 2: 
                System.out.print("dia: ");
                int dia = sc.nextInt();
                System.out.print("mes: ");
                int mes = sc.nextInt();
                System.out.print("ano: ");
                int ano = sc.nextInt();
                if(!primeira)
                  d[0]=d[1].getData();
                else
                  primeira = false;
                d[1] = new Data(ano,mes,dia);
                break;
        case 3:
                if(d[1].dataValida())
                  System.out.println("Data válida!");
                else
                  System.out.println("Data inválida!");
                break;

        case 4: System.out.print("Data: ");
                d[1].dataPrint();
                System.out.println();
                break;
        case 5: System.out.println("Data: "+d[1].dataExtenso());
                break;
        case 6: d[0]= new Data(d[1].getGnumber());
                d[1].vaiParaOntem();
                sc.nextLine();
                break;
        case 7: d[0]= new Data(d[1].getGnumber());
                d[1].vaiParaAmanha();
                sc.nextLine();
                break;
        case 8: 
                d[1].dataPrint(); System.out.print(" = "); d[0].dataPrint();
                if(d[1].igual(d[0]))
                  System.out.println("? FALSO");
                else
                  System.out.println("? VERDADEIRO");
                break;
        case 9: d[1].dataPrint(); System.out.print(" > "); d[0].dataPrint();
                if(d[1].maior(d[0]))
                  System.out.println("? FALSO");
                else
                  System.out.println("? VERDADEIRO");
                break;
        case 10:d[1].dataPrint(); System.out.print(" < "); d[0].dataPrint();
                if(d[1].maior(d[0]))
                  System.out.println("? VERDADEIRO");
                else
                  System.out.println("? FALSO");
                break;
        case 11:d[1].dataPrint(); System.out.print(" - "); d[0].dataPrint();
                System.out.print(" = ");
                d[1].menos(d[0]);
                break;
       // case 0: System.exit(0);
       //         break;
      }
      if(opcao>0 && opcao<12){
        System.out.print("\nData: ");
        d[1].dataPrint();
        System.out.print("\n<Prima RETURN>");
        sc.nextLine(); 
        System.out.println();
      }
    }while(opcao!=0);

  }
  public static void menu(){
    System.out.println(" 1. Cria novo objecto com a data actual");
    System.out.println(" 2. Cria novo objecto com uma qualquer data");
    System.out.println(" 3. Indica se a data é válida");
    System.out.println(" 4. Escreve data");
    System.out.println(" 5. Escreve data por extenso");
    System.out.println(" 6. Dia anterior");
    System.out.println(" 7. Dia seguinte");
    System.out.println(" 8. Última data igual à penúltima");
    System.out.println(" 9. Última data maior do que a penúltima");
    System.out.println("10. Última data menor do que a penúltima");
    System.out.println("11. (Última data) - (Penúltima data)");
    System.out.println(" 0. Termina");
    System.out.println("\nNOTA: Se não houver outra indicação, todas as operações\n      fazem-se sobre o último objecto criado");
    System.out.print("\nOpção: ");
  }
}

