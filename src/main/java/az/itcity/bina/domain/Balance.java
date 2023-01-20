package az.itcity.bina.domain;

import lombok.Data;

import javax.validation.constraints.Positive;


@Data
public class Balance {

    private int balance;
    private String date;
}
