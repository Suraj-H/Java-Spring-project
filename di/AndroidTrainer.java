package com.mikadosolutions.training.spring.di;

import java.util.Set;

public class AndroidTrainer implements Trainer {
	String name;
	Set<String> specialties;

	public AndroidTrainer() {
	}

	public AndroidTrainer(String name, Set<String> specialties) {
		this.name = name;
		this.specialties = specialties;
	}

	@Override
	public void train() {
		System.out.println(name + " is training on Android");
	}

	@Override
	public Set<String> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<String> specialties) {
		this.specialties = specialties;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		 return name;
	}

	@Override
	public String toString() {
		return name + " is a Android trainer";
	}
}