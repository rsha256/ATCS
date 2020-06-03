package transplant;

public class Patient implements Comparable<Patient> {

	private String name;
	private int pri;
	
	public Patient(String name, int pri) {
		this.name = name;
		this.pri = pri;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPri(int pri) {
		this.pri = pri;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPri() {
		return pri;
	}

	public boolean equals(Patient obj) {
		return obj.getPri() == this.getPri();
	}
	
	@Override
	public int compareTo(Patient arg0) {
		if(arg0.getPri() == this.getPri()) return 0; 

		if (arg0.getPri() > this.getPri()) 
			return -1; 
		else return 1;
	}

	@Override
	public String toString() {
		return this.getName();
	}
	
	
}
