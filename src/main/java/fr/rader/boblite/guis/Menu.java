package fr.rader.boblite.guis;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import fr.rader.boblite.BobLite;
import fr.rader.boblite.listeners.menu.ChangeTimeListener;
import fr.rader.boblite.listeners.menu.GoListener;

import javax.swing.*;
import java.awt.*;

public class Menu {

    private final JDialog dialog;

    private JPanel panel;

    private JLabel removeRainLabel;
    private JLabel changeTimeLabel;
    private JLabel newTimeLabel;
    private JLabel removeChatLabel;

    private JCheckBox removeRainCheckBox;
    private JCheckBox changeTimeCheckBox;
    private JCheckBox removeChatCheckBox;

    private JSpinner newTimeSpinner;

    private JButton goButton;

    private boolean goPressed = false;

    public Menu() {
        // create the frame (it's a dialog to pause the execution until it's closed)
        dialog = new JDialog(null, "Bob", Dialog.ModalityType.DOCUMENT_MODAL);
        // setting up the ui
        // this was generated by IJ
        $$$setupUI$$$();

        dialog.setIconImage(BobLite.BOB_LOGO);

        // setting the size to a relatively good size
        dialog.setSize(300, 200);
        // setting the content of the dialog to the panel IJ built
        dialog.setContentPane(panel);
        // center the frame on the screen
        dialog.setLocationRelativeTo(null);
        // dispose of the dialog when closing the window
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // set up the actions
        setComponentActionListener();
    }

    private void setComponentActionListener() {
        // this changes the newTimeSpinner enabled state when changeTimeCheckBox
        // is checked or not
        changeTimeCheckBox.addActionListener(new ChangeTimeListener(this));

        // this just changes the goPressed boolean to true
        // and dispose of the dialog
        goButton.addActionListener(new GoListener(this));
    }

    /**
     * Determines whether Bob can edit the replay or not
     *
     * @return true if the user wants to edit the replay<br>
     * false otherwise
     */
    public boolean wasGoPressed() {
        return goPressed;
    }

    /**
     * Allows parts of the code to get the JDialog
     *
     * @return the current JDialog
     */
    public JDialog getDialog() {
        return dialog;
    }

    /**
     * Change the state of the variable that tells Bob
     * whether it can edit the replay or not
     *
     * @param goPressed the boolean's new state
     */
    public void setGoPressed(boolean goPressed) {
        this.goPressed = goPressed;
    }

    /**
     * Tells Bob if the rain has to be removed
     *
     * @return true if removeRainCheckBox is selected<br>
     * false otherwise
     */
    public boolean isRemoveRainChecked() {
        return removeRainCheckBox.isSelected();
    }

    /**
     * Tells Bob if the time has to be changed
     *
     * @return true if changeTimeCheckBox is selected<br>
     * false otherwise
     */
    public boolean isChangeTimeChecked() {
        return changeTimeCheckBox.isSelected();
    }

    /**
     * Tells Bob if the chat has to be removed
     *
     * @return true if removeChatCheckBox is selected<br>
     * false otherwise
     */
    public boolean isRemoveChatChecked() {
        return removeChatCheckBox.isSelected();
    }

    /**
     * Get the new time for the replay
     *
     * @return the spinner value, the value is inside [-24000; 24000]
     */
    public int getNewTime() {
        return (int) newTimeSpinner.getValue();
    }

    /**
     * Allows parts of the code to get the newTimeSpinner
     *
     * @return the new time spinner
     */
    public JSpinner getNewTimeSpinner() {
        return newTimeSpinner;
    }

    /**
     * Show the dialog on the screen
     */
    public void show() {
        dialog.setVisible(true);
    }

    private void createUIComponents() {
        // we set a limit to the spinner
        // we can't go above 24000 or below -24000
        newTimeSpinner = new JSpinner(
                new SpinnerNumberModel(
                        -1000,
                        -24000,
                        24000,
                        1
                )
        );
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        panel = new JPanel();
        panel.setLayout(new GridLayoutManager(5, 2, new Insets(0, 0, 0, 0), -1, -1));
        removeRainCheckBox = new JCheckBox();
        removeRainCheckBox.setEnabled(true);
        removeRainCheckBox.setSelected(true);
        removeRainCheckBox.setText("");
        panel.add(removeRainCheckBox, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        removeRainLabel = new JLabel();
        removeRainLabel.setText("Remove Rain");
        panel.add(removeRainLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        changeTimeLabel = new JLabel();
        changeTimeLabel.setText("Change Time");
        panel.add(changeTimeLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        changeTimeCheckBox = new JCheckBox();
        changeTimeCheckBox.setSelected(true);
        changeTimeCheckBox.setText("");
        panel.add(changeTimeCheckBox, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(18, 17), null, 0, false));
        newTimeLabel = new JLabel();
        newTimeLabel.setText("New Time (in ticks):");
        panel.add(newTimeLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        goButton = new JButton();
        goButton.setText("Go!");
        panel.add(goButton, new GridConstraints(4, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel.add(newTimeSpinner, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        removeChatLabel = new JLabel();
        removeChatLabel.setText("Remove Chat");
        panel.add(removeChatLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        removeChatCheckBox = new JCheckBox();
        removeChatCheckBox.setText("");
        panel.add(removeChatCheckBox, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }

}
