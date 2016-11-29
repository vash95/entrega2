package uva.poo.entrega2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProductoTest {
	@Test
	public void testProducto() {
		Producto pipas = new Producto("pipas", 5.0, "12345678912");
		assertEquals(pipas.getNombre(), "pipas");
		assertEquals(5.0, pipas.getPrecio(), 0.01);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoInvalidoNombreNulo(){
		Producto pipas = new Producto(null, 5.0, "12345678912");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoInvalidoNombreVacio(){
		Producto vacio = new Producto ("",3.0, "12345678912");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoInvalidoPrecioCero(){
		Producto pipas = new Producto("pipas", 0.0, "12345678912");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoInvalidoPrecioNegativo(){
		Producto pipas = new Producto("pipas", -1.0, "12345678912");
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
//Fin constructor
	@Test
	public void testVendible() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNombre() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrecio() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNombre() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPrecio() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIdentificador() {
		fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString1() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}

}
