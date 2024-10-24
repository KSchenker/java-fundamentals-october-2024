import java.util.List;
import java.util.Random;

public abstract class AbstractStoryGenerator {

    // Ein Zufallszahlengenerator.
    private static final Random randomizer = new Random();

    protected abstract List<String> getSubjects();
    protected abstract List<String> getVerbs();
    protected abstract List<String> getObjects();

    public String getStory() {
        List<String> subjects = this.getSubjects();
        String randomSubject = subjects.get(randomizer.nextInt(subjects.size()));
        List<String> verbs = this.getVerbs();
        String randomVerb = verbs.get(randomizer.nextInt(verbs.size()));
        List<String> objects = this.getObjects();
        String randomObject = objects.get(randomizer.nextInt(objects.size()));

        return "%s %s(s) %s".formatted(randomSubject, randomVerb, randomObject);
    }
}

// Hinweis: Eine Klasse, die nicht abstract ist, heißt "konkrete Klasse".
class HorrorStoryGenerator extends AbstractStoryGenerator {

    @Override
    protected List<String> getSubjects() {
        return List.of("Dracula", "Godzilla", "Jason", "Freddy");
    }

    @Override
    protected List<String> getVerbs() {
        return List.of("burn", "kill", "eat", "smash");
    }

    @Override
    protected List<String> getObjects() {
        return List.of("House", "City", "Dog", "Human");
    }
}

class DisneyStoryGenerator extends AbstractStoryGenerator {

    @Override
    protected List<String> getSubjects() {
        return List.of("Merlin", "Mickey Mouse", "Goofy", "Dagobert Duck");
    }

    @Override
    protected List<String> getVerbs() {
        return List.of("laughs at", "smiles at", "hug", "speaks to");
    }

    @Override
    protected List<String> getObjects() {
        return List.of("Miss Piggy", "Ariel", "Variana", "Bowser");
    }
}
