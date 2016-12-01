package uva.poo.entrega2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Practica 2 de Programacion Orientada a Objetos
 * Implementacion de packs de productos y servicios realcionados con la modificacion de los mismos
 * Un pack contienen m�s de un producto
 * Los productos de un pack son distintos entre ellos
 * Un pack cuesta un 20% menos que la suma de los precios de sus productos individuales
 * Los packs heredan de la clase Vendible
 * @author alvbeni
 * @author miggonz
 * @author borraba
 */
public class Pack extends Vendible {
	//Atributo de la clase
	
	private ArrayList<Producto> contenido;
	/**
	 * Inicializacion de un pack de productos con nombre, precio
	 * @param nombre String con el nombre
	 * @param precio double precio (no se tiene en cuenta)
	 * @param identificador String con el identificador
	 * @param productos array con los Productos a meter en el pack
	 * @assert.pre getContenido().length>2 - El pack debe tener como minimo 2 productos
	 * @assert.pre distintos==true - Los productos deben de ser distintos
	 */
	public Pack(String nombre, String identificador, Producto[] productos){
		super(nombre, identificador);
		contenido = new ArrayList<Producto>(Arrays.asList(productos));
		assert(getCantidad()>=2);	
		assert(distintos());
		//faltaria un nombre!= null y eso no?
	}
	/**
	 * Comprueba que los productos de un pack son distintos
	 * Devuelve "true" si son distintos
	 * @return boolean
	 */
	public boolean distintos(){
		for(int i=0;i<getContenido().size()-1;i++){
			for(int j=i+1;j<getContenido().size();j++){
				if(getContenido().get(i).equals(getContenido().get(j)))
					return false;
					}
			}
			return true;
	}
	/**
	 * Agrega un nuevo producto al pack
	 * @param p Producto nuevo a agregar al pack
	 * @assert.pre p!=null - El producto a agregar no puede ser nulo
	 * @assert.pre !contiene(p)- El producto a agregar no puede estar ya en el pack
	 */
	public void agregaProducto(Producto p){
			assert(!contiene(p));
			getContenido().add(p);
	}
	/**
	 * Quita un producto del pack
	 * @param p Producto a quitar del pack
	 * @assert.pre p!=null - El producto a quitar no puede ser nulo
	 * @assert.pre !contiene(p)- El producto a quitar no puede estar ya en el pack
	 * @assert.pre getCantidad()>2 - El pack no puede quedarse con menos de dos productos
	 */
	public void quitaProducto(Producto p){
		assert(p!=null);
		assert(getContenido().contains(p));
		assert(getCantidad()>2);
		getContenido().remove(p);
	}
	/**
	 * Agrega varios productos a un pack
	 * @param p array de productos a agregar al pack
	 */
	public void agregaProductos(Producto p[]){
		for(Producto e:p){
			agregaProducto(e);
		}	
	}
	/**
	 * Quita varios productos de un pack
	 * @param p array de productos a quitar del pack
	 */
	public void quitaProductos(Producto p[]){
		for(Producto e:p){
			quitaProducto(e);
		}
	}
	/**
	 * Devuelve la cantidad de productos que tiene un pack
	 * Nota: se empieza a contar desde cero
	 * @return getContenido.length 
	 */
	public int getCantidad(){
		return getContenido().size();
	}
	/**
	 * Devuelve el pack
	 * @return contenido array de productos
	 */
	public ArrayList<Producto> getContenido() {
			   return contenido;
		   }
	public boolean contiene(Producto p){
		assert(p.equals(null));
		return getContenido().contains(p);
	}
	/**
	 * Devuelve el precio del pack
	 */
	@Override
	public double getPrecio() {
		double precioPack=0;
		for(Producto e:getContenido()){
			precioPack+=e.getPrecio();
		}
		precioPack-=precioPack*0.2;
		return precioPack;
	}
	/**
	 * Devuelve informacion sobre el pack
	 */
	@Override
	public String toString(){
		String contenedor="";
		for(Producto e:getContenido())
			contenedor+=" "+e.toString();
		return  "Nombre del Pack: "+getNombre()+", precio: "+getPrecio()+" euros, ID: "+getIdentificador()+" Contenido: (" +contenedor+")";
	}
	private boolean sonIgualesArrays(Pack otro){
		//Comprueba si dos arrays de productos son iguales
		int contador=0;
		if(getCantidad()==otro.getCantidad()){
			for(Producto e:otro.getContenido()){
				if(contiene(e)){
					contador++;
				}
			}
			//Deben contener los mismos productos, aunque esten en diferentes posiciones
			if(contador==getCantidad()){
				return true;
			}
		}		
		return false;
	}
	/**
	 * Comprueba si dos packs son iguales
	 * Dos packs se consideran iguales si contienen los mismos productos
	 * Devuelve "true" si son iguales
	 * @param otro otro Pack para comparar
	 * @return boolean
	 */
	public boolean equals(Pack otro){
		  if(getNombre().equals(otro.getNombre()) && getPrecio()==otro.getPrecio()
				  && getIdentificador().equals(otro.getIdentificador()) && getCantidad()==otro.getCantidad() && sonIgualesArrays(otro) ){
			  return true;
			  }
		  else{
			  return false;
		  }
	  }
}
