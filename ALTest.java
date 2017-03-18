import java.util.*;


public class ALTest {
    public static void main(String args[]) {
        ArrayList<Integer> al = new ArrayList<Integer>();

        al.add(1);
        al.add(3);
        al.add(7);
        al.add(6);
        al.add(9);

        System.out.println("Here is the ArrayList: " + al);

        al.add(0, 55);
        al.add(1, 44);

        System.out.println("Here is the ArrayList after adding to the front: " + al);

	al.remove(al.size() - 1);

        System.out.println("Here is the ArrayList after removing the last item: " + al);
    }

}

