package com.codeavecasnit.passportmapper.passportcitizen.Service;

import com.codeavecasnit.passportmapper.passportcitizen.Entities.Passport;

import java.util.List;

public interface PassportService {
    boolean save(Passport passport);
    Passport findById(Long id);
    List<Passport> findAll();
    boolean delete(Long id);
    boolean update(Passport passport,Long id);
}
