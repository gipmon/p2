/* Programação modular - Aula 3 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual.
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 * */
import java.util.Calendar;
public class Data{
  private long gnumber;
  private long ref=730486; //toDias(2000, 1, 1) (0-00-0000 a 1-01-2000)
  public void dataPrint(){
    System.out.printf("%02d-%02d-%04d",converter(2, ref+gnumber),converter(1, ref+gnumber),converter(0, ref+gnumber)); 
  }

  public Data(){
    Calendar hoje = Calendar.getInstance();
    this.gnumber = toDias(hoje.get(Calendar.YEAR), hoje.get(Calendar.MONTH)+1, hoje.get(Calendar.DAY_OF_MONTH))-ref;
   // System.out.println(this.gnumber);
  }
  public Data(long gnumber){
    this.gnumber=gnumber;
  }
  public Data(int a, int b, int c){
    this.gnumber = toDias(a, b, c)-ref;
   //  System.out.println(this.gnumber);
  }
  public long toDias(int ano, int mes, int dia){
    long dias=0;

    for(int a=0; a<ano; a++)
        dias+=diasAno(a);
    
    for(int m=1; m<mes; m++)
      dias+=nDias(ano, m);

    dias+=dia;
    //System.out.println(dias);
    return dias;
  }
  private int diasAno(int a){
    if(bisSexto(a))
      return 366;
    else
      return 365;
  }
  public int converter(int chooser, long g){ //0=ano, 1=mes, 2=dia
      int ano=0, mes=1;

      for(int a=0; g>(long)diasAno(a); a++){
        g-=diasAno(a);
        ano++;
        //System.out.println(ano);
      }
      for(int m=1; g>nDias(ano, m); m++){
        g-=nDias(ano, m);
        mes++;
        if(mes>=12)
          break;
        //System.out.println(mes+" + "+g+" + "+nDias(ano, m+1));
      }

      int dias=(int)g;
      //System.out.println(ano);
      //System.out.println(mes);
      //System.out.println(dias);
      if(chooser==0)
        return ano;
      else if(chooser==1)
        return mes;
      else 
        return dias;
  } 
  public String dataExtenso(){
    return this.converter(2, ref+gnumber)+" de "+nomeMes(this.converter(1, ref+gnumber))+" de "+this.converter(0, ref+gnumber);
  }  
  public boolean igual(Data a){
    if(this.gnumber==a.gnumber)
      return true;
    else
      return false;
  }
  public boolean maior(Data a){
    if(this.gnumber<a.gnumber)
      return true;
    else
      return false;
  }
  public void menos(Data a){
    System.out.println(this.gnumber-a.gnumber); 
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
  
  private boolean dataValida(long gnumber){//a=dia, b=mes, c=ano
    int a = this.converter(2, ref+gnumber);
    int b = this.converter(1, ref+gnumber);
    int c = this.converter(0, ref+gnumber);
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
    int dia = this.converter(2, ref+this.gnumber);
    int mes = this.converter(1, ref+this.gnumber);
    int ano = this.converter(0, ref+this.gnumber);

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
    this.gnumber++;    
  }
  public void vaiParaOntem(){
    this.gnumber--;    
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
  public Data getData(){
    return this;
  }
  public long getGnumber(){
    return this.gnumber;
  }
}


