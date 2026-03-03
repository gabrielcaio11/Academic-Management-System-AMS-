package br.com.gabrielcaio.ams.presentation.controllers.error;

public class BusinessException extends RuntimeException {

  public BusinessException(String message) {
    super(message);
  }
}
