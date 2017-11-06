package com.tutorialspoint.configurationtest;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by gu on 2017/11/6.
 */
public class TextEditorTest {

    @Test
    public void spellCheckTest() {
        SpellChecker mockSpellChecker = Mockito.mock(SpellChecker.class);
        TextEditor textEditor = new TextEditor(mockSpellChecker);
        textEditor.spellCheck();
        Mockito.verify(mockSpellChecker, Mockito.times(1)).checkSpelling();
    }
}