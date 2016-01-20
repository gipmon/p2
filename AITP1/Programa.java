/* Rafael Ferreira */
public static void main(String[] args)   {
        Mod p = new Mod("abc",false); 
        Mod.v = -5; 
        int j = p.yup(true, new Mod(false)); 
      } 
    }
class Mod {
      Mod(String s, boolean b) {}
      public static int v; 
      Mod(boolean x) {}  
      public int yup(boolean a, Mod a) {} 
    }