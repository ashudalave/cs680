package edu.umb.cs.cs680.hw08;

import java.util.ArrayList;

public class Observable {
	
	public ArrayList<Observer> observers;
	private boolean flag;
	
	public Observable() {
		observers = new ArrayList<Observer>();
		flag = false;
	}
	
	public void addObserver(Observer o) {
		this.observers.add(o);
	}
	
	public void setChanged() {
		this.flag = true;
	}
	
	public boolean hasChanged() {
		return this.flag;
	}
	
	public void clearChanged() {
		this.flag = false;
	}
	
	public void notifyObservers() {
		notifyObservers(null);
	}
	
	public void notifyObservers(Object arg) {
		if(hasChanged()) {
			for(Observer obs: this.observers) {
				obs.update(this, arg);
			}
			clearChanged();
		}
	}
}
