package ar.edu.unahur.obj2.observer;

public class SubastadorInvalidoException extends RuntimeException {
  public SubastadorInvalidoException(String mensaje) {
    super(mensaje);
  }
  public SubastadorInvalidoException() {
    super("El subastador no participa en la subasta");
  }
}
