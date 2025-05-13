
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
        Pattern pattern = Pattern.compile("^(\\d+)\\s*([+\\-*/])\\s*(\\d+)$");
        Matcher matcher = pattern.matcher(input);

       if (!matcher.matches()) {
            throw new Exception();
       }

        if(Integer.parseInt(str[0]) > 10 || Integer.parseInt(str[2]) > 10 || Integer.parseInt(str[0]) < 1 || Integer.parseInt(str[2]) < 1) {
            throw new Exception();

        }
        if(!(str[1].equals("+") || str[1].equals("-") || str[1].equals("/") || str[1].equals("*"))) {
            throw new Exception();

        }

    }


    public static String calc(String input) throws Exception {
        String[] str = input.split(" ");

        switch (str[1]) {
            case "+" -> {
                return String.valueOf(Integer.parseInt(str[0]) + Integer.parseInt(str[2]));
            }
            case "-" -> {
                return String.valueOf(Integer.parseInt(str[0]) - Integer.parseInt(str[2]));
            }
            case "*" -> {
                return String.valueOf(Integer.parseInt(str[0]) * Integer.parseInt(str[2]));
            }
            case "/" -> {
                if (Integer.parseInt(str[2]) == 0) {
                   throw new Exception("Division by zero");
               }
                return String.valueOf(Integer.parseInt(str[0]) / Integer.parseInt(str[2]));
            }
            default -> throw new Exception("Invalid operator");

        }

    }
}



