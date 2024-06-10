package Bitwise;

//关于异或操作^, 有num ^ num = 0、num ^ 0 = num, 且^满足交换律和结合律
public class SingleNumber {
    // 只有一个出现奇数次的数字, 其他数字均出现了偶数次, 异或操作可以直接找出这个数字
    public int singleNumber(int[] nums) {
        int eor = 0;
        for (int num: nums)
            eor ^= num;
        return eor;
    }

    // 有两个出现奇数次的数字, 其他数字均出现了偶数次
    public int[] singleNumberPro(int[] nums){
        int eor = 0, onlyOne = 0;
        for (int num: nums)
            eor ^= num;
        // eor = a ^ b, 且eor != 0, 则eor至少有一位不为0, 即必然有一位为1
        // 提取出最右侧(位)的1, 在这一位上, a和b中一个为1, 一个为0, 如rightOne = 00000100
        int rightOne = eor & (~eor + 1);
        // 将这一位为0的或者为1的数进行亦或, 一定能找到a或b其中一个
        for (int num: nums){
            // 通过与操作进行判断, xxxxxxxxxx & 00000100, 对应位为1结果为非0, 否则为0
            if((num & rightOne) == 0)
                onlyOne ^= num;
        }
        int otherOne = eor ^ onlyOne;   // 通过异或找到另一个
        return new int[]{onlyOne, otherOne};
    }
}
