public class StringDemo {
    public static void main(String[] args) {
//        String str = new String("Sun");
//        changeStr(str);
//        System.out.println(str);

//        equalsString();

//        demoIntern();
        sortArray();
    }

    private static void changeStr(String str) {
        str.concat(" MicroSystems");
    }

    public static void equalsString() {
        String s1 = "Java";
        String s2 = "Java";

        String s3 = new String("Java");
        System.out.println(s1 + "==" +s2 +
                " : " + (s1 == s2));
        System.out.println(s1 + "==" +s3 +
                " : " + (s1 == s3));
        System.out.println(s1 + " equals " +s2 +
                " : " + s1.equals(s2));
        System.out.println(s1 + " equals " +s3 +
                " : " + s1.equals(s3));

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
    }

    public static void demoIntern () {
        String s1 = "Java";
        String s2 = new String("Java");
        System.out.println(s1 == s2);
        s2 = s2.intern();
        System.out.println(s1 == s2);
    }

    public static void sortArray () {
        String a[] = {" Alena", "Alice", " alina", " albina", " Anastasya", " ALLA", "AnnA  "};
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i].trim();
        }
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareToIgnoreCase(a[j]) < 0) {
                    String temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }

            }
        }

        for (String str: a) {
            System.out.println(str + " ");
        }
    }
}
