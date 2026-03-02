# Use an official JDK runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine [cite: 155]

# Set the working directory inside the container
WORKDIR /app [cite: 156]

# Copy the compiled JAR file from the target folder to the container
COPY target/*.jar app.jar [cite: 157]

# Run the JAR file
ENTRYPOINT ["java","-jar","app.jar"] [cite: 158]