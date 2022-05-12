package _03LinkedList.single;

import _03LinkedList.AbstractList;

/**
 * 增加一个虚拟头结点
 * @param <E>
 */
public class SingleLinkedList2<E> extends AbstractList<E> {
    private Node<E> first;
    public SingleLinkedList2() {
        first = new Node<>(null, null);
    }
    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    /**
     * 设置index位置的元素
     * 覆盖原来的元素
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        Node<E> prev = index == 0 ? first : node(index - 1);
        prev.next = new Node<>(element, prev.next);

        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> prev = index == 0 ? first : node(index - 1);
        Node<E> node = prev.next;
        prev.next = prev.next.next;

        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    node = node.next;
                    return i;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                Node<E> node = first;
                if (element.equals(node.element)) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }
    //传入一个索引index
    //返回索引对应的节点
    /**
     * 获取index位置对应节点对象
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = first.next;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(",");
            }
            string.append(node.element);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}