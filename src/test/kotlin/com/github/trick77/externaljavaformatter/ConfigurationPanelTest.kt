package com.github.trick77.externaljavaformatter

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ConfigurationPanelTest {

  @Test
  fun findFirstDiffPos_returnsMinusOneWhenEqual() {
    assertEquals(-1, findFirstDiffPos("same", "same"))
  }

  @Test
  fun findFirstDiffPos_returnsIndexOfFirstDifference() {
    assertEquals(3, findFirstDiffPos("abcXef", "abcYef"))
  }

  @Test
  fun findFirstDiffPos_returnsLengthOfShorterWhenOneIsPrefixOfOther() {
    assertEquals(3, findFirstDiffPos("abc", "abcdef"))
    assertEquals(3, findFirstDiffPos("abcdef", "abc"))
  }

  @Test
  fun findFirstDiffPos_handlesEmptyStrings() {
    assertEquals(0, findFirstDiffPos("", "x"))
    assertEquals(-1, findFirstDiffPos("", ""))
  }

  @Test
  fun findFirstDiffPos_neverExceedsShorterLength() {
    val pos = findFirstDiffPos("hello", "help")
    assertTrue(pos <= "help".length)
    assertEquals(3, pos)
  }
}
