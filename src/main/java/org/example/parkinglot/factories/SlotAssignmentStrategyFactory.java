package org.example.parkinglot.factories;

import org.example.parkinglot.strategies.slotAllotmentStrategies.RandomSlotAssignmentStrategy;
import org.example.parkinglot.strategies.slotAllotmentStrategies.SlotAssignmentStrategy;
import org.example.parkinglot.strategies.slotAllotmentStrategies.SlotAssignmentStrategyType;

public class SlotAssignmentStrategyFactory {
    public static SlotAssignmentStrategy getSlotForType(SlotAssignmentStrategyType slotAssignmentStrategyType){
        return new RandomSlotAssignmentStrategy();
    }
}
