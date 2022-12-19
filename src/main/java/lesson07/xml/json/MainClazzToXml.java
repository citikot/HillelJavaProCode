package lesson07.xml.json;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

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