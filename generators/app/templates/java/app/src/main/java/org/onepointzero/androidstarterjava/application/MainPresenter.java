package <%= packageName %>.application;

import <%= packageName %>.domain.StarterData;
import <%= packageName %>.domain.StarterDataRepository;

public class MainPresenter {
    private MainScreen screen;

    private StarterDataRepository starterDataRepository;

    public MainPresenter(StarterDataRepository starterDataRepository) {
        this.starterDataRepository = starterDataRepository;
    }

    public void bind(MainScreen screen) {
        this.screen = screen;

        starterDataRepository
                .getStarterData()
                .map(StarterData::getMessage)
                .subscribe(screen::showLabel);
    }
}
