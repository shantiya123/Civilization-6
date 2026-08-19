package Game.Views.UnitPanel;

import Models.Elements.Buildable.Buildings.Bazaar;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.CoastalCamp;
import Models.Elements.Buildable.Buildings.Dock;
import Models.Elements.Buildable.Buildings.Farm;
import Models.Elements.Buildable.Buildings.FarmerCamp;
import Models.Elements.Buildable.Buildings.IronMine;
import Models.Elements.Buildable.Buildings.LumberMill;
import Models.Elements.Buildable.Buildings.MilitaryStable;
import Models.Elements.Buildable.Buildings.Monument;
import Models.Elements.Buildable.Buildings.MountainCamp;
import Models.Elements.Buildable.Buildings.Settlement;
import Models.Elements.Buildable.Buildings.Stable;
import Models.Elements.Buildable.Buildings.StoneMine;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Buildable.Buildings.TraderCamp;
import Models.Elements.Buildable.Buildings.TradingPost;
import Models.Elements.Buildable.Buildings.WarriorCamp;
import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Buildable.Constructure.Wall;
import Models.Elements.Units.Builder;
import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

/** Build-choice popup content; opened from the Builder unit panel's "Build" button.
 * Split into a Buildings part and a Constructures part (walls and roads/borders). */
final class BuildOrderPanel extends JPanel {
    private static final Color GOLD = new Color(198, 165, 96);
    private static final Color TEXT = new Color(230, 214, 170);
    private static final Color BACKGROUND = new Color(38, 32, 25);

    private static final Map<Class<? extends Building>, String> BUILDING_IMAGES = Map.ofEntries(
            Map.entry(Bazaar.class, "/Images/Buildings/Bazzar.png"),
//            Map.entry(CoastalCamp.class, "/Images/Buildings/TribesCamp/CoastalCamp.png"),
            Map.entry(Dock.class, "/Images/Buildings/Dock.png"),
            Map.entry(Farm.class, "/Images/Buildings/Farm.png"),
//            Map.entry(FarmerCamp.class, "/Images/Buildings/TribesCamp/FarmerCamp.png"),
            Map.entry(IronMine.class, "/Images/Buildings/IronMine.png"),
            Map.entry(LumberMill.class, "/Images/Buildings/LubmerMil.png"),
            Map.entry(MilitaryStable.class, "/Images/Buildings/MilitaryStable.png"),
            Map.entry(Monument.class, "/Images/Buildings/Monument.png"),
//            Map.entry(MountainCamp.class, "/Images/Buildings/TribesCamp/MountainCamp.png"),
            Map.entry(Settlement.class, "/Images/Buildings/Sattelment.png"),
            Map.entry(Stable.class, "/Images/Buildings/Stable.png"),
            Map.entry(StoneMine.class, "/Images/Buildings/StoneMine.png"),
            Map.entry(TownHall.class, "/Images/Buildings/TownHall.png")
//            Map.entry(TraderCamp.class, "/Images/Buildings/TribesCamp/TraderCamp.png"),
//            Map.entry(TradingPost.class, "/Images/Buildings/Farm.png"),
//            Map.entry(WarriorCamp.class, "/Images/Buildings/TribesCamp/WarriorCamp.png")
    );

    /** No dedicated art exists yet for constructures; left empty until images are added. */
    private static final Map<Class<? extends Constructure>, String> CONSTRUCTURE_IMAGES = Map.of();

