package uva.poo.entrega2;
/**
 * Práctica 2 de Programación Orientada a Objetos
 * Implementación de instancias abstractas que son vendibles
 * @author alvbeni
 * @author miggonz
 * @author borraba
 */
public abstract class Vendible {
	//Atributos de la clase
	 private String nombre;
	 private double precio;
	 private String identificador;
	 /**
	  * Inicializa una instancia de vendible con los valores dados como argumento
	  * @param nombre String con el nombre
	  * @param precio double con el precio
	  * @param identificador String con el identificador 
	  * @assert.pre nombre!=null - El nombre no puede ser nulo
	  * @assert.pre nombre!="" - El nombre no puede ser una cadena vacía
	  */
	 public Vendible(String nombre,double precio,String identificador){
		 assert (nombre!=null);
		 assert (!nombre.trim().equals("")); 
		 this.nombre=nombre;
		 this.precio=precio;
		 this.identificador=identificador;
	 }
     /**
      * Devuelve el nombre de la instancia vendible
      * @return nombre String con el nombre
      */
	 public String getNombre(){
		 return nombre;
	 }
	 /**
      * Devuelve el precio de la instancia vendible
      * @return precio double
      */
	 public double getPrecio(){
		 return precio;
	 }
	 /**
	  * Cambia el nombre del producto
	  * @param nombre String nombre del producto
	  * @assert.pre nombre!=null - El nombre no puede ser nulo
	  * @assert.pre nombre!="" - El nombre no puede ser una cadena vacía
	  */
	 public void setNombre(String nombre) {
		 assert (nombre!=null);
		 assert (!nombre.trim().equals(""));  
	     this.nombre = nombre;
	 }
	 /**
	  * Cambia el precio de la instancia vendible
	  * @param precio double con el nuevo precio 
	  */
	 public void setPrecio(double precio) {
		 this.precio = precio;
	 }
	 /**
	  * Devuelve el identificador de la instancia vendible
	  * @return identificador String con el identificador
	  */
	 public String getIdentificador(){
		 return identificador;
	 }
	  /**
	   * Modifica el identificador de de la instancia vendible
	   * @param id	String con el nuevo identificador
	   */
	  public void setIdentificador(String id){
		  this.identificador = id;
	  }
	 
}