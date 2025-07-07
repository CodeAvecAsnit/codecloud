package com.codeavecasnit.passportmapper.passportcitizen.Controllers;

import com.codeavecasnit.passportmapper.passportcitizen.Entities.Citizen;
import com.codeavecasnit.passportmapper.passportcitizen.Service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen/api/")
public class CitizenController {
    private final CitizenService citizenService;

    @Autowired
    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Citizen citizen) {
        if(citizenService.save(citizen)){
            return ResponseEntity.ok("Citizen Saved");
        }else return ResponseEntity.badRequest().body("Citizen not Saved");
    }

    @GetMapping("/all/citizens")
    public List<Citizen> getAllCitizens() {
        return citizenService.findAll();
    }

    @GetMapping("/citizen/{id}")
    public Citizen getCitizenById(@PathVariable long id) {
        return citizenService.findById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") long id, @RequestBody Citizen citizen) {
        if(citizenService.update(id, citizen)){
            return ResponseEntity.ok("Citizen Updated");
        }else return ResponseEntity.badRequest().body("Unable to update citizen");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        if(citizenService.DeleteById(id)){
            return ResponseEntity.ok("Citizen Deleted");
        }else return ResponseEntity.badRequest().body("Unable to delete citizen");
    }
}
