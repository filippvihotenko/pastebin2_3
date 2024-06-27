package by.viho.pastebin2_3.businessLogicModule.controller.adviceController;


import by.viho.pastebin2_3.pasteSendingModule.domain.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.BindException;

@ControllerAdvice
public class DefaultAdvice {
    @ExceptionHandler(BindException.class)
    public ResponseEntity<Response> bindException(BindException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
