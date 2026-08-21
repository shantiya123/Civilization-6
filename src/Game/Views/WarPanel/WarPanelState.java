package Game.Views.WarPanel;

import java.util.ArrayList;
import java.util.List;

/**
 * View model for the War Panel (battle report).
 *
 * Per DESIGN.md this is a plain panel-state class: it exposes display-ready
 * values and user-intent methods. It has no reference to any Controller,
 * System, World, or Event class, and no dependency on game logic at all;
 * every field is placeholder/sample display data set through the
 * constructor or the setters below. Wiring the intent methods to a real
 * combat system is deliberately left for later, one layer earlier than the
 * usual Panel -> State -> Controller -> System flow (there is no controller
 * yet, only the state).
 */
public final class WarPanelState {

    /** Which kind of battle report this state currently describes. */
    public enum TargetType { UNIT, STRUCTURE }

    /** Final result of the battle, mirrored in the outcome banner. */
    public enum Outcome {
        ATTACKER_WON("Attacker Won"),
        DEFENDER_WON("Defender Won"),
        DRAW("Draw"),
        TERRITORY_CAPTURED("Territory Captured");

        private final String label;

        Outcome(String label) { this.label = label; }

        public String getLabel() { return label; }
    }

    /** Which side a dice roll or unit summary row belongs to. */
    public enum Side { ATTACKER, DEFENDER }

    /** Before/after row for a single unit involved in the battle. */
    public static final class UnitBattleSummary {
        private final String unitTypeName;
        private final Side side;
        private final int hpBefore;
        private final int hpAfter;
        private final boolean defeated;

        public UnitBattleSummary(String unitTypeName, Side side, int hpBefore, int hpAfter, boolean defeated) {
            this.unitTypeName = unitTypeName;
            this.side = side;
            this.hpBefore = hpBefore;
            this.hpAfter = hpAfter;
            this.defeated = defeated;
        }

        public String getUnitTypeName() { return unitTypeName; }
        public Side getSide() { return side; }
        public int getHpBefore() { return hpBefore; }
        public int getHpAfter() { return hpAfter; }
        public boolean isDefeated() { return defeated; }
    }

    /** One contributor to structure damage when no dice are involved (wall/building/tribe camp). */
    public static final class StructureDamageEntry {
        private final String unitTypeName;
        private final int damage;

        public StructureDamageEntry(String unitTypeName, int damage) {
            this.unitTypeName = unitTypeName;
            this.damage = damage;
        }

        public String getUnitTypeName() { return unitTypeName; }
        public int getDamage() { return damage; }
    }

    private String attackerLabel;
    private String defenderLabel;
    private TargetType targetType;
    private Outcome outcome;

    // Dice-battle fields (used when targetType == UNIT).
    private List<Integer> attackerDice;
    private List<Integer> defenderDice;
    private int attackerHitsTaken;
    private int defenderHitsTaken;

    // Structure-attack fields (used when targetType == STRUCTURE).
    private String structureName;
    private int structureHpBefore;
    private int structureHpAfter;
    private List<StructureDamageEntry> structureDamageEntries;

    private List<UnitBattleSummary> unitSummaries;

    public WarPanelState() {
        loadSampleDiceBattle();
    }

    /** Fills the state with a sample dice battle, mirroring the worked example in Phase2.md. */
    public void loadSampleDiceBattle() {
        this.attackerLabel = "Attacker";
        this.defenderLabel = "Barbarian Warband";
        this.targetType = TargetType.UNIT;
        this.attackerDice = List.of(6, 3, 1);
        this.defenderDice = List.of(5, 4);
        this.attackerHitsTaken = 1;
        this.defenderHitsTaken = 1;
        this.outcome = Outcome.DRAW;
        this.unitSummaries = List.of(
                new UnitBattleSummary("Swordsman", Side.ATTACKER, 1, 0, true),
                new UnitBattleSummary("Cavalry", Side.ATTACKER, 2, 2, false),
                new UnitBattleSummary("Archer", Side.DEFENDER, 1, 1, false),
                new UnitBattleSummary("Swordsman", Side.DEFENDER, 1, 0, true)
        );
        this.structureName = null;
        this.structureDamageEntries = List.of();
    }

