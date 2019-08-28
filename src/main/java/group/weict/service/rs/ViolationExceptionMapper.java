package group.weict.service.rs;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {


    @Override
    public Response toResponse(ConstraintViolationException e) {
        return Response.status(500).entity(e.getMessage()).build();
    }
}
