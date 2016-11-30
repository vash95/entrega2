package uva.poo.entrega2;


/**
 * Pr�ctica 2 de Programaci�n Orientada a Objetos
 * Implementaci�n de packs de productos
 * Los productos de un pack son distintos entre s�
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
	 * Inicializaci�n de un pack de productos con nombre, precio
	 * @param nombre String con el nombre
	 * @param precio double precio (no se tiene en cuenta)
	 * @param identificador String con el identificador
	 * @param productos array con los Productos a meter en el pack
	 * @assert.pre getContenido().length>2 - El pack debe tener como m�nimo 2 productos
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
	public void addProducto(Producto p){
		assert(p!=null);
		assert(!contiene(p));
		Producto contenidoTmp[] = new Producto[getCantidad()+1];
		for(int i=0;i<getCantidad();i++){
			contenidoTmp[i]=getContenido()[i];
			}
		contenidoTmp[getCantidad()+1]=p;
		setContenido(contenidoTmp);
	}
	public void removeProducto(Producto p){
		assert(p!=null);
		assert(getCantidad()>2);
		assert(contiene(p));
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
	
	public void addProductos(Producto p[]){
		for(Producto e:p){
			addProducto(e);
		}	
	}
	public void removeProductos(Producto p[]){
		for(Producto e:p){
			removeProducto(e);
		}
	}
	//añadir y eliminar una lista(opcional)
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
	public void setContenido(Producto[] contenido) {
		this.contenido=contenido;
	}
	//getprecio
	public double getPrecio() {
		double precioPack=0;
		for(Producto e:getContenido()){
			precioPack+=e.getPrecio();
		}
		precioPack-=precioPack*0.2;
		return precioPack;
	}
	
	public String toString(){
		String contenedor="";
		for(Producto e:getContenido())
			contenedor+=" "+e.toString();
		return  "Nombre del Pack: "+getNombre()+", precio: "+getPrecio()+" euros, ID: "+getIdentificador()+" Contenido: (" +contenedor+")";
	}
	private boolean sonIgualesArrays(Pack otro){
		int contador=0;
		if(getCantidad()==otro.getCantidad()){
			for(Producto e:otro.getContenido()){
				if(contiene(e)){
					contador++;
				}
			}
			if(contador==getCantidad()){
				return true;
			}
		}		
		return false;
	}
	
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
