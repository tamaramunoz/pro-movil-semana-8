# Tarea 8: Servicios Avanzados y Publicación en Android

Este repositorio contiene la aplicación móvil desarrollada para la Semana 8 de la asignatura **Herramientas de Programación Móvil**.

## Objetivo de la Semana
El objetivo principal de esta unidad fue evaluar y comparar las distintas arquitecturas de ejecución de tareas en Android (Servicios en segundo plano, Notificaciones y AppWidgets), implementar una aplicación funcional interactiva desarrollada en Kotlin para resolver necesidades de cálculo técnico e identificar detalladamente el procedimiento para la preparación, refactorización y publicación de aplicaciones móviles en la plataforma Google Play Store.

## Detalles del Proyecto
* **Lenguaje:** Kotlin.
* **Selección de Arquitectura:** Implementación de una `Activity` interactiva síncrona en primer plano. Esta elección se justifica en que las operaciones aritméticas y las conversiones de base numérica son cómputos matemáticos inmediatos que no requieren tareas asíncronas prolongadas en segundo plano ni las restricciones visuales de un `AppWidget` o la naturaleza informativa de una `Notification`.
* **Funcionalidad Principal:** Calculadora técnica desarrollada para la empresa **INGE CORP** que permite realizar conversiones numéricas instantáneas entre el sistema Decimal y el sistema Binario (y viceversa), además de ejecutar operaciones aritméticas de suma y resta en ambos sistemas numéricos con validación de formato.
* **Interfaz de Usuario:** Diseño XML adaptativo estructurado en `ScrollView` para asegurar compatibilidad en diversos tamaños de pantalla, incorporando `ImageView` para el isotipo corporativo, controles `RadioButton` estilizados con tintes personalizados, `EditText` con validaciones de entrada mediante expresiones regulares (Regex) y `TextView` para el despliegue dinámico de resultados.
* **Proceso de Publicación (Google Play Store):** Documentación completa del flujo técnico de despliegue, incluyendo la refactorización del paquete principal para remover prefijos por defecto (`com.example`), la creación de la clave privada (*Keystore* `.jks`), la compilación del instalador firmado en modo *Release* (`.apk` / `.aab`), la configuración de la ficha de la tienda con políticas de privacidad obligatorias y el proceso de revisión en Google Play Console.

## Cómo ejecutar localmente
1. Clonar este repositorio.
2. Abrir la carpeta del proyecto (`Tamara_Munoz_semana8`) utilizando **Android Studio**.
3. Iniciar un emulador virtual desde el **Device Manager** (AVD) o conectar un dispositivo móvil físico habilitando la depuración por USB.
4. Presionar el botón **Run** en la barra superior para compilar e instalar la aplicación en el dispositivo.
5. Generación de ejecutable firmado (Opcional): Para compilar el archivo instalador firmado listo para distribución, ir al menú superior **Build > Generate Signed App Bundle or APK...**, seleccionar el formato deseado, vincular el almacén de claves (`.jks`) y seleccionar la variante de compilación `release`.

## Desarrollado por:
- Tamara Muñoz