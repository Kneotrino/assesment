package com.kneotrino.assesment.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel extends BaseModel {

  private static final long serialVersionUID = 564290241;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank
  private String Name;

  @NotBlank
  private String ImageUrl;

  @Min(0)
  @NotNull
  private Long Price;
}
