package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class OrderFormItem extends Model{
	
	public double amount;
	
	@ManyToOne
	public OrderForm orderForm;
	
	public OrderFormItem(double amout) {
		this.amount = amout;
	}
}
