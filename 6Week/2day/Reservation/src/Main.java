import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Reservation> reservations = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Reservation reservation = new Reservation();
            reservation.getCodeBooking();
            reservation.getDowBooking();
            reservations.add(reservation);
        }

        for (Reservation currentReservation : reservations) {
            System.out.println(currentReservation.toString());
        }

    }
}
