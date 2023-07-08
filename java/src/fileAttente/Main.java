package fileAttente;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		Triplet<Integer, String, Integer> t1 = new Triplet<>(80, "Test" , 10);
		Triplet<Integer, String, Integer> t2 = new Triplet<>(10, "Test" , 20);
		Triplet<Integer, String, Integer> t3 = new Triplet<>(70, "Test" , 5);
		ArrayList<Triplet<Integer, String, Integer>> test = new ArrayList<Triplet<Integer, String, Integer>>();
		test.add(t1);
		test.add(t2);
		test.add(t3);
		Collections.sort(test, new A1<Integer, String, Integer>());
		System.out.println(test.toString());
		
		for (int i = 0; i<test.size();i++) {
			System.out.println(test.get(i).toString());
		}

	}

}
