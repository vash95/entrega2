package uva.poo.entrega2;

public class prueba {

	public static void main(String[] args) {
		
		
		Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto[] listaDeLaCompra = new Producto[3];
		Producto b=new Producto("PATATAS", 11.54, "123456789012");
		//listaDeLaCompra[0]=a;
		listaDeLaCompra[2]=b;
		Pack miPack = new Pack("miPack",listaDeLaCompra);
	
		//System.out.println(miPack.getCantidad());
	}

}