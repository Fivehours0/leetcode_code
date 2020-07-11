package Code_38;

import java.util.Arrays;

public class Code_38 {
    public static String countAndSay(int n) {
        String ans = "1";
        StringBuilder stringBuilder = new StringBuilder(); // 构建新的ans
        for (int i = 2; i <= n; i++) {
            stringBuilder.delete(0, stringBuilder.length());
            char[] ansChars = ans.toCharArray();
            char[] ansNew = new char[ansChars.length+1];
            System.arraycopy(ansChars, 0, ansNew, 0, ansChars.length);
            int left = 0, right = 0;
            while (right < ansNew.length) {
                if (ansNew[left] == ansNew[right]) {
                    right++;
                } else {
                    stringBuilder.append(right - left);
                    stringBuilder.append(ansNew[left]);
                    left = right;
                }
            }
            ans = stringBuilder.toString();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
