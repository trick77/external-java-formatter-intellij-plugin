# external-java-format-intellij-plugin

![Build](https://github.com/trick77/external-java-formatter-intellij-plugin/workflows/Build/badge.svg)

<!-- Plugin description -->
<p>This plugin enables the integration of any Java formatter into the project.</p>
<p>Unlike other formatters, the SDK of the project is used instead of the Intellij VM when the formatter is called.
   This solves the problem where formatters could not format code from a newer SDK.</p>
<p>The configuration panel allows you to select the main class and specify further parameters.</p>
<p>The <a href="https://github.com/MrDolch/configurable-java-format">configurable-java-format</a> formatter, based on
   the google-java-format style but with a line length of 120 characters, is set as the default setting.</p>
<!-- Plugin description end -->

## Installation

Download the [latest release](https://github.com/trick77/external-java-formatter-intellij-plugin/releases/latest) from GitHub Releases and install it manually using
<kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

---
Forked from [MrDolch/external-java-formatter-intellij-plugin](https://github.com/MrDolch/external-java-formatter-intellij-plugin).

Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template