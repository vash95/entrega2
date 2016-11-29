package uva.poo.entrega2;

public class prueba {

	public static void main(String[] args) {
		
		Producto[] lista = new Producto[3];
		Producto[] lista1 = new Producto[3];
		//Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto b=new Producto("POLLO", 5.0, "123456789012");
		Producto c=new Producto("PATATAS", 10.0, "098765432112");
		Producto g=new Producto("margarita", 10.0, "098765432112");
		
		Producto d=new Producto("POLLO", 5.0, "123456789012");
		Producto e=new Producto("PATATAS", 10.0, "098765432112");
		Producto F=new Producto("COCACOLA", 10.0, "098765432112");
		
		lista[0]=F;
		lista[1]=b;
		lista[2]=g;
		lista1[0]=g;
		lista1[1]=F;
		lista1[2]=b;

		
		
		Pack a1 = new Pack("hola", 1, "123", lista);
		Pack b1 = new Pack("hola", 1, "123", lista1);
		
	
		
		System.out.println(a1.equals(b1));
		
	}

}
