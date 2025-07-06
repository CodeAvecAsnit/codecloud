package com.codeavecasnit.passportmapper.passportcitizen.ServiceImp;

import com.codeavecasnit.passportmapper.passportcitizen.Entities.Citizen;
import com.codeavecasnit.passportmapper.passportcitizen.Repositories.CitizenRepository;
import com.codeavecasnit.passportmapper.passportcitizen.Service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenServiceImpl implements CitizenService {
    private final CitizenRepository citizenRepository;

    @Autowired
    public CitizenServiceImpl(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }
    @Override
    public List<Citizen> findAll() {
        return citizenRepository.findAll();
    }

    @Override
    public Citizen findById(Long id) {
        return citizenRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(Citizen citizen) {
        try{
            citizenRepository.save(citizen);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean DeleteById(Long id) {
        try{
            citizenRepository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Long citizenId, Citizen citizen) {
        Optional<Citizen> citizenOptional = citizenRepository.findById(citizenId);
        if(citizenOptional.isPresent()){
            Citizen citizenToUpdate = citizenOptional.get();
            citizenToUpdate.setFirstName(citizen.getFirstName());
            citizenToUpdate.setLastName(citizen.getLastName());
            citizenToUpdate.setAddress(citizen.getAddress());
            return true;
        }else return false;
    }
}
