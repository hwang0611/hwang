package programming.practice.factory;

public abstract class Pizza {
	
	public abstract void prepare();
	
	public void bake() {
		System.out.println("피자 굽기~");
	}
	public void cut() {
		System.out.println("피자 자르기~");
	}
	public void box() {
		System.out.println("박스에 담기~");
	}

}
