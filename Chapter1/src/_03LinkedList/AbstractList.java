package _03LinkedList;
//因为父类只写一些LinkedList和ArrayList都有的部分
//但是对于接口List来说是都要实现，所以用abstract修饰
//特有的部分交给子类分别实现
public abstract class AbstractList<E> implements List<E> {
    /**
     * 元素的数量
     */
    protected int size;
    /**
     * 元素的数量
     */
    public int size() {
        return size;
    }
    /*
     * 是否为空
     * @return
     * */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }
    /**
     * 添加元素到尾部
     * @param element
     */
    public void add(E element) {
        /**
         * 最好：O(1)
         * 最坏：O(n)-->扩容
         * 平均：O(1+1+..+1)-->O(1)
         */
        add(size, element);
    }
    protected void outOfBound(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + " Size:" + size);
    }

    protected void rangeCheck(int index) {
        if(index < 0 || index >= size) {
            outOfBound(index);
        }
    }

    protected void rangeCheckForAdd(int index) {
        if(index < 0 || index > size) {
            outOfBound(index);
        }
    }
}
