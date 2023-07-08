package fileAttente;



public class Triplet<K extends Comparable<K>,L extends Comparable<L>, M extends Comparable<M>>{


	private K a;
	private L b;
	private M c;
	
	public Triplet(K a, L b, M c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	
	public K getA() {
		return a;
	}



	public void setA(K a) {
		this.a = a;
	}



	public L getB() {
		return b;
	}



	public void setB(L b) {
		this.b = b;
	}



	public M getC() {
		return c;
	}



	public void setC(M c) {
		this.c = c;
	}
	


	//ArrayList<Triplet> d = new ArrayList<Triplet>();
	
/*	public int compareTo(Triplet b) {
		if(this.a < b.a) {
			return -1;
		}
		else {
			if(this.a > b.a){
				return 1;
			}
			else {
				return 0;
			}
		}
	}
	
*/	
	
/*	public void max() {
	
		d.add(a);
		d.add(b);
		d.add(c);
		System.out.println("Le max est "+Collections.max(d)); 
		
		
	}
*/
	
	

	@Override
	public String toString() {
		return "Triplet [a=" + a + ", b=" + b + ", c=" + c + "]";
	}





}
