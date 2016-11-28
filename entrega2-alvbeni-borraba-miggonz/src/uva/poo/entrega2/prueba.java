package uva.poo.entrega2;

public class prueba {

	public static void main(String[] args) {
		
		Producto[] lista = new Producto[2];
		Producto[] lista1 = new Producto[2];
		//Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto b=new Producto("POLLO", 5.0, "123456789012");
		Producto c=new Producto("PATATAS", 10.0, "098765432112");
		
		Producto d=new Producto("POLLa", 5.0, "123456789012");
		Producto e=new Producto("PATATs", 10.0, "098765432112");
		
		lista[0]=b;
		lista[1]=c;
		
		lista1[0]=d;
		lista1[1]=e;
		
		Pack a1 = new Pack("hola", 1, "123", lista);
		Pack b1 = new Pack("hola", 1, "123", lista1);
		
		System.out.println(a1.equals(b1));
		
	}

}
