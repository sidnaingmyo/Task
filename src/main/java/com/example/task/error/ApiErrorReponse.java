package com.example.task.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ApiErrorReponse {
    private Date timestamp;
    private Integer result;
    private String error_code;
    private String error_message;
    private String error_remark;
}
