package resources;

import java.util.Date;

class AvoidOldDateApiTest {
    public void doSomething() {
        Date date = new Date(); // Noncompliant {{Avoid using java.util.Date; use java.time.LocalDate or java.time.Instant instead.}}
        date.toInstant();
    }
}
