Upgrade to Java 21 (LTS)

This project targets Java 21 using Gradle toolchains. These steps help you configure your environment on Windows.

1) Install a JDK 21

- Option A: Install a vendor JDK manually (Adoptium/Temurin, Eclipse, Microsoft Build of OpenJDK, etc.).
  - Download and run the Windows installer for JDK 21.
  - Set JAVA_HOME to the installation path (optional when Gradle auto-download is enabled).

- Option B: Let Gradle auto-download a JDK (requires `org.gradle.java.installations.auto-download=true` in `gradle.properties`).

2) Verify the JDK

Open PowerShell and run:

```powershell
# show java in PATH (if configured)
java -version
# run the Gradle wrapper build which will use the configured toolchain
./gradlew --version
./gradlew build
```

3) Notes

- The project uses Gradle wrapper 8.8 which supports Java 21 toolchains.
- If you see compilation errors related to the Java language level, ensure your JDK 21 installation is available or allow the wrapper to auto-download.
- If you are using CI, ensure the runner provides JDK 21 or allow the Gradle toolchain to download it.

If you want, I can try to run `./gradlew build` locally to validate the change, but I cannot install JDKs on your machine without permission. If you'd like me to attempt a local build in the environment, confirm and I will run it now.