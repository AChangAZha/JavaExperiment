class Employee {
    String number;
    String name;
    int sex;
    String birthday;
    String professionalTitles;
}

interface PerformanceCalculation {
    double doPerformanceCalculation();

    String GetString(double performance);
}

class Teacher extends Employee implements PerformanceCalculation {
    double teachingLoad;
    double researchLoad;

    public Teacher(String number, String name, int sex, String birthday, String professionalTitles, double teachingLoad,
            double researchLoad) {
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.professionalTitles = professionalTitles;
        this.teachingLoad = teachingLoad;
        this.researchLoad = researchLoad;
    }

    public void doTeaching() {
        System.out.println(this.name + "教学");
    }

    public void doReSearch() {
        System.out.println(this.name + "做科研");
    }

    public double doPerformanceCalculation() {
        double performance = 0;
        performance = (teachingLoad - 320) / 320 + (researchLoad - 75) / 75;
        System.out.println("编号：" + number);
        System.out.println("姓名：" + name);
        if (sex == 1) {
            System.out.println("性别：" + "男");
        } else {
            System.out.println("性别：" + "女");
        }
        System.out.println("出生日期：" + birthday);
        System.out.println("职称:" + professionalTitles);
        System.out.println("教学工作量：" + teachingLoad);
        System.out.println("科研工作量：" + researchLoad);
        this.doTeaching();
        this.doReSearch();
        return performance;
    }

    public String GetString(double performance) {
        return this.name + "的绩效为:" + performance;
    }
}

class ResearchStaff extends Employee implements PerformanceCalculation {
    public double researchLoad;

    public ResearchStaff(String number, String name, int sex, String birthday, String professionalTitles,
            double researchLoad) {
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.professionalTitles = professionalTitles;
        this.researchLoad = researchLoad;
    }

    public void doReSearch() {
        System.out.println(this.name + "做科研");
    }

    public double doPerformanceCalculation() {
        double performance = 0;
        performance = (researchLoad - 400) / 400;
        System.out.println("编号：" + number);
        System.out.println("姓名：" + name);
        if (sex == 1) {
            System.out.println("性别：" + "男");
        } else {
            System.out.println("性别：" + "女");
        }
        System.out.println("出生日期：" + birthday);
        System.out.println("职称：" + professionalTitles);
        System.out.println("科研工作量：" + researchLoad);
        this.doReSearch();
        return performance;
    }

    public String GetString(double performance) {
        return this.name + "的绩效为:" + performance;
    }
}

class LaboratoryAssistant extends Employee implements PerformanceCalculation {
    double laboratoryLoad;
    double researchLoad;

    public LaboratoryAssistant(String number, String name, int sex, String birthday, String professionalTitles,
            double laboratoryLoad, double researchLoad) {
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.professionalTitles = professionalTitles;
        this.laboratoryLoad = laboratoryLoad;
        this.researchLoad = researchLoad;
    }

    public void doLaboratory() {
        System.out.println(this.name + "教学");
    }

    public void doReSearch() {
        System.out.println(this.name + "做科研");
    }

    public double doPerformanceCalculation() {
        double performance = 0;
        performance = (laboratoryLoad - 240) / 240 + (researchLoad - 75) / 75;
        System.out.println("编号：" + number);
        System.out.println("姓名：" + name);
        if (sex == 1) {
            System.out.println("性别：" + "男");
        } else {
            System.out.println("性别：" + "女");
        }
        System.out.println("出生日期：" + birthday);
        System.out.println("职称：" + professionalTitles);
        System.out.println("实验工作量：" + laboratoryLoad);
        System.out.println("科研工作量：" + researchLoad);
        this.doLaboratory();
        this.doReSearch();
        return performance;
    }

    public String GetString(double performance) {
        return this.name + "的绩效为:" + performance;
    }
}

class PerformanceCalculationAdmin {
    public void allPerformanceCalculation(PerformanceCalculation[] pe) {
        for (int i = 0; i < pe.length; i++) {
            System.out.println(pe[i].GetString(pe[i].doPerformanceCalculation()));
        }
    }
}

public class School {
    public static void main(String[] args) {
        PerformanceCalculation[] employee = new PerformanceCalculation[3];
        employee[0] = new Teacher("1", "张三", 1, "1 995年7月11日", "老师", 520, 90);
        employee[1] = new ResearchStaff("2", "张思思", 1, " 1999年8月1日", "研究员 ", 800);
        employee[2] = new LaboratoryAssistant("3", "陈康", 1, " 1994年3月16日", "实验员 ", 530, 80);
        PerformanceCalculationAdmin a = new PerformanceCalculationAdmin();
        a.allPerformanceCalculation(employee);
    }
}