package ie.atu.week7_validation;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    public void savePerson(Person person){
        System.out.println("Person saved: "+person);
    }

    public Person getPersonByEmployeeId(String employeeId) {
        Person person  = new Person("Robert", "Mr",employeeId,22,"g00395612@atu.ie","engineer","software");
        return person;
    }
}
