package HJ;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-06 14:33
 */
public class HJ82 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] split = s.split("/");
            Fraction fraction = new Fraction(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            int denominator = 2;
            Fraction tmp;
            ArrayList<Integer> res = new ArrayList<>();
            while (!fraction.isZero()) {
                tmp = fraction.minus(new Fraction(1, denominator));
                if (!tmp.isNegative()) {
                    res.add(denominator);
                    fraction = tmp;
                }
                denominator++;
            }
            for (int i = 0; i < res.size(); i++) {
                if (i != 0 ) {
                    System.out.print("+");
                }
                System.out.print("1/" + res.get(i));
            }
            System.out.println();
        }
    }
}

class Fraction {
    public long numerator;  // 分子
    public long denominator; // 分母

    public Fraction(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public boolean isNegative() {
        return (numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0);
    }

    public Fraction minus(Fraction other) {
        long lcd = lcd(this.denominator, other.denominator);
        Fraction tmp = new Fraction(lcd / this.denominator * this.numerator - lcd / other.denominator * other.numerator, lcd);
        tmp.reduce();
        return tmp;
    }

    private long lcd(long x, long y) {
        return x * y / gcd(x, y);
    }

    private long gcd(long x, long y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public boolean isZero() {
        return this.numerator == 0L;
    }

    private void reduce() {
        long gcd = gcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }
}