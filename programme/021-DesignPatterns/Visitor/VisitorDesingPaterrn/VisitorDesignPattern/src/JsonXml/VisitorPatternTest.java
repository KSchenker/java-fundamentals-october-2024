package JsonXml;

public class VisitorPatternTest {

    public static void main(String[] args) {
        // hat Besucher erstellt
        Visitor visitor = new ElementVisitor();

        Document document = new Document("doc-001");
        document.addElement(new JsonElement("json-123"));
        document.addElement(new XmlElement("xml-456"));

        // Alle Elemente im Dokument akzeptieren den Besucher
        // Der Besucher(Visitor) besucht alle Elemente
        document.accept(visitor);
    }
}

