import java.util.Hashtable;

/**
 * @author Soham Sadhu
 * <p> The following interface consists of two methods, that will be
 * required to do the Key Count task. Providing the file name and
 * collecting data in a hash table. And then displaying the contents
 * of that hash table.</p>
 * <p> The choice of hash table instead of hash map is just to make
 * sure we have a thread safe data structure. The choice to have a 
 * long data type for count instead of integer, is on basis that values
 * accumulated in file could be small for integer to fill.</p>
 */
public interface IKeyCount
{
    /**
     * @param filename is a String that contains file path
     * @param keycountmap that will hold 
     * @return a boolean indicating if file contents were read
     * <p>
     * readFile() will open and read the contents of the file.
     * Expected file is ASCII. Each line on file starts with string
     * and ends with a whole number separated by a comma.<br/>
     * The string in the line will become the key in the hash table
     * provided and the number is the value of that key. If the string
     * reappears, then the number to the string will be cumulatively
     * added to the value, to the corresponding key in the table. <br/>
     * If the file could not be read, then a false value will be
     * returned. <br/>
     * If the file can be read, but the contents of the file are 
     * invalid. For example, if a line has more than one comma
     * separator, the order of string and number interchanged, or the
     * string is empty, then no attempt to read that line will be made.
     * </p>
     */
    public boolean readFile( String filename, 
            Hashtable< String, Long > keycountmap );

    /**
     * @param keycountmap consisting of a string and the corresponding
     *      count
     * <p>
     * display() will print all the entries in the provided hash table
     * in the following manner. <br/>
     * "The total for &lt;key&gt; is &lt;value&gt;." <br/>
     * Where 'key' and 'value' correspond to key and value, of entries,
     * in the provided hash table.
     * </p>
     */
    public void display( Hashtable< String, Long > keycountmap );
}
