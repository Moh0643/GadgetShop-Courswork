import java.util.Scanner;

public class Mobile extends Gadget {
    private int callingCreditMinutes;
    private static Scanner scanner = new Scanner(System.in);

    public Mobile(String model, double price, float weight, String size, int callingCreditMinutes) {
        super(model, price, weight, size);
        this.callingCreditMinutes = callingCreditMinutes;
    }
    
    @Override
    public String getModel() {
    return super.getModel();
    }

    public int getCallingCreditMinutes() {
        return callingCreditMinutes;
    }

    public void makeCall(String phoneNumber, int callDuration) {
        while (callingCreditMinutes < callDuration) {
            System.out.println("Insufficient calling credit to make the call.");
            System.out.println("Enter additional calling credit (minutes):");
            int additionalCredit = Integer.parseInt(scanner.nextLine());
            callingCreditMinutes += additionalCredit;
        }

        System.out.println("Making call to " + phoneNumber + " for " + callDuration + " minutes.");
        callingCreditMinutes -= callDuration;
    }

    public static void main(String[] args) {
        System.out.println("Enter the model:");
        String model = scanner.nextLine();

        System.out.println("Enter the price (£):");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter the weight (grams):");
        float weight = Float.parseFloat(scanner.nextLine());

        System.out.println("Enter the size (e.g., 71mm x 137mm x 9mm):");
        String size = scanner.nextLine();

        System.out.println("Enter the calling credit (minutes):");
        int callingCreditMinutes = Integer.parseInt(scanner.nextLine());

        Mobile mobile = new Mobile(model, price, weight, size, callingCreditMinutes);

        System.out.println("Enter the phone number to call:");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter the duration of the call (minutes):");
        int callDuration = Integer.parseInt(scanner.nextLine());

        mobile.makeCall(phoneNumber, callDuration);
        System.out.println("Calling credit remaining: " + mobile.getCallingCreditMinutes() + " minutes");
    }
}
