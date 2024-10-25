package JsonXml;
import java.util.ArrayList;
import java.util.List;


/*TODO                 Visitor-Schnittstelle
*  besucht ein JsonElement. Der Besucher kann den Inhalt des JSON-Elements verarbeiten.
*  besucht ein XmlElement. Sie dient dazu, das XML-Element zu verarbeiten.
*  besucht ein Document.
*  Das Dokument selbst wird bearbeitet, bevor auf die darin enthaltenen Elemente zugegriffen wird.
* */
public interface Visitor {
    void visit(JsonElement je);
    void visit(XmlElement xe);
    void visit(Document doc);
}

/*TODO       Element-Schnittstelle
*  Das  Element bildet die Basis des Visitor-Designmusters.
*  Jedes Element muss in der Lage sein, einen Besucher zu akzeptieren.
*  Daher wird die accept-Methode definiert.
* */
interface Element {
    // akzeptiert einen Besucher.
    // Sobald sie aufgerufen wird, wird die entsprechende visit-Methode des Besuchers für dieses Element ausgeführt.
    void accept(Visitor v);
}

/*TODO
*  implementiert die Element-Schnittstelle und repräsentiert ein Element im JSON-Format.
*  Jedes JsonElement hat eine eindeutige UUID und kann einen Besucher akzeptieren.
* */

class JsonElement implements Element {
    String uuid;

    // Konstruktor für JsonElement
    public JsonElement(String uuid) {
        this.uuid = uuid;
    }
    /*TODO
    *  die Methode, die den Visitor akzeptiert.
    *  Innerhalb dieser Methode wird der Besucher
    *  an die visit-Methode für JsonElement weitergeleitet,
    *  sodass das JSON-Element besucht und verarbeitet werden kann.
    * */

    @Override
    public void accept(Visitor v) {
        // Akzeptiert den Besucher und lässt ihn sich selbst besuchen
        v.visit(this);
    }
}

/*TODO
*  repräsentiert ein Element im XML-Format.
*  Wie das JsonElement implementiert es die Element-Schnittstelle und besitzt eine eindeutige UUID.
* */
class XmlElement implements Element {
    //Ein einzigartiger Kennzeichner für jedes XML-Element
    String uuid;

    // Konstruktor für XmlElement
    public XmlElement(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public void accept(Visitor v) {
        // Akzeptiert den Besucher und lässt ihn sich selbst besuchen
        v.visit(this);
    }
}

/*TODO
*  Document ist sowohl ein Element als auch ein Container für andere Elemente.
*  Ein Dokument kann sowohl JSON- als auch XML-Elemente enthalten.
* */
class Document implements Element {
    List<Element> elements = new ArrayList<>();
    String uuid;

    // Konstruktor für Document
    public Document(String uuid) {
        this.uuid = uuid;
    }

    // Fügt ein Element zum Dokument hinzu
    public void addElement(Element e) {
        elements.add(e);
    }

    @Override
    public void accept(Visitor v) {
        // Akzeptiert zuerst den Besucher selbst
        v.visit(this);
        // Akzeptiert dann den Besucher für alle enthaltenen Elemente
        for (Element e : elements) {
            e.accept(v);
        }
    }
}

//TODO implementiert die Visitor und enthält die Logik, wie jedes Element verarbeitet wird.
class ElementVisitor implements Visitor {

    @Override
    public void visit(XmlElement xe) {
        System.out.println("XML-Element mit UUID wird verarbeitet: " + xe.uuid);
    }

    @Override
    public void visit(JsonElement je) {
        System.out.println("JSON-Element mit UUID wird verarbeitet: " + je.uuid);
    }

    @Override
    public void visit(Document document) {
        System.out.println("Dokument mit UUID wird verarbeitet: " + document.uuid);
    }
}
