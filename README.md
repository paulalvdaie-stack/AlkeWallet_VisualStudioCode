# 💰 Alke Wallet - Billetera Digital (Visual Studio Code)

![Java](https://img.shields.io/badge/Java-21-orange)
![JUnit](https://img.shields.io/badge/JUnit-5.10.1-green)
![Maven](https://img.shields.io/badge/Maven-3.9+-blue)
![VS Code](https://img.shields.io/badge/VS%20Code-Latest-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

## 📋 Descripción

**Alke Wallet** es una aplicación de billetera digital desarrollada en Java que permite a los usuarios gestionar sus activos financieros de manera segura y conveniente. La aplicación implementa principios de Programación Orientada a Objetos (POO) y sigue las mejores prácticas de desarrollo de software.

**Optimizado para Visual Studio Code** con configuraciones preconfiguradas para una experiencia de desarrollo fluida.

### 🎯 Características Principales

- ✅ Crear y administrar cuentas de usuario
- 💵 Consultar saldo disponible en tiempo real
- 📥 Depositar dinero a la cuenta
- 📤 Retirar dinero de la cuenta
- 💱 Convertir saldo entre diferentes monedas (CLP, USD, EUR)
- 🔒 Validaciones de seguridad para todas las operaciones
- ✅ Pruebas unitarias completas con JUnit 5

## 🛠️ Tecnologías Utilizadas

- **Java 21**: Lenguaje de programación principal
- **Maven**: Gestión de dependencias y construcción del proyecto
- **JUnit 5**: Framework para pruebas unitarias
- **Visual Studio Code**: IDE con extensiones de Java preconfiguradas

## 📁 Estructura del Proyecto

```
AlkeWallet_VSCode/
├── .vscode/                           # Configuraciones de VS Code
│   ├── extensions.json                # Extensiones recomendadas
│   ├── launch.json                    # Configuraciones de ejecución
│   ├── settings.json                  # Configuraciones del proyecto
│   └── tasks.json                     # Tareas de Maven
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/alkemy/wallet/
│   │           ├── Main.java          # Clase principal
│   │           ├── model/
│   │           │   ├── Cuenta.java    # Interfaz Cuenta
│   │           │   └── CuentaImpl.java # Implementación
│   │           ├── service/
│   │           │   └── ConversionMoneda.java
│   │           └── util/
│   │               └── TipoMoneda.java
│   └── test/
│       └── java/
│           └── com/alkemy/wallet/
│               ├── model/
│               │   └── CuentaImplTest.java
│               └── service/
│                   └── ConversionMonedaTest.java
├── pom.xml                            # Configuración Maven
├── CONFIGURACION_VSCODE.md            # Guía de configuración
├── INICIO_RAPIDO_VSCODE.md            # Guía de inicio rápido
└── README.md                          # Este archivo
```

## 🚀 Instalación y Configuración

### Prerrequisitos

- Visual Studio Code (última versión)
- Java Development Kit (JDK) 21 o superior
- Maven 3.9 o superior (opcional, puede usar el wrapper)

### Guía Rápida de Instalación

1. **Instalar JDK 21**
   - Windows: https://www.oracle.com/java/technologies/downloads/#java21
   - macOS: `brew install openjdk@21`
   - Linux: `sudo apt install openjdk-21-jdk`

2. **Instalar Visual Studio Code**
   - Descargar desde: https://code.visualstudio.com/

3. **Abrir el proyecto**
   - File → Open Folder → Seleccionar `AlkeWallet_VSCode`
   - VS Code instalará automáticamente las extensiones recomendadas

4. **Esperar sincronización**
   - VS Code sincronizará las dependencias de Maven (1-2 minutos)

Para instrucciones detalladas, ver **[CONFIGURACION_VSCODE.md](CONFIGURACION_VSCODE.md)**

## ▶️ Cómo Ejecutar

### Método 1: Botón Run (Recomendado)

1. Abrir `src/main/java/com/alkemy/wallet/Main.java`
2. Click en el botón **"▶ Run"** que aparece arriba del método `main`
3. La aplicación se ejecutará en el terminal integrado

### Método 2: Debug (F5)

1. Presionar `F5`
2. Seleccionar "Run AlkeWallet"
3. La aplicación se ejecutará en modo debug

### Método 3: Terminal

```bash
# Compilar y ejecutar
mvn clean compile exec:java -Dexec.mainClass="com.alkemy.wallet.Main"
```

## 🧪 Ejecutar Pruebas Unitarias

### Método 1: Testing View (Recomendado)

1. Click en el ícono **🧪 Testing** en la barra lateral
2. Expandir "alke-wallet"
3. Click en **▶️** para ejecutar todas las pruebas
4. Ver resultados en tiempo real

### Método 2: Desde el código

1. Abrir cualquier archivo de prueba (ej: `CuentaImplTest.java`)
2. Click en **"▶ Run Test"** arriba de cada método
3. Ver resultados inmediatamente

### Método 3: Terminal

```bash
mvn test
```

**Resultado esperado:** ✅ 29 pruebas pasan exitosamente

## 📖 Uso de la Aplicación

### Menú Principal

```
╔════════════════════════════════════════╗
║          MENÚ PRINCIPAL                ║
╠════════════════════════════════════════╣
║ 1. Crear cuenta                        ║
║ 2. Ver saldo                           ║
║ 3. Depositar dinero                    ║
║ 4. Retirar dinero                      ║
║ 5. Convertir moneda                    ║
║ 6. Salir                               ║
╚════════════════════════════════════════╝
```

### Ejemplo de Uso

```
1. Crear cuenta → Ingresar nombre → Seleccionar moneda (CLP/USD/EUR)
2. Depositar → Ingresar monto (ej: 50000)
3. Ver saldo → Muestra saldo actual
4. Convertir → Cambiar de CLP a USD
```

## 🏗️ Arquitectura del Proyecto

### Diagrama de Clases Simplificado

```
Cuenta (Interface)
    ↑
    | implements
    |
CuentaImpl ──uses──> TipoMoneda (Enum)
                         ↓
                   ConversionMoneda (Service)
```

### Componentes Principales

- **Cuenta**: Interfaz que define operaciones de la wallet
- **CuentaImpl**: Implementación con validaciones
- **TipoMoneda**: Enum con CLP, USD, EUR
- **ConversionMoneda**: Servicio de conversión de monedas
- **Main**: Controlador con menú interactivo

## 🎯 Características de VS Code

### Configuraciones Preconfiguradas

✅ **Extensiones automáticas**: Se instalan al abrir el proyecto  
✅ **Tasks de Maven**: Ejecutar goals fácilmente  
✅ **Launch configurations**: Run y Debug listos para usar  
✅ **Testing integrado**: Ver y ejecutar pruebas visualmente  
✅ **Encoding UTF-8**: Configurado automáticamente  

### Extensiones Incluidas

Cuando abras el proyecto, VS Code te sugerirá instalar:

- **Extension Pack for Java** (esencial)
- **Maven for Java**
- **Debugger for Java**
- **Test Runner for Java**
- **SonarLint** (análisis de código)
- **Checkstyle** (estilo de código)

## ⌨️ Atajos de Teclado Útiles

| Acción | Windows/Linux | macOS |
|--------|---------------|-------|
| Ejecutar | `F5` | `F5` |
| Abrir archivo | `Ctrl+P` | `Cmd+P` |
| Paleta de comandos | `Ctrl+Shift+P` | `Cmd+Shift+P` |
| Terminal | `` Ctrl+` `` | `` Cmd+` `` |
| Ir a definición | `F12` | `F12` |
| Formatear código | `Shift+Alt+F` | `Shift+Option+F` |
| Autocompletar | `Ctrl+Space` | `Cmd+Space` |

## 📊 Tareas de Maven Disponibles

Presiona `Ctrl+Shift+P` → "Tasks: Run Task":

- **maven: clean** - Limpia el proyecto
- **maven: compile** - Compila el código
- **maven: test** - Ejecuta pruebas
- **maven: package** - Crea JAR ejecutable
- **maven: clean compile** - Limpia y compila
- **maven: clean package** - Limpia y crea JAR

## 📦 Crear JAR Ejecutable

### Usando Task

1. `Ctrl+Shift+P` → "Tasks: Run Task"
2. Seleccionar "maven: package"
3. JAR generado en: `target/alke-wallet-1.0.0.jar`

### Desde Terminal

```bash
mvn clean package
java -jar target/alke-wallet-1.0.0.jar
```

## 🧪 Cobertura de Pruebas

### Estadísticas

- **Total de pruebas**: 29
- **CuentaImplTest**: 15 pruebas
- **ConversionMonedaTest**: 14 pruebas
- **Tasa de éxito**: 100% ✅

### Qué se prueba

✅ Creación de cuentas  
✅ Depósitos válidos e inválidos  
✅ Retiros con validaciones  
✅ Conversiones entre monedas  
✅ Manejo de excepciones  
✅ Operaciones múltiples  

## 🎓 Requerimientos Cumplidos

✅ **Requerimientos Generales:**
- Administración de fondos completa
- Conversión de moneda CLP/USD/EUR

✅ **Requerimientos Técnicos:**
- Java 21 con POO
- Uso de interfaces
- Diagrama de clases
- Pruebas unitarias JUnit 5

✅ **Calidad del Código:**
- Código legible y documentado
- Estructura organizada
- Manejo de excepciones
- Validaciones de seguridad

## 🐛 Depuración (Debugging)

### Establecer Breakpoints

1. Click en el margen izquierdo (junto a números de línea)
2. Aparece círculo rojo

### Ejecutar en Debug

1. Presionar `F5`
2. O: Click en ícono ▶️ → "Start Debugging"

### Controles

- `F5` - Continuar
- `F10` - Step Over
- `F11` - Step Into
- `Shift+F11` - Step Out
- `Shift+F5` - Detener

## ⚡ Solución de Problemas

### "Java not found"

```bash
# Verificar instalación
java -version

# Configurar JAVA_HOME
# Windows: Agregar en Variables de Entorno
# macOS/Linux: Agregar en ~/.bashrc o ~/.zshrc
export JAVA_HOME=/path/to/jdk-21
```

### Maven no sincroniza

1. `Ctrl+Shift+P` → "Java: Clean Java Language Server Workspace"
2. Reload Window
3. O ejecutar: `mvn clean install`

### Extensiones no se instalan

1. `Ctrl+Shift+X` → Buscar "Extension Pack for Java"
2. Click en "Install"
3. Reiniciar VS Code

## 📚 Documentación Adicional

- **[CONFIGURACION_VSCODE.md](CONFIGURACION_VSCODE.md)** - Configuración detallada paso a paso
- **[INICIO_RAPIDO_VSCODE.md](INICIO_RAPIDO_VSCODE.md)** - Empezar en 5 minutos
- **[ARQUITECTURA.md](ARQUITECTURA.md)** - Diseño y diagramas
- **[INFORME_PRUEBAS.md](INFORME_PRUEBAS.md)** - Reporte de pruebas

## 👨‍💻 Autor

**Alkemy Digital**  
Proyecto desarrollado para el Módulo 2 del Bootcamp Android.

## 📄 Licencia

Este proyecto es de uso educativo y está disponible bajo la licencia MIT.

---

## 🔗 Enlaces Útiles

- [VS Code Java Documentation](https://code.visualstudio.com/docs/languages/java)
- [Java 21 Documentation](https://dev.java/learn/)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Maven Getting Started](https://maven.apache.org/guides/getting-started/)

---

**¡Gracias por usar Alke Wallet con VS Code! 💰**
# AndroidStudio_AlkeWallet_VisualStudioCode
# AlkeWallet_VisualStudioCode
# AlkeWallet_VisualStudioCode
# AlkeWallet_VisualStudioCode
# AlkeWallet_VisualStudioCode
