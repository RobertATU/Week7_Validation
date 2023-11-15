package ie.atu.week7_validation;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/person")
@RestController
public class PersonController {
   private final PersonService personService;
    public PersonController(PersonService personService){
       this.personService = personService;
    }
    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getPerson(@PathVariable String employeeId) {
        if (employeeId.length() > 5 || employeeId.isBlank()) {
            return ResponseEntity.badRequest().body("EmployeeId is invalid");
        }
        Person person = personService.getPersonByEmployeeId(employeeId);

        if (person == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }
    @PostMapping("/addPerson")
    public String addPerson(@RequestBody @Valid Person personRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return bindingResult.toString();
        return "Details added";
    }

    @PostMapping("/savePerson")
    public String savePerson(@RequestBody @Valid Person person){
        personService.savePerson(person);
        return person.toString();

    }
}
