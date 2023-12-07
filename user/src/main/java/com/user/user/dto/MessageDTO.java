package com.user.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {

    private Integer id;
    private String message;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private int sendTo;
    private int sendFrom;
    private String status;


}
