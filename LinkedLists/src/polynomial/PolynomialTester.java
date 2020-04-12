package polynomial;

//public class PolynomialTester {
//	public static void main(String[] args) {
//		Polynomial p = new Polynomial();
//		p.addTerm(3, 4);
//		p.addTerm(-2, 0);
//		p.addTerm(1, 3);
//
//		System.out.println("Polynomial p");
//		System.out.println(p);
//	}
//}

public class PolynomialTester {
	public static void main(String[] args) {
		Polynomial Poly1 = new Polynomial();
		Polynomial Poly2 = new Polynomial();
		Polynomial Poly3 = new Polynomial();
		Poly1.addTerm(3, 4);
		Poly1.addTerm(-2, 0);
		Poly1.addTerm(1, 3);

		Poly2.addTerm(2, 0);
		Poly2.addTerm(1, 2);
		Poly2.addTerm(3, 3);
		Poly2.addTerm(2, 1);
		Poly2.addTerm(1, 5);

		Poly3.addTerm(-3, 3);
		Poly3.addTerm(1, 2);
		Poly3.addTerm(1, 0);

		System.out.println("Poly1");
		System.out.println(Poly1);
		System.out.println();
		System.out.println("Poly2");
		System.out.println(Poly2);
		System.out.println();
		System.out.println("Poly3");
		System.out.println(Poly3);
		System.out.println();
		
		Polynomial r = new Polynomial();
		r = Poly2.add(Poly3);
		System.out.println("Poly2+Poly3");
		System.out.println(r);
		Polynomial u = new Polynomial();
		u = Poly1.add(Poly3);
		System.out.println("Poly1+Poly3");
		System.out.println(u);
		
		System.out.println();
		
		System.out.println("Poly3*Poly3");
		Polynomial s = new Polynomial();
		s = Poly3.multiply(Poly3);
		System.out.println(s);
		System.out.println("Poly1*Poly2");
		Polynomial v = new Polynomial();
		v = Poly1.multiply(Poly2);
		System.out.println(v);

		System.out.println();
		
		Polynomial t = new Polynomial();
		System.out.println("Poly2'");
		t = Poly2.derivative();
		System.out.println(t);
		Polynomial x = new Polynomial();
		System.out.println("Poly1'");
		x = Poly1.derivative();
		System.out.println(x);
	}
}