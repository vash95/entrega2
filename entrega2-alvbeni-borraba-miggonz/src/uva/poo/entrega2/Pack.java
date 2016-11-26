package uva.poo.entrega2;

import java.util.ArrayList;
import java.util.Arrays;

//clase
public class Pack extends Vendible {

	private ArrayList<Producto> contenido;
	
	public Pack(String nombre , String identificador,Producto[] productos){
		super(nombre,identificador);
		contenido = new ArrayList<Producto>(Arrays.asList(productos));
		assert(getContenido().size()>=2);
		System.out.println(distintos());
		assert(distintos());
		
	}
	public boolean distintos(){
	for(int i=0;i<getContenido().size()-1;i++){
		for(int j=i+1;j<getContenido().size();j++){
			if(getContenido().get(i).equals(getContenido().get(j)))
				return false;
				}
			}
			return true;
	}
	public void añadir(Producto p){
		assert(!contiene(p));
		getContenido().add(p);
	}
	public void eliminar(Producto p){
		assert(getContenido().size()==2);
		assert(getContenido().contains(p));
		getContenido().remove(p);
	}
	public void añadirVarios(){
		
	}
	public void eliminarVarios(){
	}
	//añadir y eliminar una lista(opcional) 
	public int getCantidad(){
		return getContenido().size();
	}
	public boolean contiene(Producto p){
		assert(p.equals(null));
		return getContenido().contains(p);
	}
	public ArrayList<Producto> getContenido() {
		   return contenido;
	   }
	@Override
	public double getPrecio(){
		double precioPack=0;
		for(Producto e:contenido){
			precioPack+=e.getPrecio();
		}
		return precioPack-=precioPack*0.2;
	}
}
