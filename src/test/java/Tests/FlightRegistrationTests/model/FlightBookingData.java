package Tests.FlightRegistrationTests.model;

public record FlightBookingData(String firstName,
                                String lastName,
                                String email,
                                String password,
                                String street,
                                String city,
                                String zip,
                                String passengersCount,
                                String expectedPrice)  {
}
