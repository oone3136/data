package org.tugas.exception.handler;

import org.tugas.exception.ValidationException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.HashMap;
import java.util.Map;

public class ValidationExceptionHendler implements ExceptionMapper<ValidationException>{
    @Override
    public Response toResponse(ValidationException e) {
        Map<String, Object>  result = new HashMap<>();
        result.put("message", e.getMessage());
        return  Response.status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON)
                .entity(result)
                .build();
    }
}
