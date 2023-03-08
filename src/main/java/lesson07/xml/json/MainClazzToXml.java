package lesson07.xml.json;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.File;

/**
 * @author spasko
 */
public class MainClazzToXml {
    public static void main(String[] args) {

        Group group = Group.groupExampleCreator();

        try {
            File file = new File("src\\main\\resources\\lesson07\\group.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Group.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(group, file);
            jaxbMarshaller.marshal(group, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}