import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileMang extends Student {
    FixedExpense fe = new FixedExpense();
    VariableExpense ve = new VariableExpense();
    String stdpath = "/home/Documentos/summary.txt";
    String expath = "/home/Documentos/summary-expenses.txt";

    public void studentsAdd() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(stdpath, true))) {
            bw.write((byte) idSt);
            bw.newLine();

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

    public void fiexpensesAdd(String name, String description, float value, String payday) throws IOException {
        for (int i = 0; i <= fe.nameList.size(); i++) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(expath, true))) {
                bw.write(fe.idList.get(i));
                bw.newLine();
                bw.write(fe.nameList.get(i));
                bw.newLine();
                bw.write(String.valueOf(fe.valueList.get(i)));
                bw.newLine();
                bw.write(fe.descriptionList.get(i));
                bw.newLine();
                bw.write(fe.paydayList.get(i));
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void vexpensesAdd(String name, String description, float value, byte priority) throws IOException {
        for (int i = 0; i <= ve.nameList.size(); i++) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(expath, true))) {
                bw.write(ve.idList.get(i));
                bw.newLine();
                bw.write(ve.nameList.get(i));
                bw.newLine();
                bw.write(String.valueOf(ve.valueList.get(i)));
                bw.newLine();
                bw.write(ve.descriptionList.get(i));
                bw.newLine();
                bw.write(ve.priorityList.get(i));
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}