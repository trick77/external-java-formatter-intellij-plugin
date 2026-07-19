package com.github.trick77.externaljavaformatter

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PersistConfigurationServiceTest {

  @Test
  fun configuration_defaults_areSaneOutOfTheBox() {
    val config = PersistConfigurationService.Configuration()

    assertFalse("formatter is opt-in", config.enabled)
    assertTrue("standard-in is the default transport", config.useStandardIn)
    assertEquals("com.google.googlejavaformat.java.Main", config.mainClass)
    assertTrue(
      "default arguments carry the {} placeholder for the filename",
      config.arguments?.contains("{}") == true
    )
  }

  @Test
  fun configuration_defaultClassPath_matchesBundledFormatterJarName() {
    // Guards against drift between the runtime default and the JAR downloaded by build.gradle.kts
    // (configurableJavaFormatVersion in gradle.properties). Update both together on a version bump.
    val config = PersistConfigurationService.Configuration()
    assertEquals("configurable-java-format-1.35.0-fork.1-all-deps.jar", config.classPath)
  }
}
