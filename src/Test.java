public class Test {
    public static void main(String[] args) {
        IntArray intArray = new IntArray(5, 1, 3, 4, 2, 6);
        InFunction inFunctions = intArray.GetInfunction();
        System.out.printf("平均值为： %.2f\n", inFunctions.Average());
        System.out.println("最大值为： " + inFunctions.Max());
        System.out.println("最小值为： " + inFunctions.Min());
        System.out.print("排序： ");
        inFunctions.Sort();
    }
}