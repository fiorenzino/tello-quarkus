package group.weict.service.rs;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class CmdExecutionExceptionMapper implements ExceptionMapper<CmdExecutionException> {


    @Override
    public Response toResponse(CmdExecutionException e) {
        return Response.status(500).entity(e.getMessage()).build();
    }
}


