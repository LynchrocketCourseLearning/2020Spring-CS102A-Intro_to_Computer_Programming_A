
public enum Landmark {
    TeachingBuilding(new Library[]{Library.Yidan, Library.Lynn, Library.LearningNexus}),
    ResearchBuilding(new Library[]{Library.Lynn, Library.Yidan, Library.LearningNexus}),
    TaizhouFloor(new Library[]{Library.Lynn, Library.Yidan, Library.LearningNexus}),
    AdministrativeBuilding(new Library[]{Library.Lynn, Library.Yidan, Library.LearningNexus}),
    SUSTechCenter(new Library[]{Library.Yidan, Library.Lynn, Library.LearningNexus}),
    Dormitory(new Library[]{Library.LearningNexus, Library.Yidan, Library.Lynn}),
    Playground(new Library[]{Library.Yidan, Library.LearningNexus, Library.Lynn});

    private final Library[] priority = new Library[]{Library.Yidan, Library.Lynn, Library.LearningNexus};

    Landmark(Library[] priority) {
        for (int i = 0; i < priority.length; i++) {
            this.priority[i] = priority[i];
        }
    }

    public Library[] getPriority() {
        return priority;
    }

//TODO: add your constructor and other methods here
}
