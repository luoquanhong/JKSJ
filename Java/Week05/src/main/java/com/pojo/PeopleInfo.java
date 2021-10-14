package com.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PeopleInfo {

    private String peopleName;

    private int peopleAge;

    private String peopleCountry;
}
