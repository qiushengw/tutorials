import java.util.regex.*;

import sun.nio.cs.ext.MacHebrew;

class Main {

    public static void main(String[] args) {
        System.out.println("test");

        Pattern ptrn = Pattern.compile("([a-zA-Z]+) (\\d+)");
        Matcher matcher = ptrn.matcher("June 24");
        if (matcher.matches()) {
            // Indeed, the expression "([a-zA-Z]+) (\d+)" matches the date string
            // To get the indices of the match, you can read the Matcher object's
            // start and end values.
            // This will print [0, 7], since it matches at the beginning and end of the
            // string
            System.out.println("Match at index [" + matcher.start() + ", " + matcher.end() + ")");

            // To get the fully matched text, you can read the Matcher object's group
            // This will print "June 24"
            System.out.println("Match: " + matcher.group());
        }

        ptrn = Pattern.compile("([a-zA-Z]+|\\s)+");
        matcher = ptrn.matcher("    W W WW   ddd");
        System.out.println("matcher.matches()"+matcher.matches());
        System.out.println("matcher.groupCount():"+matcher.groupCount());
        System.out.println(matcher);

        

        
        

    }
}
