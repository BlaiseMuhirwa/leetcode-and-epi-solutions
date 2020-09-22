package Arrays_and_Strings;

public class ReverseWordsInAString3 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int index = 0, len = words.length;
        for (String word : words) {
            sb.append(reverseString(word));
            if (index == len - 1) continue;
            else {
                sb.append(" ");
            }
            index++;
        }
        return sb.toString();
    }

    public String reverseString(String s) {
        if (s == null || s.length() == 0) return s;

        int j = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (j >= 0) {
            sb.append(s.charAt(j));
            j--;
        }
        return sb.toString();

    }
}
