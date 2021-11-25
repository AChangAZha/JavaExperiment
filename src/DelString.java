public class DelString {
    public String del(String a, String b) {
        StringBuffer string_a = new StringBuffer(a);
        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j < string_a.length(); j++) {
                if (string_a.charAt(j) == b.charAt(i)) {
                    string_a.deleteCharAt(j);
                    j--;
                }
            }
        }
        return string_a.toString();
    }

    public static void main(String[] args) {
        String a = "They are students.";
        String b = "aeiou";
        String c = "i am a teacher";
        String d = "bb";
        DelString test = new DelString();
        System.out.println(a);
        System.out.println(b);
        System.out.println(test.del(a, b));
        System.out.println(c);
        System.out.println(d);
        System.out.println(test.del(c, d));
    }
}
