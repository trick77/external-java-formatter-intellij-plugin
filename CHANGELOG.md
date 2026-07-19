<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# external-java-formatter-intellij-plugin Changelog

## [Unreleased]

## [1.1.0]

- Build against IntelliJ Platform 2025.2.6.2 (was 2024.2.5); verified compatible from 2023.3 to 2025.2

- Update the default formatter to configurable-google-java-format 1.35.0-fork.1

- Use a Java 21 toolchain so test classes and the test runtime stay on Java 21 (fixes the build after the Kotlin 2.4 upgrade, which emitted Java 25 test bytecode)

- Add unit tests for command-line argument parsing, classpath/VM-option splitting, and diff-position logic
- Remove unused Checkstyle plugin and CI job (no Java sources to lint)
- Run IntelliJ Plugin Verifier in the Check Build workflow
- Remove leftover template scaffolding and duplicate CI workflows
- Fix stale plugin name and default-formatter link in README
- Align `pluginGroup` with the plugin id and package name

## [1.0.14]

- Use Java 25 toolchain with Java 21 bytecode compatibility
- Fix nullable Boolean properties for type safety
- Add safe SDK null check to prevent NPE in formatDocument
- Add exception logging for formatting failures
- Fix process not destroyed on timeout
- Pre-compile regex patterns for better performance
- Replace JOptionPane with IntelliJ Messages API
- Remove duplicate application variable
