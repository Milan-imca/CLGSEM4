package Dec7_23;

import java.util.Scanner;

public class ArithmeticOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1,num2,inputCh;
        System.out.println("Enter first number : ");
        num1 = sc.nextInt();
        System.out.println("Enter second number : ");
        num2 = sc.nextInt();

        System.out.println("Enter choice :\n" +
                "Press 1 : Addition\n" +
                "Press 2 : Subtraction\n" +
                "Press 3 : Multiplication\n" +
                "Press 4 : Division\n" +
                "Press 5 : Exit"
                );
        inputCh = sc.nextInt();
        switch (inputCh){
            case 1:
                addition(num1,num2);
                break;
            case 2:
                subtraction(num1,num2);
                break;
            case 3:
                multiplication(num1,num2);
                break;
            case 4:
                division(num1,num2);
            case 5:
                System.exit(0);
            default:
                System.out.println("Invalid Selection Please Give a correct input");
        }

    }
    static void addition(int n1,int n2){
        int sum = n1 + n2;
        System.out.println(n1 + " + " + n2 + " = " + sum);
    }
    static void subtraction(int n1,int n2){
        int ans = n1 - n2;
        System.out.println(n1 + " - " + n2 + " = " + ans);
    }
    static void multiplication(int n1,int n2){
        int ans = n1 * n2;
        System.out.println(n1 + " * " + n2 + " = " + ans);
    }
    static void division(int n1,int n2){
        float ans = (float) n1 / n2;
        System.out.println(n1 + " / " + n2 + " = " + ans);
    }


}
