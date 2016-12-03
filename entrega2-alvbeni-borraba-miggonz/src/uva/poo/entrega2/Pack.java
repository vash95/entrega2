package uva.poo.entrega2;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Practica 2 de Programacion Orientada a Objetos
 * Implementacion de packs de productos y servicios realcionados con la modificacion de los mismos
 * Un pack contienen por lo menos dos productos
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
	 * @param productos Producto[] con los Productos a meter en el pack
	 * @assert.pre getContenido().length>3 - El pack debe tener como minimo 2 productos
	 * @assert.pre distintos==true - Los productos deben de ser distintos
	 */
	public Pack(String nombre, Producto[] productos){
		super(nombre);
		contenido = new ArrayList<Producto>(Arrays.asList(productos));
		eliminarNulls();
		assert(getCantidad()>=2);	
		assert(distintos());
	}
	//comentalo migel la chup
	
	private void eliminarNulls(){
		int contadorNulls=0;
		for(Producto p:getContenido())
			if(p==null){
				contadorNulls++;
			}
		for(int i=0;i<contadorNulls;i++){
			getContenido().remove(null);
		}
	}
	/**
	 * Comprueba que los productos de un pack son distintos
	 * @return boolean true si no hay productos repetidos
	 */
	public boolean distintos(){
		for(int i=0;i<getCantidad()-1;i++){
			for(int j=i+1;j<getCantidad();j++){
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
		assert(p!=null);
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
		assert(contiene(p));
		assert(getCantidad()>2);
		getContenido().remove(p);
	}
	/**
	 * Agrega varios productos a un pack
	 * @param p array de productos a agregar al pack
	 */
	public void agregaVariosProductos(Producto p[]){
		assert(p!=null);
		for(Producto e:p){
			if(e!=null){
			agregaProducto(e);
			}
		}	
	}
	//******************************************************TEST****
	/**
	 * Quita varios productos de un pack
	 * @param p array de productos a quitar del pack
	 */
	public void quitaVariosProductos(Producto p[]){
		for(Producto e:p){
			quitaProducto(e);
		}
	}
	/**
	 * Devuelve la cantidad de productos que tiene un pack
	 * @return getContenido().size() int con la cantidad de productos
	 */
	public int getCantidad(){
		return getContenido().size();
	}
	/**
	 * Devuelve el pack
	 * @return contenido arrayList de productos
	 */
	public ArrayList<Producto> getContenido() {
		return contenido;
	}
	/**
	* Informa de si el pack contiene o no el producto indicado
	* Devuelve "true" si el pack contiene el producto
	* @param pedido Producto pedido
	* @return boolean
	* @assert.pre p.equals(null)==false - El producto indicado no puede ser nulo
	*/
	public boolean contiene(Producto pedido){
		assert(pedido!=null);
		return getContenido().contains(pedido);
	}
	/**
	 * Devuelve el precio del pack/w
	 */
	@Override
	public double getPrecio() {
		double precioPack=0;
		for(Producto e:getContenido()){
			precioPack+=e.getPrecio();
		}
		precioPack-=precioPack*0.2;
		precioPack=precioPack*100;
		precioPack=Math.round(precioPack);
		precioPack=precioPack/100;
		return precioPack;
	}

	@Override
	public String getIdentificador(){
		String id;
		int identificadorTmp=0;
		for(Producto p:getContenido()){
			int identificadorTmp2= Integer.parseInt(p.getIdentificador().substring(0, 9));
			identificadorTmp+=identificadorTmp2;
		}
		identificadorTmp=identificadorTmp%1000000;
		id=String.valueOf(identificadorTmp)+((char)((identificadorTmp%25)+65));
		return id;
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
		  if(getNombre().equals(otro.getNombre()) && getPrecio()==otro.getPrecio() && getIdentificador().equals(otro.getIdentificador()) && getCantidad()==otro.getCantidad() && sonIgualesArrays(otro) ){
			  return true;
			  
		  }else{
			  return false;
		  }
	}
}