import java.util.*;

public class IntArray {
    public ArrayList<Integer> arr = new ArrayList<Integer>();

    public IntArray(int... numbers) {
        for (int num : numbers) {
            arr.add(num);
        }
    }

    private class IntFunctions implements InFunction {
        public void Sort() {
            Collections.sort(arr);
            for (int i = 0; i < arr.size(); i++) {
                System.out.printf(arr.get(i) + " ");
            }
        }

        public double Average() {
            double sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum += arr.get(i);
            }
            return sum / arr.size();
        }

        public int Max() {
            int max = arr.get(0);
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i) > max)
                    max = arr.get(i);
            }
            return max;
        }

        public int Min() {
            int min = arr.get(0);
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i) < min)
                    min = arr.get(i);
            }
            return min;
        }
    }

    public IntFunctions GetInfunction() {
        return new IntFunctions();
    }

}