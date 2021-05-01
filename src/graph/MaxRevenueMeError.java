package graph;

import java.util.*;

/**
 * @author kelvin
 * @create 2021-05-01 17:18
 * @Desc 图的dfs拓展, 我的实现有bug, 一定要全部走完才能更新最大值, 而不能边走边更新, 看看左神是怎么实现的吧
 */
public class MaxRevenueMeError {
    private static char[] words = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    private static Map<NodeMR, Integer> nodeIndexMap = new HashMap<>();

    public static void main(String[] args) {
        // 读入数据
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] timeList = new int[n];
        int[] awardList = new int[n];
        int[][] dependency = new int[n][n];
        for (int i = 0; i < n; i++) {
            timeList[i] = sc.nextInt();
            awardList[i] = sc.nextInt();
            for (int j = 0; j < n; j++) {
                dependency[i][j] = sc.nextInt();
            }
        }

        // 构建图, 返回图里面的起始节点(最后一个项目)
        Map<Integer, NodeMR> indexNodeMap = new HashMap<>();
        NodeMR lastItem = genGraph(timeList, awardList, dependency, indexNodeMap);

        // dfs更新所有表, 并找出最大值, 注意需要重复访问点, 所以不用设置visitedMap
        dfs(lastItem, d);

        // 找到所有结点中的最大值
        int maxAward = -1;
        int costDay = Integer.MAX_VALUE;
        int start = -1;
        for (int i = 0; i < n; i++) {
            NodeMR node = indexNodeMap.get(i);
            if (node.awardSum > maxAward && node.timeSum < costDay) {
                maxAward = node.awardSum;
                costDay = node.timeSum;
                start = i;
            }
        }
        System.out.println(maxAward + " " + costDay);
        System.out.println(start);
    }

    private static void dfs(NodeMR node, int d) {
        int timeSum = node.timeSum, awardSum = node.awardSum;

        // for debug
        System.out.println(words[nodeIndexMap.get(node)]);
        System.out.println(node.awardSum);
        System.out.println(node.timeSum);
        System.out.println();

        for (NodeMR pre : node.pre) {
            if (timeSum + pre.time <= d && awardSum + pre.award > pre.awardSum) {
                pre.awardSum = awardSum + pre.award;
                pre.timeSum = timeSum + pre.time;
                dfs(pre, d);
            }
        }
    }

    private static NodeMR genGraph(int[] timeList, int[] awardList, int[][] dependency, Map<Integer, NodeMR> indexNodeMap) {
        int n = timeList.length;
        // 构建节点
        for (int i = 0; i < n; i++) {
            NodeMR node = new NodeMR(timeList[i], awardList[i]);
            indexNodeMap.put(i, node);
            nodeIndexMap.put(node, i);
        }
        // 建立图
        int lastItemIndex = -1;
        for (int i = 0; i < n; i++) {
            NodeMR cur = indexNodeMap.get(i);
            boolean allZero = true;
            for (int j = 0; j < n; j++) {
                if (dependency[i][j] != 0) {
                    allZero = false;
                    NodeMR nextItem = indexNodeMap.get(j);
                    nextItem.pre.add(cur);
                }
            }
            if (allZero) {
                lastItemIndex = i;
            }
        }
        // 返回最后一个项目,也就是图的出发点
        return indexNodeMap.get(lastItemIndex);
    }
}

class NodeMR {
    int time;
    int timeSum;
    int award;  // 当前活动能获取的钱数
    int awardSum;  // 从当前活动开始到最后一个活动结束所获得的最大钱数
    List<NodeMR> pre;
    public NodeMR(int time, int award) {
        this.time = time;
        this.award = award;
        this.timeSum = time;
        this.awardSum = award;
        pre = new ArrayList<>();
    }
}
