package rc.demo.app.unmarshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class JAXBUnMarshaller<T> {

    public Object unMarshall(String jsonString, Class<T> type) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(type);
        Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();

        return jaxbUnMarshaller.unmarshal(new StringReader(jsonString));
    }
}
