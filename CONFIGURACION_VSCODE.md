# Guía de Configuración en Visual Studio Code con JDK 21

## 📝 Requisitos Previos

Antes de comenzar, asegúrate de tener instalado:
- Visual Studio Code (última versión)
- JDK 21 (Oracle JDK o OpenJDK)
- Maven (opcional, VS Code puede usar el wrapper incluido)

## 🔧 Instalación de JDK 21

### Windows

1. **Descargar JDK 21:**
   - Ir a: https://www.oracle.com/java/technologies/downloads/#java21
   - Descargar el instalador para Windows (.exe)

2. **Instalar JDK:**
   - Ejecutar el instalador
   - Anotar la ruta de instalación (ej: `C:\Program Files\Java\jdk-21`)

3. **Configurar Variable de Entorno:**
   - Buscar "Variables de entorno" en Windows
   - Click en "Variables de entorno"
   - En "Variables del sistema", buscar `JAVA_HOME`
   - Si no existe, crear nueva:
     - Nombre: `JAVA_HOME`
     - Valor: Ruta del JDK (ej: `C:\Program Files\Java\jdk-21`)
   - Editar `Path`:
     - Agregar: `%JAVA_HOME%\bin`

4. **Verificar instalación:**
   ```cmd
   java -version
   javac -version
   ```

### macOS

1. **Instalar con Homebrew:**
   ```bash
   brew install openjdk@21
   ```

2. **O descargar manualmente:**
   - Ir a: https://www.oracle.com/java/technologies/downloads/#java21
   - Descargar el instalador para macOS (.dmg)
   - Ejecutar el instalador

3. **Configurar JAVA_HOME:**
   ```bash
   echo 'export JAVA_HOME=$(/usr/libexec/java_home -v 21)' >> ~/.zshrc
   echo 'export PATH=$JAVA_HOME/bin:$PATH' >> ~/.zshrc
   source ~/.zshrc
   ```

4. **Verificar:**
   ```bash
   java -version
   ```

### Linux (Ubuntu/Debian)

1. **Instalar OpenJDK 21:**
   ```bash
   sudo apt update
   sudo apt install openjdk-21-jdk
   ```

2. **Configurar JAVA_HOME:**
   ```bash
   echo 'export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64' >> ~/.bashrc
   echo 'export PATH=$JAVA_HOME/bin:$PATH' >> ~/.bashrc
   source ~/.bashrc
   ```

3. **Verificar:**
   ```bash
   java -version
   ```

## 📦 Instalación de Maven (Opcional)

VS Code puede usar el Maven Wrapper incluido en el proyecto, pero puedes instalar Maven globalmente:

### Windows
```cmd
# Con Chocolatey
choco install maven

# O descargar desde: https://maven.apache.org/download.cgi
```

### macOS
```bash
brew install maven
```

### Linux
```bash
sudo apt install maven
```

**Verificar:**
```bash
mvn -version
```

## 🚀 Configuración del Proyecto en VS Code

### Paso 1: Instalar Visual Studio Code

1. Descargar desde: https://code.visualstudio.com/
2. Instalar según tu sistema operativo

### Paso 2: Instalar Extensiones de Java

1. **Abrir VS Code**

2. **Instalar Extension Pack for Java:**
   - Presiona `Ctrl+Shift+X` (Windows/Linux) o `Cmd+Shift+X` (macOS)
   - Buscar: "Extension Pack for Java"
   - Click en "Install"
   - Esta extensión incluye:
     - Language Support for Java
     - Debugger for Java
     - Test Runner for Java
     - Maven for Java
     - Project Manager for Java
     - Visual Studio IntelliCode

3. **Extensiones adicionales recomendadas** (automáticas con el proyecto):
   - SonarLint (análisis de código)
   - Checkstyle (estilo de código)
   - Code Spell Checker (revisar ortografía)

### Paso 3: Abrir el Proyecto

1. **Abrir VS Code**

