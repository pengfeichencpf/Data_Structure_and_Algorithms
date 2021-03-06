package _03LinkedList;

public class ArrayList<E> extends AbstractList<E> {
    /**
     * 所有的元素
     */
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY)? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }
    public ArrayList() {
        //elements = new int[DEFAULT_CAPACITY];
        this(DEFAULT_CAPACITY);
    }
    /*
    * 清除所有元素
    */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    public E get(int index) {
        rangeCheck(index);
        //index * 4 + 数组的首地址
        return elements[index];// O(1)
    }
    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素
     */
    public E set(int index, E element) {// O(1)
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }
    /**
     * 在index位置插入一个元素
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        /*
        最好的情况-->末尾添加元素-->O(1)
        最坏的情况-->最前面添加元素-->O(n)
        平均-->O((1+2+3+...+n)/n)-->O(n)
         */
        rangeCheckForAdd(index);
        //size = 5
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }// O(n) n是数据规模
    // size是数据规模
    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    public E remove(int index) {
        /**
         * 最好的情况-->末尾删除元素-->O(1)
         * 最坏的情况-->最前面删除元素-->O(n)
         * 平均-->O((1+2+3+...+n)/n)-->O(n)
         */
        rangeCheck(index);
        E old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        return old;
    }

    public void remove(E element) {
        remove(indexOf(element));
    }

    /**
     * 查看元素的索引
     * @param element
     * @return
     */
    public int indexOf(E element) {
        if (element == null) {
            //找到第一个index为null的就返回，即可
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                //Person persons = null;
                //persons.add(10); 空去调用一个方法是没有意义的，所以我们把element放在前面
                //因为走入这个else条件的话，肯定不是空
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 保证要有capacity的容量
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        //oldCapacity + oldCapacity >> 1 这么写相当于乘以1.5
        //新容量为旧容量的1.5倍，位运算效率高
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(oldCapacity+"扩容为"+newCapacity);
    }

    @Override
    public String toString() {
        //size = 3, [99, 88, 77]
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(",");
            }
            string.append(elements[i]);
//            if (i != size -1) {
//                string.append(",");
//            }
        }
        string.append("]");
        return string.toString();
    }
}
