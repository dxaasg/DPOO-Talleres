package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
	public static final int COSTO_POR_KM_NATURAL = 600;
	public static final int COSTO_POR_KM_CORPORATIVO = 900;
	
	public static final double DESCUENTO_PQ= 0.02;
	public static final double DESCUENTO_MEDIANAS= 0.01;
	public static final double DESCUENTO_GRANDES= 0.2;
	@Override
    protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {

        int distancia = calcularDistanciaVuelo(vuelo.getRuta());

        if (cliente instanceof ClienteNatural) {
            return distancia * COSTO_POR_KM_NATURAL;
        } else {
            return distancia * COSTO_POR_KM_CORPORATIVO;
        }
    }

    @Override
    protected double calcularPorcentajeDescuento(Cliente cliente) {

        if (cliente instanceof ClienteCorporativo) {

            ClienteCorporativo corp = (ClienteCorporativo) cliente;

            if (corp.getTamanoEmpresa() == ClienteCorporativo.PEQUENA)
                return DESCUENTO_PQ;

            if (corp.getTamanoEmpresa() == ClienteCorporativo.MEDIANA)
                return DESCUENTO_MEDIANAS;

            if (corp.getTamanoEmpresa() == ClienteCorporativo.GRANDE)
                return DESCUENTO_GRANDES;
        }

        return 0;
    }
}
