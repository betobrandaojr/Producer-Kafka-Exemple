package br.com.bandao.ProducerExemple.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PutObjectMessageDTO {
    
    private Long id;
    private String name;
    
}
