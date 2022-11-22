import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileMang extends Student {
    FixedExpense fe = new FixedExpense();
    VariableExpense ve = new VariableExpense();
    String stdpath = "/home/otaviano/Documentos/summary.txt";
    String expath = "/home/otaviano/Documentos/summary-expenses.txt";

    public void studentsAdd(String name, String email, float income) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(stdpath, true))) {
            bw.write(name);
            bw.newLine();

            bw.write(email);
            bw.newLine();

            bw.write(String.valueOf(income));
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fiexpensesAdd(String name, String description, float value, String payday) throws IOException {
        for (int i = 0; i <= fe.nameList.size(); i++) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(expath, true))) {
                bw.write(name);
                bw.newLine();
                bw.write(description);
                bw.newLine();
                bw.write(String.valueOf(value));
                bw.newLine();
                bw.write(payday);
                bw.newLine();
                bw.write("-----");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void vexpensesAdd(String name, String description, float value, byte priority) throws IOException {
        for (int i = 0; i < ve.nameList.size(); i++) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(expath, true))) {
                bw.write(name);
                bw.newLine();
                bw.write(description);
                bw.newLine();
                bw.write(String.valueOf(value));
                bw.newLine();
                bw.write(priority);
                bw.newLine();
                bw.write("-----");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}