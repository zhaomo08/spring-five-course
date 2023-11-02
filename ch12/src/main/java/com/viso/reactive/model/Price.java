package com.viso.reactive.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Price {
    public Integer coefficient;
    public Integer exponent;
    public String currency;
}
