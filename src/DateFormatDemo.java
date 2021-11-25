import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {
    public static void main(String[] args) {
        SimpleDateFormat ft1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 2021-10-19 15:31:46
        SimpleDateFormat ft2 = new SimpleDateFormat("yyyy月MM月dd日 HH时mm分ss秒"); // 2021年10月19日 15时31分46秒
        SimpleDateFormat ft3 = new SimpleDateFormat("yyyy-MM-dd EEEE"); // 2021-10-19 星期二
        String s1 = ft1.format(new Date());
        String s2 = ft2.format(new Date());
        String s3 = ft3.format(new Date());

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}