public class CodingHours {
    public static void main(String[] args) {
        // An average Green Fox attendee codes 6 hours daily
        // The semester is 17 weeks long
        int weeks = 17;
        int days = 7;
        int hours = 24;
        int sum_hours;
        // Sum of the total hours during the semester
        sum_hours = weeks * days * hours;
        System.out.println(sum_hours);
        //
        // Print how many hours is spent with coding in a semester by an attendee,
        // if the attendee only codes on workdays.
        int sum_hours_coding;
        int work_days=5;
        sum_hours_coding = weeks * work_days * 6;
        System.out.println(sum_hours_coding);
        //
        // Print the percentage of the coding hours in the semester if the average
        // work hours weekly is 52
        int sum_hours_weekly;
        sum_hours_weekly = weeks * 52;
        System.out.println(sum_hours_weekly);

        System.out.println((sum_hours_coding/(float)sum_hours_weekly)*100);
    }
}