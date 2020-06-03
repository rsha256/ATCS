package transplant;

import java.util.PriorityQueue;

public class LiverTransplantQueue {

	private PriorityQueue<Patient> one;
	
	public LiverTransplantQueue() {
		one = new PriorityQueue<Patient>();
	}
	
	int size() {
		return one.size();
	}

	void add(Patient patient) {
		one.add(patient);
	}

	String poll() {
		String tmp = "";
		Patient a = one.poll();
		tmp = a.getName();
		return tmp;
	}

	@Override
	public String toString() {
		return ""+one;
	}
	
}
