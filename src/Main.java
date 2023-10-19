import java.util.*;

public class Main {

    //to open documentation: ctrl + click on method
    //docs.oracle.com

    public static void main(String[] args) {
        //Interface List extends Collections
        //Interface Collection extends interface Iterable (перечисляемые),
        //to be able to use loop: for(Integer i: listInt)

        //List.of(...) is the same like new ArrayList<>() and Array.asList(...)
        //But List.of(...) creates collection (immutableList)
        //that cannot be changed(can't add/delete/change/sort elements)
        //All of them creates ArrayList
        List<Integer> listInt = List.of(-22, 0, 1, -2, 3, 4, 5);
        List<Integer> listInt1 = Arrays.asList(-22, 0, 1, -2, 3, 4, 5);
//        System.out.println(listInt.get(3));
//        System.out.println(onlyPositives(listInt));

//        listInt1.sort(Comparator.naturalOrder());
//        System.out.println(listInt1);

//        Randoms r = new Randoms();
//        for (Integer i: r) {
//            System.out.println(i);
//        }

        List<String> listStr = Arrays.asList("one", "two", " ", "aa", "Ab");
//        listStr.sort(Comparator.naturalOrder());
//        System.out.println(listStr);
//        listStr.sort(Comparator.reverseOrder());
//        System.out.println(listStr);

        List<Yokozuna> wrestlers = Arrays.asList(
                new Yokozuna("Takonohana", 200),
                new Yokozuna("Amusasimaru", 190),
                new Yokozuna("Kisenosato", 250)
        );
        wrestlers.sort(Comparator.naturalOrder());
        System.out.println("!!!!!!!!!" + wrestlers.toString());

        //Set
        //HashSet is implementation, uses hashCode for calculations
        //any exemplar of any class has unic hashCode, which we can compare
        //hashCode uses to check if the element is in the collection(List. Set, Map)
        Set<Integer> ints = new HashSet<>();
        ints.add(1);
        ints.add(6);
        ints.add(1);
        ints.add(5);
        ints.add(4);
        ints.add(10);
        ints.add(-1);
//        System.out.println(ints);

        List<Integer> ints1 = List.of(1, 1, 4,66, 7, 8, 8);
//        System.out.println(ints1);
//        System.out.println(new HashSet<>(ints1));

        List<List<Integer>> ints2D = List.of(
                List.of(1, 3, 5, 6, 7, 8, 999),
                List.of(-1, -3, -5, 999),
                List.of(1, 3, 5),
                List.of(5, 6));

        /*First in - first out
            index:
            0 1 2 3
                  1 <- add 1
                1 2 <- add 2
              1 2 3 .......
            1 2 3 4 .......
            2 3 4 5 <- add 5
    take 2->3 4 5
    take 3->4 5

        First in - last out
                    0 1 2 3
                  1 <- add 1
                1 2 <- add 2
              1 2 3 .......
            1 2 3 4 .......
    take 4->  1 2 3
    take 3->    1 2
        */
        //this conception's realised with Deque class
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        System.out.println(deque);
        deque.addLast(2);
        System.out.println(deque);
        deque.addLast(3);
        System.out.println(deque);
        deque.addLast(4);
        System.out.println(deque);

        //or deque.removeFirst()
        //used for stack
        System.out.println(deque.removeLast());
//        System.out.println(deque);

        System.out.println(deque.removeLast());
//        System.out.println(deque);

        //Map is interface
        //more usefull Map(like js object: key - value):
//        Map<String, Integer> likes = new HashMap<>();
        Likes likes = new Likes();
        likes.print();
        likes.addLike("heart");
        likes.print();
        likes.addLike("heart");
        likes.print();
        likes.addLike("care");
        likes.print();

        System.out.println(likes.getTotalLikes());

        likes.printTypes();

        Map<Yokozuna, List<Yokozuna>> wins = new HashMap<>();
        Yokozuna takonohana = new Yokozuna("Takonohana", 200);
        Yokozuna amusasimaru = new Yokozuna("Amusasimaru", 190);
        Yokozuna kisenosato = new Yokozuna("Kisenosato", 250);
        wins.put(takonohana, List.of(amusasimaru, kisenosato));
        wins.put(amusasimaru, List.of(kisenosato));
        System.out.println(wins);

        //Review 16.1 (29.09): hashMap()
        //List works slowly(for example, to find element), it's a "-"
        //So it's why created other type - Map of list,
        //where find element is faster, using key value
        //Structure hashMap implements interface Map<K, V>
        //- is Generic with 2 parameters: key and corresponding value
        HashMap<String, String> map = new HashMap<>();
        map.put("str1", "str1.1");
        map.put("str2", "str2.1");
        System.out.println(map.get("str2"));

        HashMap<String, List<String>> map1 = new HashMap<>();
        map1.put("str1", List.of("str1.1", "str1.2", "str1.3"));
        map1.put("str2", List.of("str2.1", "str2.2", "str2.3"));
        System.out.println(map1.get("str2"));


        Human<Dog> h1 = new Human<>();
        Human<Cat> h2 = new Human<>();

        h1.addBestFriend(new Dog());
        h1.getBestFriend().sayGav();

        Cat c = new Cat();
        h2.addBestFriend(c);
//        System.out.println(c);
        h2.getBestFriend().sayMeow();
    }

    static class Dog {
        void sayGav() {
            System.out.println("Gav");
        }
    }

    static class Cat {
        void sayMeow() {
            System.out.println("Meow");
        }
    }

    //Generic parameterised with class T
    //class is object template;
    //Generic is class template
    static class Human<T> {
        private T bestFriend;

        public T getBestFriend() {
            return bestFriend;
        }

        public void addBestFriend(T bestFriend) {
            this.bestFriend = bestFriend;
        }
    }

    static List<Integer> onlyPositives(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (Integer i: list) {
            if (i > 0) {
                result.add(i);
            }
        }
        return result;
    }
}
