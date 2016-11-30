package uva.poo.entrega2;
/**
 * Practica 2 de Programacion Orientada a Objetos
 * Implementacion de packs de productos y servicios realcionados con la modificacion de los mismos
 * Un pack contienen más de un producto
 * Los productos de un pack son distintos entre ellos
 * Un pack cuesta un 20% menos que la suma de los precios de sus productos individuales
 * Los packs heredan de la clase Vendible
 * @author alvbeni
 * @author miggonz
 * @author borraba
 */
public class Pack extends Vendible {
	//Atributo de la clase
	private Producto contenido[];
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
		contenido = productos;
		assert(getCantidad()>=2);	
		assert(distintos());
	}
	/**
	 * Comprueba que los productos de un pack son distintos
	 * Devuelve "true" si son distintos
	 * @return boolean
	 */
	public boolean distintos(){
	for(int i=0;i<getCantidad()-1;i++){
		for(int j=i+1;j<getCantidad();j++){
			if(getContenido()[i].equals(getContenido()[j]))
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
		Producto contenidoTmp[] = new Producto[getCantidad()+1];
		for(int i=0;i<getCantidad();i++){
			contenidoTmp[i]=getContenido()[i];
			}
		contenidoTmp[getCantidad()+1]=p;
		setContenido(contenidoTmp);
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
		Producto contenidoTmp[] = new Producto[getCantidad()-1];
		int j=0;
		for(int i=0;i<getCantidad();i++){
			if(!getContenido()[i].equals(p)){
				contenidoTmp[j]=getContenido()[i];
				j++;
			}
		}	
		setContenido(contenidoTmp);
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
	 * @return
	 */
	public int getCantidad(){
		return getContenido().length;
	}
	/**
	 * Informa de si el pack contiene o no el producto indicado
	 * Devuelve "true" si el pack contiene el producto
	 * @param p Producto buscado
	 * @return boolean
	 * @assert.pre p.equals(null) - El producto indicado no puede ser nulo
	 */
	public boolean contiene(Producto p){
		assert(p!=null);
		boolean contiene=false;
		for(int i=0;i<getCantidad();i++){
			if(getContenido()[i].equals(p)){
				contiene=true;
			}
		}
		return contiene;
	}
	/**
	 * Devuelve el pack
	 * @return contenido array de productos
	 */
	public Producto[] getContenido() {
		return contenido;
	}
	/**
	 * Cambia los productos que contiene el pack 
	 * @param contenido
	 */
	public void setContenido(Producto[] contenido) {
		this.contenido=contenido;
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
