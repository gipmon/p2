/*Classes, Objectos e Pacotes - Aula 2 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 *  */
import java.util.Calendar;
public class Data{
  private int dia, mes, ano;

  public void dataPrint(){
     System.out.printf("%02d-%02d-%04d\n",dia,mes,ano); 
  }
  
  public Data(){
        Calendar hoje = Calendar.getInstance();
        this.dia = hoje.get(Calendar.DAY_OF_MONTH);
        this.mes = hoje.get(Calendar.MONTH) + 1;
        this.ano = hoje.get(Calendar.YEAR);
  }
  public Data(int a, int b, int c){
        this.dia = a;
        this.mes = b;
        this.ano = c;
  }
  public String dataExtenso(){
    return this.dia+" de "+nomeMes(this.mes)+" de "+this.ano;
  }

  private String nomeMes(int a){ //a=mes
      String mes[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    return mes[a-1];
  }
  private static boolean bisSexto(int a){ //a=ano
    if(a%400==0 || (a%4==0 && a%100!=0))
          return true;
      else return false;  
  }
  
  
  private static boolean dataValida(int a, int b, int c){//a=dia, b=mes, c=ano
    //validar dias
    if(c<1){
      return false;
    }else if(b>12 || b<1){
      return false;
    }else if(a>nDias(c, b) || a<1){
      return false;
    }else 
      return true;
  }
   public boolean dataValida(){//a=dia, b=mes    , c=ano
      if(ano<1){
        return false;
      }else if(mes>12 || mes<1){
        return false;
      }else if(dia>nDias(ano, mes) || dia<1){
        return false;
      }else 
        return true;
   }
  public void vaiParaAmanha(){
        dia++;    
          
        if(dataValida(dia, mes, ano))
              return;
        else{
              dia = 1;
              mes++;
        } 
        if(dataValida(dia, mes, ano))
               return;
        else{
              mes = 1;
              ano++;
        }
  }
  
  public void vaiParaOntem(){
          dia--;    
          if(dataValida(dia, mes, ano))
                return;
          else{
                mes--;
                dia = nDias(ano, mes);
          } 
          if(dataValida(dia, mes, ano))
                return;
          else{
                mes = 12;
                ano--;
          }
  }

  private static int nDias(int a, int b){
    switch(b){
          case 1: return 31;
          case 2:
              if(bisSexto(a))
                return 29;
              else
                return 28;
          case 3: return 31; 
          case 4: return 30;
          case 5: return 31;
          case 6: return 30;
          case 7: return 31;
          case 8: return 31;
          case 9: return 30;
          case 10: return 31;
          case 11: return 30;
          case 12: return 31;
    }
    return 0;
  }
  

}
