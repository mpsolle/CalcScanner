/**
 * 
 * @author Matthew Solle 
 * @email msolle90@gmail.com
 * @github github.com/mpsolle
 * 
 */


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

public class CalcScanner {
	
	public static void main(String[] args) throws IOException {
    if(args.length > 0) {
        File file = new File(args[0]);
       // System.out.print(file);
        PushbackReader in = new PushbackReader(new FileReader(file));
        CalcScanner scan = new CalcScanner();
    	
        
        int s;
        String result = "";
        do {
        	s = scan.nextToken(in);
        	char token;
        	token = (char) s;       	
        	if(String.valueOf(token).matches("^[a-zA-Z]") ) {
        		result+=token;
        	}
        	System.out.print(result);
        } while(s != -1);
    } else {
    	System.out.print("There needs to be a file specified when launching. Format: -java CalcScanner [filename]");
    }
}

public int nextToken(PushbackReader in) throws IOException {
	return in.read();
	}
}

//public static char scan(char s) {
//	if(s == ')') {
//		return s;
//	}
//	if(s == '(') {
//		return s;
//	}
//	
//	return 'e';
//}
