package com.github.trick77.externaljavaformatter

import com.github.trick77.externaljavaformatter.FormattingRequestExecutor.Companion.parseArguments
import com.github.trick77.externaljavaformatter.FormattingRequestExecutor.Companion.parseClassPath
import com.github.trick77.externaljavaformatter.FormattingRequestExecutor.Companion.parseVmOptions
import org.junit.Assert.assertEquals
import org.junit.Test

class FormattingRequestExecutorTest {

  @Test
  fun parseClassPath_splitsOnColonAndSemicolon() {
    assertEquals(listOf("a.jar", "b.jar", "c.jar"), parseClassPath("a.jar:b.jar;c.jar"))
  }

  @Test
  fun parseClassPath_collapsesConsecutiveSeparators() {
    assertEquals(listOf("a.jar", "b.jar"), parseClassPath("a.jar:;:b.jar"))
  }

  @Test
  fun parseClassPath_trimsSurroundingWhitespace() {
    assertEquals(listOf("only.jar"), parseClassPath("  only.jar  "))
  }

  @Test
  fun parseArguments_substitutesPlaceholderWithFilePath() {
    assertEquals(
      listOf("--width=120", "--assume-filename", "/tmp/File.java", "-"),
      parseArguments("--width=120 --assume-filename {} -", "/tmp/File.java")
    )
  }

  @Test
  fun parseArguments_leavesArgumentsWithoutPlaceholderUntouched() {
    assertEquals(listOf("-a", "-b"), parseArguments("-a   -b", "/tmp/File.java"))
  }

  @Test
  fun parseArguments_onlyExactPlaceholderIsSubstituted() {
    // "{}x" is not the exact placeholder token and must be kept verbatim.
    assertEquals(listOf("{}x"), parseArguments("{}x", "/tmp/File.java"))
  }

  @Test
  fun parseVmOptions_splitsOnNewlines() {
    val input = """
      --add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED
      --add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED
    """.trimIndent()
    assertEquals(
      listOf(
        "--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
        "--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED"
      ),
      parseVmOptions(input)
    )
  }

  @Test
  fun parseVmOptions_collapsesBlankLines() {
    assertEquals(listOf("-Xmx256m", "-Dfoo=bar"), parseVmOptions("-Xmx256m\n\n\n-Dfoo=bar"))
  }
}
