package test;

import java.util.*;

/**
 * @author kelvin
 * @create 2022-09-30 14:27
 */
public class HJ25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int numI = sc.nextInt();
            List<Integer> I = new ArrayList<>();
            for (int i = 0; i < numI; i++) {
                I.add(sc.nextInt());
            }

            int numR = sc.nextInt();
            Set<Integer> R = new TreeSet<>();
            for (int i = 0; i < numR; i++) {
                R.add(sc.nextInt());
            }

            List<Integer> res = new ArrayList<>();  // 存放结果 <r,num,index,value>
            for (int r : R) {
                List<Integer> pair = new ArrayList<>();  // 记录对于当前的r, 有多少个I符合条件,<index, value>
                for (int i = 0; i < I.size(); i++) {
                    if (String.valueOf(I.get(i)).contains(String.valueOf(r))) {
                        pair.add(i);
                        pair.add(I.get(i));
                    }
                }
                if (!pair.isEmpty()) {
                    res.add(r);
                    res.add(pair.size() / 2);
                    for (int i = 0; i < pair.size(); i += 2) {
                        res.add(pair.get(i));
                        res.add(pair.get(i + 1));
                    }
                }
            }
            System.out.print(res.size());
            for (int num : res) {
                System.out.print(" " + num);
            }
        }
    }
}
