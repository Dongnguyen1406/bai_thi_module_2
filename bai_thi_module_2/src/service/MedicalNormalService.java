package service;

import entity.MedicalNormal;
import repository.IMedicalNormalRepo;
import repository.MedicalNormalRepo;

import java.util.List;

public class MedicalNormalService implements IMedicalNormalService{
    private final IMedicalNormalRepo medicalNormalRepo = new MedicalNormalRepo();
    
    @Override
    public List<MedicalNormal> getAll() {
        return medicalNormalRepo.getAll();
    }

    @Override
    public void addNew(MedicalNormal medicalNormal) {
        medicalNormalRepo.addNew(medicalNormal);
    }

    @Override
    public boolean delete(String idMedical) {
        return medicalNormalRepo.delete(idMedical);
    }

    @Override
    public boolean isExists(String idMedical, List<MedicalNormal> medicalNormalList) {
        return medicalNormalRepo.isExists(idMedical, medicalNormalRepo.getAll());
    }
}
