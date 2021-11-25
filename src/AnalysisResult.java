import java.io.*;
import java.util.*;

public class AnalysisResult {
    public static double getTotalScore(String s) {
        Scanner scanner = new Scanner(s);
        scanner.useDelimiter("[^0123456789.]+");
        double totalScore = 0;
        while (scanner.hasNext()) {
            try {
                double score = scanner.nextDouble();
                totalScore = totalScore + score;
            } catch (InputMismatchException exp) {
                String t = scanner.next();
            }
        }
        return totalScore;
    }

    public static void main(String args[]) {
        File fRead = new File("score.txt");
        File fWrite = new File("socreAnalysis.txt");
        try {
            Writer out = new FileWriter(fWrite, true);
            BufferedWriter bufferWrite = new BufferedWriter(out); // 【代码2】创建指向out的bufferWrite流
            Reader in = new FileReader(fRead); // 【代码3】创建指向文件fRead的in流
            BufferedReader bufferRead = new BufferedReader(in); // 【代码4】创建指向in的bufferRead流
            String str = null;
            while ((str = bufferRead.readLine()) != null) {
                double totalScore = getTotalScore(str);
                str = str + " 总分:" + totalScore;
                System.out.println(str);
                bufferWrite.write(str);
                bufferWrite.newLine();
            }
            bufferRead.close();
            bufferWrite.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
