package polynomial;

public class Term {

	private int coeff = 0;
	private int pow = 0;

	public Term(int coeff, int pow) {
		this.coeff = coeff;
		this.pow = pow;
	}

	public String add(Term t) {
		int c = t.coeff;
		int p = t.pow;

		int cum = 0;

		if (pow == p) {
			cum = c + coeff;
		} else {
			return "Can't be added bcuz diff powers";
		}

		return cum + "x^" + p;
	}

	public String derivative() {
		return coeff * pow + "x" + (pow - 1);
	}

	public String multiply(Term t) {
		int c = t.coeff;
		int p = t.pow;

		int cumC = c * coeff;
		int cumP = p + pow;

		return cumC + "x^" + cumP;
	}

	public int getCoeff() {
		return coeff;
	}

	public int getPow() {
		return pow;
	}

	public void setCoeff(int coeff) {
		this.coeff = coeff;
	}

	public void setPow(int pow) {
		this.pow = pow;
	}
	
	@Override
	public String toString() {
		return coeff + "x^" + pow;
	}

}
