package greedy;

import java.util.PriorityQueue;

/**
 * 获取最大项目利益
 * https://www.nowcoder.com/questionTerminal/2c615dd9e73f4e3aa4b8cf395bba4c02
 */
public class IPO {
    public static int findMaxProfit(int k, int m, int[] costs, int[] profits) {
        Project[] projects = new Project[costs.length];
        for (int i = 0; i < costs.length; i++) {
            projects[i] = new Project(costs[i], profits[i]);
        }
        PriorityQueue<Project> lockedProjects = new PriorityQueue<>((p1, p2) -> {
            return p1.cost - p2.cost;
        });
        PriorityQueue<Project> unlockedProjects = new PriorityQueue<>((p1, p2) -> {
            return p2.profit - p1.profit;
        });
        for (Project project : projects) {
            lockedProjects.offer(project);
        }
        for (int i = 0; i < k; i++) {
            while (!lockedProjects.isEmpty() && lockedProjects.peek().cost <= m) {
                unlockedProjects.offer(lockedProjects.poll());
            }
            if (unlockedProjects.isEmpty()) {
                return m;
            }
            m += unlockedProjects.poll().profit;
        }
        return m;
    }

    public static void main(String[] args) {
        int m = 2;
        int k = 5;
        int[] costs = {1, 2, 3, 4, 2, 3, 6, 2};
        int[] profits = {1, 2, 3, 4, 2, 3, 6, 2};
        int res = findMaxProfit(k, m, costs, profits);
        System.out.println(res);
    }

}

class Project {
    public int cost;
    public int profit;
    public Project(int cost, int profit) {
        this.cost = cost;
        this.profit = profit;
    }
}
