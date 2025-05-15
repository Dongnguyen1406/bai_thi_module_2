package service;

import entity.MedicalVip;
import repository.IMedicalNormalRepo;
import repository.IMedicalVipRepo;
import repository.MedicalNormalRepo;
import repository.MedicalVipRepo;

import java.util.List;

public class MedicalVipService implements IMedicalVipService{
    private final IMedicalVipRepo medicalVipRepo = new MedicalVipRepo();


    @Override
    public List<MedicalVip> getAll() {
        return medicalVipRepo.getAll();
    }

    @Override
    public void addNew(MedicalVip medicalVip) {
        medicalVipRepo.addNew(medicalVip);
    }

    @Override
    public boolean delete(String idMedical) {
        return medicalVipRepo.delete(idMedical);
    }

    @Override
    public boolean isExists(String idMedical, List<MedicalVip> medicalVipList) {
        return medicalVipRepo.isExists(idMedical, medicalVipRepo.getAll());

    }
}
