package com.rpajdak.excercise.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResultSet {

    private Double value;
    private String description;
    private String message;

    public ResultSet(String description) {
        this.description = description;
        this.message = String.format("There is no currency as %s",this.description);
    }

    public ResultSet(Double value, String description) {
        this.value = value;
        this.description = description;
    }

}
