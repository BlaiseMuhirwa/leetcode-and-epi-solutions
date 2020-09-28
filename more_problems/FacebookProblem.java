package more_problems;

public class FacebookProblem {
    public static int exchangeDigits(int num) {
        if (num % 10 == num) return num;

        String str = Integer.toString(num);
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while (i < str.length()) {
            sb.append(str.charAt(i));
            sb.append(str.charAt(i - 1));
            if (i + 2 == str.length()) {
                sb.append(str.charAt(i + 1));
                break;
            } else i += 2;
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(exchangeDigits(12345));
        System.out.println(exchangeDigits(00000));
        System.out.println(exchangeDigits(10));
        System.out.println(exchangeDigits(1));
        System.out.println(exchangeDigits(1234567891));
    }
}