2. **Abrir carpeta del proyecto:**
   - File → Open Folder (o `Ctrl+K Ctrl+O`)
   - Seleccionar la carpeta `AlkeWallet_VSCode`
   - Click en "Select Folder"

3. **Confiar en la carpeta:**
   - VS Code preguntará si confías en los autores
   - Click en "Yes, I trust the authors"

4. **Esperar la inicialización:**
   - VS Code detectará automáticamente el proyecto Maven
   - Verás una notificación: "A build file was modified. Do you want to synchronize?"
   - Click en "Now" o espera la sincronización automática
   - La barra de estado mostrará "Synchronizing projects..." (puede tardar 1-2 minutos la primera vez)

### Paso 4: Configurar JDK en VS Code

#### Opción 1: Configuración Automática

Si instalaste JDK correctamente con `JAVA_HOME`, VS Code lo detectará automáticamente.

#### Opción 2: Configuración Manual

1. **Abrir configuración:**
   - `Ctrl+,` (Windows/Linux) o `Cmd+,` (macOS)
   - O: File → Preferences → Settings

2. **Buscar "java.jdt.ls.java.home"**

3. **Editar configuración:**
   - Click en "Edit in settings.json"
   - Agregar (reemplazar las rutas según tu instalación):

   **Windows:**
   ```json
   {
       "java.jdt.ls.java.home": "C:\\Program Files\\Java\\jdk-21",
       "java.configuration.runtimes": [
           {
               "name": "JavaSE-21",
               "path": "C:\\Program Files\\Java\\jdk-21",
               "default": true
           }
       ]
   }
   ```

   **macOS:**
   ```json
   {
       "java.jdt.ls.java.home": "/Library/Java/JavaVirtualMachines/jdk-21.jdk/Contents/Home",
       "java.configuration.runtimes": [
           {
               "name": "JavaSE-21",
               "path": "/Library/Java/JavaVirtualMachines/jdk-21.jdk/Contents/Home",
               "default": true
           }
       ]
   }
   ```

   **Linux:**
   ```json
   {
       "java.jdt.ls.java.home": "/usr/lib/jvm/java-21-openjdk-amd64",
       "java.configuration.runtimes": [
           {
               "name": "JavaSE-21",
               "path": "/usr/lib/jvm/java-21-openjdk-amd64",
               "default": true
           }
       ]
   }
   ```

4. **Guardar y recargar:**
   - Presionar `Ctrl+S` para guardar
   - Presionar `Ctrl+Shift+P` → "Java: Clean Java Language Server Workspace"
   - Recargar VS Code: `Ctrl+Shift+P` → "Developer: Reload Window"

### Paso 5: Verificar la Configuración

1. **Abrir la Paleta de Comandos:**
   - `Ctrl+Shift+P` (Windows/Linux) o `Cmd+Shift+P` (macOS)

2. **Escribir y seleccionar:**
   - "Java: Configure Java Runtime"

3. **Verificar:**
   - Debe mostrar JDK 21 como la versión activa
   - El proyecto debe usar JavaSE-21

## ▶️ Ejecutar el Proyecto

### Opción 1: Usando el botón Run

1. Abrir `src/main/java/com/alkemy/wallet/Main.java`
2. Verás un botón "▶ Run" arriba del método `main`
3. Click en "Run"
4. La aplicación se ejecutará en el terminal integrado

### Opción 2: Usando F5 (Debug)

1. Presionar `F5`
2. Seleccionar "Run AlkeWallet" de la lista
3. La aplicación se ejecutará en modo debug

### Opción 3: Usando el panel lateral

1. Click en el ícono de "Run and Debug" (▶️) en la barra lateral izquierda
2. Seleccionar "Run AlkeWallet" del dropdown
3. Click en el botón verde "▶ Start Debugging"

### Opción 4: Desde el Terminal