    /** Fills the state with a sample structure attack (no dice), e.g. attacking a wall or tribe camp. */
    public void loadSampleStructureBattle() {
        this.attackerLabel = "Attacker";
        this.defenderLabel = "Tribe Camp";
        this.targetType = TargetType.STRUCTURE;
        this.structureName = "Warrior Tribe Camp";
        this.structureHpBefore = 70;
        List<StructureDamageEntry> entries = new ArrayList<>();
        entries.add(new StructureDamageEntry("Swordsman", 10));
        entries.add(new StructureDamageEntry("Cavalry", 8));
        entries.add(new StructureDamageEntry("Catapult", 20));
        this.structureDamageEntries = entries;
        int totalDamage = entries.stream().mapToInt(StructureDamageEntry::getDamage).sum();
        this.structureHpAfter = Math.max(0, structureHpBefore - totalDamage);
        this.outcome = structureHpAfter == 0 ? Outcome.TERRITORY_CAPTURED : Outcome.ATTACKER_WON;
        this.unitSummaries = List.of(
                new UnitBattleSummary("Swordsman", Side.ATTACKER, 1, 1, false),
                new UnitBattleSummary("Cavalry", Side.ATTACKER, 2, 2, false),
                new UnitBattleSummary("Catapult", Side.ATTACKER, 1, 1, false)
        );
        this.attackerDice = List.of();
        this.defenderDice = List.of();
        this.attackerHitsTaken = 0;
        this.defenderHitsTaken = 0;
    }

    public String getAttackerLabel() { return attackerLabel; }
    public void setAttackerLabel(String attackerLabel) { this.attackerLabel = attackerLabel; }

    public String getDefenderLabel() { return defenderLabel; }
    public void setDefenderLabel(String defenderLabel) { this.defenderLabel = defenderLabel; }

    public TargetType getTargetType() { return targetType; }
    public void setTargetType(TargetType targetType) { this.targetType = targetType; }

    public Outcome getOutcome() { return outcome; }
    public void setOutcome(Outcome outcome) { this.outcome = outcome; }

    public List<Integer> getAttackerDice() { return attackerDice; }
    public void setAttackerDice(List<Integer> attackerDice) { this.attackerDice = attackerDice; }

    public List<Integer> getDefenderDice() { return defenderDice; }
    public void setDefenderDice(List<Integer> defenderDice) { this.defenderDice = defenderDice; }

    public int getAttackerHitsTaken() { return attackerHitsTaken; }
    public void setAttackerHitsTaken(int attackerHitsTaken) { this.attackerHitsTaken = attackerHitsTaken; }

    public int getDefenderHitsTaken() { return defenderHitsTaken; }
    public void setDefenderHitsTaken(int defenderHitsTaken) { this.defenderHitsTaken = defenderHitsTaken; }

    public String getStructureName() { return structureName; }
    public void setStructureName(String structureName) { this.structureName = structureName; }

    public int getStructureHpBefore() { return structureHpBefore; }
    public void setStructureHpBefore(int structureHpBefore) { this.structureHpBefore = structureHpBefore; }

    public int getStructureHpAfter() { return structureHpAfter; }
    public void setStructureHpAfter(int structureHpAfter) { this.structureHpAfter = structureHpAfter; }

    public List<StructureDamageEntry> getStructureDamageEntries() { return structureDamageEntries; }
    public void setStructureDamageEntries(List<StructureDamageEntry> structureDamageEntries) {
        this.structureDamageEntries = structureDamageEntries;
    }

    public List<UnitBattleSummary> getUnitSummaries() { return unitSummaries; }
    public void setUnitSummaries(List<UnitBattleSummary> unitSummaries) { this.unitSummaries = unitSummaries; }

    /** User intent: confirm and carry out the proposed attack. Not wired to any system yet. */
    public void confirmAttack() {
        // TODO: delegate to the combat system once a WarPanelController exists.
    }

    /** User intent: retreat instead of carrying out the proposed attack. Not wired to any system yet. */
    public void retreat() {
        // TODO: delegate to the combat system once a WarPanelController exists.
    }

    /** User intent: dismiss the battle report. Not wired to any system yet. */
    public void closeReport() {
        // TODO: delegate to the presentation layer once a WarPanelController exists.
    }
}