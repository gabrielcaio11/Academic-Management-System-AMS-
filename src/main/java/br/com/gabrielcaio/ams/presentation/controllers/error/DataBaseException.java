package br.com.gabrielcaio.ams.presentation.controllers.error;

public class DataBaseException extends RuntimeException {

  public DataBaseException(String message) {
    super(message);
  }
}
