package controllers;

import java.util.List;

import models.OrderForm;
import models.OrderFormItem;
import play.mvc.Controller;

public class OrderFormItems extends Controller {
	
	public static void show(String mode) {
		List<OrderFormItem> orderFormItems = OrderFormItem.findAll();
		List<OrderForm> orderForms = OrderForm.findAll();
		if (mode == null || mode.equals("")) {
			mode = "edit";
		}
		renderTemplate("OrderFormItems/show.html", mode, orderFormItems, orderForms);	
	}
	
	public static void create(OrderFormItem orderFormItem) {
		orderFormItem.orderForm = OrderForm.findById(orderFormItem.orderForm.id);
		orderFormItem.save();
		show("add");
	}
	
	public static void edit(OrderFormItem orderFormItem) {
		orderFormItem.save();
		show("edit");
	}
	
	public static void filter(OrderFormItem orderFormItem) {
		List<OrderFormItem> orderFormItems= OrderFormItem.find("amount = ?",
													orderFormItem.amount).fetch();
		renderTemplate("OrderForms/show.html", "edit", orderFormItems);
	}
	
	public static void delete(Long id) {
		if (id != null) {
			OrderFormItem orderFormItem = OrderFormItem.findById(id);
			orderFormItem.delete();
		}
		show("edit");
	}
}
