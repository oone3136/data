package org.tugas.services;
import org.tugas.exception.ValidationException;
import org.tugas.model.User;
import org.tugas.model.dto.LoginResponse;
import org.tugas.model.dto.loginRequest;
import org.tugas.util.FormatUtil;
import org.tugas.util.GeneralUtil;
import org.tugas.util.JwtUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@ApplicationScoped
public class Authservices {
    public Response login(loginRequest request) throws NoSuchAlgorithmException {

        if (FormatUtil.isPassword(request.password)){
            throw new ValidationException("INVALID_PASSWORD");
        }

        Optional<User> userOptional = User.findByLoginName(request.loginName);
        if (!User.isEmptyByLoginName(request.loginName)){
            throw new ValidationException("USER_NOT_FOUND");
        }
        User user = userOptional.get();
        if (!user.getPassword().equals(GeneralUtil.hashPassword(request.password))){
            throw  new ValidationException("WRONG_PASSWORD");
        }
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.userData = user;
        loginResponse.token = JwtUtil.generateToken(user);

        return Response.ok(loginResponse).build();
        
    }
}
