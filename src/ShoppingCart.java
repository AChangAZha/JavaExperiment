/*
 * @Author: AChangAZha
 * @Date: 2021-12-02 11:20:08
 * @LastEditTime: 2021-12-04 20:12:08
 * @LastEditors: AChangAZha
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ShoppingCart {
    public static double getSum(HashSet<Item> items) {
        double sum = 0;
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next().getTotalPrice();
        }
        return sum;
    }

    public static void main(String[] args) {
        Set<Item> items = new HashSet<Item>();
        Scanner input = new Scanner(System.in);
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("请依次输入第" + (i + 1) + "个商品的编号、名称、单价、购买数量");
                int serialNumber = input.nextInt();
                String name = input.next();
                Double unitPrice = input.nextDouble();
                int quantity = input.nextInt();
                items.add(new Item(serialNumber, name, unitPrice, quantity));
            }
        } finally {
            input.close();
        }
        Iterator<Item> iterator = items.iterator();
        System.out.println("");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("合计：" + getSum((HashSet<Item>) items) + "元");
    }
}
