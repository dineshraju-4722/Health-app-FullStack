package com.application.DokterFinder.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRatingDto {
  private int rating;
  private int docterid;
  private int userid;
}
