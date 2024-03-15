package com.example.jobmatcher.Model.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SuccessResult {
    private boolean success;
    private String message;

    public SuccessResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
