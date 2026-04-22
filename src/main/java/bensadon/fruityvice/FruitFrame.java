package bensadon.fruityvice;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FruitFrame extends JFrame {

    public FruitFrame() {
        setSize(800, 600);
        setTitle("FruityVice");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());

        JTextField searchField = new JTextField();

        JButton searchButton = new JButton("Search");

        JLabel pictureLabel = new JLabel("Pic", SwingConstants.CENTER);
        pictureLabel.setBorder(new LineBorder(Color.BLACK));
        pictureLabel.setPreferredSize(new Dimension(200, 300));

        final JLabel familyTitleLabel = new JLabel("Family");
        final JLabel orderTitleLabel = new JLabel("Order");
        final JLabel genusTitleLabel = new JLabel("Genus");
        final JLabel caloriesTitleLabel = new JLabel("Calories");
        final JLabel fatTitleLabel = new JLabel("Fat");
        final JLabel sugarTitleLabel = new JLabel("Sugar");
        final JLabel carbsTitleLabel = new JLabel("Carbs");
        final JLabel proteinTitleLabel = new JLabel("Proteins");

        JLabel familyValueLabel = new JLabel("");
        JLabel orderValueLabel = new JLabel("");
        JLabel genusValueLabel = new JLabel("");
        JLabel caloriesValueLabel = new JLabel("");
        JLabel fatValueLabel = new JLabel("");
        JLabel sugarValueLabel = new JLabel("");
        JLabel carbsValueLabel = new JLabel("");
        JLabel proteinValueLabel = new JLabel("");

        FruitController fruitController = new FruitController(
                new FruityServiceFactory().create(),
                searchField,
                familyValueLabel,
                orderValueLabel,
                genusValueLabel,
                caloriesValueLabel,
                fatValueLabel,
                sugarValueLabel,
                carbsValueLabel,
                proteinValueLabel,
                pictureLabel
        );

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fruitController.searchFruit();
            }
        });
        GridBagConstraints constraints;


        // row 0 search field
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(searchField, constraints);

        // row 0 search button
        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(searchButton, constraints);

        // picture on left
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 8;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        add(pictureLabel, constraints);

        // row 1
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(familyTitleLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(familyValueLabel, constraints);

        // row 2
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(orderTitleLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(orderValueLabel, constraints);

        // row 3
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(genusTitleLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(genusValueLabel, constraints);

        // row 4
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(caloriesTitleLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(caloriesValueLabel, constraints);

        // row 5
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 5;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(fatTitleLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 5;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(fatValueLabel, constraints);

        // row 6
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 6;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(sugarTitleLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 6;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(sugarValueLabel, constraints);

        // row 7
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 7;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(carbsTitleLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 7;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(carbsValueLabel, constraints);

        // row 8
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 8;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        add(proteinTitleLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 8;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(proteinValueLabel, constraints);
    }

    public static void main(String[] args) {
        FruitFrame frame = new FruitFrame();
        frame.setVisible(true);
    }
}