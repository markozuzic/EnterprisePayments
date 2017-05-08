package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class OrderForm extends Model{
	
	public Date dateOfOrder;
	
	public int numberOfOrder;
	
	public OrderForm(Date dateOfOrder, int numberOfOrder) {
		this.dateOfOrder = dateOfOrder;
		this.numberOfOrder = numberOfOrder;
	}
}
