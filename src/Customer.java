
/*
 * @Author: AChangAZha
 * @Date: 2021-12-04 20:53:13
 * @LastEditTime: 2021-12-04 22:05:10
 * @LastEditors: AChangAZha
 */
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Customer {
    private Set<Integer> num = new HashSet<Integer>();

    public void SelectNumber() {
        Scanner select = new Scanner(System.in);
        try {
            while (num.size() < 7) {
                System.out.println("请输入第" + (num.size() + 1) + "个号码");
                int number = select.nextInt();
                if (number < 1 || number > 30) {
                    System.out.println("输入的号码不在1~30之间，请重新输入");
                    continue;
                }
                if (!num.add(number)) {
                    System.out.println("该号码已存在，请重新输入");
                    continue;
                }
            }
        } finally {
            select.close();
        }

    }

    public Set<Integer> GetNum() {
        return num;
    }

    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        Customer customer = new Customer();
        customer.SelectNumber();
        lottery.Draw(customer.GetNum());
    }
}
