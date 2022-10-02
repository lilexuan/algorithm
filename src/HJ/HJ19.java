package HJ;

import java.util.*;

/**
 * @author kelvin
 * @create 2022-09-30 9:37
 */
public class HJ19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<ErrRecord, Integer> map = new LinkedHashMap<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            String[] paths = split[0].split("\\\\");
            String path = paths[paths.length - 1];
            if (path.length() > 16) {
                path = path.substring(path.length() - 16);
            }
            ErrRecord errRecord = new ErrRecord(path, Integer.parseInt(split[1]));
            map.put(errRecord, map.getOrDefault(errRecord, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (ErrRecord errRecord : map.keySet()) {
            res.add(errRecord.toString() + " " + map.get(errRecord));
        }
        int begin = Math.max(res.size() - 8, 0);
        for (int i = begin; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}

class ErrRecord {
    public String path;
    public int row;

    public ErrRecord(String path, int row) {
        this.path = path;
        this.row = row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, row);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ErrRecord o = (ErrRecord) obj;
        return Objects.equals(this.path, o.path) && this.row == o.row;
    }

    @Override
    public String toString() {
        return path + " " + row;
    }
}