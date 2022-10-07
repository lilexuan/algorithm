package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-04 14:44
 */
public class HJ64 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String cmd = sc.nextLine();
        MP3 mp3 = new MP3(num);
        for (int i = 0; i < cmd.length(); i++) {
            if (cmd.charAt(i) == 'U')
                mp3.rowUp();
            if (cmd.charAt(i) == 'D')
                mp3.rowDown();
        }
        mp3.printWin();
        System.out.println(mp3.getCurRow());
    }
}

class MP3 {
    private int firstRow;
    private int endRow;
    private int winBegin;
    private int winEnd;
    private int curRow;

    public MP3(int rows) {
        this.firstRow = 1;
        this.endRow = rows;
        this.winBegin = 1;
        this.winEnd = Math.min(4, endRow);
        this.curRow = 1;
    }

    public void rowDown() {
        if (curRow < winEnd) {
            curRow++;
        } else if (curRow == winEnd) {
            boolean isSpec = toNextWindow();
            if (isSpec) {
                curRow = firstRow;
            } else {
                curRow++;
            }
        }
    }

    private boolean toNextWindow() {
        if (winEnd < endRow) {
            winBegin++;
            winEnd++;
            return false;
        } else {
            winBegin = firstRow;
            winEnd = Math.min(4, endRow);
            return true;
        }
    }

    public void rowUp() {
        if (curRow > winBegin) {
            curRow--;
        } else if (curRow == winBegin) {
            boolean isSpec = toPreWindow();
            if (isSpec) {
                curRow = endRow;
            } else {
                curRow--;
            }
        }
    }

    private boolean toPreWindow() {
        if (winBegin > firstRow) {
            winBegin--;
            winEnd--;
            return false;
        } else {
            winBegin = endRow - Math.min(4, endRow) + 1;
            winEnd = endRow;
            return true;
        }
    }

    public void printWin() {
        for (int i = winBegin; i <= winEnd; i++) {
            if (i != winBegin) {
                System.out.print(" ");
            }
            System.out.print(i);
        }
        System.out.println();
    }

    public int getCurRow() {
        return curRow;
    }
}
