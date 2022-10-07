package HJ;

import java.util.Scanner;

/**
 * @author kelvin
 * @create 2022-10-05 8:11
 */
public class HJ66 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] cmds = s.split(" ");
            if (cmds.length == 1) {
                String cmd = cmds[0];
                if ("reset".startsWith(cmd)) {
                    System.out.println("reset what");
                } else {
                    System.out.println("unknown command");
                }
            } else if (cmds.length == 2) {
                String cmd1 = cmds[0], cmd2 = cmds[1];
                if ("reset".startsWith(cmd1) && "board".startsWith(cmd2) && "reboot".startsWith(cmd1) && "backplane".startsWith(cmd2)) {
                    System.out.println("unknown command");
                } else if ("board".startsWith(cmd1) && "add".startsWith(cmd2) && "backplane".startsWith(cmd1) && "abort".startsWith(cmd2)) {
                    System.out.println("unknown command");
                } else if ("reset".startsWith(cmd1) && "board".startsWith(cmd2)) {
                    System.out.println("board fault");
                } else if ("board".startsWith(cmd1) && "add".startsWith(cmd2)) {
                    System.out.println("where to add");
                } else if ("board".startsWith(cmd1) && "delete".startsWith(cmd2)) {
                    System.out.println("no board at all");
                } else if ("reboot".startsWith(cmd1) && "backplane".startsWith(cmd2)) {
                    System.out.println("impossible");
                } else if ("backplane".startsWith(cmd1) && "abort".startsWith(cmd2)) {
                    System.out.println("install first");
                } else {
                    System.out.println("unknown command");
                }
            } else {
                System.out.println("unknown command");
            }
        }
    }
}
