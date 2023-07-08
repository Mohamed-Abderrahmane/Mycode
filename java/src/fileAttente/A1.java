package fileAttente;

import java.util.Comparator;

public class A1 <K extends Comparable<K>,L extends Comparable<L>, M extends Comparable<M>> implements Comparator <Triplet <K,L,M>> {

	public int compare(Triplet<K,L,M> a, Triplet<K,L,M> b) {
		
		return a.getA().compareTo(b.getA());
		}

	
	
}
