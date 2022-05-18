package _02UnionFind.union;

/**
 * Quick Find来实现
 */
public class UnionFind_QF extends UnionFind {
    public UnionFind_QF(int capacity) {
        super(capacity);
    }

    /**
     * 查找v所属的集合（根节点）
     * 父节点就是根节点
     * @param v
     * @return
     */
    public int find(int v) {
        rangeCheck(v);
        return parents[v];
    }

    /**
     * 合并v1、v2所在集合
     * 将v1所在集合所有元素都嫁接到v2的父节点上
     * @param v1
     * @param v2
     */
    public void union(int v1, int v2){
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;
        for (int i = 0; i < parents.length; i++) {
            if(parents[i] == p1) {
                parents[i] = p2;
            }
        }
    }
}
