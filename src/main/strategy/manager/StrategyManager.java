package main.strategy.manager;

import main.strategy.GameOfLifeStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kelvin on 03/07/17.
 */
public class StrategyManager {

    private List<GameOfLifeStrategy> strategies;

    public StrategyManager() {
        this.strategies = new ArrayList<>();
    }

    public void addStrategy(GameOfLifeStrategy strategy) {
        strategies.add(strategy);
    }

    public List<GameOfLifeStrategy> getStrategies() {
        return this.strategies;
    }
}
