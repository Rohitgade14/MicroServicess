package com.patilsoft.user.service.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StandardResponse<T> {

    private String message;
    private Boolean status;
    private T data;

}



