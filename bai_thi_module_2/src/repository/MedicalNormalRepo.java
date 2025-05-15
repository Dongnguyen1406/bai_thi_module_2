package repository;

import entity.MedicalNormal;
import utils.ReadAndWriteFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicalNormalRepo implements IMedicalNormalRepo{

    private static final String FILE_MEDICAL_NORMAL = "src/data/medical_normal_records.csv";
    private final List<MedicalNormal> medicalNormals = new ArrayList<>();


    @Override
    public List<MedicalNormal> getAll() {
        if (medicalNormals.isEmpty()){
            List<String> lines = ReadAndWriteFile.readFileToCSV(FILE_MEDICAL_NORMAL);
            for (String line : lines){
                String[] array = line.split(",");
                medicalNormals.add(new MedicalNormal(array[0], array[1], array[2], LocalDate.parse(array[3]), LocalDate.parse(array[4]), array[5], Double.parseDouble(array[6])));
            }
        }
        return medicalNormals;
    }

    @Override
    public void addNew(MedicalNormal medicalNormal) {
        medicalNormals.add(medicalNormal);
        List<String> data = new ArrayList<>();
        data.add(medicalNormal.toFileCSV());
        ReadAndWriteFile.writeFileToCSV(FILE_MEDICAL_NORMAL, data,true);
    }

    @Override
    public boolean delete(String idMedical) {
        List<MedicalNormal> medicalNormalList = getAll();
        boolean isDelete = false;

        for (int i = 0; i < medicalNormalList.size(); i++) {
            if (medicalNormalList.get(i).getIdMedical().toLowerCase().equals(idMedical.toLowerCase())){
                medicalNormalList.remove(i);
                isDelete = true;
                break;
            } else {
                System.out.println("Không tìm thấy mã bệnh án thường với id: " + idMedical);
            }
        }
        if (isDelete){
            List<String> data = new ArrayList<>();
            for (MedicalNormal medicalNormal : medicalNormalList){
                data.add(medicalNormal.toFileCSV());
            }
            ReadAndWriteFile.writeFileToCSV(FILE_MEDICAL_NORMAL, data, false);
        }

        return isDelete;
    }

    @Override
    public boolean isExists(String idMedical, List<MedicalNormal> medicalNormalList) {
        for (MedicalNormal medicalNormal : medicalNormalList){
            if (medicalNormal.getIdMedical().equals(idMedical)){
                return true;
            }
        }
        return false;
    }
}
