

public class NumberSwapper {
    public void swap(Integer a, Integer b) {
	System.out.println("a=" + a + " b=" + b);

	a = a - b;
	b = a + b;
	a = -a + b;

	System.out.println("Swapped: a=" + a + " b=" + b);
    }

    public static void main(String[] args) {
	NumberSwapper ns = new NumberSwapper();

	ns.swap(2, 8);
	ns.swap(5, 13);
	ns.swap(25, 45);
	ns.swap(-12, 65);
	ns.swap(76, -333);
    }
}

