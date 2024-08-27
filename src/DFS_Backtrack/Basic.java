package DFS_Backtrack;

// 关于 DP, 回溯, DFS
// DP 关注整棵“子树”, 回溯 关注节点间的“树枝”, DFS 关注单个的“节点”
// DFS 把 "做选择"、"撤销选择" 的逻辑放在 for 循环外面, 而 回溯 则把 "做选择"、"撤销选择" 的逻辑放在 for 循环里面(拿到“树枝”的两个端点)

/* 解决一个回溯问题, 实际上就是遍历一棵决策树的过程, 树的每个叶子节点存放着一个合法答案.
站在回溯树的一个节点上, 我们只要考虑3个问题:
1、路径: 即已经做出的选择;
2、选择列表: 即当前可以做的选择;
3、结束条件: 即到达决策树底层, 无法再做选择的条件. */
public class Basic {
}
/* 关于选择与撤销
需要显式选择和撤销选择的场景:
1. 路径或状态的维护: 如组合问题、迷宫求解等
2. 状态信息的更新与恢复: 如前缀和问题、子集和问题等
3. 环检测或多路径问题: 如有环图的遍历等
4. 全局状态的维护(全局变量): 如路径数量、最大/最小路径等
需要显式选择和撤销选择的场景:
1. 简单的遍历: 如二叉树的遍历、无环图的遍历等
2. 无需动态更新的静态状态: 如固定目标的求解等
3. 只需要一次访问的情况: 如求解路径问题
*/
/* 回溯算法: 几乎总是需要显式的选择和撤销选择,
因为回溯算法本质上是为了探索所有可能的路径, 并在必要时恢复到之前的状态, 以便继续探索其他路径。

DFS算法: 很少需要显式的选择和撤销选择,
因为DFS的主要任务是遍历节点, 而不是路径选择.
标记节点为"已访问"的操作通常不算作"选择", 因为它们不需要被撤销.
DFS的递归过程自然管理了节点的状态。*/

/* DFS 标记数组问题. —— 而回溯算法中的标记数组则是需要参与选择与撤销操作的(不仅是简单的访问标记工具, 实际上是路径选择和状态管理的一部分).
可以这么说, DFS 中的标记的设置和使用通常是全局性的; 而回溯算法中标记的使用更加细致, 每个递归步骤中的选择和撤销选择都需要同步更新标记数组.
在DFS中, 标记数组通常用于记录节点是否已经被访问过, 以防止重复访问, 尤其是在处理图或有环的结构时

一次性遍历(不需要撤销标记): 在大多数情况下, DFS只需要遍历整个图或树一次, 标记数组用来记录哪些节点已经被访问过.
例如, 在检测连通分量、拓扑排序、判断图是否有环等问题中, 标记数组的作用是避免重复访问或死循环.

多次遍历或路径探索(需要撤销标记): 在一些路径问题中, DFS可能需要探索多条路径.
例如, 求解所有可能的简单路径、Hamiltonian路径或图中的所有环时, DFS需要多次从不同的起点进行探索, 或者在一条路径探索完成后需要撤销标记, 以便继续探索其他路径.
在这些情况下, 撤销标记是必要的, 但它的作用主要是恢复节点状态, 而不是回溯意义上的"撤销选择", 认为它是"清除现场".
*/