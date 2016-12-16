package uva.poo.entrega2;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Práctica 2 de Programación Orientada a Objetos
 * Implementacion de packs de productos y servicios realcionados con la modificación de los mismos
 * Un pack contienen como mínimo dos productos
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
	 * Inicialización de un pack de productos
	 * @param nombre String con el nombre
	 * @param productos array con los Productos a meter en el pack
	 * @assert.pre (@code getCantidad()>=2) - El pack debe tener como minimo 2 productos
	 * @assert.pre distintos==true - Los productos deben de ser distintos
	 * @see uva.poo.entrega2.Vendible#Vendible(String)
	 */
	public Pack(String nombre, Producto[] productos){
		super(nombre);
		contenido = new ArrayList<Producto>(Arrays.asList(productos));
		eliminarNulls();
		assert(getCantidad()>=2);	
		assert(distintos());
	}
	private void eliminarNulls(){
		int contadorNulls=0;
		//cuenta el numero de null
		for(Producto p:getContenido())
			if(p==null){
				contadorNulls++;
			}
		//borra los null que haya
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
	 * @assert.pre (@code getCantidad()>2) - El pack no puede quedarse con menos de dos productos
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
	 * @assert.pre p!=null - El array de productos producto a agregar no puede ser nulo
	 */
	public void agregaVariosProductos(Producto p[]){
		assert(p!=null);
		for(Producto e:p){
			if(e!=null){
			agregaProducto(e);
			}
		}	
	}
	/**
	 * Quita varios productos de un pack
	 * @param p array de productos a quitar del pack
	 * @assert.pre p!=null - El array de productos producto a quitar no puede ser nulo
	 */
	public void quitaVariosProductos(Producto p[]){
		assert(p!=null);
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
	* @assert.pre pedido!=null - El producto a quitar no puede ser nulo
	*/
	public boolean contiene(Producto pedido){
		assert(pedido!=null);
		return getContenido().contains(pedido);
	}
	/**
	 * Devuelve el precio en euros del pack
	 * @return precioPack double con el precio
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
	/**
	 * Devuelve el identificador del pack
	 * Cada pack tiene un identificador exclusivo
	 * Si se añade un producto a un pack, cambia su identificador
	 * @return id, String con el identificador
	 */
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
	 * Devuelve datos sobre el pack
	 * @return info String con los datos del pack
	 */
	@Override
	public String toString(){
		String contenedor="";
		String info="";
		for(Producto e:getContenido())
			contenedor+=" "+e.toString();
		info="Nombre del Pack: "+getNombre()+", precio: "+getPrecio()+" euros, ID: "+getIdentificador()+" Contenido: (" +contenedor+")";
		return info;
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
	 * Dos packs se consideran iguales si tienen el mismo nombre, precio e identificador, por lo que deben contener también productos que sean iguales
	 * @param otro otro Pack para comparar
	 * @return resultado true si los packs son iguales
	 */
	@Override
	public boolean equals(Object otro){
	    boolean resultado=false;
	    if(otro instanceof Pack){
	      Pack a=(Pack) otro;
	      if(getNombre().equals(a.getNombre()) && getPrecio()==a.getPrecio() && getIdentificador().equals(a.getIdentificador()) && getCantidad()==a.getCantidad() && sonIgualesArrays(a) ){
	    	  resultado = true;
	      }
	    }
	    return resultado;
	  }
}