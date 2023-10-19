import java.util.StringTokenizer;

public class Yokozuna implements Comparable<Yokozuna> {
    private final String name;
    private final int weight;

    public Yokozuna(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Yokozuna o) {
        return Integer.compare(weight, o.weight);

//        compare(weight, o.weight):
//        if (weight < o.weight) {
//            return -1;
//        } else if (weight > o.weight) {
//            return 1;
//        } else {
//            return 0;
//        }
    }

//    @Override
//    public int compareTo(Yokozuna o) {
//        return String.CASE_INSENSITIVE_ORDER.compare(name, o.name);
//    }

    public String toString() {
        return "{ " + name + ", " + weight + " }";
    }
}
