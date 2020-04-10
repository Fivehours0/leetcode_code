### 题目内容
7.整数反转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

样例1:

    输入: 123
    输出: 321
样例2:

    输入: 120
    输出: 21

最大值$$2^{31} -1 = 2,147,483,647$$
最小值$$-2^{31} = -2,147,483,648$$

### 解题思路
    输入值为 x
    rev = x / 10;
    pop = x % 10;

    输出值
    temp =  temp * 10 + rev

    重点
        防止溢出, 且需要在输出值计算之前判断是否溢出
        溢出时 
            temp * 10 + rev > MAX
            temp * 10 + rev < MIN

            temp > MAX / 10时溢出
            temp = MAX / 10时，rev>7(x为正数), rev<-8(x为负数)为溢出
    value为正数时
        当前值 + 下一个值 > MAX

### 代码优化
1.观察是否又类似功能的变量，可否约去，即少定义一些变量。
2.将某些结构进行简化，例如if中的条件类似时，可以将两个if并成一个。

大佬code:

    三目运算符
    巧妙的定义long类型
```java
    Long result = 0L ;
    for(;x!=0;x=x/10){
        result = result*10+x%10;
    }
    return result>Integer.MAX_VALUE || result<Integer.MIN_VALUE? 0:result.intValue();
```

我的code: 
```java
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
```