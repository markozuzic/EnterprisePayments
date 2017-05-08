package controllers;

import java.util.List;

import models.OrderForm;
import play.mvc.Controller;

public class OrderForms extends Controller {
	
	public static void show(String mode) {
		List<OrderForm> orderForms = OrderForm.findAll();
		if (mode == null || mode.equals("")) {
			mode = "edit";
		}
		render(orderForms, mode);
	}
	
	public static void create(OrderForm orderForm) {
		orderForm.save();
		show("add");
	}
	
	public static void edit(OrderForm orderForm) {
		orderForm.save();
		show("edit");
	}
	
	public static void filter(OrderForm orderForm) {
		List<OrderForm> orderForms = OrderForm.find("dateOfOrder = ? or numberOfOrder = ?",
													orderForm.dateOfOrder, orderForm.numberOfOrder).fetch();
		renderTemplate("OrderForms/show.html", "edit", orderForms);
	}
	
	public static void delete(Long id) {
		if (id != null) {
			OrderForm orderForm = OrderForm.findById(id);
			orderForm.delete();
		}
		show("edit");
	}
	
}
