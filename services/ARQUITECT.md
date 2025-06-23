# OpenMarket Corp - E-Market Multiplataforma

## 1.- Hoja de trabajo con la priorización de características de arquitectura
![Source](https://i.imgur.com/ODfr6Fs.png)
## 2.- Estilo arquitectónico seleccionado
![Source](https://i.imgur.com/QLYEHxh.png)
## 3.- Diagramas C4
### Diagrama C4 - Nivel 1: Contexto del Sistema
![Source](https://i.postimg.cc/6qqL9z5c/diagrama1-C4.png)
### Diagrama C4 - Nivel 2: Contenedores
![Source](https://i.postimg.cc/wMr53J1p/diagrama2-C4.png)
### Diagrama C4 - Nivel 3: Componentes
![Source](https://i.postimg.cc/Hxp9Ndqf/diagrama3-C4.png)

## 4.-  Repositorio con la organización del código
![Source](https://i.imgur.com/tTFKAdf.png)

## 5.-  Diagrama de clases a elección

### cart_db
![Source](https://i.imgur.com/F69ogPr.png)

### inventory_db
![Source](https://i.imgur.com/yjFgn3i.png)

### user_db
![Source](https://i.imgur.com/tI83gj5.png)

### order_db
![Source](https://i.imgur.com/BMqmFUd.png)

### payment_db
![Source](https://i.imgur.com/UCELWRk.png)


## 6.-  Distancia desde la secuencia principal

El análisis de distancia desde la secuencia principal evalúa cómo los componentes del sistema se alejan del ideal de bajo acoplamiento y alta cohesión. A continuación se presenta este análisis para las bases de datos del sistema:

### cart_db
**Perfil estructural**:  
- Alta cohesión (C ≈ 0.9) por la estrecha relación entre `cart_item` y `cart_id`  
- Acoplamiento moderado (A ≈ 0.4) por su dependencia de inventory_db  
**Distancia**: Relativamente cercana a la secuencia principal, con ligero alejamiento por la dependencia de inventario.

**Cálculo**: 
```math 
DMS = \sqrt{(1 - 0.9)^2 + 0.4^2} = \sqrt{0.01 + 0.16} \approx 0.41
```

**Interpretación**:  
Distancia moderadamente baja, beneficiada por su alta cohesión.

### inventory_db
**Perfil estructural**:  
- Cohesión media (C ≈ 0.7) debido a la especialización de `stock_reservation`  
- Acoplamiento significativo (A ≈ 0.5) como servicio central  
**Distancia**: Mayor separación de la secuencia ideal, funcionando como nodo de interconexión.

**Cálculo**:  
$ DMS = \sqrt{(1 - 0.7)^2 + 0.5^2} = \sqrt{0.09 + 0.25} \approx 0.58 $
**Interpretación**:  
Mayor distancia debido a cohesión reducida y acoplamiento significativo.

### user_db
**Perfil estructural**:  
- Buena cohesión (C ≈ 0.8) aunque con el componente genérico `role`  
- Bajo acoplamiento (A ≈ 0.3) como servicio relativamente aislado  
**Distancia**: Entre las más cercanas al ideal, con oportunidad de mejora en el modelo de roles.

**Cálculo**:  
```math
DMS = \sqrt{(1 - 0.8)^2 + 0.3^2} = \sqrt{0.04 + 0.09} \approx 0.36
```

**Interpretación**:  
Tercera mejor posición, con bajo acoplamiento como factor clave.

### order_db
**Perfil estructural**:  
- Cohesión excelente (C ≈ 0.9) en el manejo de órdenes  
- Alto acoplamiento (A ≈ 0.6) por múltiples integraciones  
**Distancia**: Compensación interesante - alta cohesión contra mayor acoplamiento operacional.

**Cálculo**:  
```math
DMS = \sqrt{(1 - 0.9)^2 + 0.6^2} = \sqrt{0.01 + 0.36} \approx 0.61
```
**Interpretación**:  
Máxima distancia del sistema, donde su alto acoplamiento pesa más que su buena cohesión.

### payment_db
**Perfil estructural**:  
- Cohesión perfecta (C = 1) al ser single-responsibility  
- Acoplamiento controlado (A ≈ 0.5) solo con order_db  
**Distancia**: Arquitectura óptima, modelo de referencia cercano al ideal teórico.

**Cálculo**: 
```math 
DMS = \sqrt{(1 - 1.0)^2 + 0.5^2} = \sqrt{0 + 0.25} = 0.5
```
**Interpretación**:  
Cohesión perfecta compensa su acoplamiento medio, ubicándolo en posición intermedia.
