package uniandes.dpoo.aerolinea.modelo.cliente;


public class ClienteNatural extends Cliente {
	public static final String NATURAL = "Natural";
	private String nombre;
	
	
	public ClienteNatural(String nombre) {
		// TODO Auto-generated constructor stub 
    	super();
    	this.nombre = nombre;
        
	}
	 public String getTipoCliente() {
	    	
			return NATURAL;
			
		}
	    
	    public String getIdentificador() {
	    	
			return nombre;
			
		}
		
	    
	
	

}
