package com.simbirsoft.qaa.course.task2.helpers;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;

public class ClipboardHelper {

    public static String StringFromClipboard() throws UnsupportedFlavorException, IOException {
        Transferable trans = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        return (String) trans.getTransferData(DataFlavor.stringFlavor);
    }

    public static void StringToClipboard(String clipboardText) {
        StringSelection stringSelection = new StringSelection(clipboardText);
        Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipBoard.setContents(stringSelection, null);
    }
}
