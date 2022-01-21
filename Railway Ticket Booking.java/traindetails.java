import java.util.ArrayList;
import java.util.HashMap;


public class traindetails {
    HashMap<Integer,ArrayList<String>> trainDetails=new HashMap<Integer,ArrayList<String>>();
    int Seats[][]=user.SeatArr;
   
    public void trains(){
        ArrayList<String> trainDetailsTemp=new ArrayList<String>();
        trainDetailsTemp.add("Train Name:Chennai Express");
        trainDetailsTemp.add("Seats:10");
        trainDetailsTemp.add("From:Tiruppur");
        trainDetailsTemp.add("To:Chennai");
        trainDetailsTemp.add("Station 1 : Tiruppur");
        trainDetailsTemp.add("Station 2 : Erode");
        trainDetailsTemp.add("Station 3 : Salem");
        trainDetailsTemp.add("Station 4 : Dharmapuri");
        trainDetailsTemp.add("Station 5 : Krishnagiri");
        trainDetailsTemp.add("Station 6 : Jolarpet");
        trainDetailsTemp.add("Station 7 : Ambur");
        trainDetailsTemp.add("Station 8 : Vellore");
        trainDetailsTemp.add("Station 9 : Arakonam");
        trainDetailsTemp.add("Station 10 : Chennai");
        trainDetails.put(2727,trainDetailsTemp);
    }
    void display(int Id){
        ArrayList<String> Display=trainDetails.get(Id);
        for(int i=0;i<Display.size();i++){
            System.out.println(Display.get(i)+"\n");
        }
    }
    
}
