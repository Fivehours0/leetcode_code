package Code_13;

import java.util.HashMap;

public class Code_13 {
    // 与我的romanToInt少调用了几次charAt和getValue,时间上快了1ms. 使用变量preNum暂存得到的值
    public int brainBox(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0)); // 当前字符前一位所代表的数值
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i)); // 当前字符所代表的数值
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    public int romanToInt(String s) {
//        // 可以利用hashmap的方式保存罗马字符所代表的数值信息, 也可以使用switch case的方式
//        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
//        hashMap.put('I', 1);
//        hashMap.put('V', 5);
//        hashMap.put('X', 10);
//        hashMap.put('L', 50);
//        hashMap.put('C', 100);
//        hashMap.put('D', 500);
//        hashMap.put('M', 1000);

//        // 打印hashMap内容
//        for(String ss: hashMap.keySet()){
//            System.out.println(ss + ":" + hashMap.get(ss));
//        }

        int sum = getValue(s.charAt(s.length()-1)); // 返回的罗马数字转整数的结果
        for(int i=0;i<s.length()-1;i++) {
            if(getValue(s.charAt(i)) < getValue(s.charAt(i+1))) {
                sum = sum - getValue(s.charAt(i));
            }
            else {
                sum = sum + getValue(s.charAt(i));
            }
        }
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Code_13 code_13 = new Code_13();
        System.out.println(code_13.romanToInt("MCMXCIV"));
    }
}
