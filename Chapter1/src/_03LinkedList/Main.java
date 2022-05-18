package _03LinkedList;

import _03LinkedList.circle.CircleLinkedList;
import _03LinkedList.circle.SingleCircleLinkedList;

public class Main {
    static void testList(List<Integer> list) {
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        list.add(0, 55); // [55, 11, 22, 33, 44]
        list.add(2, 66); // [55, 11, 66, 22, 33, 44]
        list.add(list.size(), 77); // [55, 11, 66, 22, 33, 44, 77]

        list.remove(0); // [11, 66, 22, 33, 44, 77]
        list.remove(2); // [11, 66, 33, 44, 77]
        list.remove(list.size() - 1); // [11, 66, 33, 44]

        Asserts.test(list.indexOf(44) == 3);
        Asserts.test(list.indexOf(22) == List.ELEMENT_NOT_FOUND);
        Asserts.test(list.contains(33));
        Asserts.test(list.get(0) == 11);
        Asserts.test(list.get(1) == 66);
        Asserts.test(list.get(list.size() - 1) == 44);

        System.out.println(list);
    }

    static void josephus() {
        CircleLinkedList<Integer> list = new CircleLinkedList<>();
        for (int i = 1; i <= 8; i++) {
            list.add(i);
        }
        //指向头结点
        list.reset();
        while (!list.isEmpty()) {
            list.next();
            list.next();
            System.out.println(list.remove());
        }
    }
    public static void main(String[] args) {
        //因为ArrayList和LinkedList都是实现List这个接口，所以其实可以写成
        //左边直接写成List
        //List<Integer> list1 = new ArrayList<>();
        //List<Integer> list2 = new LinkedList<>();
//        ArrayList<Integer> list1 = new ArrayList<>();
//        SingleLinkedList<Integer> list2 = new SingleLinkedList<>();
//
//        List<Integer> list = new SingleLinkedList2<>();
//        list.add(20);
//        list.add(0,10);
//        list.add(30);
//        list.add(list.size(), 40);
//        list.remove(1);
//
//        System.out.println(list.toString());
//
//        List<Integer> list3 = new ArrayList2<>();
//        for (int i = 0; i < 50; i++) {
//            list3.add(i);
//        }
//        for (int i = 0; i < 50; i++) {
//            list3.remove(0);
//        }
//        System.out.println(list);


//        testList(new ArrayList<>());
//        testList(new LinkedList<>());
//        testList(new SingleCircleLinkedList<>());
//        testList(new CircleLinkedList<>());
        josephus();
    }
}
