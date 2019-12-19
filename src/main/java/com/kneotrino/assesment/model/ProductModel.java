package com.kneotrino.assesment.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "product")
@Data
@EqualsAndHashCode(callSuper = false)
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel extends BaseModel {

  private static final long serialVersionUID = 564290241;

  @Id
  @GeneratedValue(generator = "movie_generator")
  @SequenceGenerator(
      name = "movie_generator",
      sequenceName = "movie_sequence",
      initialValue = 10_000)
  private Integer id;

  @NotBlank
  private String Name;

  @NotBlank
  private String Url;

  @Min(0)
  private Long Price;
}
