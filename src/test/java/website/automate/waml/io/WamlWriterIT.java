package website.automate.waml.io;

import static java.lang.ClassLoader.getSystemResourceAsStream;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import website.automate.waml.io.model.Scenario;
import website.automate.waml.io.model.action.Action;
import website.automate.waml.io.model.action.ClickAction;

public class WamlWriterIT {

    private WamlWriter writer = new WamlWriter();
    
    @Test
    public void multipleScenariosAreWritten() throws Exception {
        List<Scenario> scenarios = asList(createScenario("scenario-name", "a.link"),
                createScenario("another-scenario-name", "a.link"));
        
        InputStream expectedScenarioStream = getSystemResourceAsStream("./website/automate/waml/io/serialized-multiple-scenario.yaml");
        
        ByteArrayOutputStream actualScenarioStream = new ByteArrayOutputStream();
        writer.write(actualScenarioStream, scenarios);
        
        assertEquals(IOUtils.toString(expectedScenarioStream, "UTF-8"), actualScenarioStream.toString("UTF-8"));
    }
    
    private Scenario createScenario(String name, String actionDefaultCriterionValue){
        Scenario scenario = new Scenario();
        scenario.setName(name);
        ClickAction clickAction = new ClickAction();
        clickAction.setSelector(actionDefaultCriterionValue);
        scenario.setSteps(asList((Action)clickAction));
        return scenario;
    }
}