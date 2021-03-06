动态规划应用于子问题重叠的情况
1.要去刻画最优解的结构特征；
2.尝试递归的定义最优解的值(就是我们常说的考虑状态从i-1转移到i)
3.计算最优解
4.利用计算的信息构造一个最优解。

动态规划的两种实现方式
1.带备忘录的自定向下法（记忆化搜索）
2.自底向上法（将子问题按规模排序，类似于递推）


最优子结构
具有最优子结构也可能是适用于贪心的方法求解。
注意要确保我们考察了最优解中用到的所有子问题
1.证明问题最优解的第一个组成部分是做出一个选择；
2.对于一个给定的问题，在其可能的第一步选择中，你界定已经知道哪种
选择才会得到最优解。你不需要关心这种选择具体是如何得到的，只是假
定已经知道了这种选择；
3.给定可获得的最优解的选择后，确定这次选择会产生哪些子问题，以及
如何最好的刻画子问题空间；
4.证明作为构成原问题最优解的组成部分，每个子问题的解就是它本身的
最优解，那么就可以从原问题的解中用该子问题的最优解替换当前的非最
优解，从而得到原问题的一个更优的解，从而与原问题最优解的假设矛盾。

最优子结构的不同体现在两个不同的方面：
1.原问题的最优解涉及多少个子问题；
2.确定最优解使用哪些子问题时，需要考察多少种选择。

子问题重叠
子问题空间足够小，及问题的递归算法会反复求解相同的子问题，而不是
一直生成新的子问题。

重构最优解
存表记录最优分割的位置，就不用重新按照代价来重构。



伪算法
```
//初始化基本状态 init base case
dp[0][0][...] = base;
//进行状态转移
for 状态1 in 状态1的所有取值：
    for 状态2 in 状态2的所有取值：
        for ...
            dp[状态1][状态2][...] = 求最值(选择1，选择2，...)
```
