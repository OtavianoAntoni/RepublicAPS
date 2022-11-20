import java.util.List;
import java.util.ArrayList;

//interface class made for make sure VariableExpense and FixedExpense uses sames attributes
abstract class Expense {
    
    protected byte idExp = 0;
    protected String name;
    protected float value;
    protected String description;
    //array list containing information about new expense declared   
    List <Byte> idList = new ArrayList<>(); 
    List <String> nameList = new ArrayList<>();
    List <Float> valueList = new ArrayList<>();
    List <String> descriptionList = new ArrayList<>();

    //blank constructor
    public void registerExpense(){
    }

    public List<Byte> getIdList() {
        return idList;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public List<Float> getValueList() {
        return valueList;
    }

    public List<String> getDescriptionList() {
        return descriptionList;
    }

    
}