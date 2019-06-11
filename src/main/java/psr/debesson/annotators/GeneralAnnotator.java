package psr.debesson.annotators;

import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GeneralAnnotator implements Annotator {

    public static final TextAttributesKey NBSP =
            TextAttributesKey.createTextAttributesKey("CUSTOM.NBSP", DefaultLanguageHighlighterColors.KEYWORD);

    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder) {

        if (element instanceof LeafPsiElement) {
            TextAttributesKey kind = null;
            ArrayList<TextRange> ranges = new ArrayList<>();
            if (element.getText().contains(" ")) {
                kind = NBSP;
                int index = element.getText().indexOf(' ');
                int startOffset = element.getTextRange().getStartOffset();
                ranges.add(new TextRange(startOffset + index, startOffset + index + 1));
                while (index >= 0) {
                    index = element.getText().indexOf(' ', index + 1);
                    if (index != -1) {
                        ranges.add(new TextRange(startOffset + index, startOffset + index + 1));
                    }
                }
            }
            if (kind == null) {
                return;
            }
            ranges.forEach((TextRange range) -> {
                final Annotation annotation = holder.createAnnotation(HighlightSeverity.INFORMATION, range, null);
                annotation.setTextAttributes(NBSP);
            });
        }
    }
}

