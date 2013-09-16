package calcscanner;

/*
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
       // System.out.print(file);
        if (args.length > 0) {
            File input = new File(args[0]);
            PushbackReader in = new PushbackReader(new FileReader(input));
            CalcScanner calc = new CalcScanner();               
            int s;
            String result = "";
            do {
        	s = calc.nextToken(in);
        	char token;
        	token = (char) s;     
                
                //$$
                if(token == '$') {
                    token = (char) in.read();
                    if(token == '$') {
                        break;
                    } else {
                        in.unread(token);
                    }
                }
                
                //symbols
                else if(token == '('
        				|| token == ')' 
        				|| token == '+'
        				|| token == '-'
        				|| token == '*'
        				|| token == '/') {
                    result+=token;
                } //:=
                else if (token == ':') {
                    char f = (char) in.read();
                    if (f != '=') {
                        in.unread(f);
                    } else {
                        result+=token + f;
                    }
                }
                
                //a-z,A-Z
                else if (String.valueOf(token).matches("^[a-zA-Z]")) {
                    if(String.valueOf(token).matches("[1-9]")) {
                        result+=token;
                    } else {
                        result+=token;
                    }
                } 
                //1-9
                else if(String.valueOf(token).matches("[1-9]")) {
                    result+=token;
                }
                
                //'read'
                if(token == 'r') {
                    char next = (char) in.read();
                    if(next == 'e') {
                        char next2 = (char) in.read(); 
                        if(next2 == 'a') {
                            char next3 = (char) in.read();
                            if(next3 == 'd') {
                                result += "read";
                            }   else in.unread(next3);
                        }   else in.unread(next2);
                    }   else in.unread(next);
                 }
                
                 //'write'
                 if(token == 'w') {
                    char pass = (char) in.read();
                    if(pass == 'r') {
                        char pass2 = (char) in.read(); 
                        if(pass2 == 'i') {
                            char pass3 = (char) in.read();
                            if(pass3 == 't') {
                            char pass4 = (char) in.read();
                                if(pass4 == 'e') {
                                    result+="write";
                                } else in.unread(pass4);
                            }   else in.unread(pass3);
                        }   else in.unread(pass2);
                    }   else in.unread(pass);
                 }
        		
        } while(s != -1);
    	System.out.print(result);
    }
}

    public int nextToken(PushbackReader reader) throws IOException {
        try { 
            return reader.read();
        
            } catch (IOException E) {
                System.out.println("There needs to be a file specified when launching. Format: -java CalcScanner [filename]");
            }
        return -1;
    }
}
