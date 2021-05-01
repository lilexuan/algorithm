package recur;

/**
 * @author kelvin
 * @create 2021-05-01 14:32
 */
public class Kiki {
    private static int process(int preCoin, int cur, int target, int x, int y, int z, int limitCoin, int limitCur) {
        // 如果当前的人气已经达到目标人气了, 那么就不用花费C币了
        if (cur == target) {
            return preCoin;
        }

        // 如果之前超出了限制(次数或者C币的限制), 返回最大值
        if (preCoin > limitCoin || cur < 0 || cur > limitCur) {
            return Integer.MAX_VALUE;
        }

        int c1 = process(preCoin + x, cur + 2, target, x, y, z, limitCoin, limitCur);  // 点赞
        int c2 = process(preCoin + y, cur * 2, target, x, y, z, limitCoin, limitCur);  // 送礼
        int c3 = process(preCoin + z, cur - 2, target, x, y, z, limitCoin, limitCur);  // 私聊
        return Math.min(c1, Math.min(c2, c3));
    }

    public static int minCoins(int x, int y, int z, int start, int end) {
        return process(0, start, end, x, y, z, (end - start) / 2 * x, end * 2);
    }

    public static void main(String[] args) {
        System.out.println(minCoins(3, 100, 1, 2, 6));
    }
}
