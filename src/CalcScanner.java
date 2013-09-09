import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;


public class CalcScanner {
char z;
	
	
	public static void main(String[] args) throws IOException {
    if(args.length > 0) {
        File file = new File(args[0]);
       // System.out.print(file);
        PushbackReader reader = new PushbackReader(new FileReader(file));
    	char s;
    	int x = 0;
        while (x!=-1 ) {
            x = reader.read();
            reader.unread(x);
        	s = nextToken(reader);
        	System.out.print(s);
        } 
        
    } else {
    	System.out.print("There needs to be a file specified when launching. Format: -java CalcScanner [filename]");
    }
}

public static char nextToken(PushbackReader reader) throws IOException {
	return (char) reader.read();
}




}
