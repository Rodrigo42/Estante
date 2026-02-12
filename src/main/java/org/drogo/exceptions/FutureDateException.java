package org.drogo.exceptions;

public class FutureDateException extends RuntimeException{
   public FutureDateException(String mensagem){
       super(mensagem);
   }
}
