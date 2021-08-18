package test;

import java.util.ArrayList;

public class SumEqualS {
    public static void main(String[] args) {
        Solution33 solution = new Solution33();
        ArrayList<ArrayList<Integer>> arrayLists = solution.FindContinuousSequence(15);
        System.out.println(arrayLists.toString());
    }
}

class Solution33 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        int i = 1, j = i, tmpSum = 0;
        while (i < sum && j < sum) {
            tmpSum += j;
            path.add(j);
            if (tmpSum == sum) {
                res.add(new ArrayList<Integer>(path));
                path.clear();
                tmpSum = 0;
                j++;
            } else if (tmpSum > sum) {
                path.clear();
                tmpSum = 0;
                i++;
                j = i;
            } else {
                j++;
            }
        }
        return res;
    }
}
