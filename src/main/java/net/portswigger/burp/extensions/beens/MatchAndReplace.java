package net.portswigger.burp.extensions.beens;

import com.google.gson.annotations.Expose;
import net.portswigger.burp.extensions.Constants;

import java.util.*;

import static net.portswigger.burp.extensions.Constants.*;

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

    public static List<MatchAndReplace> createDowngradeRules(){
        List<MatchAndReplace> rules = new ArrayList<>();
        for(String header : MATCH_AND_REPLACE_REGEXP_HTTP2) {
            rules.add(new MatchAndReplace(
                    String.format("HTTP2 Header %s downgrade rule", header),
                    true,
                    false,
                    Constants.MATCH_AND_REPLACE_RULE_TYPE,
                    header,
                    ""
            ));
        }
        return rules;
    }

    public static MatchAndReplace create(Browsers browser){
        String platform = System.getProperty("os.name","Windows");
        OS optionalOS = Arrays.stream(OS.values()).filter(os -> platform.contains(os.name)).findFirst().get();
        String format = BROWSERS_USER_AGENTS.get(browser.name);
        String value = BROWSERS_PLATFORMS.get(browser.name).get(optionalOS.name);
        return new MatchAndReplace(
                String.format("Emulate %s User-Agent", browser.name),
                true,
                false,
                Constants.MATCH_AND_REPLACE_RULE_TYPE,
                Constants.MATCH_AND_REPLACE_REGEXP,
                String.format(format,value)
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
