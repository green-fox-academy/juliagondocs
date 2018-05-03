public class FleetOfThings {

    public static void main(String[] args) {
        Fleet fleet = new Fleet();
        Thing firstThing = new Thing("Get milk");
        fleet.add(firstThing);

        Thing secondThing = new Thing("Remove the obstacles");
        fleet.add(secondThing);

        Thing thirdThing = new Thing("Stand up");
        thirdThing.complete();
        fleet.add(thirdThing);

        Thing fourthThing = new Thing("Eat Lunch");
        fourthThing.complete();
        fleet.add(fourthThing);

        // Create a fleet of things to have this output:
        // 1. [ ] Get milk
        // 2. [ ] Remove the obstacles
        // 3. [x] Stand up
        // 4. [x] Eat lunch

        System.out.println(fleet);
    }
}