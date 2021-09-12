import java.util.Arrays;

public class DemoStringBuffer {
    public static void main(String[] args) {
//        StringBuffer sb = new StringBuffer("Sun");
//        System.out.println("длина ->" + sb.length());
//        System.out.println("размер ->" + sb.capacity());
//        sb.append("Java");
//        System.out.println("строка -> " + sb);
//        System.out.println("длина -> " + sb.length());
//        System.out.println("размер -> " + sb.capacity());
//        System.out.println("реверс -> " + sb.reverse());
//        changeStr(sb);
//        System.out.println(sb);

        changeSentence("I am a doctor" , 3, 'e');

    }

    private static void changeStr(StringBuffer str) {
        str.append(" MicroSystems");
    }

    private static void changeSentence(String sentence, int position, char c) {
        String sb = new String(sentence);
        String[] str = sb.split(" ");
        String[] str1 = new String[str.length];
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() < position) {
                str1[i] = str[i];
            }
            else {
                char[] charArray = str[i].toCharArray();
                charArray[position] = c;
                str1[i] = new String(charArray);
            }
        }

        for (String s : str1) {
            System.out.print(s + " ");
        }
    }
}
