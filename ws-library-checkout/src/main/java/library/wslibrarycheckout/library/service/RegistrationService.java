package library.wslibrarycheckout.library.service;

import library.wslibrarycheckout.library.dao.RegistrationRepository;
import library.wslibrarycheckout.library.entity.Book;
import library.wslibrarycheckout.library.entity.Registration;
import library.wslibrarycheckout.library.exceptionhandling.Response;
import library.wslibrarycheckout.library.model.LogInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class RegistrationService {


    @Autowired
    private RegistrationRepository registrationRepository;

    public ResponseEntity<Object> register(Registration registration) {

        Response<Book> resp;
        Set result = new HashSet();
        if(registrationRepository.save(registration) != null){
            result.add(registration);
            resp = new Response<>("User Registered ", true, new Date(), HttpStatus.CREATED, result);
        } else {
            resp = new Response<>("User could not be Registered ", true, new Date(), HttpStatus.CREATED, result);
        }
       return  new ResponseEntity(resp, resp.getHttpStatus());
    }

    public ResponseEntity<Object> login(LogInDTO logInDTO) {
        String userName = logInDTO.getUserName();
        String password = logInDTO.getPassword();
        Response<Object> resp = null;
        Set result = new HashSet();
        Registration registeredUserById = registrationRepository.getByUserName(logInDTO.getUserName());
        if(registeredUserById != null) {
            if(registeredUserById.getUserName().equals(userName) && registeredUserById.getPassword().equals(password)) {
                resp =new Response<>("Logged In ", true, new Date(), HttpStatus.CREATED, result);
            }
        } else {
             resp = new Response<>("Invalid UserName password", true, new Date(), HttpStatus.UNAUTHORIZED, result);

        }
        return new ResponseEntity(resp, resp.getHttpStatus());
    }
}
