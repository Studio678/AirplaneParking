import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 Реализовать эмулятор стоянки самолётов-стэк. Размер стоянки ­ 5- мест.
 Работать должно быть следующим образом: вводим в консоль бортовые номера самолётов,
 и программа их запоминает (“ставит” их на стоянку). При вводе команды “exitAll” программа должна
 распечатать номера самолётов в порядке покидания стоянки (и удалить их все из памяти).
 При вводе “exitLast” ­ должна распечатать и удалить из памяти только тот самолёт,
 который сейчас выезжает. Если стоянка заполнена полностью,
 следующему самолёту должно быть отказано во въезде.
 LIFO

 author studio678 27.05.2019
*/

public class Main {
    private final static int PARKING_VOLUME = 5;
    public static void main(String[] args) throws IOException {
        ParkingStack parkingStack1 = new ParkingStack();

        while(true) {
            //input block
            String airplaneNumber = readBlock();
            //if block
            if (airplaneNumber.equals("exitAll")) {//exitAll block
                while(parkingStack1.getParkingStackLength() > 0) {
                    System.out.println(parkingStack1.popParkingStack());
                }
                break;
            } else if (airplaneNumber.equals("exitLast") && parkingStack1.getParkingStackLength() > 0) {//exitLast block
                System.out.println("Flight №" + parkingStack1.popParkingStack() + " is going to sky");
                System.out.println();
            } else if (parkingStack1.getParkingStackLength() == PARKING_VOLUME) {//Full Parking block
                System.out.println("Parking is full, please wait");
            }else if(!airplaneNumber.equals("exitLast")){//check if not exitLast block on empty Parking
                parkingStack1.pushParkingStack(airplaneNumber);
            }else if(parkingStack1.getParkingStackLength() == 0) {//check if parking not empty
                System.out.println("Parking is empty");
            }
            //show capacity of parking
            System.out.println("Airplanes on parking: " + parkingStack1.getParkingStackLength());
        }

    }

    private static String readBlock() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input 'exitAll' for seen all airplane numbers on the parking and delete them from memory.");
        System.out.println("Input 'exitLast' for print and delete from memmory airplane gone to the sky");
        System.out.println("Input airplane number or command: ");
        String str = reader.readLine().trim();
        System.out.println();

        return str;
    }
}