    BuildOrderPanel(Builder builder, UnitPanelState state, Runnable onOrderPlaced) {
        setBackground(BACKGROUND);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GOLD, 2), BorderFactory.createEmptyBorder(14, 14, 14, 14)));
        setLayout(new BorderLayout(0, 12));

        JLabel title = new JLabel("BUILD", SwingConstants.CENTER);
        title.setForeground(TEXT);
        title.setFont(new Font("Serif", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        content.add(sectionLabel("Buildings"));
        content.add(Box.createVerticalStrut(8));
        content.add(createBuildingsGrid(builder, state, onOrderPlaced));

        content.add(Box.createVerticalStrut(16));

        content.add(sectionLabel("Constructures"));
        content.add(Box.createVerticalStrut(8));
        content.add(createConstructuresGrid(state, onOrderPlaced));

        add(content, BorderLayout.CENTER);
    }

    private JLabel sectionLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(GOLD);
        label.setFont(new Font("Serif", Font.BOLD, 15));
        return label;
    }

    private JPanel createBuildingsGrid(Builder builder, UnitPanelState state, Runnable onOrderPlaced) {
        JPanel buildings = new JPanel(new GridLayout(0, 4, 10, 10));
        buildings.setOpaque(false);

        var hex = builder.getHex();
        boolean hexOccupied = hex != null && hex.getBuilding() != null;
        List<Class<? extends Building>> buildable = hex != null ? hex.getBuildableBuildings() : null;

        if (!hexOccupied && buildable != null) {
            for (Class<? extends Building> buildingClass : buildable) {
                buildings.add(createBuildingCard(buildingClass, state, onOrderPlaced));
            }
        }
        return buildings;
    }

    private JPanel createBuildingCard(Class<? extends Building> buildingClass, UnitPanelState state,
                                      Runnable onOrderPlaced) {
        JPanel card = new JPanel(new BorderLayout(0, 6));
        card.setOpaque(false);

        JButton imageButton = new JButton();
        imageButton.setPreferredSize(new Dimension(105, 94));
        imageButton.setBackground(new Color(81, 67, 43));
        imageButton.setBorder(BorderFactory.createLineBorder(GOLD, 1));
        imageButton.setFocusPainted(false);
        imageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imageButton.setToolTipText("Build " + displayName(buildingClass));

        Image image = ImageLoader.load(BUILDING_IMAGES.get(buildingClass));
        if (image != null) {
            imageButton.setIcon(new ImageIcon(image.getScaledInstance(82, 82, Image.SCALE_SMOOTH)));
        } else {
            imageButton.setText(displayName(buildingClass));
        }
        imageButton.addActionListener(event -> {
            state.build(buildingClass);
            onOrderPlaced.run();
        });

        JLabel name = new JLabel("<html><center>" + displayName(buildingClass).replace(" ", "<br>")
                + "</center></html>", SwingConstants.CENTER);
        name.setFont(new Font("Serif", Font.BOLD, 12));
        name.setForeground(TEXT);

        card.add(imageButton, BorderLayout.CENTER);
        card.add(name, BorderLayout.SOUTH);
        return card;
    }

    private JPanel createConstructuresGrid(UnitPanelState state, Runnable onOrderPlaced) {
        JPanel constructures = new JPanel(new GridLayout(0, 4, 10, 10));
        constructures.setOpaque(false);
        constructures.add(createConstructureCard(Wall.class, "Wall", state, onOrderPlaced));
        constructures.add(createConstructureCard(
                Models.Elements.Buildable.Constructure.Road.class, "Road", state, onOrderPlaced));
        return constructures;
    }

    private JPanel createConstructureCard(Class<? extends Constructure> constructureClass, String label,
                                          UnitPanelState state, Runnable onOrderPlaced) {
        JPanel card = new JPanel(new BorderLayout(0, 6));
        card.setOpaque(false);

        JButton imageButton = new JButton();
        imageButton.setPreferredSize(new Dimension(105, 94));
        imageButton.setBackground(new Color(81, 67, 43));
        imageButton.setBorder(BorderFactory.createLineBorder(GOLD, 1));
        imageButton.setFocusPainted(false);
        imageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imageButton.setToolTipText("Build " + label);

        Image image = ImageLoader.load(CONSTRUCTURE_IMAGES.get(constructureClass));
        if (image != null) {
            imageButton.setIcon(new ImageIcon(image.getScaledInstance(82, 82, Image.SCALE_SMOOTH)));
        } else {
            imageButton.setText(label);
        }
        imageButton.addActionListener(event -> {
            state.buildConstructure(constructureClass);
            onOrderPlaced.run();
        });

        JLabel name = new JLabel(label, SwingConstants.CENTER);
        name.setFont(new Font("Serif", Font.BOLD, 12));
        name.setForeground(TEXT);

        card.add(imageButton, BorderLayout.CENTER);
        card.add(name, BorderLayout.SOUTH);
        return card;
    }

    private String displayName(Class<? extends Building> buildingClass) {
        return buildingClass.getSimpleName().replaceAll("(?<!^)(?=[A-Z])", " ");
    }
}