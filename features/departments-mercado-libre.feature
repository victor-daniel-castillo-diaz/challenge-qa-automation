@departments-mercado-libre
Feature: Departments Mercado Libre

@DML-001
Scenario: DML-001 validate departments of Mercado Libre
  When Get departments from mercado libre
  Then validate departments
  | Electrodomésticos |
  | Hogar y Muebles |
  | Moda |
  | Deportes y Fitness |
  | Herramientas |
  | Construcción |
  | Industrias y Oficinas |
  | Accesorios para Vehículos |
  | Juegos y Juguetes |
  | Bebés |
  | Salud y Equipamiento Médico |
  | Belleza y Cuidado Personal |
  | Inmuebles |
  | Compra Internacional |
  | Productos Sustentables |
  | Más vendidos |
  | Tiendas oficiales |
