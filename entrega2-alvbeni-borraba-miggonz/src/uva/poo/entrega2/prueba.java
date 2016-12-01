package uva.poo.entrega2;

public class prueba {

	public static void main(String[] args) {
		
		Producto[] lista = new Producto[3];

		Producto a=new Producto("Margarita", 10.0, "098765432112");
		Producto b=new Producto("POLLO", 5.0, "123456789012");
		Producto c=new Producto("PATATAS", 10.0, "098765432112");
		
		lista[0]=c;
		lista[2]=b;
		
		
		Pack mio = new Pack( "uyzizukulemto", "123", lista);
		
		System.out.println(mio.getCantidad());
		
		mio.agregaProducto(a);
		
		System.out.println(mio.getCantidad());
		
		mio.quitaProducto(b);
		
		System.out.println(mio.getCantidad());
		
		//mio.quitaProducto(b);
		
	}

}
