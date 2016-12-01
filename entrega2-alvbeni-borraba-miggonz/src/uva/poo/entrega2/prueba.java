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
		Pack mio = new Pack( "uyzizukulemto", "123", lista);
		
		lista[0]=F;
		lista[1]=b;
		mio.agregaProducto(e);
		mio.toString();
		
	}

}
