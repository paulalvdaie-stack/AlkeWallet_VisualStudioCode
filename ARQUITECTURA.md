# Documentación Técnica - Alke Wallet

## 1. Diagrama de Clases UML

```
┌───────────────────────────────────────────────────┐
│              <<interface>>                        │
│                 Cuenta                            │
├───────────────────────────────────────────────────┤
│ + consultarSaldo(): double                        │
│ + depositar(monto: double): void                  │
│ + retirar(monto: double): void                    │
│ + getTitular(): String                            │
│ + getMoneda(): TipoMoneda                         │
│ + setMoneda(moneda: TipoMoneda): void             │
│ + setSaldo(saldo: double): void                   │
└───────────────┬───────────────────────────────────┘
                │
                │ <<implements>>
                │
┌───────────────▼───────────────────────────────────┐
│              CuentaImpl                           │
├───────────────────────────────────────────────────┤
│ - titular: String                                 │
│ - saldo: double                                   │
│ - moneda: TipoMoneda                              │
├───────────────────────────────────────────────────┤
│ + CuentaImpl(titular: String, moneda: TipoMoneda) │
│ + CuentaImpl(titular: String, moneda: TipoMoneda, │
│              saldoInicial: double)                │
│ + consultarSaldo(): double                        │
│ + depositar(monto: double): void                  │
│ + retirar(monto: double): void                    │
│ + getTitular(): String                            │
│ + getMoneda(): TipoMoneda                         │
│ + setMoneda(moneda: TipoMoneda): void             │
│ + setSaldo(saldo: double): void                   │
│ + toString(): String                              │
└───────────────────────────────────────────────────┘
                │
                │ <<uses>>
                │
                ▼
┌───────────────────────────────────────────────────┐
│             <<enumeration>>                       │
│              TipoMoneda                           │
├───────────────────────────────────────────────────┤
│ CLP("Peso Chileno", "$")                          │
│ USD("Dólar", "US$")                               │
│ EUR("Euro", "€")                                  │
├───────────────────────────────────────────────────┤
│ - nombre: String                                  │
│ - simbolo: String                                 │
├───────────────────────────────────────────────────┤
│ + getNombre(): String                             │
│ + getSimbolo(): String                            │
│ + toString(): String                              │
└───────────────────────────────────────────────────┘


┌───────────────────────────────────────────────────┐
│            <<utility>>                            │
│          ConversionMoneda                         │
├───────────────────────────────────────────────────┤
│ - TASAS_A_USD: Map<TipoMoneda, Double>            │
├───────────────────────────────────────────────────┤
│ + convertir(monto: double, origen: TipoMoneda,    │
│            destino: TipoMoneda): double           │
│ + obtenerTasaCambio(origen: TipoMoneda,           │
│                    destino: TipoMoneda): double   │
│ + mostrarTasas(): String                          │
└───────────────────────────────────────────────────┘


┌───────────────────────────────────────────────────┐
│                   Main                            │
├───────────────────────────────────────────────────┤
│ - scanner: Scanner                                │
│ - cuenta: Cuenta                                  │
├───────────────────────────────────────────────────┤
│ + main(args: String[]): void                      │
│ - mostrarMenu(): void                             │
│ - leerOpcion(): int                               │
│ - crearCuenta(): void                             │
│ - verSaldo(): void                                │
│ - depositarDinero(): void                         │
│ - retirarDinero(): void                           │
│ - convertirMoneda(): void                         │
│ - validarCuenta(): boolean                        │
└───────────────────────────────────────────────────┘
```

## 2. Relaciones entre Clases

### Relaciones de Implementación
- `CuentaImpl` **implements** `Cuenta`
  - CuentaImpl proporciona la implementación concreta de todos los métodos definidos en la interfaz Cuenta

### Relaciones de Dependencia
- `CuentaImpl` **uses** `TipoMoneda`
  - CuentaImpl utiliza TipoMoneda para almacenar el tipo de moneda de la cuenta
  
- `Main` **uses** `Cuenta`, `CuentaImpl`, `TipoMoneda`, `ConversionMoneda`
  - Main es la clase controladora que coordina todas las operaciones

- `ConversionMoneda` **uses** `TipoMoneda`
  - ConversionMoneda necesita TipoMoneda para realizar las conversiones

## 3. Descripción de Clases

### 3.1 Interfaz Cuenta
**Responsabilidad:** Define el contrato para las operaciones básicas de una cuenta de wallet.

**Métodos principales:**
- `consultarSaldo()`: Retorna el saldo actual
- `depositar(monto)`: Añade fondos a la cuenta
- `retirar(monto)`: Retira fondos de la cuenta
- `getTitular()`: Obtiene el nombre del titular
- `getMoneda()`: Obtiene el tipo de moneda
- `setMoneda(moneda)`: Cambia el tipo de moneda
- `setSaldo(saldo)`: Establece un nuevo saldo

**Ventajas del uso de interfaz:**
- Permite múltiples implementaciones
- Facilita pruebas con mocks
- Promueve el principio de inversión de dependencias
- Permite polimorfismo

### 3.2 Clase CuentaImpl
**Responsabilidad:** Implementación concreta de una cuenta de wallet con validaciones.

**Atributos:**
- `titular` (String): Nombre del titular de la cuenta
- `saldo` (double): Saldo actual de la cuenta
- `moneda` (TipoMoneda): Tipo de moneda de la cuenta

