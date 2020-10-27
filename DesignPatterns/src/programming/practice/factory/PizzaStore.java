package programming.practice.factory;

public class PizzaStore {
	
	public Pizza OrderPizza(String PizzaName) {
		Pizza pizza = SimplePizzaFactory.createPizza(PizzaName);
		
		if(pizza == null) {
			return null;
		}
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}

}
