package uva.poo.entrega2;
/**
 * Pr�ctica 2 de Programaci�n Orientada a Objetos
 * Implementaci�n de productos con nombre, precio y UCP.
 * Los productos heredan de la la clase Vendible
 * @author alvbeni
 * @author miggonz
 * @author borraba
 */
public class Producto extends Vendible{
	private String upc;
	private double precio;
	/**
	 * Inicializa una instancia de la clase Producto con los valores dados como argumento
	 * El d�gito de control se autentifica autom�ticamente
	 * @param nombre String con el nombre
	 * @param precio double que indica el precio de un producto en euros
	 * @param upc String con los d�gitos 12 del UPC, incluyendo el de control
	 * @assert.pre precio>0 - El precio debe ser estrictamente positivo
	 * @assert.pre upc!=null - El UPC no puede ser nulo
	 * @assert.pre upc.length()==12 - El UPC debe tener 12 d�gitos
	 * @assert.pre DigitoDeControlValido(upc) - EL UPC debe ser un n�mero y el �ltimo digito
	 */
	  public Producto(String nombre, double precio, String upc){
		  super(nombre);
		  this.precio=precio;
		  this.upc=upc;
		  assert (precio>0);
		  assert (upc!=null);
		  assert (upc.length()==12):"upc no valido";
		  assert (DigitoDeControlValido(upc));
	  }
	  /**
	   * Comprueba que el d�gito de control del UPC es v�lido dados sus anteriores caracteres
	   * Devuelve "true" si es correcto
	   * @param upc String del UPC del producto
	   * @return boolean
	   */
	  public boolean DigitoDeControlValido(String upc){
		  if(UPCValido(upc)){
			  int s=0,a,m;
			  String r;
			    for(int i =0;i<11;i++){
			      a=((int)upc.charAt(i))-48;
			      if(i%2==0){
			        s+=a*3;
			      }else{
			        s+=a;
			      }
			    }
			    m=10-(s%10);  
			    r=String.valueOf(m%10);
			    if(r.equals(Character.toString(upc.charAt(11)))){
			    	return true;
			      }
			    	return false;
				}
				return false;
			  }
	  private static boolean UPCValido(String cad){
		//Comprueba si un String que contiene el UPC es solo numeros
		    boolean valido=true;
		    for (int i=0; i<cad.length(); i++){
		      //Comprueba que el digito sea un numero
		      if((int)cad.charAt(i)<48 || (int)cad.charAt(i)>57){
		        valido=false;
		      }
		    }return valido;
	  }
	  /**
	   * Cambia el precio del producto
	   * @param precio double con el nuevo precio 
	   */
	  public void setPrecio(double precio) {
		  this.precio = precio;
	  }
	  /**
	   * Devuelve el precio del producto
	   */
	  @Override
	  public double getPrecio() {
			return precio;
		}
	  /**
	   * Cambia el UPC del producto
	   * @param upc String con el nuevo upc
	   * @assert.pre upc!=null - El UPC no puede ser nulo
	   * @assert.pre upc.length()==12 - El UPC debe tener 12 d�gitos
	   * @assert.pre DigitoDeControlValido(upc) - EL UPC debe ser un n�mero y el ultimo digito 
	   */
	  public void setIdentificador(String upc){
		  assert (upc!=null);
		  assert (upc.length()==12);
		  assert(DigitoDeControlValido(upc));
		  this.upc=upc;
	  }
	  /**
	   * Devuelve el identificador del producto, es decir, su UPC
	   */
	  @Override
	  public String getIdentificador(){
		  return upc;
	  }
	  /**
	   * Devuelve un String con la informaci�n del producto
	   */
	  @Override
	  public String toString(){
		  return "Nombre del producto: "+getNombre()+", precio: "+getPrecio()+" euros, UPC: "+getIdentificador();
	  }
	  /**
	   * Indica si el producto es igual a otro dado como argumento
	   * Devuelve "true" si son iguales
	   * @param otro Producto para comparar
	   * @return boolean
	   */
	  public boolean equals(Producto otro){
		  if(getNombre()==otro.getNombre() && getPrecio()==otro.getPrecio() && getIdentificador()==otro.getIdentificador()){
			  return true;
			  }
		  else{
			  return false;
		  }
	  }
}