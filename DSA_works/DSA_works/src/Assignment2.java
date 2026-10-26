abstract class MedicalService {
    protected String serviceId;
    protected String serviceName;
    protected double baseCost;

    public MedicalService(String serviceId, String serviceName, double baseCost) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.baseCost = baseCost;
    }

    public abstract double calculateTotalCost();

    public void displayServiceInfo() {
        System.out.println("Service ID: " + serviceId);
        System.out.println("Service: " + serviceName);
        System.out.printf("Total Cost: $%.2f%n", calculateTotalCost());
    }
}


class Consultation extends MedicalService {
    private double doctorFee;

    public Consultation(String serviceId, String serviceName,
                        double baseCost, double doctorFee) {
        super(serviceId, serviceName, baseCost);
        this.doctorFee = doctorFee;
    }

    @Override
    public double calculateTotalCost() {
        return baseCost + doctorFee;
    }
}


class LaboratoryTest extends MedicalService {
    private double testCharge;

    public LaboratoryTest(String serviceId, String serviceName,
                          double baseCost, double testCharge) {
        super(serviceId, serviceName, baseCost);
        this.testCharge = testCharge;
    }

    @Override
    public double calculateTotalCost() {
        return baseCost + testCharge;
    }
}


class Ultrasound extends MedicalService {
    private double additionalFee;

    public Ultrasound(String serviceId, String serviceName,
                      double baseCost, double additionalFee) {
        super(serviceId, serviceName, baseCost);
        this.additionalFee = additionalFee;
    }

    @Override
    public double calculateTotalCost() {
        return baseCost + additionalFee;
    }
}


public class Assignment2 {
    public static void main(String[] args) {

        MedicalService service1 = new Consultation(
                "S001", "Consultation", 15, 10
        );

        MedicalService service2 = new LaboratoryTest(
                "S002", "Laboratory Test", 10, 8
        );

        MedicalService service3 = new Ultrasound(
                "S003", "Ultrasound", 30, 10
        );

        System.out.println("===== HOSPITAL BILLING SYSTEM =====");
        System.out.println();

        service1.displayServiceInfo();
        System.out.println();

        service2.displayServiceInfo();
        System.out.println();

        service3.displayServiceInfo();
        System.out.println();

        double totalBill =
                service1.calculateTotalCost()
                        + service2.calculateTotalCost()
                        + service3.calculateTotalCost();

        System.out.println("------------------------------");
        System.out.printf("Total Hospital Bill: $%.2f%n", totalBill);
    }
}