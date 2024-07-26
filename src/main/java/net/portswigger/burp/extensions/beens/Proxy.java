package net.portswigger.burp.extensions.beens;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Proxy {
    private @Expose MatchAndReplace[] match_replace_rules;

    public Proxy(MatchAndReplace[] match_replace_rules) {
        this.match_replace_rules = match_replace_rules;
    }

    public MatchAndReplace[] getMatchReplaceRules() {
        return match_replace_rules;
    }

    public void setMatchReplaceRules(MatchAndReplace[] match_replace_rules) {
        this.match_replace_rules = match_replace_rules;
    }
    public void toggleMatchAndReplace(MatchAndReplace rule){
        List<MatchAndReplace> existing = new ArrayList<>(List.of(this.match_replace_rules));
        Arrays.stream(Browsers.values()).forEach(browser -> {
            Optional<MatchAndReplace> optional = existing.stream().filter(r -> r.filterByBrowser(browser)).findFirst();
            if (optional.isPresent()) {
                MatchAndReplace availableRule = optional.get();
                existing.remove(availableRule);
                availableRule.setEnabled(false);
                existing.add(availableRule);

            }
        });

        Optional<MatchAndReplace> found = existing.stream().filter(r -> r.filterByComment(rule)).findFirst();
        if (found.isEmpty()) {
            existing.add(rule);
        } else {
            MatchAndReplace availableRule = found.get();
            existing.remove(availableRule);
            availableRule.setEnabled(true);
            existing.add(availableRule);
        }
        setMatchReplaceRules(existing.toArray(new MatchAndReplace[0]));
    }
}
