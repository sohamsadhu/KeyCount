Usage : java Main <file path>

There is a test file in this folder test.txt which can be used

    java Main test.txt
    The total for 4 is 2. The total for Jane is 10. The total for John is 4. The total for jane is 3. The total for 4.2 is 21.

on the console, to test the application.

The folder contains 3 Java files. One is just interface file IKeyCount.java
that contains two methods, that are required for implementing the
problem solution. One of the methods

    readFile( filename, hashtable )

accepts a file path and a hash table of type string as key and long as value.
It then fills the hash table with the contents of the file, where each of
the key becomes a entry in hash table and the value along side is stored
cumulatively as value. The choice of hashtable instead of hash map here was
just to make sure, that when this hash table is passed to the file, then no 
other function any where else is able to modify the hash table, since they are
thread safe (though they are slow also, than hash map).

The other function 

    display( hashtable )

just accepts a hash table (expecting it to be filled with keys and values) and
then print them as specified by the problem.

The file KeyCount.java implements the interface IKeyCount. The function readFile()
just reads the file and sends back a false value to calling function to say it
failed in read operation of file and print error message or returns true in case
it was able to read the file.

The filling up of the hash table is done by the helper function 

    fillKeyCountMap( string, hash table )

The first parameter it gets is the contents of the file in a single string and the
hash table to be filled. The function goes through each line of the file aided by
the line separator. 

The assumption here is if the second token on the line separated by comma is not an 
integer or long, or if there are more than one comma separator, or any one of the token
on a line is absent, then that line will be ignored. Numerical values for Key are
also accepted as key.

Lastly, the file Main.java has is the start program. It has only two functions one main
and another usage. If the file provided is successfully read, then the display function
is called in KeyCount class with the hash table, to print the values.
