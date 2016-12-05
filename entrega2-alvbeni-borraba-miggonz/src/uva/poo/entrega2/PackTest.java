package uva.poo.entrega2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PackTest {
	
	@Test
	public void testPackValido(){
		Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto[] listaDeLaCompra = new Producto[2];
		Producto b=new Producto("PATATAS", 10.0, "098765432112");
		listaDeLaCompra[0]=a;
		listaDeLaCompra[1]=b;
		Pack miPack = new Pack("miPack",listaDeLaCompra);
		assertEquals(miPack.getNombre(),"miPack");
		assertEquals(miPack.getPrecio(),12.0, 0.01);
		assertEquals(miPack.getIdentificador(),"222221V");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testPackInvalidoMenosDe2Productos(){
		Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto[] listaDeLaCompra = new Producto[1];
		listaDeLaCompra[0]=a;
		Pack miPack = new Pack("miPack",listaDeLaCompra);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testPackInvalidoProductosIguales(){
		Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto[] listaDeLaCompra = new Producto[2];
		listaDeLaCompra[0]=a;
		listaDeLaCompra[1]=a;
		Pack miPack = new Pack("miPack",listaDeLaCompra);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testPackInvalidoNombreNull(){
		Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto[] listaDeLaCompra = new Producto[2];
		Producto b=new Producto("PATATAS", 10.0, "098765432112");
		listaDeLaCompra[0]=a;
		listaDeLaCompra[1]=b;
		Pack miPack = new Pack(null,listaDeLaCompra);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testPackInvalidoNombreVacio(){
		Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto[] listaDeLaCompra = new Producto[2];
		Producto b=new Producto("PATATAS", 10.0, "098765432112");
		listaDeLaCompra[0]=a;
		listaDeLaCompra[1]=b;
		Pack miPack = new Pack("",listaDeLaCompra);
	}
	@Test
	public void testDistintosValido() {
		Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto[] listaDeLaCompra = new Producto[2];
		Producto b=new Producto("PATATAS", 10.0, "098765432112");
		listaDeLaCompra[0]=a;
		listaDeLaCompra[1]=b;
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		assertTrue(miPack.distintos());
	}
	@Test
	public void testAgregaProductoValido(){
		Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto[] listaDeLaCompra = new Producto[2];
		Producto b=new Producto("PATATAS", 10.0, "098765432112");
		listaDeLaCompra[0]=a;
		listaDeLaCompra[1]=b;
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Producto c=new Producto("COCACOLA", 10.0, "098765432112");
		miPack.agregaProducto(c);
		assertEquals(miPack.getContenido().get(2),c);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testAgregaProductoInvalidoProductoNull(){
		Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto[] listaDeLaCompra = new Producto[2];
		Producto b=new Producto("PATATAS", 10.0, "098765432112");
		listaDeLaCompra[0]=a;
		listaDeLaCompra[1]=b;
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Producto c=null;
		miPack.agregaProducto(c);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testAgregaProductoInvalidoYaConteniaElProducto(){
		Producto repe=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {repe,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		miPack.agregaProducto(repe);
	}
	@Test
	public void testQuitaProductoValido() {
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto cola=new Producto("COCACOLA", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas,cola};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		miPack.quitaProducto(cola);
		assertEquals(miPack.getCantidad(),2);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testQuitaProductoInvalidoNull() {
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Producto nulo=null;
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		miPack.quitaProducto(nulo);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testQuitaProductoInvalidoQueNoEsta() {
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto cola=new Producto("COCACOLA", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		miPack.quitaProducto(cola);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testQuitaProductoInvalidoPackPeque() {
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		miPack.quitaProducto(patatas);
		miPack.quitaProducto(pollo);
	}
	@Test
	public void testAgregaVariosProductoValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto cola=new Producto("COCACOLA", 10.0, "098765432112");
		Producto golosinas = new Producto ("OSITOS HARIBO", 0.99, "123456789012");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Producto[] ampliacion = {cola,golosinas};
		miPack.agregaVariosProductos(ampliacion);
		assertEquals(miPack.getCantidad(),4);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testAgregaVariosInvalidoArrayNull(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto cola=new Producto("COCACOLA", 10.0, "098765432112");
		Producto golosinas = new Producto ("OSITOS HARIBO", 0.99, "123456789012");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Producto[] ampliacion = null;
		miPack.agregaVariosProductos(ampliacion);
	}
	@Test
	public void testQuitaVariosProductoValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto cola=new Producto("COCACOLA", 10.0, "098765432112");
		Producto golosinas = new Producto ("OSITOS HARIBO", 0.99, "123456789012");
		Producto[] listaDeLaCompra = {pollo,patatas,cola,golosinas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Producto[] quitar = {cola,golosinas};
		miPack.quitaVariosProductos(quitar);
		assertEquals(miPack.getCantidad(),2);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testQuitaVariosInvalidoArrayNull(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto cola=new Producto("COCACOLA", 10.0, "098765432112");
		Producto golosinas = new Producto ("OSITOS HARIBO", 0.99, "123456789012");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Producto[] quitar = null;
		miPack.agregaVariosProductos(quitar);
	}
	@Test
	public void testGetCantidadValido() {
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		assertEquals(miPack.getCantidad(),2);
	}
	@Test
	public void testContieneValido() {
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		assertTrue(miPack.contiene(pollo));
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testContieneInvalidoProductoNull() {
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		miPack.contiene(null);
	}
	@Test
	public void testGetPrecioValido() {
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		assertEquals(miPack.getPrecio(),12.0, 0.01);
	}
	@Test
	public void testGetIdentificadorValido() {
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		assertEquals(miPack.getIdentificador(),"222221V");
	}
	@Test
	public void testToStringValido() {
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		assertEquals(miPack.toString(),"Nombre del Pack: nombre, precio: 12.0 euros, ID: 222221V Contenido: ( Nombre del producto: POLLO, precio: 5.0 euros, UPC: 123456789012 Nombre del producto: PATATAS, precio: 10.0 euros, UPC: 098765432112)");
	}
	@Test
	public void testEqualsValido() {
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack PrimerPack = new Pack("nombre",listaDeLaCompra);
		Producto[] listaDeLaCompra2 = {pollo,patatas};
		Pack SegundoPack = new Pack("nombre", listaDeLaCompra2);
		assertTrue(PrimerPack.equals(SegundoPack));
	}
	//TEST COMO VENDIBLE
	@Test
	public void testPackVendibleInicializarValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto = (Vendible) miPack;
		assertEquals(miPack.getNombre(),"nombre");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testPackVendibleInicializarInvalidoNombreNull(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack(null,listaDeLaCompra);
		Vendible objeto = (Vendible) miPack;
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testPackVendibleInicializarInvalidoNombrVacio(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("",listaDeLaCompra);
		Vendible objeto = (Vendible) miPack;
	}
	@Test
	public void testPackVendibleGetNombreValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto = (Vendible) miPack;
		assertEquals(miPack.getNombre(),"nombre");
	}
	@Test
	public void testPackVendibleGetPrecioValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto = (Vendible) miPack;
		assertEquals(miPack.getPrecio(),12.0, 0.01);
	}
	@Test
	public void testPackVendibleSetNombreValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto_vendible = (Vendible) miPack;
		objeto_vendible.setNombre("cambio");
		assertEquals(miPack.getNombre(),"cambio");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testPackVendibleSetNombreInvalidoNombreNull(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto_vendible = (Vendible) miPack;
		objeto_vendible.setNombre(null);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testPackVendibleSetNombreInvalidoNombreVacio(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto_vendible = (Vendible) miPack;
		objeto_vendible.setNombre("");
	}
	@Test
	public void testPackVendibleGetIdentificadorValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre",listaDeLaCompra);
		Vendible objeto_vendible = (Vendible) miPack;
		assertEquals(objeto_vendible.getIdentificador(),"222221V");
	}
	
	
}