
import java.util.Scanner;
import java.text.DecimalFormat;
class HelloWorld {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        DecimalFormat form = new DecimalFormat("$00.00");
        System.out.println("Phone Bill Activity!");

        System.out.println("Please enter which package you use (green, blue, purple)");
        String pack = input.nextLine().toLowerCase().trim();
        while(!pack.equals("green") && !pack.equals("blue") && !pack.equals("purple")) {
            System.out.println("Invalid package. Please enter which package you use (green, blue, purple)");
            pack = input.nextLine().toLowerCase().trim();
        }
        double monthlyRate;
        int data = 0;
        boolean unlimited = false;
        boolean hasCoupon = false;
        double addedCost = 0;
        if (pack.equals("green")) {
            monthlyRate = 49.99;
            data = 2;
            addedCost = 15;
            System.out.println("Do you have a coupon? (yes or no)");
            String couponYN = input.nextLine().toLowerCase().trim();
            while(!couponYN.equals("yes") && !couponYN.equals("no")) {
                System.out.println("Invalid. Do you have a coupon? (yes or no)");
                couponYN = input.nextLine().toLowerCase().trim();
            }
            if(couponYN.equals("yes")) {
                hasCoupon = true;
            }

        }
        else if (pack.equals("blue")) {
            monthlyRate = 70;
            data = 4;
            addedCost = 10;
        }
        else {
            monthlyRate = 99.95;
            unlimited = true;
        }
        if(!unlimited) {
            System.out.println("How much data did you use?");
            int dataUsed = input.nextInt();
            if(dataUsed > data) {
                monthlyRate+= (dataUsed-data)*addedCost;
            }
            if(hasCoupon && monthlyRate >= 75) {
                monthlyRate-=20;
            }
        }
        System.out.println("Your cost is: " + form.format(monthlyRate));

        
    }
}
