package programming.practice.factory;

public class Main {
	public static void main(String[] args) {
		
		PizzaStore pizzaStore =new PizzaStore();
		
		Pizza
		
		pizza = pizzaStore.OrderPizza("cheese");
		System.out.println(pizza+"°í°´ Àü´Þ\n");
		
		pizza = pizzaStore.OrderPizza("pepperoni");
		System.out.println(pizza+"°í°´ Àü´Þ\n");
		
		pizza = pizzaStore.OrderPizza("clam");
		System.out.println(pizza+"°í°´ Àü´Þ\n");
		
		pizza = pizzaStore.OrderPizza("viggle");
		System.out.println(pizza+"°í°´ Àü´Þ\n");
	}

}
