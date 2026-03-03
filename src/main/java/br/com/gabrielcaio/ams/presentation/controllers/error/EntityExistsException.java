package br.com.gabrielcaio.ams.presentation.controllers.error;

public class EntityExistsException extends RuntimeException {

  public EntityExistsException(String message) {
    super(message);
  }
}
