package website.automate.waml.io.model.action;

public class EnterAction extends ElementStoreAction {

    private String input;
    
    private String clear;
    
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getClear() {
        return clear;
    }

    public void setClear(String clear) {
        this.clear = clear;
    }
    
    @Override
    public boolean canBeShortNotated(){
        return input == null
                && clear == null
                && super.canBeShortNotated();
    }
}
