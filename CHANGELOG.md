<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# external-java-format-intellij-plugin Changelog

## [1.0.14]

- Fix nullable Boolean properties for type safety
- Add safe SDK null check to prevent NPE in formatDocument
- Add exception logging for formatting failures
- Fix process not destroyed on timeout
- Pre-compile regex patterns for better performance
- Replace JOptionPane with IntelliJ Messages API
- Remove duplicate application variable
