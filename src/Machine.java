public class Machine {
    public void checkBag(Goods goods) throws DangerException {
        if (goods.isDanger()) {
            DangerException danger = new DangerException();
            throw danger; // 抛出danger
        } else {
            System.out.print(goods.getName() + "不是危险品! ");
        }
    }
}
