package com.projetocodigocerto.api.dto.response;


import lombok.Builder;
import lombok.Data;
import org.aspectj.internal.lang.annotation.ajcDeclareEoW;

@Data
@Builder
public class MessageResponseDTO {
    
    public String message;
}
