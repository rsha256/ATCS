package polynomial;

import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {

	private LinkedList<Term> one;

	public Polynomial() {
		one = new LinkedList<Term>();
	}

	public void addTerm(int c, int p) {
		if (c == 0) {
			return;
		}

		ListIterator<Term> iter = one.listIterator();
		while (iter.hasNext()) {
			Term term = iter.next();
			if (term.getPow() < p) {
				iter.previous();
				iter.add(new Term(c, p));
				return;
			} else if (term.getPow() == p) {
				if ((term.getCoeff() + c) != 0) {
					term.setCoeff(term.getCoeff() + c);
				} else {
					iter.remove();
				}
				return;
			}
		}
		iter.add(new Term(c, p));

	}

	public Polynomial add(Polynomial poly3) {
		Polynomial poly4 = new Polynomial();

		ListIterator<Term> iter1 = one.listIterator();
		while (iter1.hasNext()) {
			Term x = iter1.next();
			poly4.addTerm(x.getCoeff(), x.getPow());
		}

		ListIterator<Term> iter2 = poly3.one.listIterator();
		while (iter2.hasNext()) {
			Term x = iter2.next();
			poly4.addTerm(x.getCoeff(), x.getPow());
		}

		return poly4;
	}

	public Polynomial multiply(Polynomial poly3) {
        Polynomial two = new Polynomial();
        ListIterator<Term> iter = this.one.listIterator();

        while (iter.hasNext()) {
        	Term termOne = (Term) iter.next();
        	ListIterator<Term> iter3 = poly3.one.listIterator();
            
            while (iter3.hasNext()) {
            	Term term = (Term) iter3.next();
            	int c = termOne.getCoeff() * term.getCoeff();
                int p = termOne.getPow() + term.getPow();
            	two.addTerm(c, p);
            }
        }

        return two;
	}

	public Polynomial derivative() {
		Polynomial two = new Polynomial();
		for (Term term : one) {
			int c = term.getCoeff() * term.getPow();
			int p = term.getPow() - 1;
			if (p != 0) // case for ln|x| it isnt a polynomial so we dont add it :(
				two.addTerm(c, p);
		}
		return two;
	}

	@Override
	public String toString() {
		return one + "";
	}

}
