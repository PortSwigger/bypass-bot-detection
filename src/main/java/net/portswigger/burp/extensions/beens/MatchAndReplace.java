package net.portswigger.burp.extensions.beens;

import com.google.gson.annotations.Expose;
import net.portswigger.burp.extensions.Constants;

public class MatchAndReplace {
    private @Expose String comment;
    private @Expose boolean enabled;
    private @Expose boolean is_simple_match;
    private @Expose String rule_type;
    private @Expose String string_match;
    private @Expose String string_replace;

    public MatchAndReplace(String comment, boolean enabled, boolean is_simple_match, String rule_type, String string_match, String string_replace) {
        this.comment = comment;
        this.enabled = enabled;
        this.is_simple_match = is_simple_match;
        this.rule_type = rule_type;
        this.string_match = string_match;
        this.string_replace = string_replace;
    }

    public static MatchAndReplace create(Browsers browser){
        return new MatchAndReplace(
                String.format("Emulate %s User-Agent", browser.name),
                true,
                false,
                Constants.MATCH_AND_REPLACE_RULE_TYPE,
                Constants.MATCH_AND_REPLACE_REGEXP,
                Constants.BROWSERS_USER_AGENTS.get(browser.name)
        );
    }
    public boolean filterByComment(MatchAndReplace filter) {
        return this.comment.equalsIgnoreCase(filter.comment);
    }
    public boolean filterByBrowser(Browsers browser) {
        return this.comment != null && this.comment.equalsIgnoreCase(String.format("Emulate %s User-Agent", browser.name));
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
