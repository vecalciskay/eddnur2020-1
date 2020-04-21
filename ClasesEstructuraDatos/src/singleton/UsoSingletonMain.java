package singleton;

public class UsoSingletonMain {

	public static void main(String[] args) {
		MiSingleton obj1 = MiSingleton.getOrCreate();
		obj1.setAtributo1("Paco");
		
		MiSingleton obj2 = MiSingleton.getOrCreate();
		obj2.setAtributo1("Luis");
		
		if (obj1 == obj2)
			System.out.println("Dos referencias al mismo objeto");
		
		System.out.println(obj1.getAtributo1());
		System.out.println(obj2.getAtributo1());
	}
}
