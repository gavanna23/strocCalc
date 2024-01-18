import java.util.Scanner;

public class Main {
    static String stroca1;
    static String stroca2;
    static char arif_action;
    static String result;

    public static void main(String[] args) throws Exception {
        System.out.println("Введите пример");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(stringCalc(input));
    }

    public static String stringCalc(String input) throws Exception {
        try {
            String split1 = input.replaceAll("\"", "");
            String[] split = split1.split(" [+\\- */] ");
            stroca1 = split[0].trim();
            stroca2 = split[1].trim();
            if (stroca1 != "[0-9)]") {
                throw new Exception("Первым аргументом выражения должна быть введена строка");
            }
            if (stroca1.length() > 10 | stroca2.length() > 10) {
                throw new Exception("Строки должны быть не более 10 символов");
            }
            char[] znak = new char[split1.length()];
            for (int i = 0; i < split1.length(); i++) {

                znak[i] = split1.charAt(i);
                if (znak[i] == '+') {
                    arif_action = '+';
                }
                if (znak[i] == '-') {
                    arif_action = '-';
                }
                if (znak[i] == '*') {
                    arif_action = '*';
                }
                if (znak[i] == '/') {
                    arif_action = '/';
                }
            }

            switch (arif_action) {
                case '+':
                    result = stroca1 + stroca2;
                    break;
                case '*':
                    int i = Integer.parseInt(stroca2.trim());
                    if (i > 10) {
                        throw new Exception("Число должно быть не больше 10");
                    } else
                        result = stroca1.repeat(i);
                    break;
                case '/':
                    int j = Integer.parseInt(stroca2.trim());
                    if (j > 10) {
                        throw new Exception("Число должно быть не больше 10");
                    } else result = stroca1.substring(0, stroca1.length() / j);
                    break;
                case '-':
                    int minus = stroca1.indexOf(stroca2);
                    if (minus == -1) {
                        result = stroca1;
                    } else result = stroca1.substring(0, minus);
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Умножать и делить на слова нельзя");
        }
        if (result.length() > 40) {
            throw new Exception(result.substring(0, 40) + "...");
        } else return result;
    }
}