1. Abrir terminal integrado: `` Ctrl+` `` (backtick)
2. Ejecutar:
   ```bash
   mvn clean compile exec:java -Dexec.mainClass="com.alkemy.wallet.Main"
   ```

## 🧪 Ejecutar Pruebas Unitarias

### Opción 1: Testing View

1. **Abrir Testing View:**
   - Click en el ícono de "Testing" (🧪) en la barra lateral izquierda
   - O presionar `Ctrl+Shift+T`

2. **Ver todas las pruebas:**
   - Expandir "alke-wallet"
   - Verás todas las clases de prueba

3. **Ejecutar pruebas:**
   - Click en ▶️ al lado de "alke-wallet" para ejecutar todas
   - O click en ▶️ al lado de una clase específica
   - O click en ▶️ al lado de un test individual

### Opción 2: Desde el código

1. Abrir una clase de prueba (ej: `CuentaImplTest.java`)
2. Verás botones "▶ Run Test" arriba de cada método `@Test`
3. Click para ejecutar ese test específico
4. O click en "▶ Run Test" arriba de la clase para ejecutar todos

### Opción 3: Usando Maven

1. Abrir terminal: `` Ctrl+` ``
2. Ejecutar:
   ```bash
   mvn test
   ```

### Opción 4: Usando Tasks

1. Presionar `Ctrl+Shift+P`
2. Escribir "Tasks: Run Task"
3. Seleccionar "maven: test"

## 📊 Ver Resultados de Pruebas

- Los resultados aparecen en el panel "Test Results"
- Verde ✅ = Prueba pasó
- Rojo ❌ = Prueba falló
- Amarillo ⚠️ = Prueba omitida

## 🛠️ Tareas de Maven Configuradas

Presiona `Ctrl+Shift+P` → "Tasks: Run Task" para ver todas:

- **maven: clean** - Limpia el proyecto
- **maven: compile** - Compila el código
- **maven: test** - Ejecuta las pruebas
- **maven: package** - Crea el JAR
- **maven: clean compile** - Limpia y compila
- **maven: clean package** - Limpia y crea JAR

## 📦 Crear JAR Ejecutable

### Opción 1: Usando Task

1. `Ctrl+Shift+P` → "Tasks: Run Task"
2. Seleccionar "maven: package"
3. El JAR se creará en `target/alke-wallet-1.0.0.jar`

### Opción 2: Desde terminal

```bash
mvn clean package
```

### Ejecutar el JAR:

```bash
java -jar target/alke-wallet-1.0.0.jar
```

## 🔍 Explorador de Proyectos Java

1. **Abrir Java Projects:**
   - Click en el ícono de "Java Projects" en la barra lateral

2. **Funcionalidades:**
   - Ver estructura de paquetes
   - Dependencias de Maven
   - Librerías referenciadas
   - Archivos de prueba

## ⚙️ Atajos de Teclado Útiles

### Navegación
- `Ctrl+P` - Abrir archivo rápidamente
- `Ctrl+Shift+O` - Ir a símbolo en archivo
- `F12` - Ir a definición
- `Alt+F12` - Ver definición (peek)
- `Shift+F12` - Ver referencias

### Edición
- `Ctrl+Space` - Autocompletar
- `Shift+Alt+F` - Formatear documento
- `Ctrl+/` - Comentar/descomentar línea
- `Ctrl+Shift+K` - Eliminar línea
- `Alt+↑/↓` - Mover línea arriba/abajo

