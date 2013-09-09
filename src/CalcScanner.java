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
        PushbackReader in = new PushbackReader(new FileReader(file));
    	char s;
    	char c;
    	int x = 0;
        while (x!=-1 ) {
            x = in.read();
            in.unread(x);
        	s = nextToken(in);
        	c = scan(s);
        	System.out.print(c);
        } 
        
    } else {
    	System.out.print("There needs to be a file specified when launching. Format: -java CalcScanner [filename]");
    }
}

public static char nextToken(PushbackReader in) throws IOException {
	return (char) in.read();
}

public static char scan(char s) {
	if(s == ')') {
		return s;
	}
	if(s == '(') {
		return s;
	}
	
	return 'e';
}




}
