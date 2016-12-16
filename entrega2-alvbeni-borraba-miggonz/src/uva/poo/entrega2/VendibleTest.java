package uva.poo.entrega2;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Práctica 2 de Programación Orientada a Objetos
 * La clase vendible es abstracta, por lo que para probarla, utilizamos referencias de las clases que heredan de ella, probando así su uso polimórficamente
 * @author alvbeni
 * @author miggonz
 * @author borraba
 */
public class VendibleTest {
	//Test de instancias pack como vendibles
	@Test
	public void testVendiblePackInicializarValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto = miPack;
		assertEquals(objeto.getNombre(),"nombre");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testVendiblePackInicializarInvalidoNombreNull(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack(null,listaDeLaCompra);
		Vendible objeto = miPack;
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testVendiblePackInicializarInvalidoNombreVacio(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("",listaDeLaCompra);
		Vendible objeto = miPack;
	}
	@Test
	public void testVendiblePackGetNombreValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto = miPack;
		assertEquals(objeto.getNombre(),"nombre");
	}
	@Test
	public void testVendiblePackGetPrecioValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto = miPack;
		assertEquals(objeto.getPrecio(),12.0, 0.01);
	}
	@Test
	public void testVendiblePackSetNombreValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible pack_vendible = miPack;
		pack_vendible.setNombre("cambio");
		assertEquals(pack_vendible.getNombre(),"cambio");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testVendiblePackSetNombreInvalidoNombreNull(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto_vendible = miPack;
		objeto_vendible.setNombre(null);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testVendiblePackSetNombreInvalidoNombreVacio(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto_vendible = miPack;
		objeto_vendible.setNombre("");
	}
	@Test
	public void testVendiblePackGetIdentificadorValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto_vendible = miPack;
		assertEquals(objeto_vendible.getIdentificador(),"222221V");
	}
	//Test de instancias producto como vendible
	@Test
	public void testVendibleProductoInicializarValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Vendible pollo_vendible = pollo;
		assertEquals(pollo_vendible.getNombre(),"POLLO");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testVendibleProductoInicializarInvalidoNombreNull(){
		Producto pollo=new Producto(null, 5.0, "123456789012");
		Vendible pollo_vendible = pollo;
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testVendibleProductoInicializarInvalidoNombreVacio(){
		Producto pollo=new Producto("", 5.0, "123456789012");
		Vendible pollo_vendible = pollo;
	}
	@Test
	public void testVendibleProductoGetNombreValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Vendible pollo_vendible = pollo;
		assertEquals(pollo_vendible.getNombre(),"POLLO");
	}
	@Test
	public void testVendibleProductoGetPrecioValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Vendible pollo_vendible = pollo;
		assertEquals(5.0, pollo_vendible.getPrecio(), 0.01);	
	}
	@Test
	public void testVendibleProductoGetIdentificadorValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Vendible pollo_vendible = pollo;
		assertEquals(pollo_vendible.getIdentificador(),"123456789012");
	}
	@Test
	public void testVendibleProductoSetNombreValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Vendible pollo_vendible = pollo;
		pollo_vendible.setNombre("nuevo");
		assertEquals(pollo_vendible.getNombre(),"nuevo");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testVendibleProductoSetNombreInvalidoNombreNull(){
		Producto pollo=new Producto("", 5.0, "123456789012");
		Vendible pollo_vendible = pollo;
		pollo_vendible.setNombre(null);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testVendibleProductoSetNombreInvalidoNombreVacio(){
		Producto pollo=new Producto("", 5.0, "123456789012");
		Vendible pollo_vendible = pollo;
		pollo_vendible.setNombre("");
	}
	
}