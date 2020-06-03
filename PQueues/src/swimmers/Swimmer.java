package swimmers;

public class Swimmer implements Comparable<Swimmer> {

	private int ht, wt, age;

	public Swimmer() {
		this(0, 0, 0);
	}

	public Swimmer(int ht, int wt, int age) {
		this.ht = ht;
		this.wt = wt;
		this.age = age;
	}

	public void setHeight(int ht) {
		this.ht = ht;
	}

	public void setWeight(int wt) {
		this.wt = wt;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Object clone() {
		return new Swimmer();
	}

	public int getHeight() {
		return ht;
	}

	public int getWeight() {
		return wt;
	}

	public int getAge() {
		return age;
	}

	public boolean equals(Swimmer o) {
		return (o.getAge() == this.getAge() && o.getHeight() == this.getHeight() && o.getWeight() == this.getWeight());
	}

	@Override
	public int compareTo(Swimmer rhs) {
		if (rhs.equals(this))
			return 0;

		if (rhs.getHeight() != this.getHeight()) {
			if (rhs.getHeight() > this.ht)
				return -1;
			else
				return 1;
		}
		if (rhs.getWeight() != this.wt) {
			if (rhs.getWeight() > this.wt)
				return -1;
			else
				return 1;
		}
		if (rhs.getAge() != this.age) {
			if (rhs.getAge() > this.age)
				return -1;
			else
				return 1;
		}
		return 1;
	}

	public String toString() {
		return this.ht + " " + this.wt + " " + this.age;
	}

}
