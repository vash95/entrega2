package uva.poo.entrega2;


/**
 * Implementación de productos que tienen nombre, precio y UCP.
 * Práctica 1 de POO
 * @author alvbeni
 * @author miggonz
 * @author borraba
 *
 */
public class Producto extends Vendible{

	
  /**
   * Inicializa una instancia de la clase Producto con los valores dados como argumento
   * El dígito de control se autentifica automáticamente
   * @param nombre String con el nombre
   * @param precio double que indica el precio de un producto en euros
   * @param upc String con los dígitos 12 del UPC, incluyendo el de control
   * @assert.pre nombre!=null - El nombre no puede ser nulo
   * @assert.pre nombre!="" - El nombre no puede ser una cadena vacía
   * @assert.pre precio>0 - El precio debe ser estrictamente positivo
   * @assert.pre upc!=null - El UPC no puede ser nulo
   * @assert.pre upc.length()==12 - El UPC debe tener 12 dígitos
     * @assert.pre UPCValido(upc) - EL UPC debe ser un número
   */
  public Producto(String nombre, double precio, String upc){
	super(nombre,precio,upc);
    assert (nombre!=null);
    assert (!nombre.trim().equals(""));
    assert (precio>0);
    assert (upc!=null);
    assert (upc.length()==12):"upc no valido";
    assert (DigitoDeControl(upc));
  }
  //comentarlo
  public boolean DigitoDeControl(String upc){
    //Método que cambia el valor de UPC para añadir el dígito de control 
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
    //Comprueba si un String que contiene el UPC es solo números
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
   * @param precio double con el nuevo precio en euros
   * @assert.pre precio>0 - El precio debe ser estrictamente positivo
   */
  @Override
  public void setPrecio(double precio) {
          assert (precio>0);
          super.setPrecio(precio);
  }
    /**
     * Devuelve el upc del producto
     * @return upc String con el upc
     */
  public String getUpc() {
           return super.getIdentificador();
  }
  /**
  * Cambia el upc del producto
  * @param upc String con el nuevo upc
  * @assert.pre upc!=null - El UPC no puede ser nulo
  * @assert.pre upc.length()==12 - El UPC debe tener 12 dígitos
  * @assert.pre UPCValido(upc) - EL UPC debe ser un número
  */
  public void setUpc(String upc) {
    assert (upc!=null);
    assert (upc.length()==12);
    assert (UPCValido(upc));
    assert(DigitoDeControl(upc));
    super.setIdentificador(upc);
  }
  /**
   * Devuelve un String con la información del producto
   */
  @Override
  public String toString(){
	  return "Nombre del producto: "+getNombre()+", precio: "+getPrecio()+" euros, UPC: "+getUpc();
  }
  /**
   * Indica si dos productos son iguales o no
   * @param otro Producto para comparar
   * @return boolean true si son los dos productos iguales
   */
  public boolean equals(Producto otro){
    if(getNombre()==otro.getNombre() && getPrecio()==otro.getPrecio() && getUpc()==otro.getUpc()){
      return true;
    }
    else
    return false;
  }
}
