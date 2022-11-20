import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileMang extends Student{
    String stdpath = "/home/Documentos/summary.txt";
    String expath = "/home/Documentos/summary.txt";
    
    public void studentsAdd() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(stdpath, true))) {
            bw.write(name);
            bw.newLine();

            bw.write(email);
            bw.newLine();

            bw.write((byte) income);
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void expensesAdd() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(expath, true))) {
            bw.write();
        }
    }
}
