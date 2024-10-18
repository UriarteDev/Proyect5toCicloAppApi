# Usar una imagen base de Java
FROM openjdk:17-jdk-alpine

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR generado al contenedor
COPY target/tu-aplicacion.jar /app/tu-aplicacion.jar  # Asegúrate de usar el nombre correcto del archivo JAR

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "/app/tu-aplicacion.jar"]
