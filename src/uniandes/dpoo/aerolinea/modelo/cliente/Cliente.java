package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {

   
    protected List<Tiquete> tiquetesSinUsar;
    protected List<Tiquete> tiquetesUsados;

    public Cliente() {
    	tiquetesSinUsar = new ArrayList<>();
        tiquetesUsados = new ArrayList<>();
    }

    public abstract String getTipoCliente();
    
    public abstract String getIdentificador();

    
    public void agregarTiquete(Tiquete tiquete) {
        tiquetesSinUsar.add(tiquete);
    }

    public void usarTiquetes(Vuelo vuelo) {
        for (Tiquete t : tiquetesSinUsar) {
            if (t.getVuelo().equals(vuelo)) {
                t.marcarComoUsado();
                tiquetesUsados.add(t);
            }
        }
        tiquetesSinUsar.removeAll(tiquetesUsados); 
    }

    
    public int calcularValorTotalTiquetes() {
    	int total = 0;

        for (Tiquete t : tiquetesSinUsar) {
            total += t.getTarifa();
        }

        for (Tiquete t : tiquetesUsados) {
            total += t.getTarifa();
        }

        return total;
    }

    public int calcularSaldoPendiente() {
        int total = 0;

        for (Tiquete t : tiquetesSinUsar) {
            total += t.getTarifa();
        }

        return total;
    }
}

