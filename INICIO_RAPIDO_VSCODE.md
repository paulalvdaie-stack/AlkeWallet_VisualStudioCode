# 🚀 Guía de Inicio Rápido - Alke Wallet (VS Code)

## ⚡ Empezar en 5 Minutos

### 📥 Paso 1: Verificar Requisitos

Necesitas tener instalado:
- ✅ **JDK 21** → [Descargar aquí](https://www.oracle.com/java/technologies/downloads/#java21)
- ✅ **VS Code** → [Descargar aquí](https://code.visualstudio.com/)

**Verificar instalación de Java:**
```bash
java -version
# Debe mostrar: java version "21..."
```

Si no tienes JDK 21, instálalo primero:

#### Windows
```cmd
# Descargar e instalar desde Oracle
# Luego configurar JAVA_HOME en Variables de Entorno
```

#### macOS
```bash
brew install openjdk@21
```

#### Linux
```bash
sudo apt install openjdk-21-jdk
```

---

### 📂 Paso 2: Abrir en Visual Studio Code

1. **Descargar y extraer** el proyecto `AlkeWallet_VSCode.zip`

2. **Abrir VS Code**

3. **Abrir carpeta:**
   - File → Open Folder
   - Seleccionar la carpeta `AlkeWallet_VSCode`
   - Click en "Select Folder"

4. **Confiar en la carpeta:**
   - VS Code preguntará: "Do you trust the authors?"
   - Click en **"Yes, I trust the authors"**

---

### 🔌 Paso 3: Instalar Extensiones (Automático)

VS Code mostrará una notificación:
```
"This workspace has extension recommendations"
```

**Click en "Install All"** (¡muy importante!)

Esto instalará:
- ✅ Extension Pack for Java
- ✅ Maven for Java
- ✅ Debugger for Java
- ✅ Test Runner for Java

**Espera 30-60 segundos** mientras se instalan las extensiones.

---

### ⏳ Paso 4: Esperar Sincronización de Maven

En la barra de estado (abajo) verás:
```
⏳ Synchronizing projects...
```

**Espera 1-2 minutos** mientras Maven descarga las dependencias.

Cuando termine verás:
```
✅ Sync completed
```

---

### ▶️ Paso 5: Ejecutar el Proyecto

#### Opción A: Botón Run (Más Fácil)

1. Abrir: `src/main/java/com/alkemy/wallet/Main.java`
2. Buscar el método `public static void main`
3. Click en **"▶ Run"** que aparece arriba del método
4. ¡Listo! La aplicación se ejecuta en el terminal

#### Opción B: Presionar F5

1. Presionar `F5`
2. Seleccionar **"Run AlkeWallet"**
3. La aplicación inicia automáticamente

---

### 🧪 Paso 6: Ejecutar Pruebas

#### Método Visual (Recomendado)

1. Click en el ícono **🧪 Testing** en la barra lateral izquierda
2. Expandir **"alke-wallet"**
3. Click en **▶️** al lado de "alke-wallet"
4. ¡Verás las 29 pruebas ejecutándose!

Resultado esperado:
```
✅ CuentaImplTest (15/15 passed)
✅ ConversionMonedaTest (14/14 passed)
Total: 29/29 passed
```

#### Método Terminal

```bash
mvn test
```

---

## 📖 Uso Básico de la Aplicación

### Crear una Cuenta

```
===========================================
    BIENVENIDO A ALKE WALLET
    Tu billetera digital segura
===========================================

╔════════════════════════════════════════╗
║          MENÚ PRINCIPAL                ║
╠════════════════════════════════════════╣
║ 1. Crear cuenta                        ║
...
╚════════════════════════════════════════╝

Seleccione una opción: 1
Ingrese su nombre: Juan Pérez
Seleccione el tipo de moneda:
1. Peso Chileno (CLP)
2. Dólar (USD)
3. Euro (EUR)
Opción: 1

✅ Cuenta creada exitosamente!
```

### Depositar Dinero

```
Seleccione una opción: 3
Ingrese el monto a depositar: 50000

✅ Depósito realizado exitosamente!
Nuevo saldo: CLP ($) 50000.00
```

### Convertir Moneda

```
Seleccione una opción: 5
Saldo actual: CLP ($) 50000.00

Seleccione la moneda destino:
2. Dólar (USD)
Opción: 2

✅ Conversión realizada exitosamente!
Saldo anterior: CLP ($) 50000.00
Nuevo saldo: USD (US$) 55.00
```

---

## 🎯 Estructura del Proyecto (Vista Rápida)

```
AlkeWallet_VSCode/
├── .vscode/              ← Configuraciones de VS Code
│   ├── extensions.json   ← Extensiones recomendadas
│   ├── launch.json       ← Cómo ejecutar/debug
│   ├── settings.json     ← Configuraciones
│   └── tasks.json        ← Tareas de Maven
│
├── src/
│   ├── main/java/        ← Código fuente
│   │   └── com/alkemy/wallet/
│   │       ├── Main.java           ← ¡EJECUTA ESTE!
│   │       ├── model/              ← Clases del modelo
│   │       ├── service/            ← Servicios
│   │       └── util/               ← Utilidades
│   │
│   └── test/java/        ← Pruebas unitarias
│       └── com/alkemy/wallet/
│           ├── model/
│           └── service/
│
└── pom.xml               ← Configuración de Maven
```

---

## ⌨️ Atajos Útiles en VS Code

| Qué hacer | Atajo |
|-----------|-------|
| Ejecutar programa | `F5` |
| Abrir archivo rápido | `Ctrl+P` (Win/Linux) / `Cmd+P` (Mac) |
| Paleta de comandos | `Ctrl+Shift+P` / `Cmd+Shift+P` |
| Abrir/cerrar terminal | `` Ctrl+` `` / `` Cmd+` `` |
| Formatear código | `Shift+Alt+F` / `Shift+Option+F` |
| Ir a definición | `F12` |
| Buscar símbolo | `Ctrl+Shift+O` / `Cmd+Shift+O` |

---

## 🛠️ Tareas Comunes

### Compilar el Proyecto

**Método 1: Task**
1. `Ctrl+Shift+P` → "Tasks: Run Task"
2. Seleccionar **"maven: compile"**

**Método 2: Terminal**
```bash
mvn compile
```

### Limpiar el Proyecto

```bash
mvn clean
```

### Crear JAR Ejecutable

**Método 1: Task**
1. `Ctrl+Shift+P` → "Tasks: Run Task"
2. Seleccionar **"maven: package"**

**Método 2: Terminal**
```bash
mvn clean package
```

El JAR se crea en: `target/alke-wallet-1.0.0.jar`

**Ejecutar el JAR:**
```bash
java -jar target/alke-wallet-1.0.0.jar
```

---

## 🔍 Explorar el Código

### Panel Java Projects

1. Click en el ícono **Java** en la barra lateral
2. Verás:
   - 📦 Paquetes del proyecto
   - 📚 Dependencias de Maven
   - 🧪 Archivos de prueba

### Ver Estructura de una Clase

1. Abrir cualquier archivo `.java`
2. `Ctrl+Shift+O` → Ver todos los métodos
3. Click en un método para ir ahí

---

## 🐛 Debug (Depuración)

### Establecer un Breakpoint

1. Abrir `Main.java`
2. **Click en el margen izquierdo** (junto a los números de línea)
3. Aparece un **círculo rojo** 🔴

### Ejecutar en Modo Debug

1. Presionar `F5`
2. El programa se detendrá en el breakpoint
3. Ver valores de variables en el panel izquierdo

### Controles de Debug

- `F5` = Continuar
- `F10` = Siguiente línea
- `F11` = Entrar en método
- `Shift+F5` = Detener

---

## ⚡ Solución Rápida de Problemas

### Problema: "Java not found"

```bash
# Verificar instalación
java -version

# Si no aparece, instalar JDK 21
```

### Problema: Extensiones no se instalaron

1. `Ctrl+Shift+X` (abrir extensiones)
2. Buscar: **"Extension Pack for Java"**
3. Click en **"Install"**
4. **Reiniciar VS Code**

### Problema: Maven no sincroniza

1. `Ctrl+Shift+P`
2. Escribir: **"Java: Clean Java Language Server Workspace"**
3. Seleccionar **"Restart and delete"**
4. Esperar a que recargue

### Problema: No puedo ejecutar Main.java

1. Verificar que las extensiones de Java estén instaladas
2. Cerrar y abrir VS Code
3. Esperar a que sincronice Maven (barra de estado abajo)
4. Intentar de nuevo

---

## ✅ Checklist de Verificación

- [ ] JDK 21 instalado (`java -version` funciona)
- [ ] VS Code abierto con el proyecto
- [ ] Extensiones de Java instaladas
- [ ] Maven sincronizó dependencias (sin errores en barra de estado)
- [ ] Puedo ejecutar `Main.java` (presionando F5 o botón Run)
- [ ] Las 29 pruebas pasan (Testing view)

---

## 🎉 ¡Estás Listo!

Ahora tienes:
- ✅ Billetera digital funcional
- ✅ Programación Orientada a Objetos
- ✅ Uso de Interfaces
- ✅ 29 Pruebas Unitarias (100% éxito)
- ✅ Validaciones de seguridad
- ✅ VS Code completamente configurado

---

## 📚 Siguiente Paso

Para aprender más sobre el proyecto, lee:

- **[README.md](README.md)** - Documentación completa
- **[CONFIGURACION_VSCODE.md](CONFIGURACION_VSCODE.md)** - Configuración detallada
- **[ARQUITECTURA.md](ARQUITECTURA.md)** - Diseño del sistema
- **[INFORME_PRUEBAS.md](INFORME_PRUEBAS.md)** - Reporte de pruebas

---

## 🆘 ¿Necesitas Ayuda?

1. Revisa **CONFIGURACION_VSCODE.md** para configuración detallada
2. Verifica que JDK 21 esté instalado correctamente
3. Asegúrate de que las extensiones de Java estén instaladas
4. Espera a que Maven sincronice completamente

---

**¡Éxito con tu proyecto Alke Wallet! 💰🚀**
