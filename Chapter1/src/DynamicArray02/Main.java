package DynamicArray02;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<Integer>();
        ints.add(10);
        ints.add(11);
        ints.add(22);
        Asserts.test(ints.size() == 3);
        Asserts.test(ints.get(0) == 10);
//        ArrayList<Person> persons = new ArrayList<Person>();
//        persons.add(new Person(10,"Jack"));
//        persons.add(null);
//        persons.add(new Person(12,"James"));
//        persons.add(null);
//        persons.add(new Person(15,"Rose"));
//        persons.add(null);
//        System.out.println(persons);
//        persons.clear();
//        //提醒JVM垃圾回收
//        System.gc();
    }
    static void test() {
        Object[] objects = new Object[7];
        //objects[0]内存中放的是对象的地址值
        //objects[0]放地址可以节省空间，如果是放对象本身的话，可能会非常的大
        objects[0] = new Person(10,"Java");
        objects[1] = new Person(10,"Java");
        objects[2] = new Person(10,"Java");
        objects[3] = new Person(10,"Java");
        //int --> Integer
        //所有的类，最终都继承java.lang.Object

        //int[] array = new int[] {11, 22, 33};
        //new是向堆空间申请内存
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Person(10,"Jack"));
        persons.add(new Person(12,"James"));
        persons.add(new Person(15,"Rose"));
        System.out.println(persons);

        ArrayList<Integer> ints = new ArrayList<Integer>();
        ints.add(10);
        ints.add(11);
        ints.add(22);
        ints.add(33);
        System.out.println(ints);
//        list.add(99);
//        list.add(88);
//        list.add(77);
//        list.add(66);
//        list.add(55);
//        list.remove(0);
//        list.add(0, 999);
//        list.set(3, 80);
//        Asserts.test(list.get(3) == 80);
//        for (int i = 0; i < 30; i++) {
//            list.add(i);
//        }
//        System.out.println(list);
    }
}
