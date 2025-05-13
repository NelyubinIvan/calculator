import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        String operationOnNumbers = input.nextLine();
        checkingForExceptions(operationOnNumbers);
        System.out.println(calc(operationOnNumbers));


    }

    public static void checkingForExceptions(String input) throws Exception {
        String[] str = input.split(" ");
        if (str.length < 3) {
            throw new Exception("throws Exception");
        }
        int number1 = Integer.parseInt(str[0]);
        int number2 = Integer.parseInt(str[2]);
        Pattern pattern = Pattern.compile("^(\\d+)\\s*([+\\-*/])\\s*(\\d+)$");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new Exception("throws Exception");
        }
        if (number1 > 10 || number2 > 10 || number1 < 1 || number2 < 1) {
            throw new Exception("throws Exception");

        }

    }


    public static String calc(String input) throws Exception {
        String[] str = input.split(" ");
        int number1 = Integer.parseInt(str[0]);
        int number2 = Integer.parseInt(str[2]);
        String operator = str[1];
        switch (operator) {
            case "+" -> {
                return String.valueOf(number1 + number2);
            }
            case "-" -> {
                return String.valueOf(number1 - number2);
            }
            case "*" -> {
                return String.valueOf(number1 * number2);
            }
            case "/" -> {
                if (Integer.parseInt(str[2]) == 0) {
                    throw new Exception("throws Exception");
                }
                return String.valueOf(number1 / number2);
            }
            default -> throw new Exception();

        }

    }
}


