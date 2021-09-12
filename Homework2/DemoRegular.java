import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoRegular {
    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("a+y");
        Matcher m1 = p1.matcher("aaaay");
        boolean b = m1.matches();
        System.out.println(b);

        String regex = "(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)*";

        String s = "адреса эл.почты:mymail@tut.by и rom@bsu.by";
        Pattern p2 = Pattern.compile(regex);
        Matcher m2 = p2.matcher(s);
        while(m2.find()) {
            System.out.println("e-mail: " + m2.group());
        }
    }
}
