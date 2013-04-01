import java.util.Hashtable ;
import java.util.Enumeration ;
import java.io.FileNotFoundException ;
import java.io.IOException ;
import java.io.BufferedReader ;
import java.io.FileReader ;

public class KeyCount implements IKeyCount
{
    public KeyCount() {} // Default constructor.

    /*
     * The function goes through string having file contents separated by
     * new lines. The line is split on the comma, and if there are more than
     * two entries on the line, or if the numbers are not in proper format,
     * or if the first string is not present, then that line is ignored.
     */
    private void fillKeyCountMap( String fcontent,
            Hashtable< String, Long > keycountmap )
    {
        String [] lines = fcontent.split( System.getProperty( "line.separator" ));
        for( String line : lines )
        {
            String [] kvpair = line.split(",");
            if( 2 == kvpair.length ) // Do not read lines that have more than one comma separator.
            {
                try
                {
                    Long value = new Long( kvpair[1].trim() ); // Get the second part as long number.
                    String key = kvpair[0].trim();
                    if( key.length() != 0 && key != null ) // If the first part of line is null or no 
                    {                                      // characters at all, then do not process.
                        if( keycountmap.containsKey( key ))  // Search for the existing entry.
                        {
                            Long nv = new Long( value.longValue() + 
                                    keycountmap.get( key ).longValue() );
                            keycountmap.put( key, nv );  // Update the existing value of the entry.
                        }
                        else // Treat this as a new entry.
                        {
                            keycountmap.put( key, value );
                        }
                    }
                    
                }
                catch( NumberFormatException nex ) {} // No need to deal with this exception. Ignore.
            }
        }
    }

    public boolean readFile( String filename, 
            Hashtable< String, Long > keycountmap )
    {
        StringBuilder contents = new StringBuilder();
        try
        {
            BufferedReader ip = new BufferedReader( new FileReader ( filename ));
            String line = null;
            while( (line = ip.readLine()) != null )
            {
                contents.append( line );
                contents.append( System.getProperty( "line.separator" ) );
            }
        }
        catch( FileNotFoundException fnfe )
        {
            System.err.println("File is not found \n"+ fnfe.getMessage());
            return false;
        }
        catch( SecurityException se )
        {
            System.err.println("Please change the security setting of the file "+
                    "\n"+ se.getMessage());
            return false;
        }
        catch( IOException ioex )
        {
            System.err.println("Could not read the file \n"+ ioex.getMessage());
            return false;
        }
        catch( Exception e )
        {
            System.err.println("Error "+ e.getMessage());
            return false;
        }
        fillKeyCountMap( contents.toString(), keycountmap ); 
        return true;
    }

    public void display( Hashtable< String, Long > keycountmap )
    {
        Enumeration e = keycountmap.keys();
        while( e.hasMoreElements() ) 
        {
            Object key = e.nextElement();
            System.out.print("The total for "+ key.toString() +" is "+
                    keycountmap.get( key ).toString()+ ". ");
        }
    }
}
