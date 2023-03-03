package br.ada.americanas.jsf.helloworldjsf.weld;

import org.jboss.weld.environment.se.Weld;

public class WeldInstance {

    public static final WeldInstance INSTANCE = new WeldInstance();
    private Weld weld;

    private WeldInstance() {
    }

    public void start() {
        if (weld == null) {
            weld = new Weld();
            weld.initialize();
        }
    }

    public void shutdown() {
        if (weld != null) {
            weld.shutdown();
        }
    }

}
