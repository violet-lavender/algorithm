package UnionFind;

// 等式方程的可满足性.
// equations装着若干字符串表示的算式, 每个算式equations[i]长度都是4, 而且只有a==b或者a!=b两种情况, 其中a、b是任意小写字母.
// 先处理 == 算式, 构成连通分量, 再处理 != 算式, 检查不等关系是否破坏了连通性
public class EquationsPossible {
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                char p = equation.charAt(0);
                char q = equation.charAt(3);
                uf.union(p - 'a', q - 'a');
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                char p = equation.charAt(0);
                char q = equation.charAt(3);
                // 检查不等关系是否破坏了连通性
                if (uf.connected(p - 'a', q - 'a'))
                    return false;
            }
        }
        return true;
    }
}
