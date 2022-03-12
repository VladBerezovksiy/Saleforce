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
public class AccountModel {

    String AccountName;
    String Phone;
    String Website;
    int Employees;
    String Type;
    String Industry;

}
