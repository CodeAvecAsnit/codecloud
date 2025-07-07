package com.codeavecasnit.passportmapper.passportcitizen.ServiceImp;

import com.codeavecasnit.passportmapper.passportcitizen.Entities.Citizen;
import com.codeavecasnit.passportmapper.passportcitizen.Entities.Passport;
import com.codeavecasnit.passportmapper.passportcitizen.Repositories.CitizenRepository;
import com.codeavecasnit.passportmapper.passportcitizen.Repositories.PassportRepository;
import com.codeavecasnit.passportmapper.passportcitizen.Service.PassportService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;
    private final EntityManager entityManager;
    private final CitizenRepository citizenRepository;

    @Autowired
    public PassportServiceImpl(PassportRepository passportRepository,EntityManager entityManager,
                               CitizenRepository citizenRepository) {
        this.passportRepository = passportRepository;
        this.entityManager = entityManager;
        this.citizenRepository = citizenRepository;
    }

    @Override
    @Transactional
    public boolean save(Passport passport) {
        try {
            Optional<Citizen> optionalCitizen = citizenRepository.findById(passport.getCitizen().getcitizenshipNo());

            if (optionalCitizen.isPresent()) {
                passport.setCitizen(optionalCitizen.get());
                entityManager.merge(passport);
            } else {
                passportRepository.save(passport);
            }
            return true;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
    }

    @Override
    @Transactional
    public Passport findById(Long id) {
        return passportRepository.findById(id).orElse(null);
    }

    @Override
    public List<Passport> findAll() {
        return passportRepository.findAll();
    }


    @Override
    public boolean delete(Long id) {
        try{
            passportRepository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Passport passport, Long id) {
        Optional<Passport> optionalPassport = passportRepository.findById(id);
        if (optionalPassport.isPresent()) {
            Passport toUpdate = optionalPassport.get();
            toUpdate.setCitizen(passport.getCitizen());
            toUpdate.setIssueDate(passport.getIssueDate());
            toUpdate.setIssueDate(passport.getIssueDate());
            return toUpdate.equals(passport);
        }else return false;
    }
}

