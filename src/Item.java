/*
 * @Author: AChangAZha
 * @Date: 2021-12-02 11:29:40
 * @LastEditTime: 2021-12-02 21:11:01
 * @LastEditors: AChangAZha
 */
public class Item {
    private int serialNumber;
    private String productName;
    private double unitPrice;
    private int quantity = 1;

    public Item(int serialNumber, String name, double unitPrice, int quantity) {
        this.serialNumber = serialNumber;
        this.productName = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return this.unitPrice * this.quantity;
    }

    @Override
    public int hashCode() {
        return this.serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        if (this == o || this.serialNumber == item.serialNumber) {
            item.quantity += this.quantity;
            /**
             * 通过调试可以发现，HashSet添加元素时
             * 如果HashSet中已存在与待添加元素(this)哈希值相同的元素(o)
             * 则会比较(this)与(o)的编号
             * 若(this)与(o)的编号相等
             * 则将(o)的数量(quantity)更新，不再重复加入(this)
             */
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + this.serialNumber + " " + this.productName + " 单价：" + this.unitPrice + " 数量：" + this.quantity
                + " 金额：" + getTotalPrice() + "元";
    }

}
