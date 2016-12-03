package uva.poo.entrega2;
/**
 * Practica 2 de Programacion Orientada a Objetos
 * Implementacion de instancias abstractas que son vendibles
 * @author alvbeni
 * @author miggonz
 * @author borraba
 */
public abstract class Vendible {
	//Atributos de la clase
	 private String nombre;
	 /**
	  * Inicializa una instancia de vendible con los valores dados como argumento
	  * @param nombre String con el nombre
	  * @param identificador String con el identificador 
	  * @assert.pre nombre!=null - El nombre no puede ser nulo
	  * @assert.pre nombre!="" - El nombre no puede ser una cadena vacia
	  */
	 public Vendible(String nombre){
		 assert (nombre!=null);
		 assert (!nombre.trim().equals("")); 
		 this.nombre=nombre;
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
	 public abstract double getPrecio();
	 /**
	  * Cambia el nombre del producto
	  * @param nombre String nombre del producto
	  * @assert.pre nombre!=null - El nombre no puede ser nulo
	  * @assert.pre nombre!="" - El nombre no puede ser una cadena vacia
	  */
	 public void setNombre(String nombre) {
		 assert (nombre!=null);
		 assert (!nombre.trim().equals(""));  
	     this.nombre = nombre;
	 }
	 /**
	  * Devuelve el identificador de la instancia vendible
	  * @return identificador String con el identificador
	  */
	 abstract String getIdentificador();
}