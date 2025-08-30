package Library;
import java.util.Scanner;
//Class with conversion methods
class TemperatureConverter {
 
 // Convert Celsius to Fahrenheit
    public double celsiusToFahrenheit(double celsius) {
       return (celsius * 9 / 5) + 32;
    }
// Convert Fahrenheit to Celsius
   public double fahrenheitToCelsius(double fahrenheit) {
     return (fahrenheit - 32) * 5 / 9;
   }
}
//Main class
public class TemperatureConverterApp {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     TemperatureConverter converter = new TemperatureConverter(); // create object

     System.out.println("------ Temperature Converter ------");
     System.out.println("1. Celsius to Fahrenheit");
     System.out.println("2. Fahrenheit to Celsius");
     System.out.print("Enter your choice (1 or 2): ");
     int choice = sc.nextInt();

     switch (choice) {
         case 1:
             System.out.print("Enter temperature in Celsius: ");
             double celsius = sc.nextDouble();
             System.out.println(celsius + " °C = " 
                                + converter.celsiusToFahrenheit(celsius) + " °F");
             break;

         case 2:
             System.out.print("Enter temperature in Fahrenheit: ");
             double fahrenheit = sc.nextDouble();
             System.out.println(fahrenheit + " °F = " 
                                + converter.fahrenheitToCelsius(fahrenheit) + " °C");
             break;

         default:
             System.out.println("Invalid choice! Please select 1 or 2.");
     }

     sc.close();
 }
}
