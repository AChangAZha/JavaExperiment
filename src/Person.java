import java.util.Scanner;

class IleageAgeException extends Exception {
    public IleageAgeException(String s) {
        super(s);
    }
}

public class Person {
    public int age;
    public String name;
    public String sex;

    public int GetAge() {
        return age;
    }

    public void SetAge(int age) throws IleageAgeException {
        if (age < 1 || age > 150) {
            throw new IleageAgeException("输入的年龄不在1~150之间");
        } else {
            this.age = age;
        }
    }

    public String GetName() {
        return name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public String GetSex() {
        return sex;
    }

    public void SetSex(String sex) {
        this.sex = sex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person();
        while (true) {
            try {
                System.out.println("输入姓名：");
                person.SetName(scanner.next());
                System.out.println("输入性别：");
                person.SetSex(scanner.next());
                System.out.println("输入年龄：");
                person.SetAge(scanner.nextInt());
                System.out.println("姓名：" + person.GetName());
                System.out.println("性别：" + person.GetSex());
                System.out.println("年龄：" + person.GetAge());
                break;
            } catch (IleageAgeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
