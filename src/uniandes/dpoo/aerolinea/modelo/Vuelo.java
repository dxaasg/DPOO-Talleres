package uniandes.dpoo.aerolinea.modelo;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Vuelo {
	
	
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private Map<String, Tiquete> tiquetes;

	
	public Vuelo(Ruta ruta,String fecha,Avion avion) {
		super();
		this.fecha = fecha;
        this.ruta = ruta;
        this.avion = avion;
        tiquetes = new HashMap<>();
        
		// TODO Auto-generated constructor stub
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	
	public void agregarTiquete(Tiquete tiquete) {
	    tiquetes.put(tiquete.getCodigo(), tiquete);
	}
	
	public Tiquete getTiquete(String codigo) {
	    return tiquetes.get(codigo);
	}
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {

	    int disponibles = avion.getCapacidad() - tiquetes.size();

	    if (cantidad > disponibles) {
	        cantidad = disponibles; // vender solo los que se puedan
	    }

	    int totalCobrado = 0;

	    for (int i = 0; i < cantidad; i++) {

	        // calcular tarifa usando la calculadora
	        int tarifa = calculadora.calcularTarifa(this, cliente);

	        // crear código único simple
	        String codigo = ruta.getCodigoRuta() + "-" + fecha + "-" + (tiquetes.size() + 1);

	        Tiquete tiquete = new Tiquete(codigo, this, cliente, tarifa);

	        // guardar en el vuelo
	        tiquetes.put(codigo, tiquete);

	        // agregar al cliente
	        cliente.agregarTiquete(tiquete);

	        totalCobrado += tarifa;
	    }

	    return totalCobrado;
	}
	@Override
	public boolean equals(Object obj) {

	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
 
	    Vuelo otro = (Vuelo) obj;

	    return fecha.equals(otro.fecha)
	            && ruta.getCodigoRuta().equals(otro.ruta.getCodigoRuta());
	}
	@Override
	public int hashCode() {
	    return fecha.hashCode() + ruta.getCodigoRuta().hashCode();
	}
	
	public Collection<Tiquete> getTiquetes() {
	    return tiquetes.values();
	}
		
	
	
}
