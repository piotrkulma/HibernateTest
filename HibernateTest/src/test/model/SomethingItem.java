package test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="SOMETHING_ITEM")
public class SomethingItem implements Comparable<SomethingItem>{
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="VALUE")
	private String value;
	
	@ManyToOne
	private Something something;
	
	public SomethingItem() {}

	public SomethingItem(String value, Something s) {
		this.value = value;
		this.something = s;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Something getSomething() {
		return something;
	}

	public void setSomething(Something something) {
		this.something = something;
	}

	@Override
	public int compareTo(SomethingItem o) {
		if(id > o.id) return 1;
		else if(id < o.id) return -1;
		else return 0;
	}
}
