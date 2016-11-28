package uva.poo.entrega2;
/**
 * Pr·ctica 2 de ProgramaciÛn Orientada a Objetos
 * ImplementaciÛn de packs de productos
 * Los productos de un pack son distintos entre sÌ
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
	 * InicializaciÛn de un pack de productos con nombre, precio
	 * @param nombre String con el nombre
	 * @param precio double precio (no se tiene en cuenta)
	 * @param identificador String con el identificador
	 * @param productos array con los Productos a meter en el pack
	 * @assert.pre getContenido().length>2 - El pack debe tener como mÌnimo 2 productos
	 * @assert.pre distintos==true - Los productos deben de ser distintos
	 */
	public Pack(String nombre, double precio, String identificador, Producto[] productos){
		super(nombre, precio, identificador);
		contenido = productos;
		assert(getContenido().length>=2);
		assert(distintos());
		setPrecio();
		
	}
	/**
	 * Comprueba que los productos de un pack son distintos
	 * Devuelve "true" si son distintos
	 * @return boolean
	 */
	public boolean distintos(){
	for(int i=0;i<getContenido().length-1;i++){
		for(int j=i+1;j<getContenido().length;j++){
			if(getContenido()[i].equals(getContenido()[j]))
				return false;
				}
			}
			return true;
	}
	/*public void a√±adir(Producto p){
		assert(!contiene(p));
		getContenido().add(p);
		setPrecio();
	}
	public void eliminar(Producto p){
		assert(getContenido().size()>2);
		assert(getContenido().contains(p));
		getContenido().remove(p);
		setPrecio();
	}
	public void a√±adirVarios(){
		
	}
	public void eliminarVarios(){
	}
	//a√±adir y eliminar una lista(opcional) 
	public int getCantidad(){
		return getContenido().length;
	}
	*/
	/**
	 * Informa de si el pack contiene o no el producto indicado
	 * Devuelve "true" si el pack contiene el producto
	 * @param p Producto buscado
	 * @return boolean
	 * @assert.pre p.equals(null) - El producto indicado no puede ser nulo
	 */
	public boolean contiene(Producto p){
		assert(p.equals(null));
		boolean contiene=false;
		for(int i=0;i<getContenido().length;i++){
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
	private void setPrecio() {
		double precioPack=0;
		for(Producto e:contenido){
			precioPack+=e.getPrecio();
		}
		setPrecio(precioPack-=precioPack*0.2);
	}
}
