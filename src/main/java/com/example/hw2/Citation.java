package com.example.hw2;

import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class Citation {
    @Size(max = 30)

    private String citation;
}
