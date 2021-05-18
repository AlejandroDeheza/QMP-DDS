package ropa;

import java.util.List;
import java.util.stream.Collectors;

public class GeneradorSugerencias {

  private ServicioClima servicioClima;

  public GeneradorSugerencias(ServicioClima servicioClima) {
    this.servicioClima = servicioClima;
  }

  public Atuendo generarSugerenciaSegunClimaActual(String ciudad, List<Prenda> prendas) {
    Integer temperaturaActual = servicioClima.getTemperaturaCelciusActual(ciudad);
    List<Prenda> prendasAdecuadas = prendas.stream()
        .filter(prenda -> prenda.esAdecuadaPara(temperaturaActual))
        .collect(Collectors.toList());
    return generarAtuendo(prendasAdecuadas);
  }

  private Atuendo generarAtuendo(List<Prenda> prendas) {
    return new Atuendo(null, null, null, null); //TODO
  }
}
