package Code_394;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */

class S {
    /**
     * 使用栈    3[a2[c]]
     *  构建[前的数字，构建完成后压入栈
     *  当遇到]表示当前的[]构建完成，返回一个String数组，数组内为构建的字符串以及当前的i值
     *  返回当前i值的目的，是当递归返回时，调用递归的函数的i需要从递归返回的i开始
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        Deque<String> charStack = new LinkedList<>();
        int num = 0;
        StringBuilder ans = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) num = num * 10 + Character.digit(c, 10);
            if (Character.isLetter(c)) ans.append(c);
            if (c == '[') {
                numStack.addLast(num);
                charStack.addLast(ans.toString());
                num = 0;
                ans = new StringBuilder();
            }

            if (c == ']') {
                int count = numStack.removeLast();
                StringBuilder tmp = new StringBuilder();
                while (count-- > 0) tmp.append(ans);
                ans = new StringBuilder(charStack.removeLast() + tmp.toString());
            }
        }
        return ans.toString();
    }

    /**
     * 方法二：使用递归
     */
    private final Deque<Integer> numStack = new LinkedList<>();
    public String recurrence (String s) {
        return this.recurrence(s.toCharArray(), 0,"")[0];
    }

    private String[] recurrence (char[] chars, int start, String ans) {
        int count = 0;
        for (int i = start; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) count = count * 10 + Character.digit(c, 10);
            if (Character.isLetter(c)) ans = ans + c;
            // 当遇到[字符时，开始构建[]内的编码
            if (c == '[') {
                numStack.addLast(count);
                count = 0;
                // 由于递归是i是混乱的，所以需要返回i表示迭代到哪里了，便于递归返回时，继续从该处的i开始
                String[] tmp = this.recurrence(chars, i+1, "");
                ans = ans + tmp[1];
                i = Integer.parseInt(tmp[0]);
            }
            // 当遇到]字符时，说明[]内构建完毕
            if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                count = numStack.removeLast();
                while (count-- > 0) tmp.append(ans);
                return new String[] { String.valueOf(i), tmp.toString() };
            }
        }
        return new String[] {ans};
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
//        String s = "3[a2[c]]";
//        String s = "3[ac]";
        System.out.println(new S().recurrence(s));
    }
}