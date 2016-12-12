package uva.poo.entrega2;
//Producto test
import static org.junit.Assert.*;
import org.junit.Test;

public class ProductoTest {
	@Test
	public void testProducto() {
		Producto pipas = new Producto("pipas", 5.0, "123456789012");
		assertEquals(pipas.getNombre(), "pipas");
		assertEquals(5.0, pipas.getPrecio(), 0.01);
		assertEquals(pipas.getIdentificador(),"123456789012");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoInvalidoNombreNulo(){
		Producto pipas = new Producto(null, 5.0, "123456789012");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoInvalidoNombreVacio(){
		Producto vacio = new Producto ("",3.0, "123456789012");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoInvalidoPrecioCero(){
		Producto pipas = new Producto("pipas", 0.0, "123456789012");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoInvalidoPrecioNegativo(){
		Producto pipas = new Producto("pipas", -1.0, "123456789012");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoInvalidoUPCNulo(){
		Producto pipas = new Producto ("pipas",3.0, null);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoInvalidoUPCLargo(){
		Producto pipas = new Producto ("pipas",3.0, "1234567890123");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoInvalidoDigitoDeControlInvalido(){
		Producto pipas = new Producto ("pipas",3.0,"123456789013");
	}
	@Test
	public void testDigitoDeControlValidoCorrecto(){
		Producto a = new Producto("pipas", 5.0, "123456789012");
		assertTrue(a.DigitoDeControlValido(a.getIdentificador()));
	}
	@Test
	public void testSetPrecioValido() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		p.setPrecio(5.0);
		assertEquals(5.0, p.getPrecio(), 0.01);	
	}
	@Test
	public void testGetPrecioValido() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		assertEquals(1.0, p.getPrecio(), 0.01);	
	}
	@Test
	public void testGetIdentificadorValido() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		assertEquals(p.getIdentificador(),"123456789012");
	}
	@Test
	public void testSetIdentificadorValido() {
		Producto correcto = new Producto("pipas", 5.0, "123456789012");
		correcto.setIdentificador("123456789012");
		assertEquals(correcto.getIdentificador(),"123456789012");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testSetIdentificadorInvalidoNull(){
		Producto error = new Producto("pipas",5.0, null);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testSetIdentificadorInvalidoLongMenorA12(){
		Producto error = new Producto("pipas", 5.0, "1234567890123");
		error.setIdentificador("123456789012");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testSetIdentificadorInvalidoLongMayorrA12(){
		Producto error = new Producto("pipas", 5.0, "1234567890123");
		error.setIdentificador("12345678901234");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testSetIdentificadorInvalidoDigitoControlInvalido(){
		Producto error = new Producto("pipas", 5.0, "1234567890123");
		error.setIdentificador("1234567890124");
	}
	@Test
	public void testToStringValido(){
		Producto p = new Producto ("hola",1.0,"123456789012");
		String s="Nombre del producto: hola, precio: 1.0 euros, UPC: 123456789012";
		assertTrue(s.equals(p.toString()));
	}
	@Test
	public void testEqualsValido() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		Producto q = new Producto ("hola",1.0,"123456789012");
		assertNotSame(p,q);
		assertTrue(q.equals(p));
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