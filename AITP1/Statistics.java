/* Rafael Ferreira */
public class Statistics {

private double data [];
private int n;
private final int BLOCK = 16;

Statistics ()
{
     data = new double[BLOCK];
     n = 0;
}

private void resize ( int delta )
{
    if (data.length >= n + delta) {
        return;
    }

    double copy[] = data ;

    data = new double[n + delta + BLOCK];

    for (int i = 0; i < copy.length ; i++) {
        data[i] = copy[i];
    }
}

public int add ( double x )
{
     resize (1);

     data[n++] = x;

     return n;
}

public int add ( double x[] ) throws  IllegalArgumentException
{
     if (x == null ) {
     	 throw new IllegalArgumentException ( "Null reference" );
     }

     resize ( x.length );

     for (int i = 0; i < x.length; i++) {
         data[n++] = x[i];
     }

     return n;
}

public double average () throws  IllegalArgumentException
{
     if (n == 0 ) {
         throw new IllegalArgumentException  ( "Empty data set" );
     }

     double sum  = 0;

     for (int i = 0; i < n; i++) {
	 sum += data[i];
     }

     return sum / n;
}

} 