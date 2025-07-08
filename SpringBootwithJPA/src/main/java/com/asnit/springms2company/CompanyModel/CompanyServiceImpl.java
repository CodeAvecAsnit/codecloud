package com.asnit.springms2company.CompanyModel;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository=companyRepository;
    }


    @Override
    @Transactional
    public boolean save(Company company) {
        try{
            companyRepository.save(company);
            return true;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        try{
            companyRepository.deleteById(id);
            return true;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    @Transactional
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    @Transactional
    public boolean updateCompany(Long id, Company company){
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isPresent()) {
           Company prevCompany = optionalCompany.get();
           prevCompany.setName(company.getName());
           prevCompany.setDescription(company.getDescription());
           companyRepository.save(prevCompany);
           return true;
        }else return false;
        }
}
