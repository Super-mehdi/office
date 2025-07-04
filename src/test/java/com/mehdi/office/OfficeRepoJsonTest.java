package com.mehdi.office;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
@JsonTest
public class OfficeRepoJsonTest {
    @Autowired
    private JacksonTester<Employee> json;

    @Test
    void serializationTest() throws IOException {
        Employee emp= new Employee(7,"Kelly Kapoor",Dept.CUSTOMER_SERVICE);
        assertThat(json.write(emp)).isStrictlyEqualToJson("expected0.json");
        assertThat(json.write(emp)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(emp)).hasJsonPathStringValue("@.name");
        assertThat(json.write(emp)).hasJsonPathValue("@.department");
        assertThat(json.write(emp)).extractingJsonPathNumberValue("@.id").isEqualTo(7);
        assertThat(json.write(emp)).extractingJsonPathStringValue("@.name").isEqualTo("Kelly Kapoor");
        assertThat(json.write(emp)).extractingJsonPathStringValue("@.department").isEqualTo("CUSTOMER_SERVICE");
    }
    @Test
    void deserializationTest() throws IOException{
        String data= """
                {
                "id": 1,
                "name": "Michael Scott",
                "department": "MANAGEMENT"
                }
                """;
        assertThat(json.parse(data)).isEqualTo(new Employee(1,"Michael Scott",Dept.MANAGEMENT));
        assertThat(json.parseObject(data).getId()).isEqualTo(1);
        assertThat(json.parseObject(data).getName()).isEqualTo("Michael Scott");
        assertThat(json.parseObject(data).getDepartment()).isEqualTo(Dept.MANAGEMENT);

    }
}
