package net.portswigger.burp.extensions;

import burp.api.montoya.MontoyaApi;
import burp.api.montoya.core.ToolType;
import burp.api.montoya.http.message.HttpRequestResponse;
import burp.api.montoya.ui.contextmenu.ContextMenuEvent;
import burp.api.montoya.ui.contextmenu.ContextMenuItemsProvider;
import burp.api.montoya.ui.contextmenu.MessageEditorHttpRequestResponse;
import net.portswigger.burp.extensions.beens.Browsers;
import net.portswigger.burp.extensions.beens.MatchAndReplace;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class TLSContextMenuItemsProvider implements ContextMenuItemsProvider {
    private ThreadPoolExecutor taskEngine;

    public TLSContextMenuItemsProvider(ThreadPoolExecutor taskEngine) {
        this.taskEngine = taskEngine;
    }

    @Override
    public List<Component> provideMenuItems(ContextMenuEvent contextMenuEvent) {
        if (contextMenuEvent.isFromTool(ToolType.LOGGER, ToolType.PROXY, ToolType.TARGET, ToolType.ORGANIZER)) {

            List<Component> menuItemList = new ArrayList<>();
            List<HttpRequestResponse> requestResponses = new ArrayList<>();

            if(contextMenuEvent.messageEditorRequestResponse().isPresent()) {
                MessageEditorHttpRequestResponse message = contextMenuEvent.messageEditorRequestResponse().get();
                requestResponses.add(message.requestResponse());
                String negotiation = Utilities.getComment(message.requestResponse());
                if(negotiation != null) {
                    JMenuItem negotiationItem = new JMenuItem(Utilities.getResourceString("negotiation"));
                    negotiationItem.addActionListener(e -> addManualSettings(negotiation));
                    menuItemList.add(negotiationItem);
                }
            } else {
                requestResponses = contextMenuEvent.selectedRequestResponses();
            }

            Arrays.stream(Browsers.values()).forEach(
                    browser -> {
                        JMenuItem item = new JMenuItem(browser.name);
                        item.addActionListener(e -> addTLSCiphers(browser));
                        menuItemList.add(item);
                    }
            );
            String menuLabel = Utilities.enabledHTTPDowngrade() ? "Enable " : "Disable ";
            JMenuItem downgradeMenu = new JMenuItem(menuLabel + Utilities.getResourceString("menu_downgrade"));
            downgradeMenu.addActionListener(e -> downgradeHttp());
            menuItemList.add(downgradeMenu);

            JMenuItem item = new JMenuItem(Utilities.getResourceString("menu_brute_force"));
            item.addActionListener(new TriggerCipherGuesser(taskEngine, requestResponses));
            menuItemList.add(item);


            return menuItemList;
        }

        return null;
    }

    public void downgradeHttp(){
        Utilities.updateHTTPSettings();
    }
    public void addTLSCiphers(Browsers browser){
        Utilities.updateTLSSettingsSync(Constants.BROWSERS_PROTOCOLS.get(browser.name), Constants.BROWSERS_CIPHERS.get(browser.name));
        Utilities.updateProxySettingsSync(MatchAndReplace.create(browser));
    }
    public void addManualSettings(String negotiation){
        Utilities.montoyaApi.burpSuite().importProjectOptionsFromJson(negotiation);
    }
}
