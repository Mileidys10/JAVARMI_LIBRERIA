package net;

import calculo.modelo.CalculoCosto;

public class CalculoRmiCombustibleImplem implements IRemotaCalculoCosto {

    public CalculoRmiCombustibleImplem() {
    }

    @Override
    public CalculoCosto.Costo calcularCosto(CalculoCosto calculo) {
        if (calculo == null) {
            return null;
        }

        System.out.println("Distancia: " + calculo.getDistancia());
        System.out.println("Rendimiento: " + calculo.getRendimiento());
        System.out.println("Precio Combustible: " + calculo.getPrecioCombustible());

        CalculoCosto.Costo costo = calculo.getCosto();

        System.out.println("Litros necesarios: " + costo.litrosNecesarios);
        System.out.println("Costo: " + costo.resultado);
        System.out.println("Mensaje: " + costo.mensaje);

        return costo;
    }
}
