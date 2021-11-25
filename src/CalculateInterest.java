import java.util.Calendar;
import java.util.Scanner;

public class CalculateInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入存款钱数：");
        int money = scanner.nextInt();
        System.out.print("请输入日利率：");
        double rate = scanner.nextDouble();
        System.out.println("输入存款起始日期");
        System.out.print("输入年份：");
        short yearOne = scanner.nextShort();
        System.out.print("输入月份：");
        byte monthOne = scanner.nextByte();
        System.out.print("输入日期：");
        byte dayOne = scanner.nextByte();
        System.out.println("输入存款截止日期");
        System.out.print("输入年份：");
        short yearTwo = scanner.nextShort();
        System.out.print("输入月份：");
        byte monthTwo = scanner.nextByte();
        System.out.print("输入日期：");
        byte dayTwo = scanner.nextByte();
        Calendar calendar = Calendar.getInstance();
        calendar.set(yearOne, monthOne - 1, dayOne);
        long timeOne = calendar.getTimeInMillis();
        calendar.set(yearTwo, monthTwo - 1, dayTwo);
        long timeTwo = calendar.getTimeInMillis();
        long days = (Math.abs(timeTwo - timeOne)) / (1000 * 60 * 60 * 24);
        System.out.println("总天数为" + days + "天");
        double interest = money * Math.pow(1 + rate, days) - money;
        System.out.println("利息为：" + interest);
    }
}
