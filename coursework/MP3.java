import java.util.Scanner;

public class MP3 extends Gadget {
    private double memory;

    public MP3(String model, double price, float weight, String size, double memory) {
        super(model, price, weight, size);
        this.memory = memory;
    }
    
    public double getmemory() {
        return memory;
    }

    public double getAvailableMemory() {
        return memory;
    }
    
    public String getModel() {
    return super.getModel();
    }    
    
    public void downloadSize(double downloadSize) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the music download (in MB):");
        double musicSize = Double.parseDouble(scanner.nextLine());

        if (downloadSize <= memory) {
            memory -= downloadSize;
            System.out.println("Music downloaded successfully. Available memory: " + memory + " MB");
        } else {
            System.out.println("Not enough memory to download music.");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        MP3 mp3Player = new MP3("Sony Walkman", 50.0, 50.0f, "100mm x 50mm x 10mm", 1000.0);
        System.out.println("Initial memory: " + mp3Player.getmemory() + " MB");

    }
}
