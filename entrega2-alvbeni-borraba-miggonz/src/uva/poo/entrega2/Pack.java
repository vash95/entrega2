package uva.poo.entrega2;

import java.util.ArrayList;
import java.util.Arrays;

//clase
public class Pack extends Vendible {

	private Producto contenido[];
	
	public Pack(String nombre, String identificador, Producto[] productos){
		super(nombre,identificador);
		contenido = productos;
		assert(getContenido().length>=2);
		assert(distintos());
		setPrecio();
		
	}
	public boolean distintos(){
	for(int i=0;i<getContenido().length-1;i++){
		for(int j=i+1;j<getContenido().length;j++){
			if(getContenido()[i].equals(getContenido()[j]))
				return false;
				}
			}
			return true;
	}
	/*public void añadir(Producto p){
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
	public void añadirVarios(){
		
	}
	public void eliminarVarios(){
	}
	//añadir y eliminar una lista(opcional) 
	public int getCantidad(){
		return getContenido().length;
	}
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
