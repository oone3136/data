package org.tugas.controller;

import com.oracle.svm.core.annotate.Inject;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.tugas.model.dto.UserRequest;
import org.tugas.services.UserServices;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;

@Path("api/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserServices userServices;

    @POST
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema (implementation = UserRequest.class)))
    @APIResponses({
            @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, example = "{}"))
    })
    public Response post(UserRequest request) throws NoSuchAlgorithmException {
        return userServices.post(request);
    }
//
//    public Response get(){
//
//    }
//
//    public Response put(){
//
//    }
//
//    public Response delete(){
//
//    }
//

}
