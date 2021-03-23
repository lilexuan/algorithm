package greedy;

import java.util.Arrays;

public class BestArrange {
    public static int bestArrage(int[][] projects) {
        if (projects == null || projects.length == 0) {
            return 0;
        }
        Arrays.sort(projects, (o1, o2) -> {
            return o1[1] - o1[1];
        });
        int end = projects[0][1];
        int cnt = 1;
        for (int i = 1; i < projects.length; i++) {
            if (projects[i][0] >= end) {
                cnt++;
                end = projects[i][1];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] projects = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(bestArrage(projects));
    }
}
