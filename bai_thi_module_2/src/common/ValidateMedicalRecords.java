package common;

import java.util.regex.Pattern;

public class ValidateMedicalRecords {
    private static final String ID_MEDICAL_REGEX_ = "^BN-\\d{3}$";
    private static final String NAME_PATIENT_REGEX = "^([A-Z][a-z]*)(\\s[A-Z][a-z]*)*$";

    public static void validateIdMedical(String id) throws Exception {
        if (!Pattern.matches(ID_MEDICAL_REGEX_, id)) {
            throw new Exception("Invalid ID Medical !");
        }
    }
    public static void validateNamePatient(String name) throws Exception{
        if (!Pattern.matches(NAME_PATIENT_REGEX, name)){
            throw new Exception("Invalid name patient !");
        }
    }
    
    
}
