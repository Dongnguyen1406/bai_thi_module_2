package controller;

import entity.MedicalNormal;
import entity.MedicalVip;
import service.IMedicalNormalService;
import service.IMedicalVipService;
import service.MedicalNormalService;
import service.MedicalVipService;
import view.MedicalRecordsView;

import java.util.List;
import java.util.Scanner;

public class HopitalController {
    static final Scanner scanner = new Scanner(System.in);
    static final IMedicalVipService medicalVipService = new MedicalVipService();
    static final IMedicalNormalService medicalNormalService = new MedicalNormalService();

    public static void displayMenu() {
        boolean flagMain = true;
        do {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN" +
                    "\n 1. Thêm mới" +
                    "\n 2. Xóa" +
                    "\n 3. Xem danh sách các bệnh án" +
                    "\n 4. Thoát");
            System.out.print("Chọn chức năng: ");
            int chooseMenuMain = scanner.nextInt();
            switch (chooseMenuMain) {
                case 1:
                    boolean flagCreate = true;
                    do {
                        System.out.println("Thêm mới phương tiện" +
                                "\n 1. Thêm Bệnh án thường" +
                                "\n 2. Thêm Bệnh án VIP" +
                                "\n 3. Trở lại menu chính");
                        System.out.print("Chọn chức năng: ");
                        int chooseCreate = scanner.nextInt();
                        switch (chooseCreate) {
                            case 1:
                                MedicalNormal medicalNormal = MedicalRecordsView.inputMedicalNormal();
                                if (medicalNormalService.isExists(medicalNormal.getIdMedical(), medicalNormalService.getAll())){
                                    System.out.println("Mã bệnh án đã tồn tại!");
                                } else {
                                    medicalNormalService.addNew(medicalNormal);
                                    System.out.println("Thêm mới bệnh án thành công!");
                                    break;
                                }
                                break;
                            case 2:
                                MedicalVip medicalVip = MedicalRecordsView.inputMedicalVip();
                                if (medicalVipService.isExists(medicalVip.getIdMedical(), medicalVipService.getAll())){
                                    System.out.println("Mã bệnh án đã tồn tại!");
                                } else {
                                    medicalVipService.addNew(medicalVip);
                                    System.out.println("Thêm mới bệnh án thành công!");
                                    break;
                                }
                                break;
                            case 3:
                                flagCreate = false;
                                break;
                            default:
                                System.out.println("Vui lòng chọn từ (1-3) !");
                        }
                    } while (flagCreate);
                    break;
                case 2:
                    String idMedical = MedicalRecordsView.inputIdMedicalToDelete();

                    if (medicalNormalService.delete(idMedical)) {
                        System.out.println("Xóa thành công!");
                    }
                    if (medicalVipService.delete(idMedical)) {
                        System.out.println("Xóa thành công!");
                    }
                    break;
                case 3:
                    boolean flagDisplay = true;
                    do {
                        System.out.println("Hiển thị danh sách bệnh án" +
                                "\n 1. Hiển thị bệnh án thường" +
                                "\n 2. Hiển thị bệnh án VIP" +
                                "\n 3. Trở lại menu chính");
                        System.out.print("Chọn chức năng: ");
                        int chooseDisplay = scanner.nextInt();
                        switch (chooseDisplay) {
                            case 1:
                                List<MedicalNormal> medicalNormals = medicalNormalService.getAll();
                                if (medicalNormals.isEmpty()) {
                                    System.out.println("Danh sách rỗng!");
                                } else {
                                    for (MedicalNormal medicalNormal : medicalNormals) {
                                        System.out.println(medicalNormal);
                                    }
                                }
                                break;
                            case 2:
                                List<MedicalVip> medicalVips = medicalVipService.getAll();
                                if (medicalVips.isEmpty()) {
                                    System.out.println("Danh sách rỗng!");
                                } else {
                                    for (MedicalVip lunarRover : medicalVips) {
                                        System.out.println(lunarRover);
                                    }
                                }
                                break;
                            case 3:
                                flagDisplay = false;
                                break;
                            default:
                                System.out.println("Vui lòng chọn từ (1-3) !");
                        }
                    } while (flagDisplay);
                    break;
                case 4:
                    flagMain = false;
                    System.out.println("Thoát chương trình thành công!.");
                    break;
                default:
                    System.out.println("Vui lòng chọn từ (1-4) !");
            }
        } while (flagMain);
    }
}
