package br.com.gabrielcaio.ams.presentation.controllers.error;

public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(String message) {
    super(message);
  }
}
