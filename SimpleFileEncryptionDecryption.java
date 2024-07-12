import java.io.*;

public class SimpleFileEncryptionDecryption {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("File Encryption/Decryption Program");
            System.out.print("Enter 'encrypt' or 'decrypt': ");
            String mode = reader.readLine().trim().toLowerCase();

            if (!mode.equals("encrypt") && !mode.equals("decrypt")) {
                System.out.println("Invalid mode. Please enter 'encrypt' or 'decrypt'.");
                return;
            }

            System.out.print("Enter input file path: ");
            String inputFile = reader.readLine().trim();

            System.out.print("Enter output file path: ");
            String outputFile = reader.readLine().trim();

            System.out.print("Enter encryption/decryption key (shift amount): ");
            int key = Integer.parseInt(reader.readLine().trim());

            if (mode.equals("encrypt")) {
                encryptFile(inputFile, outputFile, key);
                System.out.println("File encrypted successfully.");
            } else {
                decryptFile(inputFile, outputFile, key);
                System.out.println("File decrypted successfully.");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void encryptFile(String inputPath, String outputPath, int key) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                char encryptedChar = (char) (ch + key);
                writer.write(encryptedChar);
            }
        }
    }

    public static void decryptFile(String inputPath, String outputPath, int key) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                char decryptedChar = (char) (ch - key);
                writer.write(decryptedChar);
            }
        }
    }
}
