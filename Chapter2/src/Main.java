import _02UnionFind.tools.Asserts;
import _02UnionFind.union.UnionFind;
import _02UnionFind.union.UnionFind_QU;

public class Main {
    public static void main(String[] args) {
        UnionFind uf = new UnionFind_QU(12);
        //初始化
        uf.union(0,1);
        uf.union(0,3);
        uf.union(0,4);
        uf.union(2,3);
        uf.union(2,5);

        uf.union(6,7);

        uf.union(8,10);
        uf.union(9,10);
        uf.union(9,11);

        //System.out.println(uf.isSame(0,6));//false
        //System.out.println(uf.isSame(0,5));//true

        Asserts.test(!uf.isSame(2,7));
        uf.union(4,6);
        Asserts.test(uf.isSame(2,7));
        //System.out.println(uf.isSame(2,7));//true
    }
}
