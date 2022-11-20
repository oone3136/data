package org.tugas.services;

import io.quarkus.narayana.jta.runtime.TransactionConfiguration;
import io.vertx.ext.auth.impl.hash.SHA256;
import org.tugas.exception.ValidationException;
import org.tugas.model.User;
import org.tugas.model.dto.UserRequest;
import org.tugas.util.FormatUtil;
import org.tugas.util.GeneralUtil;

import javax.enterprise.context.ApplicationScoped;

import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Optional;

@ApplicationScoped
public class UserServices {
    public Response post(UserRequest request) throws NoSuchAlgorithmException {
        if (!User.isEmptyByLoginName(request.loginName)){
            throw new ValidationException("LOGIN_NAME_EXISTS");
        }
        if (FormatUtil.isPassword(request.password)){
            throw new ValidationException("INVALID_PASSWORD");
        }
        if (!FormatUtil.isEmail(request.email) || !FormatUtil.isAlfabet(request.fullname)
        || !FormatUtil.isPhoneNuber(request.mobilePhoneNumber) || !FormatUtil.isPhoneNuber(request.workPhoneNumber)){
            throw new ValidationException("BAD_REQUEST");

        }

        persistUser(request);

        return Response.ok(new HashMap<>()).build();

    }
    @Transactional
    @TransactionConfiguration(timeout = 30)
    public User persistUser(UserRequest request) throws NoSuchAlgorithmException {
        Optional<User> userOptional = User.findByLoginName(request.loginName);
        User user;
        if(userOptional.isEmpty()){
            user =new User();
        }else {
            user = userOptional.get();
        }

        user.setLoginName(request.loginName);
        user.setPassword(GeneralUtil.hashPassword(request.password));
        user.setAdress(request.addres);
        user.setFullName(request.fullname);
        user.setEmail(request.email);
        user.setMobilePhoneNumber(request.mobilePhoneNumber);
        user.setWorkPhoneNumber(request.workPhoneNumber);
        User.persist(user);

        return user;
    }

}
