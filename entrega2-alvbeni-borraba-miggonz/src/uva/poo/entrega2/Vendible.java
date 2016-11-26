package uva.poo.entrega2;

public abstract class Vendible {

	 private String nombre;
	 private double precio;
	 private String identificador;
	 
	 public Vendible(String nombre,String identificador){
		 this.nombre=nombre;
		 this.identificador=identificador;
	}
	 
	 public Vendible(String nombre,double precio,String identificador){
		 this.nombre=nombre;
		 this.precio=precio;
		 this.identificador=identificador;
	 }
     /**
      * Devuelve el nombre del producto
      * @return nombre String con el nombre
      */
	 public String getNombre(){
		 return nombre;
	 }
	 /**
     * Devuelve el precio del producto en euros
     * @return precio double en euros
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
	   * Cambia el precio del producto
	   * @param precio double con el nuevo precio en euros
	   * @assert.pre precio>0 - El precio debe ser estrictamente positivo
	   */
	  public void setPrecio(double precio) {
	            this.precio = precio;
	  }
	  public String getIdentificador(){
			 return identificador;
		 }
	  
	  public void setIdentificador(String id){
		  this.identificador = id;
		 }
	 
}