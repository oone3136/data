package org.tugas.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.tugas.model.dto.LoginResponse;
import org.tugas.model.dto.loginRequest;
import org.tugas.services.Authservices;

import java.security.NoSuchAlgorithmException;

@Path("/api/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthController {
    @Inject
    Authservices authservices;
    @POST
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = loginRequest.class)))
    @APIResponses(
            @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON,schema = @Schema(implementation = LoginResponse.class)))
    )
    public Response login(loginRequest request) throws NoSuchAlgorithmException {
        return authservices.login(request);
    }
}
