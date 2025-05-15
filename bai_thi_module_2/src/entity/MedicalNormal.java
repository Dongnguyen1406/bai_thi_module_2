package entity;

import java.time.LocalDate;

public class MedicalNormal extends MedicalRecord{
    private Double price;

    public MedicalNormal(String id, String idMedical, String namePatient, LocalDate startDay, LocalDate endDay, String reason, Double price) {
        super(id, idMedical, namePatient, startDay, endDay, reason);
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MedicalNormal{" +
                "id='" + id + 
                ", idMedical='" + idMedical +
                ", namePatient='" + namePatient + 
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", reason='" + reason + 
                ", price=" + price +
                '}';
    }

    @Override
    public String toFileCSV() {
        return super.toString() +
                price;
    }


}