**Validaciones implementadas:**
- Los depósitos deben ser mayores a cero
- Los retiros deben ser mayores a cero y menores o iguales al saldo
- El saldo nunca puede ser negativo

### 3.3 Enum TipoMoneda
**Responsabilidad:** Define los tipos de moneda soportados por el sistema.

**Valores:**
- `CLP`: Peso Chileno (símbolo: $)
- `USD`: Dólar Estadounidense (símbolo: US$)
- `EUR`: Euro (símbolo: €)

**Atributos:**
- `nombre`: Nombre completo de la moneda
- `simbolo`: Símbolo de la moneda

### 3.4 Clase ConversionMoneda
**Responsabilidad:** Realiza conversiones entre diferentes tipos de moneda.

**Características:**
- Utiliza tasas de cambio fijas (simplificadas para el proyecto)
- Todas las conversiones pasan por USD como moneda base
- Redondea resultados a 2 decimales

**Tasas de cambio:**
- 1 CLP = 0.0011 USD
- 1 USD = 1.0 USD
- 1 EUR = 1.08 USD

### 3.5 Clase Main
**Responsabilidad:** Clase principal que maneja la interfaz de usuario y coordina las operaciones.

**Funcionalidades:**
- Muestra menú interactivo
- Crea y administra una cuenta
- Permite realizar todas las operaciones de la wallet
- Valida las entradas del usuario

## 4. Patrones de Diseño Utilizados

### 4.1 Strategy Pattern (Patrón Estrategia)
- La interfaz `Cuenta` permite diferentes estrategias de implementación

### 4.2 Utility Class Pattern
- `ConversionMoneda` es una clase utilitaria con métodos estáticos

### 4.3 Enumeration Pattern
- `TipoMoneda` encapsula un conjunto fijo de constantes relacionadas

## 5. Principios SOLID Aplicados

### Single Responsibility Principle (SRP)
- Cada clase tiene una única responsabilidad bien definida
- `CuentaImpl`: Gestiona operaciones de cuenta
- `ConversionMoneda`: Realiza conversiones de moneda
- `Main`: Maneja la interfaz de usuario

### Open/Closed Principle (OCP)
- La interfaz `Cuenta` está abierta a extensión pero cerrada a modificación
- Se pueden crear nuevas implementaciones sin modificar el código existente

### Liskov Substitution Principle (LSP)
- Cualquier implementación de `Cuenta` puede sustituir a otra sin afectar el funcionamiento

### Interface Segregation Principle (ISP)
- La interfaz `Cuenta` contiene solo los métodos esenciales

### Dependency Inversion Principle (DIP)
- `Main` depende de la abstracción `Cuenta`, no de `CuentaImpl`

## 6. Flujo de Operaciones

### Flujo de Depósito
```
1. Usuario selecciona opción "Depositar"
2. Main solicita monto al usuario
3. Main llama a cuenta.depositar(monto)
4. CuentaImpl valida que monto > 0
5. CuentaImpl incrementa el saldo
6. Main muestra confirmación
```

### Flujo de Retiro
```
1. Usuario selecciona opción "Retirar"
2. Main muestra saldo disponible
3. Main solicita monto al usuario
4. Main llama a cuenta.retirar(monto)
5. CuentaImpl valida monto > 0
6. CuentaImpl valida monto <= saldo
7. CuentaImpl decrementa el saldo
8. Main muestra confirmación
```

### Flujo de Conversión
```
1. Usuario selecciona opción "Convertir moneda"
2. Main muestra saldo y moneda actual
3. Main solicita moneda destino
4. Main llama a ConversionMoneda.convertir()
5. ConversionMoneda calcula nuevo saldo
6. Main actualiza moneda y saldo en la cuenta
7. Main muestra resultado de la conversión
```

## 7. Manejo de Excepciones

### IllegalArgumentException
Se lanza en los siguientes casos:
- Intentar depositar un monto negativo o cero
- Intentar retirar un monto negativo o cero
- Intentar retirar más dinero del disponible
- Intentar convertir un monto negativo

### NumberFormatException
Se captura cuando el usuario ingresa valores no numéricos

## 8. Extensibilidad

El diseño actual permite fácilmente:

1. **Agregar nuevas monedas:**
   - Añadir valores al enum `TipoMoneda`
   - Actualizar las tasas en `ConversionMoneda`

2. **Implementar nuevos tipos de cuenta:**
   - Crear nuevas clases que implementen `Cuenta`
   - Por ejemplo: `CuentaAhorro`, `CuentaCorriente`

3. **Agregar nuevas operaciones:**
   - Extender la interfaz `Cuenta`
   - Implementar en `CuentaImpl`

4. **Agregar persistencia:**
   - Crear una capa de repositorio
   - Guardar/cargar cuentas desde archivo o base de datos

5. **Agregar autenticación:**
   - Crear clase `Usuario`
   - Implementar sistema de login

## 9. Mejoras Futuras

- Implementar historial de transacciones
- Agregar transferencias entre cuentas
- Implementar límites de retiro diario
- Agregar autenticación de usuario
- Persistencia de datos en base de datos
- API REST para acceso remoto
- Interfaz gráfica (GUI)
- Notificaciones por email
- Generación de reportes
- Multi-divisa simultánea
