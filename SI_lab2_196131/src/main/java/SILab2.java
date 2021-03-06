
import java.util.ArrayList;
import java.util.List;

class Time {
    int hours;
    int minutes;
    int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        return "Time{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }
}

public class SILab2 {

    public static List<Integer> function(List<Time> timesList) { //1
        List<Integer> result = new ArrayList<>(); // A //2

        for (int i = 0; i < timesList.size(); i++) { // B //3
            int hr = timesList.get(i).getHours(); // C //4
            int min = timesList.get(i).getMinutes(); // C //5
            int sec = timesList.get(i).getSeconds(); // C //6
            if (hr < 0 || hr > 24){ // D //7
                if (hr < 0){ // E //8
                    throw new RuntimeException("The hours are smaller than the minimum"); // F //9
                }
                else { // G //10
                    throw new RuntimeException("The hours are grater than the maximum"); // H //11
                }
            }
            else if (hr < 24) { // I //12
                if (min < 0 || min > 59) // J //13
                    throw new RuntimeException("The minutes are not valid!"); // K //14
                else { // L //15
                    if (sec >= 0 && sec <= 59) // M //16
                        result.add(hr * 3600 + min * 60 + sec); // N //17
                    else // O //18
                        throw new RuntimeException("The seconds are not valid"); // P //19
                }
            }
            else if (hr == 24 && min == 0 && sec == 0) { // Q  //20
                result.add(hr * 3600 + min * 60 + sec); // R  //21
            }
            else { // S  //22
                throw new RuntimeException("The time is greater than the maximum"); // T  //23
            }
        }  //24
        return result; // U  //25
    } // 26


    public static void main(String[] args){
        List<Time> timesList = new ArrayList<>();
        timesList.add(new Time(1,1,30));
        timesList.add(new Time(1,30,15));
        timesList.stream().forEach(i -> System.out.println(i));
        System.out.println(function(timesList));

    }

}


