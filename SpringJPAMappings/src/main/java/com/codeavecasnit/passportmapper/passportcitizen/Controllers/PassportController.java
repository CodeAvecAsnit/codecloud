package com.codeavecasnit.passportmapper.passportcitizen.Controllers;

import com.codeavecasnit.passportmapper.passportcitizen.Entities.Passport;
import com.codeavecasnit.passportmapper.passportcitizen.Service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passport")
public class PassportController {

    private final PassportService passportService;
    @Autowired
    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Passport passport) {
        if(passportService.save(passport)) {
            return ResponseEntity.ok("Passport saved");
        }else return ResponseEntity.badRequest().body("Something went wrong");
    }

    @GetMapping("/all")
    public List<Passport> findAll() {
        return passportService.findAll();
    }

    @GetMapping("/passport/{id}")
    public ResponseEntity<Passport> findById(@PathVariable long id) {
        try{
            Passport passport = passportService.findById(id);
            return ResponseEntity.ok(passport);
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Passport passport,@PathVariable long id) {
       if(passportService.update(passport,id)) {
           return ResponseEntity.ok("Passport updated");
       }else return ResponseEntity.badRequest().body("We could not update the requested data");

    }
}
