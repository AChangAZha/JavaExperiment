interface CompurerAverage {
    public double average(double x[]);
}

class Gymnastics implements CompurerAverage {
    public double average(double x[]) {
        int count = x.length;
        double aver = 0, temp = 0;
        for (int i = 0; i < count; i++) {
            for (int j = i; j < count; j++) {
                if (x[j] < x[i]) {
                    temp = x[j];
                    x[j] = x[i];
                    x[i] = temp;
                }
            }
        }
        for (int i = 1; i < count - 1; i++) {
            aver = aver + x[i];
        }
        if (count > 2)
            aver = aver / (count - 2);
        else
            aver = 0;
        return aver;
    }
}

class BSchool implements CompurerAverage {// 重写public double average(double x[]);返回数组x[]的元素的算术平均
    public double average(double x[]) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i];
        }
        return sum / x.length;
    }
}

public class Estimator {
    public static void main(String args[]) {
        double a[] = { 9.89, 9.88, 9.99, 9.12, 9.69, 9.76, 8.97 };
        double b[] = { 89, 56, 78, 90, 100, 77, 56, 45, 36, 79, 98 };
        CompurerAverage computer;
        computer = new Gymnastics();
        double result = computer.average(a); // computer调用average(double x[])方法，将数组a传递给参数x
        System.out.printf("%n");
        System.out.printf("体操选手最后得分:%5.3f\n", result);
        computer = new BSchool();
        result = computer.average(b); // computer调用average(double x[])方法，将数组b传递给参数x
        System.out.printf("班级考试平均分数:%-5.2f", result);
    }
}
