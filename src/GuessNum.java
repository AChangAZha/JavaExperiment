import java.util.Scanner;
import java.util.Random;

public class GuessNum {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        try {
            int num = rand.nextInt(100) + 1;
            System.out.println("请输入一个整数");
            while (true) {
                int x = input.nextInt();
                if (x == num) {
                    System.out.println("猜对了");
                    break;
                } else if (x > num)
                    System.out.println("猜大了");
                else
                    System.out.println("猜小了");

            }
        } finally {
            input.close();
        }
    }
}
