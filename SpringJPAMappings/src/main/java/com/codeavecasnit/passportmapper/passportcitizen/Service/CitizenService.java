package com.codeavecasnit.passportmapper.passportcitizen.Service;

import com.codeavecasnit.passportmapper.passportcitizen.Entities.Citizen;

import java.util.List;

public interface CitizenService {
    List<Citizen> findAll();
    Citizen findById(Long id);
    boolean save(Citizen citizen);
    boolean DeleteById(Long id);
    boolean update(Long citizenId, Citizen citizen);

}
