package bensadon.fruityvice;

import javax.swing.*;
import java.net.URL;
import java.net.MalformedURLException;

public class FruitController {
    private final FruityService fruityService;
    private final JTextField searchField;
    private final JLabel familyValueLabel;
    private final JLabel orderValueLabel;
    private final JLabel genusValueLabel;
    private final JLabel caloriesValueLabel;
    private final JLabel fatValueLabel;
    private final JLabel sugarValueLabel;
    private final JLabel carbsValueLabel;
    private final JLabel proteinValueLabel;
    private final JLabel imageLabel;

    public FruitController(FruityService fruityService,
                           JTextField searchField,
                           JLabel familyValueLabel,
                           JLabel orderValueLabel,
                           JLabel genusValueLabel,
                           JLabel caloriesValueLabel,
                           JLabel fatValueLabel,
                           JLabel sugarValueLabel,
                           JLabel carbsValueLabel,
                           JLabel proteinValueLabel,
                           JLabel imageLabel) {
        this.fruityService = fruityService;
        this.searchField = searchField;
        this.familyValueLabel = familyValueLabel;
        this.orderValueLabel = orderValueLabel;
        this.genusValueLabel = genusValueLabel;
        this.caloriesValueLabel = caloriesValueLabel;
        this.fatValueLabel = fatValueLabel;
        this.sugarValueLabel = sugarValueLabel;
        this.carbsValueLabel = carbsValueLabel;
        this.proteinValueLabel = proteinValueLabel;
        this.imageLabel = imageLabel;
    }

    public void searchFruit() {
        fruityService.getFruit(searchField.getText())
                .subscribeOn(io.reactivex.rxjava3.schedulers.Schedulers.io())
                .observeOn(io.reactivex.rxjava3.schedulers.Schedulers.from(SwingUtilities::invokeLater))
                .subscribe(
                        fruit -> handleResponse(fruit),
                        Throwable::printStackTrace
                );
    }

    private void handleResponse(Fruit fruit) {
        familyValueLabel.setText(fruit.family());
        orderValueLabel.setText(fruit.order());
        genusValueLabel.setText(fruit.genus());

        Nutritions nutritions = fruit.nutritions();
        caloriesValueLabel.setText(String.valueOf(nutritions.calories()));
        fatValueLabel.setText(String.valueOf(nutritions.fat()));
        sugarValueLabel.setText(String.valueOf(nutritions.sugar()));
        carbsValueLabel.setText(String.valueOf(nutritions.carbohydrates()));
        proteinValueLabel.setText(String.valueOf(nutritions.protein()));

        try {
            ImageIcon imageIcon = new ImageIcon(new URL("https://picsum.photos/800/600"));
            imageLabel.setIcon(imageIcon);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}