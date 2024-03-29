package com.example.rinhav2.dtos;

import jakarta.validation.constraints.NotBlank;

public record TransactionRequest(@NotBlank Integer value,
                                 @NotBlank Character type,
                                 @NotBlank String description) {
}
