package com.example.hw2;

import jakarta.validation.constraints.Size;

public class Citation {
    @Size(max = 30)
    private String citation;

    public String getCitation() {
        return citation;
    }

    public void setCitation(String citation) {
        this.citation = citation;
    }
}
