package dominio.usuario;

import dominio.ropa.Atuendo;

import java.util.List;

public class Usuario {
  private List<Guardarropa> guardarropas;
  private List<PropuestaGuardarropa> propuestasPendientes;
  private List<PropuestaGuardarropa> propuestasAceptadas;
  private List<Atuendo> sugerencias;
  private NotificationService servicioDeNotificacion;
  private MailSender mailSender;
  private String email;

  public Usuario(List<Guardarropa> guardarropas, List<PropuestaGuardarropa> propuestasPendientes,
                 List<PropuestaGuardarropa> propuestasAceptadas, List<Atuendo> sugerencias,
                 NotificationService servicioDeNotificacion, MailSender mailSender, String email) {
    this.guardarropas = guardarropas;
    this.propuestasPendientes = propuestasPendientes;
    this.propuestasAceptadas = propuestasAceptadas;
    this.sugerencias = sugerencias;
    this.servicioDeNotificacion = servicioDeNotificacion;
    this.mailSender = mailSender;
    this.email = email;
  }

  public void agregarSugerencia(Atuendo sugerencia) {
    sugerencias.add(sugerencia);  // de qmp anteriores
  }

  public void agregarGuardarropa(Guardarropa guardarropa) {
    this.guardarropas.add(guardarropa);
  }

  public void removerGuardarropa(Guardarropa guardarropa) {
    this.guardarropas.remove(guardarropa);
  }

  public void agregarPropuesta(PropuestaGuardarropa propuesta) {
    propuestasPendientes.add(propuesta);
  }

  public void rechazarPropuesta(PropuestaGuardarropa propuesta) {
    propuestasPendientes.remove(propuesta);
  } // no valido que la "propuesta" este en "propuestas" -> confiar en el adentro
  // la "propuesta" seguramente se obtenga de un listado (en la UI) generado a partir de esta misma lista "propuestas"

  public void aceptarPropuesta(PropuestaGuardarropa propuesta) {
    propuesta.aplicar();
    this.propuestasPendientes.remove(propuesta);
    this.propuestasAceptadas.add(propuesta);
  }

  public void deshacerPropuesta(PropuestaGuardarropa propuesta) {
    propuesta.deshacer();
    this.propuestasAceptadas.remove(propuesta);
    this.propuestasPendientes.add(propuesta);
  }

  public void notificar(String text) {
    this.servicioDeNotificacion.notify(text);
  }

  public void enviarMail(String texto) {
    this.mailSender.send(this.email, texto);
  }

  // GETTERS

  public List<Guardarropa> getGuardarropas() {
    return this.guardarropas;
  }

  public List<PropuestaGuardarropa> getPropuestasPendientes() {
    return propuestasPendientes;
  }

  public List<PropuestaGuardarropa> getPropuestasAceptadas() {
    return propuestasAceptadas;
  }

}
