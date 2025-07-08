package com.asnit.springms2company.CompanyModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    CompanyServiceImpl companyServiceImpl;


    @Autowired
    public CompanyController(CompanyServiceImpl companyServiceImpl){
        this.companyServiceImpl = companyServiceImpl;
    }


    @GetMapping("/ml")
    public String MachineLearning(){
        return "Machine learning is interesting";
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveCompany(@RequestBody Company company){
        if(companyServiceImpl.save(company)){
            return ResponseEntity.ok("Successfully Inserted");
        }else return ResponseEntity.badRequest().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Company> getById(@PathVariable Long id){
        Company company = companyServiceImpl.getCompanyById(id);
        if(company!=null){
            return ResponseEntity.ok(company);
        }else return ResponseEntity.badRequest().build();
    }

    @GetMapping("/find/all")
    public List<Company> findAll(){
        return companyServiceImpl.getAll();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company company){
        if(companyServiceImpl.updateCompany(id, company)){
            return ResponseEntity.ok("Successfully updated");
        }else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id ){
        if(companyServiceImpl.deleteById(id)){
            return ResponseEntity.ok("Successfully deleted");
        }else return ResponseEntity.notFound().build();

    }
}