### Ejecución
- `F5` - Iniciar debug
- `Ctrl+F5` - Ejecutar sin debug
- `` Ctrl+` `` - Abrir/cerrar terminal
- `Ctrl+Shift+P` - Paleta de comandos

### Refactoring
- `F2` - Renombrar símbolo
- `Ctrl+.` - Quick Fix (acciones rápidas)

## 📚 Panel de Maven

1. **Abrir panel de Maven:**
   - Click en "MAVEN" en la barra lateral izquierda

2. **Ver ciclo de vida:**
   - Expandir "alke-wallet" → "Lifecycle"
   - Ver: clean, compile, test, package, etc.

3. **Ejecutar goals:**
   - Click derecho en un goal → "Run"

## 🐛 Depuración (Debug)

### Establecer Breakpoints

1. Click en el margen izquierdo del editor (junto a los números de línea)
2. Aparecerá un círculo rojo

### Ejecutar en modo Debug

1. Presionar `F5`
2. O: Run → Start Debugging

### Controles de Debug

- `F5` - Continuar
- `F10` - Step Over (siguiente línea)
- `F11` - Step Into (entrar en método)
- `Shift+F11` - Step Out (salir de método)
- `Shift+F5` - Detener

### Panel de Variables

- Ver valores de variables en tiempo real
- Expandir objetos para ver sus propiedades

## ⚡ Solución de Problemas Comunes

### Problema: Java no detectado

**Solución:**
1. Verificar que JDK 21 esté instalado: `java -version`
2. Configurar `JAVA_HOME` correctamente
3. Reiniciar VS Code
4. `Ctrl+Shift+P` → "Java: Clean Java Language Server Workspace"

### Problema: Maven no funciona

**Solución:**
1. Verificar que Maven esté instalado: `mvn -version`
2. O usar el Maven Wrapper del proyecto:
   - Windows: `.\mvnw.cmd clean compile`
   - macOS/Linux: `./mvnw clean compile`

### Problema: Importaciones no funcionan

**Solución:**
1. `Ctrl+Shift+P` → "Java: Clean Java Language Server Workspace"
2. Reload Window: `Ctrl+Shift+P` → "Developer: Reload Window"
3. Verificar que todas las extensiones de Java estén instaladas

### Problema: Pruebas no aparecen

**Solución:**
1. Abrir Testing View
2. Click en el icono de "Refresh" (🔄)
3. O ejecutar desde terminal: `mvn test`

### Problema: "Cannot resolve symbol"

**Solución:**
1. Esperar a que Maven sincronice dependencias
2. `Ctrl+Shift+P` → "Java: Force Java Compilation"
3. Reiniciar VS Code

### Problema: Encoding incorrecto

**Solución:**
1. Verificar en settings.json:
   ```json
   {
       "files.encoding": "utf8",
       "java.project.encoding": "UTF-8"
   }
   ```

## 🎨 Personalización Adicional

### Temas Recomendados para Java

1. `Ctrl+Shift+P` → "Preferences: Color Theme"
2. Opciones populares:
   - One Dark Pro
   - Dracula Official
   - Material Theme
   - GitHub Theme

### Configuraciones Útiles

Agregar en `settings.json`:

```json
{
    // Auto-guardado
    "files.autoSave": "afterDelay",
    "files.autoSaveDelay": 1000,
    
    // Minimap
    "editor.minimap.enabled": true,
    
    // Breadcrumbs
    "breadcrumbs.enabled": true,
    
    // Format on paste
    "editor.formatOnPaste": true,
    
    // Whitespace
    "editor.renderWhitespace": "boundary"
}
```

## 📖 Recursos Adicionales

- [VS Code Java Documentation](https://code.visualstudio.com/docs/languages/java)
- [Java in VS Code](https://code.visualstudio.com/docs/java/java-tutorial)
- [Maven in VS Code](https://code.visualstudio.com/docs/java/java-build)
- [Debugging in VS Code](https://code.visualstudio.com/docs/java/java-debugging)

## ✅ Checklist de Verificación

- [ ] JDK 21 instalado y verificado
- [ ] VS Code instalado
- [ ] Extension Pack for Java instalado
- [ ] Proyecto abierto en VS Code
- [ ] Maven sincronizó correctamente
- [ ] Main.java se puede ejecutar
- [ ] Todas las pruebas pasan (29/29)
- [ ] No hay errores en el explorador de problemas

---

¡Listo! Ahora tienes VS Code completamente configurado para trabajar con el proyecto Alke Wallet usando JDK 21. 🚀
