package OrderMap;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author kelvin
 * @create 2021-04-24 13:53
 */
public class ChooseWork {
    public static class Job {
        public int money;
        public int hard;
        public Job(int money, int hard) {
            this.money = money;
            this.hard = hard;
        }
    }

    public static int[] getMoneys(Job[] jobs, int[] abilities) {
        Arrays.sort(jobs, (j1, j2) -> {
            if (j1.hard != j2.hard) {
                return j1.hard - j2.hard;
            } else {
                return j2.money - j1.money;
            }
        });
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Job preJob = jobs[0];
        for (int i = 1; i < jobs.length; i++) {
            if (preJob.hard != jobs[i].hard && preJob.money < jobs[i].money) {
                map.put(jobs[i].hard, jobs[i].money);
                preJob = jobs[i];
            }
        }
        int[] res = new int[abilities.length];
        for (int i = 0; i < abilities.length; i++) {
            Integer key = map.ceilingKey(abilities[i]);
            res[i] = key != null ? map.get(key) : 0;
        }
        return res;
    }
}
