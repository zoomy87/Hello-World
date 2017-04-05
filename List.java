package edu.ilstu.it275.assignment7.ejzumba;

import java.util.Arrays;

public class List {
	private Organism list[];
	private int size;
	private int location;

	public List() {
		location = 0;
		size = 1000;
		list = new Organism[size];
	}

	public void store(Organism obj) {
		if (location > (size * .75)) {
			increaseStorage();
		} else {
			list[location] = obj;
			location++;
		}
	}

	private void increaseStorage() {
		size *= 2;
		if (size > 400) {
			return;
		} else {
			list = Arrays.copyOf(list, size);
			return;
		}
	}
	
	public Organism getOrganism(int i){
		return list[i];
	}
	
}
