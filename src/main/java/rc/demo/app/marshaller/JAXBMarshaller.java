package rc.demo.app.marshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class JAXBMarshaller<T> {

    public String marshall(T object) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        StringWriter stringWriter = new StringWriter();
        jaxbMarshaller.marshal(object, stringWriter);

        return stringWriter.toString();
    }
}
