package com.cassio.exception;

public class RecordNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(Long id) {
        super("Visor não encontrado com o id: " + id);
    }
    
}
