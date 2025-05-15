package entity;

import java.time.LocalDate;

public abstract class MedicalRecord {
    protected String id;
    protected String idMedical;
    protected String namePatient;
    protected LocalDate startDay;
    protected LocalDate endDay;
    protected String reason;

    public MedicalRecord(String id, String idMedical, String namePatient, LocalDate startDay, LocalDate endDay, String reason) {
        this.id = id;
        this.idMedical = idMedical;
        this.namePatient = namePatient;
        this.startDay = startDay;
        this.endDay = endDay;
        this.reason = reason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdMedical() {
        return idMedical;
    }

    public void setIdMedical(String idMedical) {
        this.idMedical = idMedical;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return id + "," +
                idMedical + "," +
                namePatient + "," +
                startDay + "," +
                endDay + "," +
                reason + ",";
    }

    public abstract String toFileCSV();
}
