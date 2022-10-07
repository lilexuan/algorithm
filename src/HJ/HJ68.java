package HJ;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-05 9:52
 */
public class HJ68 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int flag = Integer.parseInt(sc.nextLine());
        ArrayList<StuHJ68> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] info = s.split(" ");
            list.add(new StuHJ68(info[0], Integer.parseInt(info[1]), i));
        }
        if (flag == 1) {
            list.sort((o1, o2) -> {
                if (o1.score != o2.score) {
                    return o1.score - o2.score;
                } else {
                    return o1.index - o2.index;
                }
            });
        } else {
            list.sort((o1, o2) -> {
                if (o1.score != o2.score) {
                    return o2.score - o1.score;
                } else {
                    return o1.index - o2.index;
                }
            });
        }
        for (StuHJ68 stu : list) {
            System.out.println(stu);
        }
    }

}

class StuHJ68 {
    public String name;
    public int index;
    public int score;
    public StuHJ68(String name, int score, int index) {
        this.name = name;
        this.score = score;
        this.index = index;
    }

    @Override
    public String toString() {
        return name + " " + score;
    }
}
