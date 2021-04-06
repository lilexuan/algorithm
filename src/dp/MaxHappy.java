package dp;

import java.util.ArrayList;
import java.util.List;

public class MaxHappy {
    private static class Info {
        public int inHappy;
        public int outHappy;
        public Info(int inHappy, int outHappy) {
            this.inHappy = inHappy;
            this.outHappy = outHappy;
        }
    }

    private static class Employee {
        public int happy;
        public List<Employee> subordinates;
        public Employee(int happy, List<Employee> subordinates) {
            this.happy = happy;
            this.subordinates = subordinates;
        }

    }

    private static Info process(Employee x) {
        int inHappy = x.happy;
        int outHappy = 0;
        for (Employee sub : x.subordinates) {
            Info subInfo = process(sub);
            inHappy += subInfo.outHappy;
            outHappy += Math.max(subInfo.inHappy, subInfo.outHappy);
        }
        return new Info(inHappy, outHappy);
    }

    public static int maxHappy(Employee boss) {
        Info info = process(boss);
        return Math.max(info.inHappy, info.outHappy);
    }

    public static void main(String[] args) {
        List<Employee> subOfboss = new ArrayList<>();
        subOfboss.add(new Employee(1, new ArrayList<>()));
        subOfboss.add(new Employee(1, new ArrayList<>()));
        Employee boss = new Employee(5, subOfboss);
        System.out.println(maxHappy(boss));
    }
}
