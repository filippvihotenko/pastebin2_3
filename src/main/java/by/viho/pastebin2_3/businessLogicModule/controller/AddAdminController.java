/*
package by.viho.pastebin2_3.businessLogicModule.controller;

import by.viho.pastebin2_3.businessLogicModule.service.UserRegistrationService;
import by.viho.pastebin2_3.dataAccessModule.repository.PersonRepo;
import by.viho.pastebin2_3.pasteSendingModule.domain.Person;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/add")
public class AddAdminController
{
    private UserRegistrationService userRegistrationService;

    @Autowired
    public AddAdminController(UserRegistrationService userRegistrationService)
    {
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addAdmin(@RequestBody Person person){
        userRegistrationService.register(person);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
*/
