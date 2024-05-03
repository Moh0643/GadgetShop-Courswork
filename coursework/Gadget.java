import java.util.Scanner;

public class Gadget {
    private String model;
    private double price;
    private double weight;
    private String size;

    public Gadget(String model, double price, float weight, String size) {

        this.price = price;
        this.weight = weight;
        this.size = size;
    }
    
    public String getModel() {
    return model;
    }

    public void displayInfo() {
        System.out.println("Gadget: ");
        System.out.println("Price: £" + price);
        System.out.println("Weight: " + weight + " grams");
        System.out.println("Size: " + size);
    }

    public void increasePrice(float amount) {
        price += amount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter the model:");
        String model = scanner.nextLine();
        
        System.out.println("Please enter the price (in £):");
        double price = Float.parseFloat(scanner.nextLine());
        
        System.out.println("Please enter the weight (in grams):");
        float weight = Float.parseFloat(scanner.nextLine());
        
        System.out.println("Please enter the size (in mm):");
        String size = scanner.nextLine();
        
        scanner.close();
       
       Gadget gadget = new Gadget(model, price, weight, size);
       gadget.displayInfo();
       
       
       
        
    }
}

