package uva.poo.entrega2;

import static org.junit.Assert.*;

import org.junit.Test;

public class VendibleTest {

	//La clase vendible es abstracta, por lo que para probarla, utilizamos referencias 
	//de las clases que heredan de ella, y probamos su uso polim”rficamente
	
	//TEST COMO Pack
	@Test
	public void testPackVendibleInicializarValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto = miPack;
		assertEquals(objeto.getNombre(),"nombre");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testPackVendibleInicializarInvalidoNombreNull(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack(null,listaDeLaCompra);
		Vendible objeto = miPack;
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testPackVendibleInicializarInvalidoNombrVacio(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("",listaDeLaCompra);
		Vendible objeto = miPack;
	}
	@Test
	public void testPackVendibleGetNombreValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto = miPack;
		assertEquals(objeto.getNombre(),"nombre");
	}
	@Test
	public void testPackVendibleGetPrecioValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto = miPack;
		assertEquals(objeto.getPrecio(),12.0, 0.01);
	}
	@Test
	public void testPackVendibleSetNombreValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible pack_vendible = miPack;
		pack_vendible.setNombre("cambio");
		assertEquals(pack_vendible.getNombre(),"cambio");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testPackVendibleSetNombreInvalidoNombreNull(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto_vendible = miPack;
		objeto_vendible.setNombre(null);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testPackVendibleSetNombreInvalidoNombreVacio(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto_vendible = miPack;
		objeto_vendible.setNombre("");
	}
	@Test
	public void testPackVendibleGetIdentificadorValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto_vendible = miPack;
		assertEquals(objeto_vendible.getIdentificador(),"222221V");
	}
	//Test como Producto
	@Test
	public void testProductoVendibleInicializarValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Vendible pollo_vendible = pollo;
		assertEquals(pollo_vendible.getNombre(),"POLLO");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoVendibleInicializarInvalidoNombreNull(){
		Producto pollo=new Producto(null, 5.0, "123456789012");
		Vendible pollo_vendible = pollo;
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoVendibleInicializarInvalidoNombreVacio(){
		Producto pollo=new Producto("", 5.0, "123456789012");
		Vendible pollo_vendible = pollo;
	}
	@Test
	public void testProductoVendibleGetNombreValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Vendible pollo_vendible = pollo;
		assertEquals(pollo_vendible.getNombre(),"POLLO");
	}
	@Test
	public void testProductoVendibleGetPrecioValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Vendible pollo_vendible = pollo;
		assertEquals(5.0, pollo_vendible.getPrecio(), 0.01);	
	}
	@Test
	public void testProductoVendibleGetIdentificadorValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Vendible pollo_vendible = pollo;
		assertEquals(pollo_vendible.getIdentificador(),"123456789012");
	}
	@Test
	public void testProductoVendibleSetNombreValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Vendible pollo_vendible = pollo;
		pollo_vendible.setNombre("nuevo");
		assertEquals(pollo_vendible.getNombre(),"nuevo");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoVendibleSetNombreInvalidoNombreNull(){
		Producto pollo=new Producto("", 5.0, "123456789012");
		Vendible pollo_vendible = pollo;
		pollo_vendible.setNombre(null);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoVendibleSetNombreInvalidoNombreVacio(){
		Producto pollo=new Producto("", 5.0, "123456789012");
		Vendible pollo_vendible = pollo;
		pollo_vendible.setNombre("");
	}
	
}