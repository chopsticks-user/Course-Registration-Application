package sis.gui.util;

import javafx.scene.Node;

public interface ViewBuilder<T> {
    public T build() throws Exception;
}
