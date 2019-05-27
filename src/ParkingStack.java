import java.util.ArrayList;

/**
    This class will realize stack structure for airplane parking
 */


class ParkingStack {
    private ArrayList<String> parkingStack;
    ParkingStack(){
        parkingStack = new ArrayList<>();
    }

    int getParkingStackLength(){
        return parkingStack.size();
    }

    String popParkingStack(){
        return parkingStack.remove(getParkingStackLength()-1);
    }

    void pushParkingStack(String airplaneNumber){
        parkingStack.add(airplaneNumber);
    }
}