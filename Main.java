import java.util.Hashtable;

public class Main
{
    public void usage()
    {
        System.out.println("Usage: java Main <file path name>");
    }

    public static void main( String [] args )
    {
        Main M = new Main();
        if( args.length == 1 )
        {
            IKeyCount KC = new KeyCount();
            Hashtable< String, Long > keycountmap = new Hashtable< String, Long >();
            if( KC.readFile( args[0], keycountmap )) {
                KC.display( keycountmap );
            }
        }
        else
        {
            M.usage();
        }
    }
}
