package br.com.fiap.strixapi.dto;

public record TitleDto (
     String title,
     String description,
     int score,
     int status

) {

     
     public TitleDto(String title, String description){
          this(title, description, 100, 0);
     }

}
