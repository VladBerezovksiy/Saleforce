package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ContactModel {

    String Salutation;
    String FirstName;
    String LastName;
    String Phone;
    String AccountName;
    String FullInitials;

}
