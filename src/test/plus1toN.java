package test;

public class plus1toN {
    public static void main(String[] args) {
        SolutionPlus1toN s = new SolutionPlus1toN();
        int i = s.Sum_Solution(1);
        System.out.println(i);
    }
}

class SolutionPlus1toN {
    int sum = 0;
    public int Sum_Solution(int n) {
        boolean bool = (n >= 1) && (sum += (n + Sum_Solution(n-1))) > 0;
        return sum;
    }
}
