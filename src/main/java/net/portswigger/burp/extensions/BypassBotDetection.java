package net.portswigger.burp.extensions;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BypassBotDetection implements BurpExtension {
    @Override
    public void initialize(MontoyaApi montoyaApi) {
        montoyaApi.extension().setName(Utilities.getResourceString("tool_name"));
        try {
            new Utilities(montoyaApi);
            BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();
            ThreadPoolExecutor taskEngine = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, tasks);
            Utilities.saveTLSSettings();
            montoyaApi.userInterface().registerContextMenuItemsProvider(new TLSContextMenuItemsProvider(taskEngine));
            montoyaApi.logging().logToOutput(Utilities.getResourceString("greetings"));
            montoyaApi.extension().registerUnloadingHandler(()-> {
                Utilities.unloaded.set(true);
                try {
                    taskEngine.getQueue().clear();
                    taskEngine.shutdown();
                }finally {
                    Utilities.loadTLSSettings();
                    Utilities.log("Extension unloaded.");
                }
            });
            // warming up
            Utilities.log(Utilities.getResourceString("loading"));
            String project_settings = Utilities.readResourceForClass("/project_options.json", BypassBotDetection.class);
            SwingUtilities.invokeLater(() -> {
                if(project_settings!=null) {
                    Utilities.importProject(project_settings);
                }
            });
            Utilities.loadTLSSettings();


        } catch (Exception e) {
            montoyaApi.logging().logToError(Utilities.getResourceString("error"));
            montoyaApi.logging().logToError(e.getMessage());
        }
    }
}
