import java.text.DateFormatSymbols;
import java.util.ArrayList;

public class Reservation implements Reservations {
    public String reservationCode;
    public String Dow;
    String[] dowArray = new String[7];
    String resCode = "";

    public Reservation(String reservationCode, String Dow) {
        this.reservationCode = reservationCode;
        this.Dow = Dow;
    }

    public Reservation() {
    }

    public String getDowBooking() {
        DateFormatSymbols dfs = new DateFormatSymbols();
        dowArray = dfs.getShortWeekdays();
        int day = (int) (Math.random() * 7) + 1;
        return dowArray[day].toUpperCase();
    }

    public String getCodeBooking() {
        ArrayList<Character> chars = new ArrayList<>();
        for (char ch = '0'; ch < '9'; ++ch) {
            chars.add(ch);
        }
        for (char ch = 'A'; ch < 'Z'; ++ch) {
            chars.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = (int) (Math.random() * chars.size()) + 0;
            sb.append(chars.get(index));
        }
        resCode = sb.toString();
        return resCode;
    }

    @Override
    public String toString() {
        return "Booking# " + this.getCodeBooking() + " for " + this.getDowBooking();
    }
}
