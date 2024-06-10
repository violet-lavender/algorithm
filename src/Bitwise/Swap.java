package Bitwise;

public class Swap {
    // 异或操作可以巧妙地实现交换, 但是注意两个对象不能指向同一个地址, 不然会直接置0
    public void swap(int a, int b){
        a = a ^ b;    // a = a ^ b, b = b
        b = a ^ b;    // b = a ^ b = a ^ b ^ b = a, a = a ^ b
        a = a ^ b;    // a = a ^ b = a ^ b ^ a = b, b = a
    }
}
