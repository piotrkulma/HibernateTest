package test.model;

import java.util.SortedSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity(name="SOMETHING")
public class Something {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "FIELD")
	private String field;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="something", targetEntity=SomethingItem.class)
	@OrderBy(value="id")
	private SortedSet<SomethingItem> somethingItems;

	
	public Something() {}
	public Something(String field) {
		this.field = field;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public SortedSet<SomethingItem> getSomethingItems() {
		return somethingItems;
	}

	public void setSomethingItems(SortedSet<SomethingItem> somethingItems) {
		this.somethingItems = somethingItems;
	}
}
