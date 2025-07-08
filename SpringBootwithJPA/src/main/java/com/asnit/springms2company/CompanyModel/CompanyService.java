package com.asnit.springms2company.CompanyModel;

import java.util.List;

public interface CompanyService {
    public boolean save(Company company);
    public boolean deleteById(Long id);
    public Company getCompanyById(Long id);
    public List<Company> getAll();
    public boolean updateCompany(Long id , Company company);
}
