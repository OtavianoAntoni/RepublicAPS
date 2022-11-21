import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

public class FixedExpense extends Expense {
    //private String payday;
    List <String> paydayList = new ArrayList<>();

    FileMang fg = new FileMang();

    public void registerExpense(String name, String description, float value, String payday) throws IOException {
        idList.add(idExp);
        nameList.add(name);
        valueList.add(value);
        descriptionList.add(description);
        paydayList.add(payday);
        idExp += 1;
        fg.fiexpensesAdd(name, description, value, payday);
    }

    public float totalExpensesF() {
        float total = 0;
        for (int r = 0; r <= valueList.size(); r++) {
            total += valueList.get(r);
        }
        return total;
    }

    public List<Byte> getIdList() {
        return super.getIdList();
    }

    public List<String> getNameList() {
        return super.getNameList();
    }

    public List<Float> getValueList() {
        return super.getValueList();
    }

    public List<String> getDescriptionList() {
        return super.getDescriptionList();
    }
}