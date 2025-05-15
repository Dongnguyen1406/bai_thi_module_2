package view;

import entity.MedicalNormal;
import entity.MedicalVip;
import repository.IMedicalNormalRepo;
import repository.IMedicalVipRepo;
import repository.MedicalNormalRepo;
import repository.MedicalVipRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordsView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IMedicalNormalRepo medicalNormalRepo = new MedicalNormalRepo();
    private static final IMedicalVipRepo medicalVipRepo = new MedicalVipRepo();


    public static MedicalNormal inputMedicalNormal(){
        String id, idMedical, namePatient, reason;
        LocalDate startDay, endDay;
        Double price;
        
        id = generateNextIdNormalMedical();

        System.out.print("Nhập mã bệnh án (BA-XXX): ");
        idMedical = scanner.nextLine();

        System.out.print("Nhập tên bệnh nhân: ");
        namePatient = scanner.nextLine();

        System.out.println("Nhập ngày nhập viện (yyyy-MM-dd): ");
        startDay = LocalDate.parse(scanner.nextLine());

        System.out.println("Nhập ngày ra viện (yyyy-MM-dd): ");
        endDay = LocalDate.parse(scanner.nextLine());

        System.out.print("Nhập lý do: ");
        reason = scanner.nextLine();

        System.out.println("Nhập phí nằm viện: ");
        price = Double.parseDouble(scanner.nextLine());
        
        return new MedicalNormal(id, idMedical, namePatient, startDay, endDay, reason, price);
    }

    public static MedicalVip inputMedicalVip(){
        String id, idMedical, namePatient, reason, typeVIP;
        LocalDate startDay, endDay, durationVip;
        
        id = generateNextIVipMedical();

        System.out.print("Nhập mã bệnh án: ");
        idMedical = scanner.nextLine();

        System.out.print("Nhập tên bệnh nhân: ");
        namePatient = scanner.nextLine();

        System.out.println("Nhập ngày nhập viện (yyyy-MM-dd): ");
        startDay = LocalDate.parse(scanner.nextLine());

        System.out.println("Nhập ngày ra viện (yyyy-MM-dd): ");
        endDay = LocalDate.parse(scanner.nextLine());

        System.out.print("Nhập lý do: ");
        reason = scanner.nextLine();

        System.out.print("Nhập loại VIP (VIP I, II, III): ");
        typeVIP = scanner.nextLine();
        

        System.out.println("Nhập ngày hết hạn (yyyy-MM-dd): ");
        durationVip = LocalDate.parse(scanner.nextLine());
        
        return new MedicalVip(id, idMedical, namePatient, startDay, endDay, reason, typeVIP, durationVip);
    }

    public static String inputIdMedicalToDelete() {
        System.out.print("Nhập mã bệnh án cần xóa: ");
        return scanner.nextLine();
    }

    private static String generateNextIdNormalMedical() {
        List<MedicalNormal> medicalNormalList = medicalNormalRepo.getAll();
        int max = 0;
        for (MedicalNormal medicalNormal : medicalNormalList) {
            String[] parts = medicalNormal.getId().split("-");
            int number = Integer.parseInt(parts[1]);
            if (number > max) {
                max = number;
            }
        }
        return  String.format("BA-%03d", max + 1);
    }

    private static String generateNextIVipMedical() {
        List<MedicalVip> medicalVipList = medicalVipRepo.getAll();
        int max = 0;
        for (MedicalVip medicalVip : medicalVipList) {
            String[] parts = medicalVip.getId().split("-");
            int number = Integer.parseInt(parts[1]);
            if (number > max) {
                max = number;
            }
        }
        return  String.format("BA-%03d", max + 1);
    }
    
    
}
