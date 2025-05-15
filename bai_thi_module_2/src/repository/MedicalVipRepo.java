package repository;

import entity.MedicalNormal;
import entity.MedicalVip;
import utils.ReadAndWriteFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicalVipRepo implements IMedicalVipRepo{

    private static final String FILE_MEDICAL_VIP = "src/data/medical_vip_records.csv";
    private final List<MedicalVip> medicalVips = new ArrayList<>();
    
    @Override
    public List<MedicalVip> getAll() {
        if (medicalVips.isEmpty()){
            List<String> lines = ReadAndWriteFile.readFileToCSV(FILE_MEDICAL_VIP);
            for (String line : lines){
                String[] array = line.split(",");
                medicalVips.add(new MedicalVip(array[0], array[1], array[2], LocalDate.parse(array[3]), LocalDate.parse(array[4]), array[5], array[6],LocalDate.parse(array[7])));
            }
        }
        return medicalVips;
    }

    @Override
    public void addNew(MedicalVip medicalVip) {
        medicalVips.add(medicalVip);
        List<String> data = new ArrayList<>();
        data.add(medicalVip.toFileCSV());
        ReadAndWriteFile.writeFileToCSV(FILE_MEDICAL_VIP, data, true);
    }

    @Override
    public boolean delete(String idMedical) {
        List<MedicalVip> medicalVipList = getAll();
        boolean isDelete = false;

        for (int i = 0; i < medicalVipList.size(); i++) {
            if (medicalVipList.get(i).getIdMedical().toLowerCase().equals(idMedical.toLowerCase())){
                medicalVipList.remove(i);
                isDelete = true;
                break;
            } else {
                System.out.println("Không tìm thấy mã bệnh án vip với id: " + idMedical);
            }
        }
        if (isDelete){
            List<String> data = new ArrayList<>();
            for (MedicalVip medicalVip : medicalVipList){
                data.add(medicalVip.toFileCSV());
            }
            ReadAndWriteFile.writeFileToCSV(FILE_MEDICAL_VIP, data, false);
        }

        return isDelete;
    }

    @Override
    public boolean isExists(String idMedical, List<MedicalVip> medicalVipList) {
        for (MedicalVip medicalVip : medicalVipList){
            if (medicalVip.getIdMedical().equals(idMedical)){
                return true;
            }
        }
        return false;
    }
}
