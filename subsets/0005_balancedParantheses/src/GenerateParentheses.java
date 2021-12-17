import java.util.*;

class ParenthesesString {
    String str;
    int parenOpen;
    int parenClose;

    public ParenthesesString(String s, int parenOpen, int parenClose) {
        str = s;
        this.parenOpen = parenOpen;
        this.parenClose = parenClose;
    }
}

class GenerateParentheses {

    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<String>();

        Queue<ParenthesesString> parens = new LinkedList<>();
        parens.add(new ParenthesesString("",0,0));

        while(!parens.isEmpty()) {
            ParenthesesString ps = parens.poll();

            if(ps.parenOpen==num && ps.parenClose==num) {
                result.add(ps.str);
            }
            else {
                if(ps.parenOpen < num)
                    parens.add(new ParenthesesString(ps.str + "(", ps.parenOpen+1,ps.parenClose));
                if(ps.parenClose < ps.parenOpen)
                    parens.add(new ParenthesesString(ps.str + ")",ps.parenOpen,ps.parenClose+1));
            }
        }

        // TODO: Write your code here
        return result;
    }

    public static void main(String[] args) {
        List<String> result = GenerateParentheses.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParentheses.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
