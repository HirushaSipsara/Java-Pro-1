import javax.swing.*;

class SuccessNotify {
    public static void Saved(){
        // Create and display the success message
        JOptionPane.showMessageDialog(
                null,
                "Contact Number Saved successfully...",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}