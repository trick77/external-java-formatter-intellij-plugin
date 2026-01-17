# external-java-format-intellij-plugin

<!-- Plugin description -->
<p>This plugin allows you to integrate any Java formatter into your project.</p>
<p>Unlike other formatters, it uses the project's SDK instead of the IntelliJ VM.
   This solves the problem of formatters being unable to format code that uses a newer SDK.</p>
<p>The configuration panel allows you to select the main class and specify additional parameters.</p>
<p>The default formatter is <a href="https://github.com/MrDolch/configurable-java-format">configurable-java-format</a>,
   which is based on google-java-format but with a line length of 120 characters.</p>
<!-- Plugin description end -->

## Installation

Download the [latest release](https://github.com/trick77/external-java-formatter-intellij-plugin/releases/latest) from GitHub Releases and install it manually using
<kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

---
Forked from [MrDolch/external-java-formatter-intellij-plugin](https://github.com/MrDolch/external-java-formatter-intellij-plugin).

Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template