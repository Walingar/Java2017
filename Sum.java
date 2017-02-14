public class Sum {
    public static boolean isIntegerOrMinus(char value) {
        if (('0' <= value && value <= '9') || value == '-') {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        int total = 0;
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args[i].length(); j++) {
                if (isIntegerOrMinus(args[i].charAt(j))) {
                    int endOfNumber = j + 1;
                    while (endOfNumber < args[i].length() && isIntegerOrMinus(args[i].charAt(endOfNumber))) {
                        endOfNumber++;
                    }
                    total += Integer.parseInt(args[i].substring(j, endOfNumber));
                    j += endOfNumber - j;
                }
            }
        }
        System.out.println(total);
    }
}
