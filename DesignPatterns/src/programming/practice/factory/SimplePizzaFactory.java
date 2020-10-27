package programming.practice.factory;

public class SimplePizzaFactory {
	
	public static Pizza createPizza(String name) {
		Pizza pizza = null;
		
		if(name.equals("cheese")) {
			pizza = new CheesePizza();
		} else if(name.equals("pepperoni")) {
			pizza = new PepperoniPizza();
		} else if (name.equals("clam")) {
			pizza = new ClamPizza();
		} else if (name.equals("viggie")) {
			pizza = new VeggiePizza();
		}
		
		return pizza;
	}

}
