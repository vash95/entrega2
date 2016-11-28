package uva.poo.entrega2;

public class prueba {

	public static void main(String[] args) {
		
		Producto[] lista = new Producto[2];
		//Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto b=new Producto("POLLO", 5.0, "123456789012");
		Producto c=new Producto("PATATAS", 10.0, "098765432112");
		
		lista[0]=b;
		//lista[1]=new Producto("POLLO", 5.0, "123456789012");
		lista[1]=c;
		
		Pack a = new Pack("pack", "123455", lista);
		System.out.println(a.getPrecio());
		c.setPrecio(20);
		System.out.println(a.getPrecio());
		
		System.out.println(b.getIdentificador());
		
		System.out.println(a.getPrecio());
	}

}
