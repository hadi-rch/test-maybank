# --- Tahap 1: Build ---
# Menggunakan image Maven yang berisi JDK untuk meng-compile aplikasi
FROM maven:3.8.5-openjdk-17 AS build

# Menentukan direktori kerja di dalam container
WORKDIR /app

# Copy file pom.xml terlebih dahulu untuk memanfaatkan cache Docker
COPY pom.xml .
# Download semua dependency
RUN mvn dependency:go-offline

# Copy sisa source code aplikasi
COPY src ./src

# Jalankan proses build dan package menjadi JAR file
RUN mvn package -DskipTests

# --- Tahap 2: Run ---
# Menggunakan image Java Runtime Environment (JRE) yang lebih kecil untuk menjalankan aplikasi
FROM eclipse-temurin:17-jre-jammy

# Menentukan direktori kerja
WORKDIR /app

# Copy file JAR yang sudah di-build dari tahap sebelumnya
COPY --from=build /app/target/*.jar app.jar

# Expose port yang digunakan oleh Spring Boot (default: 8080)
EXPOSE 8080

# Perintah untuk menjalankan aplikasi saat container dimulai
ENTRYPOINT ["java", "-jar", "app.jar"]