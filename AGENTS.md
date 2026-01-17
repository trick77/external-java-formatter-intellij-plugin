# AGENTS.md

This file provides guidance to agentic coding tools when working with code in this repository.

## Build Commands

```bash
# Build the plugin
./gradlew build

# Run tests
./gradlew test

# Run the plugin in a sandbox IDE for manual testing
./gradlew runIde

# Run IDE with UI test support
./gradlew runIdeForUiTests

# Verify plugin compatibility with IDEs
./gradlew verifyPlugin

# Check code quality
./gradlew check
```

## Architecture Overview

This is an IntelliJ Platform plugin that integrates external Java formatters (like google-java-format) into the IDE. The key design decision is that it uses the **project's SDK** to run the formatter, not the IDE's JVM - this allows formatting code that uses newer Java syntax.

### Core Components

- **ExternalJavaFormatter** (`ExternalJavaFormatter.kt`): Implements `AbstractDocumentFormattingService`. Entry point that IntelliJ calls when formatting Java files. Checks if formatting is enabled and a project SDK is configured, then delegates to `FormattingRequestExecutor`.

- **FormattingRequestExecutor** (`FormattingRequestExecutor.kt`): Builds and executes the external formatter process. Creates a `GeneralCommandLine` using `SimpleJavaParameters` with the project SDK. Handles both stdin-based input and file-based input modes. Updates the document on completion via `DocumentMerger`.

- **PersistConfigurationService** (`PersistConfigurationService.kt`): Project-level persistent state for formatter settings (enabled, classpath, main class, arguments, VM options, etc.). Settings stored in `external-java-formatter.xml`.

- **ConfigurationPanel** (`ConfigurationPanel.kt`): Settings UI under Project Settings. Provides a "Test" button to validate formatter configuration.

### How Formatting Works

1. IntelliJ calls `ExternalJavaFormatter.canFormat()` - returns true if file is Java, project has SDK, and plugin is enabled
2. `formatDocument()` queues an async background task (or runs synchronously in headless mode)
3. `FormattingRequestExecutor` spawns external JVM process using project SDK with configured classpath/main class
4. Formatter output replaces document content via write action

### Default Configuration

The plugin ships with `configurable-java-format` (google-java-format variant with 120-char line width) bundled in `src/main/resources/lib/`. The default main class is `com.google.googlejavaformat.java.Main`.
