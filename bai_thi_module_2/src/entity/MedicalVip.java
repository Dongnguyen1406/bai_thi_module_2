package entity;

import java.time.LocalDate;

public class MedicalVip extends MedicalRecord {
    private String typeVIP;
    private LocalDate durationVip;

    public MedicalVip(String id, String idMedical, String namePatient, LocalDate startDay, LocalDate endDay, String reason, String typeVIP, LocalDate durationVip) {
        super(id, idMedical, namePatient, startDay, endDay, reason);
        this.typeVIP = typeVIP;
        this.durationVip = durationVip;
    }

    public String getTypeVIP() {
        return typeVIP;
    }

    public void setTypeVIP(String typeVIP) {
        this.typeVIP = typeVIP;
    }

    public LocalDate getDurationVip() {
        return durationVip;
    }

    public void setDurationVip(LocalDate durationVip) {
        this.durationVip = durationVip;
    }

    @Override
    public String toString() {
        return "MedicalVIP{" +
                "id='" + id +
                ", idMedical='" + idMedical +
                ", namePatient='" + namePatient +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", reason='" + reason +
                ", typeVIP='" + typeVIP +
                ", durationVip=" + durationVip +
                '}';
    }

    @Override
    public String toFileCSV() {
        return super.toString() +
                typeVIP + "," +
                durationVip;
    }

}
