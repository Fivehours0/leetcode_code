package Code_17;

public class Code_17 {
    public int reverse(int x) {
        int temp = 0;
        int rev = 0; 
        rev = x % 10; // 余数
        while(x!=0){
            // 判断溢出
            if(temp > Integer.MAX_VALUE / 10 || temp < Integer.MIN_VALUE / 10)
                return 0;
            if(temp == Integer.MAX_VALUE / 10 && (x > 7 || x < -8))
                return 0;
            temp = temp * 10 + rev;
            x = x / 10; // 商
            rev = x % 10; // 余数
        }
        return temp;
    }
    public static void main(String[] arg){
        Code_17 code_17 = new Code_17();
        System.out.println(code_17.reverse(120)); 
    }
}