package HJ;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-07 9:51
 */
public class HJ88 {
    public static HashMap<String, Integer> levelMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split("-");
        String[] pokesLevel = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "joker", "JOKER"};
        for (int i = 0; i < pokesLevel.length; i++) {
            levelMap.put(pokesLevel[i], i);
        }
        String res = comparePoke(split[0], split[1]);
        System.out.println(res);
    }

    private static String comparePoke(String str1, String str2) {
        Poke poke1 = makePoke(str1);
        Poke poke2 = makePoke(str2);
        if (poke1.type == PokeType.JOKERBOMB || poke2.type == PokeType.JOKERBOMB) { // 其中一个是王炸
            return poke1.type == PokeType.JOKERBOMB ? poke1.rawString : poke2.rawString;
        } else if (poke1.type == PokeType.BOMB && poke2.type == PokeType.BOMB) { // 两个都是炸弹
            return poke1.level > poke2.level ? poke1.rawString : poke2.rawString;
        } else if (poke1.type == PokeType.BOMB || poke2.type == PokeType.BOMB) { // 其中一个是炸弹
            return poke1.type == PokeType.BOMB ? poke1.rawString : poke2.rawString;
        } else {
            if (poke1.type != poke2.type) {
                return "ERROR";
            } else {
                return poke1.level > poke2.level ? poke1.rawString : poke2.rawString;
            }
        }
    }

    private static Poke makePoke(String str) {
        if (str.equals("joker JOKER")) {
            return new Poke(PokeType.JOKERBOMB, levelMap.get("JOKER"), str);
        }
        String[] split = str.split(" ");
        if (split.length == 4) {
            return new Poke(PokeType.BOMB, levelMap.get(split[0]), str);
        } else if (split.length == 3) {
            return new Poke(PokeType.THREE, levelMap.get(split[0]), str);
        } else if (split.length == 5) {
            return new Poke(PokeType.STRAIGHT, levelMap.get(split[0]), str);
        } else if (split.length == 2) {
            return new Poke(PokeType.PAIR, levelMap.get(split[0]), str);
        } else if (split.length == 1) {
            return new Poke(PokeType.SINGLE, levelMap.get(split[0]), str);
        }
        return null;
    }
}

class Poke {
    public PokeType type;
    public int level;
    public String rawString;
    public Poke(PokeType type, int level, String str) {
        this.type = type;
        this.level = level;
        this.rawString = str;
    }
}

enum PokeType {
    JOKERBOMB, BOMB, THREE, STRAIGHT, PAIR, SINGLE
}
