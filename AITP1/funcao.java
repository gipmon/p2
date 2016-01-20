/* Rafael Ferreira */
static int f(int[] a, int r) {
    for(int i = 0; i < a.length; i=i+2)
          r += a[i];
      return r;
}

int [] x = {4,1,2,3,5}
int y = 3;
System.out.print(f(x,y));

/* Sabendo que começa em 3 pois y=3 logo r=3
 * e que i=0, a[0]=4, r+=4=7 depois é incrementado 2
 * logo i=2, a[2]=2, r+=2=9 depois é incrementado 2
 * logo i=4, a[4]=5, r+=5=14 depois é incrementado 2 só
 * que ultrapassa 5 logo para.
 * Logo a saída é 14 */
