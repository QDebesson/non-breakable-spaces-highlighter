package psr.debesson.settings;

import com.intellij.icons.AllIcons;
import com.intellij.lang.Language;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.psi.codeStyle.DisplayPriority;
import com.intellij.psi.codeStyle.DisplayPrioritySortable;
import com.intellij.util.PlatformUtils;
import psr.debesson.annotators.GeneralAnnotator;
import gnu.trove.THashMap;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.Icon;
import java.util.Map;

public class GeneralColorSettings implements ColorSettingsPage, DisplayPrioritySortable {
    @NonNls
    static final AttributesDescriptor[] GENERAL_ATTRIBUTES;
    @NonNls
    static final Map<String, TextAttributesKey> GENERAL_DESCRIPTORS = new THashMap<>();

    private static final TextAttributesKey NBSP = GeneralAnnotator.NBSP;

    static {
        GENERAL_ATTRIBUTES = new AttributesDescriptor[]{
                new AttributesDescriptor("Character: ' ' (non breaking space)", NBSP),
        };
        GeneralColorSettings.GENERAL_DESCRIPTORS.putAll(GeneralColorSettings.createAdditionalHlAttrs());
    }

    private static Map<String, TextAttributesKey> createAdditionalHlAttrs() {
        final Map<String, TextAttributesKey> descriptors = new THashMap<>();
        descriptors.put("nbsp", NBSP);
        return descriptors;
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return AllIcons.FileTypes.Any_type;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return SyntaxHighlighterFactory.getSyntaxHighlighter(Language.ANY, null, null);
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "NBSP: ' '.";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return GENERAL_DESCRIPTORS;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return GENERAL_ATTRIBUTES;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "General Additions";
    }

    @Override
    public DisplayPriority getPriority() {
        return PlatformUtils.isIntelliJ() ? DisplayPriority.KEY_LANGUAGE_SETTINGS : DisplayPriority.LANGUAGE_SETTINGS;
    }
}
