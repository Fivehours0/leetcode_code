package Code_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<String> res = new ArrayList<>();

    /**
     * 动态规划
     * 首先确定从状态n-1 到 n 是如何转移的。在这道题目中，状态 n 比 状态 n - 1 多出了一对括号
     * (a)b  其中a，b都是有效的括号对，且a+b的括号对数为 n - 1; 对所有的ab情况进行遍历，就可以得到状态 n 的结果
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        LinkedList<LinkedList<String>> result = new LinkedList<>();

        if (n == 0) return new ArrayList<String>();

        LinkedList<String> l1 = new LinkedList<>();
        l1.add("");
        result.add(l1);

        LinkedList<String> l2 = new LinkedList<>();
        l2.add("()");
        result.add(l2);

        for (int i = 2; i <= n; i++) {
            LinkedList<String> tmp = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                for (String s1: result.get(j)) {
                    for (String s2: result.get(i - 1 - j)) {
                        String e = "(" + s1 + ")" + s2;
                        tmp.add(e);
                    }
                }
            }
            result.add(tmp);
        }
        return result.get(n);
    }


//    /**
//     * 回溯算法
//     * @param n
//     * @return
//     */
//    public List<String> generateParenthesis(int n) {
//        if (n == 0) return res;
//        help("(", n, 0, 0, new StringBuilder());
//        return res;
//    }
//
//    private void help (String in, int n, int countL, int countR, StringBuilder last) {
//        // countL 代表“(”出现的次数. countR代表")"出现的次数
//        last.append(in);
//
//        if (in.equals("(")) {
//            if (countL < n) countL++;
//            else return;
//        }
//
//        if (in.equals(")")) {
//            if (countR < n) countR++;
//            else return;
//        }
//
//        if (countL < countR) return;
//        if (countL == n && countR  == n) {
//            res.add(last.toString());
//            return;
//        }
//
//        help("(", n, countL, countR, last);
//        last.deleteCharAt(last.length() - 1);
//        help(")", n, countL, countR, last);
//        last.deleteCharAt(last.length() - 1);
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(2));
    }
}