
public class Postfix {
	static int lookahead;
    
    public Postfix() throws IOException{
        lookahead = System.in.read();
    }

    void match(int t) throws IOException{
        if(lookahead == t){
            lookahead = System.in.read();
        }
        else{
            throw new Error("** Syntax Error! ***");
        }
    }
    
    void term() throws IOException{
        if(Character.isDigit((char)lookahead)||(char)lookahead==' '){
            System.out.write((char)lookahead);
            match(lookahead);
        }
        else{
            throw new Error("** Syntax Error! ***");
        }
    }
    
    void expr() throws IOException{
        term();
        while(true){
        	if(lookahead == '+') {
        		match('+');
                term();
                System.out.write('+');
        	}else if(lookahead == '-') {
        		match('-');
                term();
                System.out.write('-');
        	}
        }
    }
}
