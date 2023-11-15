package ie.atu.week7_validation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @NotBlank(message =  "Name cannot be blank")
    @Size(min = 2, max = 15, message = "Name must be between 2 and 15 characters")
    private String name;

    @Size(min = 2 ,max = 3, message = "Title must be between 2 and 3 characters")
    private String title;

    @Min(value = 1,message = "Id must be greater than 1")
    private int employeeId;

    @Min(value = 1,message = "Age must be greater than 1")
    private int age;

    @Email(message = "Invalid Email address")
    private String email;

    @Size(min = 2 ,max = 20, message = "Title must be between 2 and 20 characters")
    private String position;

    @Size(min = 2 ,max = 20, message = "Department must be between 2 and 20 characters")
    private String department;

}
