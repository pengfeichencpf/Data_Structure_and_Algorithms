package _02UnionFind.union;

/**
 * Quick Union - 基于rank的优化 - 路径分裂（Path Splitting）
 */
public class UnionFind_QU_R_PS extends UnionFind_QU_R{
    public UnionFind_QU_R_PS(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (parents[v] != v) {
            int p = parents[v];
            parents[v] = parents[parents[v]];
            v = p;
        }
        return v;
    }
}
