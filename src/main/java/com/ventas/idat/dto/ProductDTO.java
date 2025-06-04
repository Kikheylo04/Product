package com.ventas.idat.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {
   private @NotBlank(
   message = "El nombre es obligatorio"
) String name;
   private @Size(
   max = 255,
   message = "La descripcion no puede superar los 255 caracteres"
) String description;
   private @Positive(
   message = "El precio debe ser positivo"
) double price;
   private @Min(
   value = 0L,
   message = "El stock no puede ser negativo"
) int stock;

   public ProductDTO() {
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return this.description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public double getPrice() {
      return this.price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public int getStock() {
      return this.stock;
   }

   public void setStock(int stock) {
      this.stock = stock;
   }
}
