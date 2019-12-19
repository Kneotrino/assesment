package com.kneotrino.assesment.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
public class ProductModel extends BaseModel {

  private static final long serialVersionUID = 564290241;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank
  private String Name;

  @NotBlank
  private String Url;

  @Min(0)
  private Long Price;
}
